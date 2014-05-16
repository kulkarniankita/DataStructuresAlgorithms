package binarytree;

import binarytree.TreeNode;
public class Traversals {

	public static void main(String[] args) 
	{
		TreeNode parent = new TreeNode(10);
		
		parent.insertInOrder(2);
		parent.insertInOrder(13);
		parent.insertInOrder(5);
		parent.insertInOrder(6);
		parent.insertInOrder(15);
		parent.insertInOrder(6);
		
		System.out.println("Pre-order traversal");
		parent.preOrderTraversal(parent, null,0);
		System.out.println();
		
		System.out.println("Post-order traversal");
		parent.postOrderTraversal(parent);
		System.out.println();
		
		System.out.println("In-order traversal");
		parent.inOrderTraversal(parent);
		System.out.println();
		
		/*
		 * Find Min Element in the tree
		 */
		System.out.println("min element:"+parent.findMin(parent));
		
		/*
		 * Find Max element in the tree
		 */
		System.out.println("max element:"+parent.findMax(parent));
		
	}

}
