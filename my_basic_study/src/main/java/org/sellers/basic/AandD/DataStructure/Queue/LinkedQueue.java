package org.sellers.basic.AandD.DataStructure.Queue;

import org.sellers.basic.AandD.DataStructure.Node;

/**
 * 单链表是实现的队列
 * 实际上就是，入队与出队分别在队首与队尾
 */
public class LinkedQueue {

    //队头
    private Node headPointer;

    //队尾
    private Node rearPointer;

    //队列长度
    private int size = 0;

    public LinkedQueue() {
        headPointer = rearPointer = null;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    /**
     * 入队
     * 添加数据到队尾，
     */
    public boolean add(Object data) {
        if (size == 0) {
            headPointer = new Node(null, data);
            rearPointer = headPointer;
            size++;
            return true;
        } else {
            Node newNode = new Node(null, data);//创建一个新节点
            rearPointer.setNext(newNode);
            rearPointer = newNode;
            size++;
            return true;
        }
    }

    /**
     * 出队，即弹出链表的第一个node
     */
    public Object poll(){
        if(size==0)
            throw new RuntimeException("queue is empty!");
        Node node=this.headPointer;
        this.headPointer=node.getNext();
        size--;
        return node.getData();
    }


}

