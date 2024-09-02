package org.sellers.basic.base.IOModel.advance.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * bio 程序测试
 * C10K问题：当10k个connection过来时，服务端能否承受；
 * 多线程下的bio无法解决c10k问题
 */
public class MyServerSocket {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9080);
            while (true) {
                System.out.println("等待连接。。。。。");
                Socket clientSocket = serverSocket.accept();
                System.out.println("已有客户端连接");
                new Thread(() -> {
                    try {
                        handler(clientSocket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handler(Socket clientSocket) throws IOException {
        byte[] bytes = new byte[1024];
        System.out.println("准备read。。。");
        int read = clientSocket.getInputStream().read(bytes);
        System.out.println("read完毕");
        if (read != -1) {
            System.out.println("客户端的数据：" + new String(bytes, 0, read));
        }
        clientSocket.close();
    }

    /**
     * 对文件的处理
     */
    private static void fileHandler(Socket socket) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        int byteCount = 0;
        byte[] buffer = new byte[1024];
        while (true) {
            int readCount = dataInputStream.read(buffer, 0, buffer.length);
            byteCount = byteCount + readCount;
            if (readCount == -1) {
                System.out.println("服务端接收：" + byteCount + "字节");
                break;
            }
        }
    }
}
