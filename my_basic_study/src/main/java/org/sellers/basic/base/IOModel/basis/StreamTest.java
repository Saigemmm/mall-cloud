package org.sellers.basic.base.IOModel.basis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamTest {
    public static void main(String[] args) throws IOException {
        byte[] a="大家好才是真的好".getBytes();
        FileOutputStream fileOutputStream=new FileOutputStream("F:/local.txt");//创建文件字节输出流
        File file=new File("F:/local.txt");//在F盘根目录下创建一个local.txt文件
        FileInputStream fileInputStream=new FileInputStream(file);//创建文件字节输入流
        System.out.println(file.getName()+fileInputStream.read()+file.length());
        fileOutputStream.write(a);//用输入流将a写进文件
        fileOutputStream.close();
        System.out.println(file.getName()+fileInputStream.read()+file.length());
        fileInputStream.close();
        Buffer buffer=new Buffer();
        buffer.read();
        CopyFile copyFile=new CopyFile();
        copyFile.copy();
    }
}
