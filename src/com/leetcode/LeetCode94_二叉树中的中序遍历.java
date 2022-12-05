package com.leetcode;

import com.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode94_二叉树中的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        dfs(root,res);

        return res;
    }


    void dfs(TreeNode root,List<Integer> res){

        if(root == null){
            return;
        }

        res.add(root.val);
        dfs(root.left,res);
        dfs(root.right,res);
    }


}
