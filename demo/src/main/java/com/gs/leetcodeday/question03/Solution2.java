package com.gs.leetcodeday.question03;

/**
 * @User远
 * @Date2022/3/21
 *  https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 *  剑指offer 58 左旋转字符串
 *
 *  字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//方法1 直接调用string的api  方法2 2for循环append
public class Solution2 {
    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
    }

    public static String reverseLeftWords(String s, int n) {
        String[] split = s.split("");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i <split.length ; i++) {
            stringBuilder.append(split[i]);
        }
        for (int i = 0; i < n; i++) {
            stringBuilder.append(split[i]);
        }
        return stringBuilder.toString();
    }

    public static String reverseLeftWords1(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

}
