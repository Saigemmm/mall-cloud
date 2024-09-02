package org.sellers.basic.DesignPattern.Prototype.deepClone;

import java.io.*;

//深拷貝的兩種方法
public class DeepPrototype implements Serializable, Cloneable {
    public String name;

    public DeepCloneTarget deepCloneTarget;

    public DeepPrototype() {
        super();
    }

    //深拷貝 方式1,重寫clone方法
    //方法2，通過對象序列化實現（推薦）
    public Object deepClone() {
        //創建流對象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);//當前這個對象以對象流的方式輸出
            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            //關閉流
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
