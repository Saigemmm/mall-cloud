package org.sellers.basic.AandD.DataStructure.Stack;

import org.sellers.basic.AandD.DataStructure.Node;

/**
 * 栈 链表实现
 * 入栈与出栈都在栈的同一边，与队列相反
 * 因为是单链表，所以入栈与出栈都选在栈头
 */
public class LinkedStack {

    private Node headPointer;

    private int size = 0;

    public LinkedStack() {
        headPointer = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    //入栈
    public boolean push(Object data) {
        if (size == 0) {
            headPointer = new Node(null, data);
            size++;
            return true;
        } else {
            Node newNode = new Node(null, data);
            newNode.setNext(headPointer);
            headPointer = newNode;
            size++;
            return true;
        }
    }

    public Object pop() {
        if (size == 0)
            throw new RuntimeException("stack is empty!");
        Node node = this.headPointer;
        this.headPointer = node.getNext();
        size--;
        return node.getData();
    }
}
