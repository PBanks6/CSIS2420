package weeks9to10;

import java.util.Random;

/*
 * BSTDemo.java - Class to demonstrate a binary search tree.
 * 
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedtrees.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 *
 **/

public class BSTDemo extends BinarySearchTree {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		// Sample Data: 20, 33, 18, 19, 46, 29, 4, 62
		bst = randomInsert(1000);
		bst.countNodes(bst.root);

		System.out.print("PreOrder Traverse:\t");
		bst.preOrderTraverse(bst.root);
		System.out.println();
		System.out.print("InOrder Traverse:\t");
		bst.inOrderTraverse(bst.root);
		System.out.println();
		System.out.print("PostOrder Traverse:\t");
		bst.postOrderTraverse(bst.root);
		System.out.println();

	}

	public static BinarySearchTree randomInsert(int ranNum) {
		BinarySearchTree bst = new BinarySearchTree();
		Random rand = new Random();

		for (int i = 0; i < ranNum; i++) {
			String id = String.format("%04d", rand.nextInt(10000));
			bst.insert(Integer.parseInt(id));
		}
		return bst;
	}

}
