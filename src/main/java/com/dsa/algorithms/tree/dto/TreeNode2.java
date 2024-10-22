package com.dsa.algorithms.tree.dto;

public class TreeNode2 {
	int data;
    TreeNode2 left;
    TreeNode2 right;

    public TreeNode2(int data) {
        this.data = data;
        left = null;
        right = null;
    }

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode2 getLeft() {
		return left;
	}

	public void setLeft(TreeNode2 left) {
		this.left = left;
	}

	public TreeNode2 getRight() {
		return right;
	}

	public void setRight(TreeNode2 right) {
		this.right = right;
	}
}
