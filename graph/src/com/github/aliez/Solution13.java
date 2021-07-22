package com.github.aliez;

/**
 * 13 机器人的运动范围
 *
 * @author Administrator
 * @date 2021/7/22 21:37
 */
public class Solution13 {
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        if (n * m <= k) {
            return m * n;
        }
        boolean[][] visited = new boolean[m][n];
        return dfs(m, n, k, 0, 0, visited);
    }

    private int dfs(int m, int n, int k, int i, int j, boolean[][] visited) {
        if (i >= m || j >= n || digitSum(i) + digitSum(j) > k || visited[i][j]) {
            return 0;
        }
        System.out.print("当前i:"+i+" 当前j:"+j+" ");
        System.out.println("visited数组:"+visited[i][j]);
        visited[i][j] = true;
        return 1 + dfs(m, n, k, i + 1, j, visited) + dfs(m, n, k, i, j + 1, visited);
    }

    private int digitSum(int num) {
        return num / 10 + num % 10;
    }

    public static void main(String[] args) {
        System.out.println(new Solution13().movingCount(5, 1, 1));
    }
}
