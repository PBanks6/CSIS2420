package finalProject;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * GuessingGame includes the main class for calling all the methods to tie
 * together the linked list and binary search tree to produce the guessing game.
 * 
 * @author Parker Banks
 * CSIS 2420
 * Salt Lake Community College
 *
 */
public class GuessingGame {

	/**
	 * Runs the main program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String file1 = "/Users/parkerbanks/eclipse-workspace/CSIS_2420/src/finalProject/marioCartQs.csv";
		String file2 = "/Users/parkerbanks/eclipse-workspace/CSIS_2420/src/finalProject/altGuesses.csv";
		long startTime;
		long endTime;
		long BTTime;
		long LLTime;
		BSTNode finalGuess;

		BinarySearchTree tree = new BinarySearchTree();
		LinkedList LList = new LinkedList();

		writeBST(file1, tree);
		writeLL(file2, LList);
		System.out.println("                 Welcome to the Mario Cart Guessing Game!!");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("                    Think of a Mario Cart Character...");
		System.out.println("I'm going to ask you some yes or no questions and try to guess your character.");
		System.out.println("         Respond to each question with 'Y' for yes and 'N' for no.");
		System.out.println("                              Let's begin!");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("");
		startTime = System.nanoTime();
		finalGuess = tree.returnGuess(tree.root);
		endTime = System.nanoTime();
		BTTime = ((endTime - startTime) - tree.userResponseTime);
		startTime = System.nanoTime();
		LList.returnGuess(finalGuess.guess);
		endTime = System.nanoTime();
		LLTime = ((endTime - startTime) - LList.userResponseTime);
		System.out.println("");
		System.out.println("                               Testing Results");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("");
		System.out.println("Printing Binary Tree...");
		System.out.println("-----------------------");
		tree.preOrderTraverse(tree.root);
		System.out.println("");
		System.out.println("There are " + tree.countNodes(tree.root) + " nodes.");
		System.out.println(" ");
		System.out.println("Printing LinkedList");
		System.out.println("-------------------");
		LList.displayLinkedList();
		System.out.println("");
		System.out.println("Timing Results");
		System.out.println("--------------");
		System.out.println("It took the computer " + BTTime + " nanoseconds to traverse the Binary Tree.");
		System.out.println("");
		System.out.println("It took the computer " + LLTime + " nanoseconds to traverse the linked list.");
	}

	/**
	 * writeBST reads the question csv file and writes them to a binary search tree.
	 * 
	 * @param file
	 * @param tree
	 */
	public static void writeBST(String file, BinarySearchTree tree) {
		String line;
		int position;
		String guess;
		int i = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				String[] lineA = line.split("[,]", 0);

				if (i == 0) {
					position = 1000;
				} else {
					position = Integer.parseInt(lineA[0]);
				}
				guess = lineA[1];
				tree.insert(position, guess);
				i++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * writeLL reads the alternate characters list and writes them to a linked list.
	 * 
	 * @param file
	 * @param LList
	 */
	public static void writeLL(String file, LinkedList LList) {
		String line;
		String altGuess;
		int x = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				String[] lineA = line.split("[,]", 0);
				for (int i = 0; i < lineA.length; i++) {
					altGuess = lineA[i];
					LList.appendNode(x, altGuess);
				}
				x++;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
