package com.gs.leetcodeday.question03;

/**
 * @User远
 * @Date2022/3/21
 *  https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 *  剑指offer 05 替换空格
 *
 *  请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

// 方法1 直接调用string的api  方法2 转为字节集合 去判断 是否为空 通过stringBuilder拼接
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().replaceSpace("We are happy."));
    }
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c: s.toCharArray()) {
            if(c == ' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public String replaceSpace1(String s) {
        return s.replaceAll(" ", "%20");
    }
}
