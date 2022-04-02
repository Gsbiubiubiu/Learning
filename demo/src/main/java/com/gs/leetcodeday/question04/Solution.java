package com.gs.leetcodeday.question04;

import java.util.HashSet;
import java.util.Set;

/**
 * @User远
 * @Date2022/3/21
 *  https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 *  剑指offer 03 数组中重复的数字
 *
 *  在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

// 方法1：循环2次判断数组 如果是当前元素就break避免自己与自己比较
    // 方法2：放入set中根据是否add成功来判断是否重复
    //TODO 还有更优解 空间复杂度为O(1) 有空看下
public class Solution {
    public Integer findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = 0; i1 < nums.length; i1++) {
                if(i == i1){
                    break;
                }
                if(nums[i] == nums[i1]){
                    return nums[i];
                }
            }
        }
        return null;
    }

    /**
     * 官方解答
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public Integer findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums) {
            if(!set.add(num)) {
                return num;
            }
        }
        return -1;
    }
}
