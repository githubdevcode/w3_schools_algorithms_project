package com.dsa.algorithms.tree.service;

import com.dsa.algorithms.tree.dto.TreeNode;
import com.dsa.algorithms.tree.dto.TreeNode2;
import com.dsa.algorithms.tree.dto.TreeNode3;

public interface TreeService {
	void preOrderTraversal(TreeNode node);
	void inOrderTraversal(TreeNode node);
	void postOrderTraversal(TreeNode node);
	void inOrderTraversal(TreeNode2 node);
	void inOrderTraversal(TreeNode3 node);
	TreeNode2 search(TreeNode2 node, int target);
	TreeNode2 insert(TreeNode2 node, int data);
	TreeNode2 minValueNode(TreeNode2 node);
	TreeNode3 minValueNode(TreeNode3 node);
	TreeNode2 delete(TreeNode2 node, int data);
	TreeNode3 delete(TreeNode3 root, char data);
	TreeNode3 insert(TreeNode3 node, char data);
}
