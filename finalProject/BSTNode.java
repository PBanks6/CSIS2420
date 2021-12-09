package finalProject;

/**
 * BSTNode initializes the binary search tree for the position, questions, and
 * first guesses of the Mario Cart characters.
 * 
 * @author Parker Banks
 * CSIS 2420
 * Salt Lake Community College
 *
 */
public class BSTNode {

	String guess;
	int position;
	BSTNode left;
	BSTNode right;

	/**
	 * BSTNode builds the binary search tree nodes.
	 * 
	 * @param position
	 * @param guess
	 */
	public BSTNode(int position, String guess) {
		this.position = position;
		this.guess = guess;
	}
}
