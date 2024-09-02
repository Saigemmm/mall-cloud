package org.sellers.basic.AandD.DataStructure.Stack;

/**
 * 栈 FILO 数组实现
 */
public class ArrayStack {

    private int[] elements;

    public ArrayStack() {
        this.elements = new int[0];
    }

    public ArrayStack(int size) {
        this.elements = new int[size];
    }

    //入栈 直接将新元素添加到数组末尾
    public void push(int element) {
        int[] newElements = new int[elements.length + 1];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        newElements[newElements.length - 1] = element;
        elements = newElements;
    }

    /**
     * 出栈
     * 1.取数组的最后一个元素
     * 2.创建一个新数组将原数组复制过来除了取出的那个元素外
     */
    public int pop() {
        if (elements.length == 0)
            throw new RuntimeException("stack is empty.");
        int element = elements[elements.length - 1];
        int[] newElements = new int[elements.length - 1];
        System.arraycopy(elements, 0, newElements, 0, newElements.length);
        elements = newElements;
        return element;
    }

    //查看栈顶元素
    public int peek() {
        return elements[elements.length - 1];
    }

    //判断栈是否为空格
    public boolean isEmpty() {
        return elements.length == 0;
    }

}
