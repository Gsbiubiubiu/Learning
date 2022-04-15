package com.gs.leetcodeday.question06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 *  剑指offer 32 - I. 从上到下打印二叉树
 *
 *  从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 *
 * 思想：这里运用了广度优先搜索(BFS) 需要借助队列 先进先出(FIFO)的特点 来确定打印二叉树的顺序
 *  从根节点开始  从左孩子到右孩子 依次给队列添加元素  再poll(取出队列中的第一个元素) 出元素
 *  从而得到一个数组
 *  时间复杂度 O(N) ： N 为二叉树的节点数量，即 BFS 需循环 N 次。
 * 空间复杂度 O(N) ： 最差情况下，即当树为平衡二叉树时，最多有 N/2 个树节点同时在 queue 中，使用 O(N) 大小的额外空间
 */
public class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
        return null;
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
