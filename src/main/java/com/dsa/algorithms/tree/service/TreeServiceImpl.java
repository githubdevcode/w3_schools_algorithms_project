package com.dsa.algorithms.tree.service;

import org.springframework.stereotype.Service;

import com.dsa.algorithms.tree.dto.TreeNode;
import com.dsa.algorithms.tree.dto.TreeNode2;
import com.dsa.algorithms.tree.dto.TreeNode3;

@Service
public class TreeServiceImpl implements TreeService {

	@Override
	public void preOrderTraversal(TreeNode node) {
		// TODO Auto-generated method stub
		if (node == null) {
			return;
		}
		System.out.print(node.getData() + ", ");
		preOrderTraversal(node.getLeft());
		preOrderTraversal(node.getRight());
	}

	@Override
public void inOrderTraversal(TreeNode node) {
		// TODO Auto-generated method stub
		if (node == null) {
            return;
        }
        inOrderTraversal(node.getLeft());
        System.out.print(node.getData() + ", ");
        inOrderTraversal(node.getRight());
	}

	@Override
	public void inOrderTraversal(TreeNode2 node) {
		// TODO Auto-generated method stub		
		if (node == null) {
			return;
		}
		inOrderTraversal(node.getLeft());
		System.out.print(node.getData() + ", ");
		inOrderTraversal(node.getRight());
	}
	
	@Override
	public void inOrderTraversal(TreeNode3 node) {
		// TODO Auto-generated method stub		
		if (node == null) {
			return;
		}
		inOrderTraversal(node.getLeft());
		System.out.print(node.getData() + ", ");
		inOrderTraversal(node.getRight());
	}
	
	@Override
	public void postOrderTraversal(TreeNode node) {
		if (node == null) {
            return;
        }
        postOrderTraversal(node.getLeft());
        postOrderTraversal(node.getRight());
        System.out.print(node.getRight() + ", ");
	}

	@Override
	public TreeNode2 search(TreeNode2 node, int target) {
		// TODO Auto-generated method stub
		if (node == null) {
            return null;
        } else if (node.getData() == target) {
            return node;
        } else if (target < node.getData()) {
            return search(node.getLeft(), target);
        } else {
            return search(node.getRight(), target);
        }
	}

	@Override
	public TreeNode2 insert(TreeNode2 node, int data) {
		if (node == null) {
            return new TreeNode2(data);
        } else {
            if (data < node.getData()) {
                node.setLeft(insert(node.getLeft(), data));
            } else if (data > node.getData()) {
                node.setRight(insert(node.getRight(), data));
            }
        }
        return node;
	}
	
	@Override
	public TreeNode2 minValueNode(TreeNode2 node) {
		TreeNode2 current = node;
        while (current != null && current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
	}
	
	@Override
	public TreeNode3 minValueNode(TreeNode3 node) {
		TreeNode3 current = node;
		while (current != null && current.getLeft() != null) {
			current = current.getLeft();
		}
		return current;
	}

	@Override
	public TreeNode2 delete(TreeNode2 node, int data) {
		if (node == null) {
            return null;
        }

        if (data < node.getData()) {
            node.setLeft(delete(node.getLeft(), data));
        } else if (data > node.getData()) {
            node.setRight(delete(node.getRight(), data));
        } else {
            // Node with only one child or no child
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            // Node with two children: Get the inorder successor
            node.setData(minValueNode(node.getRight()).getData());
            node.setRight(delete(node.getRight(), node.getData()));
        }
        return node;
	}
	
	private int height(TreeNode3 N) {
		if (N == null) return 0;
        return N.getHeight();
	}
	
	private int getBalance(TreeNode3 N) {
        if (N == null) return 0;
        return height(N.getLeft()) - height(N.getRight());
    }
	
	private TreeNode3 rightRotate(TreeNode3 y) {
        TreeNode3 x = y.getLeft();
        TreeNode3 T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);

        return x;
    }
	
	private TreeNode3 leftRotate(TreeNode3 x) {
        TreeNode3 y = x.getRight();
        TreeNode3 T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        return y;
    }
	
	@Override
	public TreeNode3 insert(TreeNode3 node, char data) {
        if (node == null) return new TreeNode3(data);

        if (data < node.getData()) node.setLeft(insert(node.getLeft(), data));
        else if (data > node.getData()) node.setRight(insert(node.getRight(), data));
        else return node;

        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));

        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && data < node.getLeft().getData())
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && data > node.getRight().getData())
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && data > node.getLeft().getData()) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && data < node.getRight().getData()) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        return node;
    }
	
	@Override
	public TreeNode3 delete(TreeNode3 root, char data) {
        if (root == null)
            return root;

        if (data < root.getData())
            root.setLeft(delete(root.getLeft(), data));
        else if (data > root.getData())
            root.setRight(delete(root.getRight(), data));
        else {
            if ((root.getLeft() == null) || (root.getRight() == null)) {
                TreeNode3 temp = null;
                if (temp == root.getLeft())
                    temp = root.getRight();
                else
                    temp = root.getLeft();

                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                TreeNode3 temp = minValueNode(root.getRight());
                root.setData(temp.getData());
                root.setRight(delete(root.getRight(), temp.getData()));
            }
        }

        if (root == null)
            return root;

        root.setHeight(Math.max(height(root.getLeft()), height(root.getRight())) + 1);

        int balance = getBalance(root);

        // Left Left Case
        if (balance > 1 && getBalance(root.getLeft()) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.getLeft()) < 0) {
            root.setLeft(leftRotate(root.getLeft()));
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.getRight()) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.getRight()) > 0) {
            root.setRight(rightRotate(root.getRight()));
            return leftRotate(root);
        }

        return root;
    }
}
