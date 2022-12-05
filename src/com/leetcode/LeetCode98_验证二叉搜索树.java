package com.leetcode;

import com.leetcode.model.TreeNode;

public class LeetCode98_验证二叉搜索树 {


    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }

        if(root.left != null && root.val < root.left.val){
           return false;
        }
        if(root.right != null && root.val > root.right.val){
            return false;
        }

        boolean validL =   isValidBST(root.left);
        boolean validR =   isValidBST(root.right);

        return validL & validR;
    }
}
