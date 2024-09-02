package org.sellers.basic.base.IOModel.advance.client;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * memory map(MMAP)零拷贝示例 rocketMQ
 */
public class MMapCopyClient {
    private static final String PATH="C:\\advance\\MMap";

    public static void main(String[] args) throws IOException {
        //映射文件
        File file=new File(PATH,"000000000000000000000");
        //映射文件的fileChannel，（操作文件）
        FileChannel fileChannel=new RandomAccessFile(file,"rw").getChannel();
        MappedByteBuffer mMap=fileChannel.map(FileChannel.MapMode.READ_WRITE,0,1024);
        //模拟rocketMQ写入数据
        mMap.put("king".getBytes());
        //刷盘
        mMap.flip();
        byte[] buffer=new byte[4];
        //从mMap读取文件，模拟MQ消费
        mMap.get(buffer,0,4);
        System.out.println(new String(buffer));
        //接触MMAP，内存映射
        mMap.clear();
    }
}
