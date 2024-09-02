package org.sellers.basic.AandD.DataStructure.Linked;

//单链表的节点
public class SingleLinkedNode {

    //数据
    private Object data;

    //下一个节点的指针
    private SingleLinkedNode next;

    public SingleLinkedNode(Object data) {
        this.data = data;
    }

    //为节点追加节点，即将所有节点都链接起来，使用尾插法
    public SingleLinkedNode append(SingleLinkedNode node) {
        SingleLinkedNode currentNode = this;
        //循环目的；一直找到本链表的最后一个节点
        while (true) {
            SingleLinkedNode nextNode = currentNode.next;
            if (nextNode == null) {
                break;
            }
            currentNode = nextNode;
        }
        //让后将最后一个节点的next赋给新节点，链表成链
        currentNode.next = node;
        return this;
    }

    //插入一个新的节点到当前节点之后
    public void afterInsert(SingleLinkedNode node) {
        SingleLinkedNode nextNext = this.next;
        this.next = node;
        node.next = nextNext;
    }

    //删除当前节点的下一个节点
    public void removeNext() {
        if (this.next == null)
            throw new RuntimeException("next node is empty!");
        this.next = this.next.next;
    }

    public Object getData() {
        return this.data;
    }

    public SingleLinkedNode getNext() {
        return this.next;
    }

    //打印所有节点
    public void show() {
        SingleLinkedNode currentNode = this;
        do {
            System.out.print(currentNode.getData() + "|" + currentNode.next + "->");
            currentNode = currentNode.next;
        } while (currentNode != null);
        System.out.println("");
    }

    public boolean isLast() {
        return this.next == null;
    }

}
