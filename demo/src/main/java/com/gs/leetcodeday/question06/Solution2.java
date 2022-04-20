package com.gs.leetcodeday.question06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.ToIntFunction;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 *  剑指offer 32 - 从上到下打印二叉树 II
 *
 例如:  从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 给定二叉树: [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回其层次遍历结果：

 [
 [3],
 [9,20],
 [15,7]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 * 思想： for循环的判断条件比较秀、巧妙地进行了分层打印
 时间复杂度 O(N) ： N 为二叉树的节点数量，即 BFS 需循环 N 次。
 空间复杂度 O(N) ： 最差情况下，即当树为平衡二叉树时，最多有 N/2 个树节点同时在 queue 中，使用 O(N) 大小的额外空间。
 */
public class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>(0);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        queue.add(root);
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
            lists.add(list);
        }
        return lists;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    //        List<List<Integer>> lists = new ArrayList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()){
//            List<TreeNode> tmp = new ArrayList<>();
//            if(tmp.isEmpty()){
//                TreeNode poll = queue.poll();
//                lists.add(new ArrayList<>(poll.val));
//                tmp.add(0, poll);
//                if(poll.left!=null){
//                    queue.add(poll.left);
//                }
//                if(poll.right!=null){
//                    queue.add(poll.right);
//                }
//            }
//            List<Integer> list = new ArrayList<>();
//            while (tmp.get(0).left == null && tmp.get(0).right == null){
//                TreeNode poll = queue.poll();
//                list.add(poll.val);
//
//            }
//        }
}
