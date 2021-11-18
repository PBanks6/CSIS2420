package weeks9to10Assignment2;

/**
 * This class creates a binary tree with an IP address and a user name.
 * 
 * @author Parker Banks.
 * CSIS 2420.
 * Salt Lake Community College.
 * November 17, 2021.
 * 
 */
public class IPUserNode {

	int IP;
	String userName;
	IPUserNode left;
	IPUserNode right;

	/**
	 * Binary tree node with an IP and user name.
	 * 
	 * @param IP
	 * @param userName
	 */
	public IPUserNode(int IP, String userName) {
		this.IP = IP;
		this.userName = userName;
	}

}
