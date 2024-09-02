package org.sellers.basic.base.IOModel.advance.client;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * sendFile零拷贝示例 kafka
 */
public class SendFileClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 9080));
        socketChannel.configureBlocking(false);
        String fileName = "C:\\Users\\86707\\Pictures\\Saved Pictures\\Camera Roll\\0040jbadgy1h334k2024yj61wk2jm4qs02.jpg";
        //文件通道
        FileChannel fileChannel = new FileInputStream(fileName).getChannel();
        //文件读写、映射和操作的通道
        long startTime = System.currentTimeMillis();
        //transferTo底层是send file，调用操作系统内核函数，直接在内核空间完成了从磁盘到网络设备的拷贝，只有两次copy和上下文切换
        long transferCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);
        long endTime = System.currentTimeMillis();
        System.out.println("发送总字节数：" + transferCount + "，耗时：" + (endTime - startTime) + "ms");
        fileChannel.close();
        socketChannel.close();
    }
}
