package com.github.aliez;

/**
 * 05 替换空格
 *
 * @author Administrator
 * @date 2021/7/18 22:15
 */
public class Solution05 {
    public String replaceSpace(String s) {
        char[] array1 = s.toCharArray();
        int spaceNum = 0;
        for (char c : array1) {
            if (c == ' ') {
                spaceNum++;
            }
        }
        char[] array2 = new char[array1.length + 2 * spaceNum];
        int j = array1.length + 2 * spaceNum - 1;
        int i = array1.length - 1;
        while (i >= 0 && j >= 0) {
            if (array1[i] != ' ') {
                array2[j] = array1[i];
                i--;
                j--;
            } else {
                array2[j] = '0';
                array2[j - 1] = '2';
                array2[j - 2] = '%';
                i--;
                j -= 3;
            }
        }
        return new String(array2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution05().replaceSpace("We are happy."));
    }
}
