package org.selelrs.mall.message.util;

import org.apache.rocketmq.common.message.Message;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * MQ批量发送消息时，每条消息的大小限制是4M，当超过的时候用此工具类切割消息大小
 * 为保持性能，建议不超过1M
 */
public class ListSplitter implements Iterator<List<Message>> {
    //每条消息的最大值
    private final static int SIZE_LIMIT = 40 * 1000;
    private final List<Message> messages;
    //当前切割的下标，默认是0
    private int currentIndex;

    public ListSplitter(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < messages.size();
    }

    //这是算的这一条消息的大小，也就是这个list的大小
    @Override
    public List<Message> next() {
        int nextIndex = currentIndex;
        int totalSize = 0;
        for (; nextIndex < messages.size(); nextIndex++) {
            Message message = messages.get(nextIndex);
            int messageSize = message.getBody().length + message.getTopic().length();
            Map<String, String> properties = message.getProperties();
            for (Map.Entry<String, String> next : properties.entrySet()) {
                int length = next.getKey().length() + next.getValue().length();
                messageSize = messageSize + length;
            }
            messageSize += 20;
            //消息大小计算完成，开始对比
            if (messageSize > SIZE_LIMIT) {
                //第一发送久超过了限制，直接跳过这条消息继续扫描
                if (nextIndex == currentIndex) {
                    nextIndex++;
                }
                break;
            }
            if (messageSize + totalSize > SIZE_LIMIT) {
                break;
            } else {
                totalSize += messageSize;
            }
        }
        List<Message> messages = this.messages.subList(currentIndex, nextIndex);
        currentIndex = nextIndex;
        return messages;
    }
}
