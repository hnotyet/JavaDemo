package com.leetcode;

import com.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode114_二叉树展开为链表 {

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }


    /**
     * 进阶
     * @param root
     */
    public void flatten2(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }


}
