package com.gs.leetcodeday.question05;

/**
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 *  剑指offer 11 旋转数组的最小数字
 *
 *  把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。  
 *
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思想：特殊的几个位置 left mid right  使用right和mid进行比较
 * 为什么不用left 因为数组本身就是递增的 中间元素比左边大本身就是非常正常的 使用右边界判断的分治效果更好
 *
 */
public class Solution2 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length-1;
        while (left < right){
            int mid = (left + right) / 2;
            // 如果最右边的大于中间的  说明最小值在左边 调整边界
            if(numbers[right] > numbers[mid]){
                right = mid;
            }
            // 如果最右边的小于中间的  说明此时最小值在右边 调整左边界
            else if(numbers[right] < numbers[mid]){
                left = mid + 1;

            }
            // 相等的情况 说明此时这个元素可以忽略 判断右边第二个元素
            else {
                right--;
            }
        }

        return numbers[left];
    }

    //TODO 有空了看一下
//    public int minArray(int[] nums) {
//        int len = nums.length;
//        return minArray(nums, 0, len - 1);
//    }
//
//    private int minArray(int[] nums, int left, int right) {
//        if (left + 1 >= right) {
//            return Math.min(nums[left], nums[right]);
//        }
//
//        if (nums[left] < nums[right]) {
//            return nums[left];
//        }
//        int mid = left + (right - left) / 2;
//        return Math.min(minArray(nums, left, mid - 1), minArray(nums, mid, right));
//    }
}
