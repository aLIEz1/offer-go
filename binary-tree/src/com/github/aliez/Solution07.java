package com.github.aliez;


import java.util.HashMap;
import java.util.Map;

/**
 * 07 重建二叉树
 *
 * @author Administrator
 * @date 2021/7/18 23:36
 */
public class Solution07 {
    /**
     * 涉及数组拷贝，时间复杂度太高，转用索引法
     *
     * @param preorder 前序遍历结果
     * @param inorder  中序遍历结果
     * @return 根节点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);

        if (preorder.length == 1) {
            return root;
        }
        int delimiterIndex;
        for (delimiterIndex = 0; delimiterIndex < inorder.length; delimiterIndex++) {
            if (inorder[delimiterIndex] == rootValue) {
                break;
            }
        }

        int[] inLeft = new int[delimiterIndex];
        int[] inRight = new int[inorder.length - delimiterIndex - 1];

        System.arraycopy(inorder, 0, inLeft, 0, delimiterIndex);
        System.arraycopy(inorder, delimiterIndex + 1, inRight, 0, inorder.length - delimiterIndex - 1);

        int[] preLeft = new int[delimiterIndex];
        int[] preRight = new int[preorder.length - delimiterIndex - 1];
        System.arraycopy(preorder, 1, preLeft, 0, delimiterIndex);
        System.arraycopy(preorder, delimiterIndex + 1, preRight, 0, preorder.length - delimiterIndex - 1);

        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;

    }

    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>(16);
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preLeft, int pRight, int inLeft, int inRight) {
        if (preLeft > pRight) {
            return null;
        }
        int rootValue = preorder[preLeft];
        int delimiterIndex = indexMap.get(rootValue);
        int leftSize = delimiterIndex - inLeft;
        TreeNode root = new TreeNode(rootValue);
        root.left = myBuildTree(preorder, inorder, preLeft + 1, preLeft + leftSize, inLeft, delimiterIndex - 1);
        root.right = myBuildTree(preorder, inorder, preLeft + 1 + leftSize, pRight, delimiterIndex + 1, inRight);
        return root;

    }
}
