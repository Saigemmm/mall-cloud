package org.sellers.basic.base.IOModel.advance.client;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TraditionClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9080);
        String fileName = "C:\\Users\\86707\\Pictures\\Saved Pictures\\Camera Roll\\0040jbadgy1h334k2024yj61wk2jm4qs02.jpg";
        InputStream inputStream = new FileInputStream(fileName);
        //用输出流接收socket接受到的数据
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        byte[] buffer = new byte[1024];
        long readCount;
        long total = 0;
        long startTime = System.currentTimeMillis();
        //这里实际要发生两次copy和上下文切换
        while ((readCount = inputStream.read(buffer)) >= 0) {
            total += readCount;
            //网络发送，发生两次copy和上下文切换
            dataOutputStream.write(buffer);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("发送总字节数：" + total + "耗时：" + (endTime - startTime) + "ms");
        dataOutputStream.close();
        socket.close();
        inputStream.close();
    }
}
