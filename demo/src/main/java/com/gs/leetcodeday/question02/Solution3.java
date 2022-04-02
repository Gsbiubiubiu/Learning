package com.gs.leetcodeday.question02;

import java.util.HashMap;
import java.util.Map;

/**
 * @User远
 * @Date2022/3/21
 *  https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 *  剑指offer 35 复杂链表的复制
 *
 *  请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
// 注意不能直接调用原来链表的引用地址  例如return head
// 存储一个map 来建立原来链表head 与 新链表curr 的映射关系
// 然后给curr的next、random 分别赋值
// 最后return map中head 对应的 curr
public class Solution3 {

    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node curr = head;
        Map<Node, Node> map = new HashMap();
        while (curr != null){
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null){
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
