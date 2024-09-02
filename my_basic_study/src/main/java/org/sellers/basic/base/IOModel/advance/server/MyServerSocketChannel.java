package org.sellers.basic.base.IOModel.advance.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * nio示例
 */
public class MyServerSocketChannel {
    //保存客户端连接
    private final List<SocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) {
        MyServerSocketChannel myServerSocketChannel = new MyServerSocketChannel();
        try {
            //创建nio serverSocketChannel，与bio的ServerSocket类似
            ServerSocketChannel serverSocket = ServerSocketChannel.open();
            serverSocket.socket().bind(new InetSocketAddress(9081));
            //设置serverSocket为非阻塞
            serverSocket.configureBlocking(false);
            System.out.println("服务启动成功。");
            while (true) {
                //nio的非阻塞是由操作系统内部实现的 ，底层调用了linux内核的accept函数
                SocketChannel socketChannel = serverSocket.accept();
                //nio若没有连接不会阻塞，会直接返回null
                if (socketChannel != null) {
                    System.out.println("连接成功。");
                    //设置socketChannel为非阻塞
                    socketChannel.configureBlocking(false);
                    myServerSocketChannel.channelList.add(socketChannel);
                }else {
                    Thread.sleep(1000L);
                    System.out.println("no connection");
                }
                Iterator<SocketChannel> iterator = myServerSocketChannel.channelList.iterator();
                while (iterator.hasNext()) {
                    SocketChannel sc = iterator.next();
                    //非阻塞模式的read方法
                    ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                    int len = sc.read(byteBuffer);
                    if (len > 0) {
                        System.out.println("接收到：" + new String(byteBuffer.array()));
                    } else if (len == -1) {
                        iterator.remove();
                        System.out.println("客户端断开连接");
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
