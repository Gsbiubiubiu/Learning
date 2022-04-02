package com.gs.leetcodeday.question02;

/**
 * @User远
 * @Date2022/3/21
 *  https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 *  剑指offer 24 反转链表
 *
 *  定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution2 {

    public ListNode reverseList(ListNode head) {
        // 储存上个节点
        ListNode pre = null;
        // 储存当前节点
        ListNode curr = head;
        while (curr != null){
            // 储存下一个节点
            ListNode next = curr.next;
            // 下个节点指向上一个节点 为了反转
            curr.next = pre;
            // 当前节点付给上个节点 为了下次循环
            pre = curr;
            // 当前节点变为储存的上个节点
            curr = next;
        }
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
