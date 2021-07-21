package com.github.aliez;

/**
 * 10-II 青蛙跳台阶问题
 *
 * @author Administrator
 * @date 2021/7/20 12:38
 */
public class Solution10II {
    public int numWays(int n) {
        if (n < 2) {
            return 1;
        }
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return (int) dp[n];
    }
}
