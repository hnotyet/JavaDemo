package com.leetcode;

import com.leetcode.model.TreeNode;

public class LeetCode617_合并二叉树 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if(root1 != null && root2!=null){
            TreeNode left = mergeTrees(root1.left,root2.left);
            TreeNode right = mergeTrees(root1.right,root2.right);

            int val1 = root1 != null ? root1.val:0;
            int val2 = root2 != null ? root2.val:0;
            TreeNode node = new TreeNode(val1+val2);
            node.left = left;
            node.right = right;

            return node;
        }else if(root1 != null){
            TreeNode left = mergeTrees(root1.left,null);
            TreeNode right = mergeTrees(root1.right,null);

            int val1 = root1 != null ? root1.val:0;
            TreeNode node = new TreeNode(val1);
            node.left = left;
            node.right = right;

            return node;
        }else if(root2 != null){
            TreeNode left = mergeTrees(null,root2.left);
            TreeNode right = mergeTrees(null,root2.right);

            int val2 = root2 != null ? root2.val:0;
            TreeNode node = new TreeNode(val2);
            node.left = left;
            node.right = right;

            return node;
        }else{
            return null;
        }
    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;
    }

}
