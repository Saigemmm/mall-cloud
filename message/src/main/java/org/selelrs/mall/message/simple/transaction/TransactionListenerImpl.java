package org.selelrs.mall.message.simple.transaction;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * 模拟本地事务监听器
 */
public class TransactionListenerImpl implements TransactionListener {
    @Override
    public LocalTransactionState executeLocalTransaction(Message message, Object o) {
        String tags = message.getTags();
        if (tags.contains("TagA")) {
            return LocalTransactionState.COMMIT_MESSAGE;
        } else if (tags.contains("TagB")) {
            return LocalTransactionState.ROLLBACK_MESSAGE;
        } else {
            return LocalTransactionState.UNKNOW;
        }
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
        String tags = messageExt.getTags();
        if (tags.contains("TagC")) {
            return LocalTransactionState.COMMIT_MESSAGE;
        } else if (tags.contains("TagD")) {
            return LocalTransactionState.ROLLBACK_MESSAGE;
        } else {
            return LocalTransactionState.UNKNOW;
        }
    }
}
