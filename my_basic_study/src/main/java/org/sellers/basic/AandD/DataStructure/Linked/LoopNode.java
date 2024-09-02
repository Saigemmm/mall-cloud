package org.sellers.basic.AandD.DataStructure.Linked;

//循环链表
public class LoopNode {

    //数据
    private Object data;

    //下一个节点的指针指向自己；若该链表只有一个节点即是如此
    private LoopNode next=this;

    public LoopNode(Object data) {
        this.data = data;
    }

    //插入一个新的节点到当前节点之后
    public void afterInsert(LoopNode node){
        LoopNode nextNext=this.next;
        this.next=node;
        node.next=nextNext;
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

    public LoopNode getNext() {
        return this.next;
    }

}
