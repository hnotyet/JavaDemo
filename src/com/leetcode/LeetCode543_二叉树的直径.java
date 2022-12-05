package com.leetcode;

import com.leetcode.model.TreeNode;

public class LeetCode543_二叉树的直径 {

    int max = 0;

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = depth(root.left);
        int r = depth(root.right);

        max = Math.max(max, l + r + 1);

        return Math.max(l, r) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max - 1;
    }


}
