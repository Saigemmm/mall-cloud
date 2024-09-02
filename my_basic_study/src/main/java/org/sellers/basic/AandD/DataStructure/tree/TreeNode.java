package org.sellers.basic.AandD.DataStructure.tree;

/**
 * 一个树节点
 */
public class TreeNode {

    //节点的权
    private Object value;

    //左儿子
    private TreeNode leftNode;

    //右儿子
    private TreeNode rightNode;

    public TreeNode(Object value) {
        this.value = value;
    }

    public TreeNode(Object value, TreeNode leftNode, TreeNode rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    //树的遍历；前序遍历
    public void frontShow() {
        System.out.println(value);
        if (leftNode != null)
            leftNode.frontShow();
        if (rightNode != null)
            rightNode.frontShow();
    }

    //前序查找
    public TreeNode frontSearch(Object value) {
        if (this.value == value)
            return this;
        else {
            if (leftNode != null)
                return leftNode.frontSearch(value);
            if (rightNode != null)
                return rightNode.frontSearch(value);
        }
        return null;
    }

    //删除一个子树
    public void deleteTree(Object value) {
        TreeNode parent = this;
        if (leftNode.getValue() == value) {
            leftNode = null;
            return;
        }
        if (rightNode.getValue() == value) {
            rightNode = null;
            return;
        }
        parent = leftNode;
        if (parent != null) {
            deleteTree(value);
        }
        parent = rightNode;
        if (parent != null) {
            deleteTree(value);
        }
    }

}
