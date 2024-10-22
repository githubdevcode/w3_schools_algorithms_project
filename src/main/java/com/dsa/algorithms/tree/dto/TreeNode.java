package com.dsa.algorithms.tree.dto;

public class TreeNode {
	char data;
	TreeNode left;
	TreeNode right;

	public TreeNode(char data) {
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

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}
}
