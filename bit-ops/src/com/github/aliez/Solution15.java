package com.github.aliez;

/**
 * 15 二进制中1的个数（汉明距离）
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/solution/mian-shi-ti-15-er-jin-zhi-zhong-1de-ge-shu-wei-yun/
 *
 * @author Administrator
 * @date 2021/7/23 13:02
 */
public class Solution15 {
    /**
     * n-1 会将最后一个1变为0 此1后面的0全部变成1
     * n&(n-1) 会将n最右边的1变成0
     *
     * @param n 数字
     * @return 汉明距离
     */
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    /**
     * 当最右边为0的时候n&1为0
     * 当最右边为1的时候n&1为1
     * 运算完之后需要无符号右移
     *
     * @param n 数字
     * @return 汉明距离
     */
    public int hammingWeight1(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}
