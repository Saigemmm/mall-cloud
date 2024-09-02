package org.sellers.basic.AandD.DataStructure.Array;

/**
 * 可以添加或者删除元素的数组，低配版ArrayList
 */
public class ArrayObjects {

    private Object[] objects;

    public ArrayObjects(){
        objects=new Object[0];
    }

    public ArrayObjects(int size){
        objects=new Object[size];
    }

    public Object get(int index){
        return objects[index];
    }

    public int size(){
        return objects.length;
    }

    public Object[] set(int index,Object object){
        objects[index]=object;
        return objects;

    }

    /**
     *若不指定添加位置则往数组末尾添加，同ArrayList也是在末尾插入
     */
    public void add(Object object){
        Object[] newObjects=new Object[objects.length+1];
        //objects：源数组；0：源数组开始下标；newObjects：目标数组；0：目标数组开始下标；objects.length：需要复制的长度
        System.arraycopy(objects, 0, newObjects, 0, objects.length);
        newObjects[newObjects.length-1]=object;
        objects=newObjects;
    }

    /**
     * 指定添加元素的位置
     */
    public void add(Object object,int index){
        Object[] newObjects=new Object[objects.length+1];
        for(int i=0;i<newObjects.length;i++){
            if(i<index){
                newObjects[i]=objects[i];
            }else if(i==index){
                newObjects[i]=object;
            }else{
                newObjects[i]=objects[i-1];
            }
        }
        objects=newObjects;
    }

    public void delete(int index){
        Object[] newObjects=new Object[objects.length-1];
        for(int i=0;i<newObjects.length;i++){
            if(i<index){
                newObjects[i]=objects[i];
            }else{
                newObjects[i]=objects[i+1];
            }
        }
        objects=newObjects;
    }
}
