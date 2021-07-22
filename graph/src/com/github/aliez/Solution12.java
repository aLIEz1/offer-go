package com.github.aliez;

/**
 * 12 矩阵中的路径
 * 使用深度优先算法，当遇到不符的就剪枝操作
 *
 * @author Administrator
 * @date 2021/7/22 11:07
 */
public class Solution12 {
    public boolean exist(char[][] board, String word) {
        int h = board.length;
        if (h == 0) {
            return false;
        }
        int w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = dfs(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word, int k) {
        if (board[i][j] != word.charAt(k)) {
            return false;
        } else if (k == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] direction : directions) {
            int ni = i + direction[0];
            int nj = j + direction[1];
            if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length) {
                if (!visited[ni][nj]) {
                    boolean flag = dfs(board, visited, ni, nj, word, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }

    public static void main(String[] args) {
        char[] ab = {'a', 'b'};
        char[][] pa = {ab};
        System.out.println(new Solution12().exist(pa, "ab"));
    }
}
