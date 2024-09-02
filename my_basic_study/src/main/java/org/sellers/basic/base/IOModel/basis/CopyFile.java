package org.sellers.basic.base.IOModel.basis;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    //用字节输入输出流完成copy操作
    public void copy() throws IOException {
        //FileOutputStream fileOutputStream=new FileOutputStream("F:/local.txt",true);//参数取true时，输出流不会刷新所指向的文件，反之相反
        FileInputStream fileInputStream=new FileInputStream("F:/local.txt");//字节输入流
        FileOutputStream fileOutputStream=new FileOutputStream("E:/local.txt");//若没有改文件则先创建文件，字节输出流
        int l=fileInputStream.available();//返回此输入流下一个方法调用可以不受阻塞的从此输入流读取（或跳过）的估计字节数，即计算此输入流的大小
        for (int i=0;i<l;i++){
            int b=fileInputStream.read();//从输入流中读取一定数量的字节
            fileOutputStream.write(b);//将指定的字节b写入输出流；即完成了copy操作
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
