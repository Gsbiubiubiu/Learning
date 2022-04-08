package com.gs.leetcodeday.question06;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import static java.util.Collections.*;

/**
 * @User远
 * @Date2022/4/8
 */
public class Solution {
    //TODO 写错了 层序遍历  这种递归顺序不对
    List<Integer> list = new ArrayList<>();
    public int[] levelOrder(TreeNode root) {
        getNext(root);
        Collections.sort(list);
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

    private void getNext(TreeNode next){
        if(next == null){
            return;
        }
        list.add(next.val);
        if(next.left != null){
            getNext(next.left);
        }
        if(next.right != null){
            getNext(next.right);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
