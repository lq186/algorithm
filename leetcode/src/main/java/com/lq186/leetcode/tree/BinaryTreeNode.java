package com.lq186.leetcode.tree;

/**
 * 二叉树节点
 *
 * @author lq
 * @date 2019/12/6
 */
public class BinaryTreeNode {

    /**
     * 左节点
     */
    private BinaryTreeNode leftNode;

    /**
     * 数据
     */
    private String data;

    /**
     * 右节点
     */
    private BinaryTreeNode rightNode;

    public BinaryTreeNode(String data) {
        this.data = data;
    }

    public BinaryTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public BinaryTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
