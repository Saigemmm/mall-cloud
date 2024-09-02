package org.sellers.basic.base.IOModel.advance.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 多路复用器selector nio示例
 * 这个其实是epoll
 *
 * 具体参考博客：https://aobing.blog.csdn.net/article/details/122293594
 */
public class MyNIOSelector {
    public static void main(String[] args) {
        try {
            //创建NIO ServerSocketChannel
            ServerSocketChannel serverSocket = ServerSocketChannel.open();
            serverSocket.socket().bind(new InetSocketAddress(9083));
            serverSocket.configureBlocking(false);
            //打开Selection（多路复用器）处理channel，即创建epoll
            Selector selector = Selector.open();
            //把ServerSocketChannel注册到selector上，并且selector对客户端accept连接操作感兴趣
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("服务启动成功。");
            while (true) {
                //阻塞等待需要处理的事情发生。
                selector.select();
                //获取selector中注册的全部事件的SelectionKey实例
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    //如果是OP_ACCEPT事件，则进行连接获取和事件注册
                    if (key.isAcceptable()) {
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel socketChannel = server.accept();
                        if (socketChannel != null) {
                            socketChannel.configureBlocking(false);
                            //这里只注册了读事件，如果需要给客户端发送数据可以注册写事件
                            socketChannel.register(selector, SelectionKey.OP_READ);
                            System.out.println("客户端连接成功。");
                        }
                    } else if (key.isReadable()) {//如果是OP_READ事件，则进行读取和打印
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                        int len = socketChannel.read(byteBuffer);
                        if (len > 0) {
                            System.out.println("接收到：" + new String(byteBuffer.array()));
                        } else if (len == -1) {
                            System.out.println("客户端关闭。");
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
