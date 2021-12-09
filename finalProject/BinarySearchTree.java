package finalProject;

import java.util.Scanner;

/**
 * BinarySearchTree includes all the methods for applying the binary search
 * tree. This includes asking the user questions, building the search tree, and
 * testing methods.
 * 
 * @author Parker Banks
 * CSIS 2420
 * Salt Lake Community College
 *
 */
public class BinarySearchTree {

	int numNodes = 0;
	public BSTNode root;
	long startTime;
	long endTime;
	long userResponseTime = 0;

	/**
	 * insert builds and adds to the binary search tree.
	 * 
	 * @param position
	 * @param guess
	 */
	public void insert(int position, String guess) {
		BSTNode newNode = new BSTNode(position, guess);
		if (root == null) {
			root = newNode;
			return;
		} else {
			BSTNode current = root, parent = null;
			while (true) {
				parent = current;
				if (position < current.position) {
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

	/**
	 * preOrderTraverse prints the binary search tree.
	 * 
	 * @param n
	 */
	public void preOrderTraverse(BSTNode n) {
		if (root == null) {
			System.out.println("Tree is empty");
			return;
		} else {
			System.out.println(n.guess + " ");
			if (n.left != null) {
				preOrderTraverse(n.left);
			}
			if (n.right != null) {
				preOrderTraverse(n.right);
			}
		}
	}

	/**
	 * returnGuess asks the questions from the binary search tree based on user
	 * input.
	 * 
	 * @param n
	 * @return
	 */
	public BSTNode returnGuess(BSTNode n) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String response = null;

		if (n.left != null && n.right != null) {
			System.out.print(n.guess + ": ");
			startTime = System.nanoTime();
			response = scanner.next();
			endTime = System.nanoTime();
			userResponseTime = userResponseTime + (endTime - startTime);
			System.out.println("");
			if (response.equals("Y")) {
				return returnGuess(n.right);
			}
			if (response.equals("N")) {
				return returnGuess(n.left);
			} else {
				System.out.println("Answer must be 'Y' for yes or 'N' for no.");
				System.out.println("");
				return returnGuess(n);
			}
		}
		return n;
	}

	/**
	 * countNodes counts the number of nodes in the binary search tree.
	 * 
	 * @param n
	 * @return
	 */
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
