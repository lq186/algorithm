package com.lq186.leetcode.tree;

/**
 * 二叉树操作
 *
 * @author lq
 * @date 2019/12/6
 */
public class BinaryTreeOperations {

    /**
     * 计算二叉树的高度
     *
     * @param rootNode 根节点
     * @return
     */
    public static int calcTreeHeight(BinaryTreeNode rootNode) {
        if (rootNode == null) {
            return 0;
        }
        int leftHeight = calcTreeHeight(rootNode.getLeftNode());
        int rightHeight = calcTreeHeight(rootNode.getRightNode());
        return 1 + Math.max(leftHeight, rightHeight);
    }

}
