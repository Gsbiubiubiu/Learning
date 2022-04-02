package com.gs.leetcodeday.question01;

import java.util.Stack;

/**
 * @User远
 * @Date2022/3/21
 *  https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 *  剑指offer 09 用两个栈实现队列
 *
 *  用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class warehouseQueue {

    private Stack<Integer> putStack;
    private Stack<Integer> delStack;

    public warehouseQueue() {
        putStack = new Stack<Integer>();
        delStack = new Stack<Integer>();
    }

    public void appendTail(int value) {
        putStack.push(value);
    }

    public int deleteHead() {
        if(delStack.empty()){
            while (!putStack.empty()) delStack.push(putStack.pop());
        }
        if(delStack.empty()){
            return -1;
        }else {
            return delStack.pop();
        }
    }

    public static void main(String[] args) {
        warehouseQueue warehouseQueue = new warehouseQueue();
        warehouseQueue.appendTail(3);
        System.out.println(warehouseQueue.deleteHead());
        System.out.println(warehouseQueue.deleteHead());

        System.out.println(warehouseQueue.deleteHead());
        warehouseQueue.appendTail(5);
        warehouseQueue.appendTail(2);
        System.out.println(warehouseQueue.deleteHead());
        System.out.println(warehouseQueue.deleteHead());
    }
}
