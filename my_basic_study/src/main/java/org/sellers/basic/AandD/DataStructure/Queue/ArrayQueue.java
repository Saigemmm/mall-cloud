package org.sellers.basic.AandD.DataStructure.Queue;

/**
 * 队列 FIFO 数组实现
 */
public class ArrayQueue {

    private int[] elements;

    public ArrayQueue() {
        elements = new int[0];
    }

    public ArrayQueue(int size) {
        elements = new int[size];
    }

    //入队 直接添加元素到数组末尾
    public void add(int element) {
        int[] newElements = new int[elements.length + 1];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        newElements[newElements.length - 1] = element;
        elements = newElements;
    }

    /**
     * 出队
     * 1.取出数组第一个元素
     * 2.创建一个新数组，并将除了第一个元素外的所有元素都复制给新数组
     */
    public int poll() {
        if(elements.length==0)
            throw new RuntimeException("queue is empty!");
        int element = elements[0];
        int[] newElements = new int[elements.length - 1];
        System.arraycopy(elements, 1, newElements, 0, newElements.length);
        elements = newElements;
        return element;
    }

    public boolean isEmpty() {
        return elements.length == 0;
    }

}
