package weeks9to10Assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * This class runs the console menu, generating a menu for options manipulating
 * or examining the CSV file within a binary search tree.
 * 
 * @author Parker Banks.
 * CSIS 2420.
 * Salt Lake Community College.
 * November 17, 2021.
 *
 */
public class IPUserDemo {

	public static void main(String[] args) {
		IPUserBinarySearchTree IPU = new IPUserBinarySearchTree();
		Scanner input = new Scanner(System.in);

		int IP;
		String userName;
		String file = "/Users/parkerbanks/eclipse-workspace/CSIS_2420/src/weeks9to10Assignment2/users.csv";
		String line;
		boolean quit = false;
		int choice;
		String result = null;
		int userNum;
		String userStr;

		do {
			displayMenu();
			choice = input.nextInt();
			switch (choice) {
			case 1:
				try (BufferedReader br = new BufferedReader(new FileReader(file))) {
					while ((line = br.readLine()) != null) {
						String[] lineA = line.split("[,]", 0);

						IP = Integer.parseInt(lineA[0]);
						userName = lineA[1];
						IPU.insert(IP, userName);
					}
				} catch (Exception e) {
					System.out.println(e);
				}
				System.out.println("\nUser tree has been built.");
				break;
			case 2:
				System.out.print("\nEnter the last digits of the IP address you want to find: ");
				userNum = input.nextInt();
				result = IPU.search(IPU.root, userNum);
				if (result == null) {
					System.out.println("IP 10.0.0." + userNum + " not found.");
				} else {
					System.out.println(result);
				}
				IPU.clear();
				result = null;
				break;
			case 3:
				System.out.print("\nEnter the username of the user you want to find: ");
				userStr = input.next();
				result = IPU.search(IPU.root, userStr);
				if (result == null) {
					System.out.println("User " + userStr + " not found.");
				} else {
					System.out.println(result);
				}
				IPU.clear();
				result = null;
				break;
			case 4:
				System.out.println("\nThere are " + IPU.countNodes(IPU.root) + " nodes.");
				IPU.clear();
				break;
			case 5:
				System.out.println("\nIP Address  Username");
				System.out.println("----------  --------");
				IPU.printTree(IPU.root);
				break;
			case 6:
				quit = true;
				break;
			default:
				System.out.println("\nInvalid choice.");
			}
			System.out.print("\n");
		} while (!quit);
		System.out.println("Goodbye!");
		input.close();
	}

	/**
	 * Prints menu to console with options for the binary search tree.
	 */
	public static void displayMenu() {
		System.out.println("-------------------------");
		System.out.println("1 Build Users Tree");
		System.out.println("2 Find by IP Address");
		System.out.println("3 Find by Username");
		System.out.println("4 Report Number of Nodes");
		System.out.println("5 Print Entire Tree");
		System.out.println("6 Exit");
		System.out.println("-------------------------");
		System.out.print("Enter 1, 2, 3, 4, 5 or 6: ");
	}

}
