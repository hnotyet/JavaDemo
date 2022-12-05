package com.leetcode;

import com.leetcode.model.TreeNode;

public class LeetCode538_把二叉树转化为累加数 {


    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }





}
