package com.gs.leetcodeday.question05;

/**
 *  https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 *  剑指offer 04. 二维数组中的查找  中等
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *[
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 思路：从右上角(或者左上角) 查看这个矩阵 如果target大于当前元素则向下查找  如果小于则向左查找 直到查找完毕位置
 * 时间复杂度 纵向最多 m次  横向做多n次  所以为O(m+n)
 */
public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int cols = matrix.length;
        int lens = matrix[0].length;
        int col = 0;
        int len = lens-1;

        while(col<cols && len>=0 ){
            if(matrix[col][len] == target){
                return true;
            }
            if(matrix[col][len] > target){
                len--;
            }else {
                col++;
            }
        }
        return false;
    }
}
