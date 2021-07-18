package com.github.aliez;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 03 数组中重复的数字
 *
 * @author Administrator
 * @date 2021/7/18 10:25
 */
public class Solution03 {
    public int findRepeatNumber1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return nums[i - 1];
            }
        }
        return 0;
    }

    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (!hashSet.add(num)) {
                return num;
            }
        }
        return -1;
    }
}
