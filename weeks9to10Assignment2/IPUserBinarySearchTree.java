package weeks9to10Assignment2;

/**
 * This class creates several tools for examining and manipulating the binary
 * search tree IPUserNode.
 * 
 * @author Parker Banks.
 * CSIS 2420.
 * Salt Lake Community College.
 * November 17, 2021.
 * 
 */
public class IPUserBinarySearchTree {
	public IPUserNode root;
	int numNodes = 1;
	Boolean flag = false;
	String ref;

	/**
	 * Creates root of tree. Adds and sorts other variables to tree.
	 * 
	 * @param IP
	 * @param userName
	 */
	public void insert(int IP, String userName) {
		IPUserNode newNode = new IPUserNode(IP, userName);

		if (root == null) {
			root = newNode;
			return;
		} else {
			IPUserNode current = root, parent = null;
			while (true) {
				parent = current;
				if (IP < current.IP) {
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
	 * Searches tree for node containing the last digits of the IP address
	 * given.
	 * 
	 * @param n
	 * @param IP
	 * @return Searched IP with user or null if not found
	 */
	public String search(IPUserNode n, int IP) {
		if (root == null) {
			return null;
		} else {
			if (n.IP > IP && n.left != null) {
				search(n.left, IP);
			}
			if (n.IP < IP && n.right != null) {
				search(n.right, IP);
			}
			if (n.IP == IP) {
				ref = "Found: 10.0.0." + IP + " " + n.userName;
			}
			return ref;
		}
	}

	/**
	 * Searches tree for node containing the user name given.
	 * 
	 * @param n
	 * @param userName
	 * @return Searched user with IP or null if not found
	 */
	public String search(IPUserNode n, String userName) {
		if (root == null) {
			return null;
		} else {
			if (n.userName.equals(userName)) {
				flag = true;
				ref = "Found: 10.0.0." + n.IP + " " + userName;
			}
			if (flag == false && n.left != null) {
				search(n.left, userName);
			}
			if (flag == false && n.right != null) {
				search(n.right, userName);
			}
			return ref;
		}
	}

	/**
	 * Prints the tree with two columns, IP address and user name.
	 * 
	 * @param n
	 */
	public void printTree(IPUserNode n) {
		if (root == null) {
			System.out.println("Tree is empty");
			return;
		} else {
			if (n.left != null) {
				printTree(n.left);
			}
			System.out.println("10.0.0." + n.IP + " " + n.userName);
			if (n.right != null) {
				printTree(n.right);
			}
		}
	}

	/**
	 * Counts the number of nodes in the tree.
	 * 
	 * @param n
	 * @return Number of nodes
	 */
	public int countNodes(IPUserNode n) {
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

	/**
	 * Resets variables for recursive methods to run correctly. Specifically
	 * countNodes and both search methods.
	 */
	public void clear() {
		numNodes = 1;
		flag = false;
		ref = null;
	}
}