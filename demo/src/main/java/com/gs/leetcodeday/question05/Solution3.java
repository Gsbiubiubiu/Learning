package com.gs.leetcodeday.question05;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 *  剑指offer 50 第一个只出现一次的字符
 *
 *  在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思想：将字符串切分为char数组，将他放入map中  value为Boolean(比较巧妙) 逻辑也更加简单了
 *
 * 时间复杂度 O(N) ： N 为字符串 s 的长度；需遍历 s 两轮，使用 O(N) ；HashMap 查找操作的复杂度为 O(1) ；
 * 空间复杂度 O(1) ： 由于题目指出 s 只包含小写字母，因此最多有 26 个不同字符，HashMap 存储需占用 O(26) = O(1) 的额外空间。
 *
 */
public class Solution3 {
    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Boolean> map = new HashMap();
        for (char c:chars){
            map.put(c, map.containsKey(c)); // 第一次为false  大于1次为true
        }
        for(char c : chars){
            if(!map.get(c)){
                return c;
            }
        }
        return ' ';
    }
}
