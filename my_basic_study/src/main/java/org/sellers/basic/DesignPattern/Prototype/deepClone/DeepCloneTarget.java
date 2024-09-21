package org.sellers.basic.DesignPattern.Prototype.deepClone;

import java.io.Serializable;

/**
 * 浅克隆： 创建一个新对象，新对象的属性和原始对象的相应属性具有相同的值。如果属性是值类型的，则对该属性执行逐位复制；如果属性是引用类型，则复制引用但不复制引用的对象。
 * 深克隆: 创建一个新对象，并递归地复制原始对象中的每个属性，包括引用类型的属性。这样，原始对象和副本就相互独立了。
 */
public class DeepCloneTarget implements Serializable,Cloneable {
    private static final long serialVersionUID= 1L;

    private String cloneName;

    private String cloneClass;

    public DeepCloneTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getCloneName() {
        return cloneName;
    }

    public void setCloneName(String cloneName) {
        this.cloneName = cloneName;
    }

    public String getCloneClass() {
        return cloneClass;
    }

    public void setCloneClass(String cloneClass) {
        this.cloneClass = cloneClass;
    }
}
