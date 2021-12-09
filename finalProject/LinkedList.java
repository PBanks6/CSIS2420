package finalProject;

import java.util.Scanner;

/**
 * LinkedList includes the functions for LList with creating the list, returning
 * lists of characters, and testing methods.
 * 
 * @author Parker Banks
 * CSIS 2420
 * Salt Lake Community College
 *
 */
public class LinkedList {

	public static LList linkedArray[] = new LList[18];
	LList head;
	long startTime;
	long endTime;
	long userResponseTime = 0;

	/**
	 * appendNode builds the LinkedList.
	 * 
	 * @param arrayIndex
	 * @param altGuess
	 */
	public void appendNode(int arrayIndex, String altGuess) {
		if (linkedArray[arrayIndex] == null) {
			linkedArray[arrayIndex] = new LList(altGuess);
		} else {
			LList current = linkedArray[arrayIndex];
			while (current.next != null) {
				current = current.next;
			}
			current.next = new LList(altGuess);
		}
	}

	/**
	 * displayLinkedList displays the linkedList.
	 */
	public void displayLinkedList() {
		for (int i = 0; i < linkedArray.length; i++) {
			System.out.printf("linkedArray[%d]", i);
			if (linkedArray[i] != null) {
				LList current = linkedArray[i];
				System.out.printf(" -> [%s]", current.altGuess);
				while (current.next != null) {
					current = current.next;
					System.out.printf(" -> [%s]", current.altGuess);
				}
			}
			System.out.println();
		}
	}

	/**
	 * returnGuess guesses alternate characters based on user input.
	 * 
	 * @param guess
	 */
	public void returnGuess(String guess) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String response = "N";
		Boolean flag = false;

		if (guess.equals("Dry Bones") || guess.equals("Dry Bowser")) {
			flag = true;
			while (response.equals("N") && linkedArray[0] != null) {
				System.out.print("Is " + linkedArray[0].altGuess + " who you are thinking of?: ");
				startTime = System.nanoTime();
				response = scanner.next();
				endTime = System.nanoTime();
				userResponseTime = userResponseTime + (endTime - startTime);
				System.out.println("");

				if (response.equals("Y") || response.equals("N")) {
					if (response.equals("Y")) {
						System.out.println("Yay! I knew it! I win :)");
					}
					if (response.equals("N") && linkedArray[0] != null) {
						linkedArray[0] = linkedArray[0].next;
					}
					if (response.equals("N") && linkedArray[0] == null) {
						System.out.println("Hmmm... I can't figure it out. You win :/");
					}
				} else {
					System.out.println("Answer must be 'Y' for yes or 'N' for no.");
					System.out.println("");
					guess = linkedArray[0].altGuess;
					returnGuess(guess);
				}

			}
		} else {
			for (int i = 0; i < 18; i++) {
				if (linkedArray[i].altGuess.equals(guess)) {
					flag = true;
					while (response.equals("N") && linkedArray[i] != null) {
						System.out.print("Is " + linkedArray[i].altGuess + " who you are thinking of?: ");
						startTime = System.nanoTime();
						response = scanner.next();
						endTime = System.nanoTime();
						userResponseTime = userResponseTime + (endTime - startTime);
						System.out.println("");

						if (response.equals("Y") || response.equals("N")) {
							if (response.equals("Y")) {
								System.out.println("Yay! I knew it! I win :)");
							}
							if (response.equals("N") && linkedArray[i] != null) {
								linkedArray[i] = linkedArray[i].next;
							}
							if (response.equals("N") && linkedArray[i] == null) {
								System.out.println("Hmmm... I can't figure it out. You win :/");
							}
						} else {
							System.out.println("Answer must be 'Y' for yes or 'N' for no.");
							System.out.println("");
							guess = linkedArray[i].altGuess;
							returnGuess(guess);
						}

					}

				}
			}
		}
		if (flag == false) {
			System.out.print("Is " + guess + " who you are thinking of?: ");
			startTime = System.nanoTime();
			response = scanner.next();
			endTime = System.nanoTime();
			userResponseTime = userResponseTime + (endTime - startTime);
			System.out.println("");
			if (response.equals("Y") || response.equals("N")) {
				if (response.equals("Y")) {
					System.out.println("Yay! I knew it! I win :)");
				}
				if (response.equals("N")) {
					System.out.println("Hmmm... I can't figure it out. You win :/");
				}
			} else {
				System.out.println("Answer must be 'Y' for yes or 'N' for no.");
				System.out.println("");
				returnGuess(guess);
			}

		}
	}

}
