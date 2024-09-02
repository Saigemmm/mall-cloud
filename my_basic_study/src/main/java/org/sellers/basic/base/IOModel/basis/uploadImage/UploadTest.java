package org.sellers.basic.base.IOModel.basis.uploadImage;

import java.io.IOException;
import java.util.Scanner;

public class UploadTest {
    public static void main(String[] args) throws IOException {
        ImageUpload imageUpload=new ImageUpload();
        System.out.println("输入上传图片的原始路径");
        Scanner scanner1=new Scanner(System.in);
        String oldImage=scanner1.nextLine();
        System.out.println("输入上传图片的目的目录");
        Scanner scanner2=new Scanner(System.in);
        String newImage=scanner2.nextLine();
        imageUpload.upload(oldImage,newImage);
        System.out.println("上传完成");
    }
}
