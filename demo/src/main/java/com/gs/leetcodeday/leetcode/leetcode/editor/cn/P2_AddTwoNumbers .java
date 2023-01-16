package com.gs.leetcodeday.leetcode.leetcode.editor.cn;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 8866 👎 0

/**
 * 两数相加
 *
 * @author Gaos
 */
class P2_AddTwoNumbers{
    public static void main(String[] args) {
        Solution solution = new P2_AddTwoNumbers().new Solution();
        
    }
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 定义一个新链表 头节点的位置 用于返回结果
        ListNode pre = new ListNode(0);
        // cur 指向的仍是pre对象，用于指向存储位置， 存储pre下的每个ListNode
        ListNode cur = pre;
        // 存储 前两数之和
        int carry = 0;

        // 任意一个ListNode不为空时 都不会停止循环
        while (l1 != null || l2 != null){
            // 补0操作
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            // 前两数之和需要进的位数 如21 进 2
            carry = sum / 10 ;
            // 前两数之和的余数 如21 1
            sum = sum % 10 ;

            // 下一个指针就是余数的值
            cur.next = new ListNode(sum);
            cur = cur.next;

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
