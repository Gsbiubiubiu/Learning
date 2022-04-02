package com.gs.leetcodeday.question02;

/**
 * @User远
 * @Date2022/3/21
 *  https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *  剑指offer 06 从尾到头打印链表
 *
 *  输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
// 思路：先循环一次链表得到数组长度 在循环一次赋值
public class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode listNode = head;
        int count = 0;
        while (listNode != null){
            listNode = listNode.next; //指向下个节点 持续循环
            count++;
        }

        ListNode arrNode = head;
        int[] strings = new int[count];
        while (arrNode != null) {
            strings[count-1] = arrNode.val;
            count--; // 达到数组倒叙赋值的效果
            arrNode = arrNode.next;
        }
        return strings;
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

