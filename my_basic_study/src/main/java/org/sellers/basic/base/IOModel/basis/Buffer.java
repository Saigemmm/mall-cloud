package org.sellers.basic.base.IOModel.basis;

import java.io.*;

public class Buffer {
    /**
     * 读取文件内容；创建缓冲区输出
     * @throws IOException
     */
    public void read() throws IOException {
        FileReader fileReader=new FileReader("F:/local.txt");//字符输出流
        BufferedReader bufferedReader=new BufferedReader(fileReader);//将字符输出流转为缓冲输出流
        StringBuffer stringBuffer=new StringBuffer();//构造一个不带字符的字符缓冲区，其初始容量为16个字符
        String line=bufferedReader.readLine();//读取一个文本行给line
        while(line!=null){
            System.out.println(stringBuffer.append(line));//添加给stringBuffer
            break;
        }
        fileReader.close();
        bufferedReader.close();
    }

    /**
     * 写文件；创建缓冲区输入
     */
    public void write() throws IOException {
        FileWriter fileWriter=new FileWriter("F:/local.txt");//字符输入流
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);//将字符输入流转为缓冲输入流
        for (int i=0;i<=10;i++){
            bufferedWriter.write("哈哈哈哈");
            bufferedWriter.newLine();//写入换行
            bufferedWriter.flush();//刷新
        }
        fileWriter.close();
        bufferedWriter.close();
    }
}
