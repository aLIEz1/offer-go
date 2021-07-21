package com.github.aliez;

/**
 * 10-1 斐波那契数列
 *
 * @author Administrator
 * @date 2021/7/19 11:24
 */
public class Solution10I {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return (int) dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution10I().fib(95));
    }
}
