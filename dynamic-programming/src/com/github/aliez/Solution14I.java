package com.github.aliez;

/**
 * 14-I 剪绳子
 *
 * @author Administrator
 * @date 2021/7/23 11:15
 */
public class Solution14I {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            // i-j >= 2
            for (int j = 1; j <= i - 2; j++) {
                //更新dp[i] 右边的(i - j) * j为剩下的绳子不剪断时的乘积  dp[i - j] * j 为剩下的绳子剪断时的乘积，两者取最大值
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j) * j));
            }
        }
        return dp[n];
    }
}
