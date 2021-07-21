package com.github.aliez;

/**
 * 11 旋转数组的最小数字
 *
 * @author Administrator
 * @date 2021/7/21 13:25
 */
public class Solution11 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) >> 1;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[right];
    }
}
