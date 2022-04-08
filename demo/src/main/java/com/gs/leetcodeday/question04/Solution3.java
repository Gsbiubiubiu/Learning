package com.gs.leetcodeday.question04;

/**
 *  https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 *  剑指offer 53 0～n-1中缺失的数字
 *
 *  一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution3 {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }

    public int missingNumber2(int[] nums) {
//        if (nums[0]==1) return 0;
        for (int i = 0;i<nums.length;i++){
            if (nums[i]!=i) return i;
        }
        return nums.length;
    }
}
