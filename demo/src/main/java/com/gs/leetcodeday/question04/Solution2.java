package com.gs.leetcodeday.question04;

/**
 * @User远
 * @Date2022/3/21
 *  https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 *  剑指offer 53 在排序数组中查找数字 I
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
//TODO 要写一个二分查找
public class Solution2 {
    public int search(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if(num == target){
                count++;
            }
        }
        return count;
    }
    public int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = (right+left) / 2;
        return 1;

    }

}
