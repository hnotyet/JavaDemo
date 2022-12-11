package com.leetcode;

import com.leetcode.model.TreeNode;

public class LeetCode105_重建二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        TreeNode root = new TreeNode(preorder[0]);
        TreeNode left = null;
        TreeNode right =null;
        for(int i =1; i< preorder.length-1;i++){
            if(preorder[i] < root.val){
                left = new TreeNode(preorder[i]);
            }else{
                right = new TreeNode(preorder[i]);
            }


        }




        return null;
    }
}
