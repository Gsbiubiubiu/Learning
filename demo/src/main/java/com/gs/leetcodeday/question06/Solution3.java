package com.gs.leetcodeday.question06;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 *  剑指offer 32 - 从上到下打印二叉树 II
 *
 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
 第三行再按照从左到右的顺序打印，其他行以此类推。

 例如:
 给定二叉树: [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回其层次遍历结果：
 [
 [3],
 [20,9],
 [15,7]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 * 思想： 在前面的基础上再加一个flag判断标识位
 时间复杂度 O(N) ： N 为二叉树的节点数量，即 BFS 需循环 N 次。
 空间复杂度 O(N) ： 最差情况下，即当树为平衡二叉树时，最多有 N/2 个树节点同时在 queue 中，使用 O(N) 大小的额外空间。
 */
public class Solution3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        boolean flag = true;
        if(root != null) queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>(queue.size());
            for (int i = queue.size(); i > 0; i--) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if(poll.left != null){
                    queue.add(poll.left);
                }
                if(poll.right != null){
                    queue.add(poll.right);
                }
            }
            if(flag){
                lists.add(list);
                flag = false;
            }else {
                Collections.reverse(list);
                lists.add(list);
                flag = true;
            }

        }
        return lists;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
