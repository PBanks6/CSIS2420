package weeks9to10;

/*
 * BinarySearchTree.java - Class to manage binary search 
 *                         tree implementations.
 * 
 * @author: @professorgordon
 * @url: http://johngordon.io/javaadvancedtrees.php
 * @license: Creative Commons. No Warranty. No Liability.
 * @disclaimer: This code file is intended strictly for
 *              academic purposes. It is NOT intended for
 *              use in production systems.
 *
 */

public class BinarySearchTree {
	public BSTNode root;
	long startTime1;
	long startTime2;
	long startTime3;
	long endTime1;
	long endTime2;
	long endTime3;
	int numNodes = 0;
	int count1;
	int count2;
	int count3;

	public void insert(int data) {
		BSTNode newNode = new BSTNode(data);
		if (root == null) {
			root = newNode;
			return;
		} else {
			BSTNode current = root, parent = null;
			while (true) {
				parent = current;
				if (data < current.data) {
					current = current.left;
					if (current == null) {
						parent.left = newNode;
						return;
					}
				} else {
					current = current.right;
					if (current == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}

	public void preOrderTraverse(BSTNode n) {
		if (count1 == 0) {
			startTime1 = System.nanoTime();
			count1++;
		}
		if (root == null) {
			System.out.println("Tree is empty");
			endTime1 = System.nanoTime();
			System.out.println("Time to compute: " + (endTime1 - startTime1) / 1000000);
			return;
		} else {
			System.out.print(n.data + " ");
			if (count1 > numNodes) {
				System.out.println("");
				endTime1 = System.nanoTime();
				System.out.println("Time to compute: " + (endTime1 - startTime1) / 1000000);
			}
			count1++;
			if (n.left != null) {
				preOrderTraverse(n.left);
			}
			if (n.right != null) {
				preOrderTraverse(n.right);
			}
		}
	}

	public void inOrderTraverse(BSTNode n) {
		if (count2 == 0) {
			startTime2 = System.nanoTime();
			count2++;
		}
		if (root == null) {
			System.out.println("Tree is empty");
			endTime2 = System.nanoTime();
			System.out.println("Time to compute: " + (endTime2 - startTime2) / 1000000);
			return;
		} else {
			if (n.left != null) {
				inOrderTraverse(n.left);
			}
			System.out.print(n.data + " ");
			if (count2 > numNodes) {
				System.out.println("");
				endTime2 = System.nanoTime();
				System.out.println("Time to compute: " + (endTime2 - startTime2) / 1000000);
			}
			count2++;
			if (n.right != null) {
				inOrderTraverse(n.right);
			}
		}
	}

	public void postOrderTraverse(BSTNode n) {
		if (count3 == 0) {
			startTime3 = System.nanoTime();
			count3++;
		}
		if (root == null) {
			System.out.println("Tree is empty");
			endTime3 = System.nanoTime();
			System.out.println("Time to compute: " + (endTime3 - startTime3) / 1000000);
			return;
		} else {
			if (n.left != null) {
				postOrderTraverse(n.left);
			}
			if (n.right != null) {
				postOrderTraverse(n.right);
			}
			System.out.print(n.data + " ");
			if (count3 > numNodes) {
				System.out.println("");
				endTime3 = System.nanoTime();
				System.out.println("Time to compute: " + (endTime3 - startTime3) / 1000000);
			}
			count3++;
		}
	}

	public String Search(int data, BSTNode n) {
		String ref = null;
		if (root == null) {
			return ref;
		} else {
			if (n.data > data && n.left != null) {
				return Search(data, n.left);
			}
			if (n.data < data && n.right != null) {
				return Search(data, n.right);
			}
			if (n.data == data) {
				ref = n.toString();
			}
			return ref;
		}
	}

	int right = 0;
	int left = 0;

	public int Depth(BSTNode n) {

		if (root == null) {
			return 0;
		} else {
			if (n.left != null) {
				left++;
				Depth(n.left);
			}
			if (n.right != null) {
				right++;
				Depth(n.right);
			}
			if (left > right) {
				return left;
			} else {
				return right;
			}
		}

	}

	public void clearDepthCount() {
		right = 0;
		left = 0;
	}

	public BSTNode Delete(int data, BSTNode root) {
		if (root == null) {
			return root;
		} else {
			if (root.data > data) {
				root.left = Delete(data, root.left);
			} else if (root.data < data) {
				root.right = Delete(data, root.right);
			} else {
				if (root.left != null && root.right != null) {
					BSTNode delNum = root;
					BSTNode minR = delNum.right;
					while (minR.right != null) {
						if (delNum.right.data <= minR.data) {
							minR = minR.right;
						}
					}
					root.data = minR.data;
					root.right = Delete(minR.data, root.right);
				} else if (root.left != null) {
					root = root.left;

				} else if (root.right != null) {
					root = root.right;

				} else {
					root = null;
				}

			}
			return root;
		}

	}

	public int countNodes(BSTNode n) {
		if (root == null) {
			return 0;
		} else {
			if (n.left != null) {
				numNodes++;
				countNodes(n.left);
			}
			if (n.right != null) {
				numNodes++;
				countNodes(n.right);
			}
			return numNodes;

		}
	}

}
