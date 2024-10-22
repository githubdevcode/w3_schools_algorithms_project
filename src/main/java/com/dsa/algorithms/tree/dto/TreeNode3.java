package com.dsa.algorithms.tree.dto;

public class TreeNode3 {
	char data;
	TreeNode3 left, right;
	int height;

	public TreeNode3(char data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public TreeNode3 getLeft() {
		return left;
	}

	public void setLeft(TreeNode3 left) {
		this.left = left;
	}

	public TreeNode3 getRight() {
		return right;
	}

	public void setRight(TreeNode3 right) {
		this.right = right;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
