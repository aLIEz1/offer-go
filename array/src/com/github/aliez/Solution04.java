package com.github.aliez;

/**
 * 04 二维数组中的查找
 *
 * @author Administrator
 * @date 2021/7/18 13:12
 */
public class Solution04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int flag = 0;
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        if (matrix[0][0] > target || matrix[m - 1][n - 1] < target) {
            return false;
        }
        for (int[] ints : matrix) {
            if (ints[0] < target) {
                for (int j = 0; j < n; j++) {
                    if (ints[j] == target) {
                        return true;
                    } else if (ints[j] > target) {
                        break;
                    }
                }
            } else if (ints[0] == target) {
                return true;
            }
        }
        return false;
    }
}
