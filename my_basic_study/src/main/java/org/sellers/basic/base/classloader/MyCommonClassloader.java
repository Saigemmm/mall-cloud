package org.sellers.basic.base.classloader;

import java.io.*;

public class MyCommonClassloader extends ClassLoader {
    //表明当前的classloader可并行加载不同的类
    static {
        registerAsParallelCapable();
    }

    //指定字节码文件所在的本地目录
    private final String commonPath;

    //字节码类文件所在的本地目录
    public MyCommonClassloader(String commonPath) {
        if (!commonPath.isEmpty()
                && commonPath.charAt(commonPath.length() - 1) != File.separatorChar) {
            this.commonPath = commonPath + File.separator;
        } else this.commonPath = commonPath;
    }

    public MyCommonClassloader(String commonPath, ClassLoader parent) {
        super(parent);
        if (!commonPath.isEmpty()
                && commonPath.charAt(commonPath.length() - 1) != File.separatorChar) {
            this.commonPath = commonPath + File.separator;
        } else this.commonPath = commonPath;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] b = loadClassFromFile(name);
            return defineClass(name, b, 0, b.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(name);
        }
    }

    private byte[] loadClassFromFile(String name) throws IOException {
        String FileName = name.replace(",", File.separator) + ".class";
        String filePath = this.commonPath + FileName;
        try (InputStream inputStream = new FileInputStream(filePath);
             ByteArrayOutputStream byteStream = new ByteArrayOutputStream()) {
            int nextValue;
            while ((nextValue = inputStream.read()) != -1) {
                byteStream.write(nextValue);
            }
            return byteStream.toByteArray();
        }
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        System.out.println("prepare to user MyCommonClassLoader to load class :" + name);
        return super.loadClass(name, resolve);
    }
}
