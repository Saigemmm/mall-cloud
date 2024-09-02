package org.sellers.basic.base.IOModel.basis.uploadImage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ImageUpload {
    /**
     * 判断某个文件名是否是图片
     *
     * @param name
     * @return
     */
    public boolean isImage(String name) {
        String[] strings = {".jpg", ".gif", ".png"};
        if (name.lastIndexOf(".") == -1) {//lastIndexOf(".")是返回字符串最右边处出现与"."相同的字符串到结尾是的长度，如果没有则返回-1
            return false;
        } else for (String s : strings) {
            if (name.substring(name.indexOf(".")).equals(s)) {//indexOf(".")返回在该字符串开头到第一次出现"."的长度
                //substring(int i);返回从第i开始到结尾的字符串
                return true;
            }
        }
        return false;
    }

    /**
     * 创建新目录下的新图片文件
     */
    public void createFolder(String newImage) {
        File file = new File(newImage);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /**
     * 得到原目录下的所有图片文件
     */
    public List<String> getAllImages(String oldImage) {
        List<String> imgs = new ArrayList<String>();
        File folder = new File(oldImage);
        File[] files = folder.listFiles();//返回oldImage目录下所有文件和文件夹的绝对路径到File[]中
        for (File f : files) {
            if (f.isFile()) {//判断是否是文件，而不是文件夹
                if (isImage(f.getName())) {//调用isImage方法判断file[]中的文件是否是图片
                    imgs.add(f.getName());//将是图片的文件赋给imgs
                }
            }
        }
        return imgs;
    }

    /**
     * 原目录到新目录
     */
    public void upload(String oldImage, String newImage) throws IOException {
        String a = "//";//在java中"/"属于转义字符，定义时需要用"//"
        ImageUpload imageUpload = new ImageUpload();
        List<String> imgs = imageUpload.getAllImages(oldImage);
        imageUpload.createFolder(newImage);
        for (String img : imgs) {
            FileInputStream fileOld = new FileInputStream(new File(oldImage + a + img));//创建字节输入流对象，目的：从原文件中获取数据
            FileOutputStream fileNew = new FileOutputStream(new File(newImage + a + img));//创建字节输出流对象，目的，将数据写入到新文件
            byte[] bytes = new byte[2048];
            while (fileOld.read(bytes) != -1) {//read方法是从fileOld输入流中逐个读取2048个数据字节并存在bytes数组中，如果已经到文件末尾则返回-1
                fileNew.write(bytes);//通过输出流对象fileNew写入bytes存入的数据字节
            }
            fileNew.close();
            fileOld.close();
        }
    }
}
