package org.sellers.basic.AandD.DataStructure;

public class Node {

    //数据
    private Object data;
    //指针
    private Node next;

    public Node(Node next, Object data) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
