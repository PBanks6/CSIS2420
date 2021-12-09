package finalProject;

/**
 * LList initializes the linked list including the grouped Mario Cart
 * characters.
 * 
 ** @author Parker Banks
 * CSIS 2420
 * Salt Lake Community College
 *
 */
public class LList {

	LList next;
	String altGuess;

	/**
	 * LList initializes the linked list nodes.
	 * 
	 * @param altGuess
	 */
	public LList(String altGuess) {
		this.altGuess = altGuess;
	}
}
