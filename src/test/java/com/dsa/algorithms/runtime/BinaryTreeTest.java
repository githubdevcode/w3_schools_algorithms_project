package com.dsa.algorithms.runtime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.dsa.algorithms.AlgorithmsApplication;
import com.dsa.algorithms.tree.dto.TreeNode;
import com.dsa.algorithms.tree.dto.TreeNode2;
import com.dsa.algorithms.tree.dto.TreeNode3;
import com.dsa.algorithms.tree.service.TreeService;

@SpringBootTest(classes = { AlgorithmsApplication.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class BinaryTreeTest {

	private TreeNode binaryTreeRoot;
	private TreeNode2 binarySearchTreeRoot;

	@BeforeEach
	public void before() {
		createBinaryTree();
		createBinarySearchTree();
	}

	private void createBinarySearchTree() {
		// TODO Auto-generated method stub
		binarySearchTreeRoot = new TreeNode2(13);
		TreeNode2 node7 = new TreeNode2(7);
		TreeNode2 node15 = new TreeNode2(15);
		TreeNode2 node3 = new TreeNode2(3);
		TreeNode2 node8 = new TreeNode2(8);
		TreeNode2 node14 = new TreeNode2(14);
		TreeNode2 node19 = new TreeNode2(19);
		TreeNode2 node18 = new TreeNode2(18);
		
		binarySearchTreeRoot.setLeft(node7);
		binarySearchTreeRoot.setRight(node15);

		node7.setLeft(node3);
		node7.setRight(node8);

		node15.setLeft(node14);
		node15.setRight(node19);

		node19.setLeft(node18);
	}

	private void createBinaryTree() {
		binaryTreeRoot = new TreeNode('R');
		TreeNode nodeA = new TreeNode('A');
		TreeNode nodeB = new TreeNode('B');
		TreeNode nodeC = new TreeNode('C');
		TreeNode nodeD = new TreeNode('D');
		TreeNode nodeE = new TreeNode('E');
		TreeNode nodeF = new TreeNode('F');
		TreeNode nodeG = new TreeNode('G');

		binaryTreeRoot.setLeft(nodeA);
		binaryTreeRoot.setRight(nodeB);

		nodeA.setLeft(nodeC);
		nodeA.setRight(nodeD);

		nodeB.setLeft(nodeE);
		nodeB.setRight(nodeF);

		nodeF.setLeft(nodeG);
	}

	@Test
	public void whenCreatingBinaryTree_thenLookForRootRightLeftData() {
		System.out.println("BinaryTree LookForRootRightLeftData");
		// Test
		System.out.println("root.right.left.data: " + binaryTreeRoot.getRight().getLeft().getData());
	}

	@Autowired
	private TreeService treeService;

	@Test
	public void whenThereIsABinaryTree_thenPerformAPreOrderTraversal() {
		System.out.println("BinaryTree PreOrderTraversal");
		treeService.preOrderTraversal(binaryTreeRoot);
		System.out.print("\n");
	}

	@Test
	public void whenThereIsABinaryTree_thenPerformAnInOrderTraversal() {
		System.out.println("BinaryTree InOrderTraversal");
		treeService.inOrderTraversal(binaryTreeRoot);
		System.out.print("\n");
	}

	@Test
	public void whenThereIsABinaryTree_thenPerformAPostOrderTraversal() {
		System.out.println("BinaryTree PostOrderTraversal");
		treeService.inOrderTraversal(binaryTreeRoot);
		System.out.print("\n");
	}
	
	@Test
	public void whenThereIsABinarySearchTree_thenPerformAnInOrderTraversal() {
		System.out.println("BinarySearchTree InOrderTraversal");
		treeService.inOrderTraversal(binarySearchTreeRoot);
		System.out.print("\n");
	}
	
	@Test
	public void whenThereIsABinarySearchTree_thenPerformASearchingForAValue() {
		System.out.println("BinarySearchTree SearchingForAValue");
		TreeNode2 result = treeService.search(binarySearchTreeRoot, 8);
		if (result != null) {
            System.out.println("Found the node with value: " + result.getData());
        } else {
            System.out.println("Value not found in the BST.");
        }
	}
	
	@Test
	public void whenThereIsABinarySearchTree_thenPerformAnInsertingOfAValue() {
		System.out.println("BinarySearchTree InsertingOfAValue");
		treeService.insert(binarySearchTreeRoot, 10);
		treeService.inOrderTraversal(binarySearchTreeRoot);
		System.out.print("\n");
	}
	
	@Test
	public void whenThereIsABinarySearchTree_thenPerformALookingForTheMinValueNode() {
		System.out.println("BinarySearchTree MinValueNode");
		TreeNode2 minValueNode = treeService.minValueNode(binarySearchTreeRoot);
		treeService.inOrderTraversal(binarySearchTreeRoot);
		System.out.print("\n");
		System.out.println("Lowest value: "+ minValueNode.getData());
	}
	
	@Test
	public void whenThereIsABinarySearchTree_thenPerformTheDeletingOfANode() {
		System.out.println("BinarySearchTree DeletingOfANode");
		treeService.inOrderTraversal(binarySearchTreeRoot);
		System.out.print("\n");
		treeService.delete(binarySearchTreeRoot, 15);
		treeService.inOrderTraversal(binarySearchTreeRoot);
		System.out.print("\n");
	}
	
	@Test
	public void whenThereIsABinarySearchTree_thenPerformTheInsertingAndDeletingOfANode() {
		System.out.println("BinarySearchTree InsertingAndDeletingOfANode");
		TreeNode3 root = null;
		char[] letters = {'C', 'B', 'E', 'A', 'D', 'H', 'G', 'F'};
        for (char letter : letters) {
            root = treeService.insert(root, letter);
        }
		
        treeService.inOrderTraversal(root);
        
        System.out.println("\nDeleting A");
        root = treeService.delete(root, 'A');
        treeService.inOrderTraversal(root);
		System.out.print("\n");
	}
}
