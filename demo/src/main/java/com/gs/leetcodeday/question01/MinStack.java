package com.gs.leetcodeday.question01;

import java.util.Stack;
import java.util.stream.Collectors;

//TODO 并非最优解 最优解待补充

/**
 * @User远
 * @Date2022/3/21
 *  https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 *  剑指offer 30 包含min函数的栈
 *
 *  定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

// 解题思路：定义两个栈 一个用来存储 另一个用来存储该元素对应的min
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    //private Stack<Integer> compareStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        //compareStack.push(x);
        if(minStack.empty()){
            minStack.push(x);
        }else {
            //Integer integer = stack.stream().min((o1, o2) -> 0).get(); //TODO
            Integer integer = stack.stream().sorted().collect(Collectors.toList()).get(0);
            minStack.push(integer);
        }

    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }
}
