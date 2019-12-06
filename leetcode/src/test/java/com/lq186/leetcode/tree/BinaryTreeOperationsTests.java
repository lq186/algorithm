package com.lq186.leetcode.tree;

import org.junit.Before;
import org.junit.Test;

/**
 * @author lq
 * @date 2019/12/6
 */
public class BinaryTreeOperationsTests {

    private final BinaryTreeNode rootNode = new BinaryTreeNode("root");

    @Before
    public void initTree() {
        BinaryTreeNode node = new BinaryTreeNode("left1");
        BinaryTreeNode node2 = new BinaryTreeNode("left2");
        node2.setLeftNode(new BinaryTreeNode("left3"));
        node.setLeftNode(node2);
        rootNode.setLeftNode(node);

        node = new BinaryTreeNode("right1");
        node2 = new BinaryTreeNode("right2");
        BinaryTreeNode node3 = new BinaryTreeNode("right3");
        node3.setLeftNode(new BinaryTreeNode("rl4"));
        node3.setRightNode(new BinaryTreeNode("rr4"));
        node2.setRightNode(node3);
        node.setRightNode(node2);
        rootNode.setRightNode(node);
    }

    @Test
    public void testCalcTreeHeight() {
        assert 5 == BinaryTreeOperations.calcTreeHeight(rootNode);
    }

}
