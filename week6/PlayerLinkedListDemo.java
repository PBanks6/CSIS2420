package week6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public class PlayerLinkedListDemo {

	public static void main(String[] args) {
		PlayerLinkedList players = new PlayerLinkedList();

		String file = "/Users/parkerbanks/eclipse-workspace/CSIS_2420/Players.csv";
		String line;
		int playerID;
		String firstName;
		String lastName;
		String playerName;
		String playerType;
		double lifePoints;
		int totalScore;
		int i = 0;
		Scanner input = new Scanner(System.in);
		boolean quit = false;
		int choice;

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				String[] lineA = line.split("[,]", 0);

				// Not sure why first variable (1122) returns a NumberFormatException with
				// parseInt. The coder value in the debug menu under variables equals 1
				// (coder=1) for lineA[0] which causes the error. All other variables run fine
				// after first variable in the csv file. I wrote this if loop to overcome the
				// issue.
				// -------------------------------------------------------------------------------
				if (i == 0) {
					playerID = 1122;
				} else {
					playerID = Integer.parseInt(lineA[0]);
				}
				i++;
				// -------------------------------------------------------------------------------

				firstName = lineA[1];
				lastName = lineA[2];
				playerName = lineA[3];
				playerType = lineA[4];
				lifePoints = Double.parseDouble(lineA[5]);
				totalScore = Integer.parseInt(lineA[6]);
				players.append(playerID, firstName, lastName, playerName, playerType, lifePoints, totalScore);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		do {
			displayMenu();
			choice = input.nextInt();
			switch (choice) {
			case 1:
				newPlayer(players);
				break;
			case 2:
				deletePlayer(players);
				break;
			case 3:
				totNumPlayers(players);
				break;
			case 4:
				printList(players);
				break;
			case 5:
				searchID(players);
				break;
			case 6:
				searchRealName(players);
				break;
			case 7:
				searchGameName(players);
				break;
			case 8:
				highScore(players);
				break;
			case 9:
				lowScore(players);
				break;
			case 0:
				quit = true;
				break;
			default:
				System.out.println("Invalid choice.");
			}
			System.out.print("\n");
		} while (!quit);
		System.out.println("Goodbye!");
		input.close();

	}

	private static void displayMenu() {
		System.out.println("-----------------------------------------");
		System.out.println("1. Add a new player");
		System.out.println("2. Delete a player");
		System.out.println("3. Report total number of players");
		System.out.println("4. Print full player list");
		System.out.println("5. Search by Player ID");
		System.out.println("6. Search by Player's real name");
		System.out.println("7. Search by Player's Game Name");
		System.out.println("8. Report Player with Highest Total Score");
		System.out.println("9. Report Player with Lowest Total Score");
		System.out.println("0. Exit");
		System.out.println("-----------------------------------------");
		System.out.print("Enter Menu Choice (0-9): ");

	}

	private static void newPlayer(PlayerLinkedList players) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		String firstName = "";
		String lastName = "";
		String userName = "";
		String playerType = "";
		String sid;
		int id;
		double lifePoints = 0;
		int score = 0;

		System.out.print("\nEnter player's real first name: ");
		firstName = input.nextLine();
		System.out.print("\nEnter player's real last name: ");
		lastName = input.nextLine();
		System.out.print("\nEnter the player's game player name: ");
		userName = input.nextLine();
		System.out.print("\nEnter the player's type: ");
		playerType = input.nextLine();

		sid = String.format("%04d", random.nextInt(10000));
		id = Integer.parseInt(sid);

		// Extra Credit
		while (players.search(id) != null) {
			sid = String.format("%04d", random.nextInt(10000));
			id = Integer.parseInt(sid);
		}
		players.append(id, firstName, lastName, userName, playerType, lifePoints, score);
		System.out.println("\nPlayer has been added!");

	}

	private static void deletePlayer(PlayerLinkedList players) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int id = -1;

		System.out.print("\nEnter a player's Id to delete the player: ");
		id = input.nextInt();
		players.delete(id);
		System.out.println("\nThe player has been deleted.");

	}

	private static void totNumPlayers(PlayerLinkedList players) {
		System.out.println("\n");
		players.length();

	}

	private static void printList(PlayerLinkedList players) {
		System.out.println("\n");
		players.printPlayerList();

	}

	private static void searchID(PlayerLinkedList players) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int id = -1;
		String player = "";

		System.out.print("\nEnter a player's Id to search for: ");
		id = input.nextInt();
		player = players.search(id);

		if (player != null) {
			System.out.println("\n------------------------------------------------------------------------");
			System.out.println("                          P l a y e r  F o u n d");
			System.out.println("------------------------------------------------------------------------");
			System.out.println("ID       Name                 Player Name      Type      Life      Score");
			System.out.println("------------------------------------------------------------------------");
			System.out.println(players.printReference(player));
		} else {
			System.out.println("\nThe player was not found.");
		}

	}

	private static void searchRealName(PlayerLinkedList players) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String player = "";
		String firstName = "";
		String lastName = "";

		System.out.print("\nEnter a player's real first name to search for: ");
		firstName = input.nextLine();
		System.out.print("\nEnter a player's real last name to search for: ");
		lastName = input.nextLine();
		player = players.search(firstName, lastName);

		if (player != null) {
			System.out.println("\n------------------------------------------------------------------------");
			System.out.println("                          P l a y e r  F o u n d");
			System.out.println("------------------------------------------------------------------------");
			System.out.println("ID       Name                 Player Name      Type      Life      Score");
			System.out.println("------------------------------------------------------------------------");
			System.out.println(players.printReference(player));
		} else {
			System.out.println("\nThe player was not found.");
		}

	}

	private static void searchGameName(PlayerLinkedList players) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String player = "";
		String userName = "";

		System.out.print("\nEnter a player's player name to search for: ");
		userName = input.nextLine();
		player = players.search(userName);

		if (player != null) {
			System.out.println("\n------------------------------------------------------------------------");
			System.out.println("                          P l a y e r  F o u n d");
			System.out.println("------------------------------------------------------------------------");
			System.out.println("ID       Name                 Player Name      Type      Life      Score");
			System.out.println("------------------------------------------------------------------------");
			System.out.println(players.printReference(player));
		} else {
			System.out.println("\nThe player was not found.");
		}

	}

	private static void highScore(PlayerLinkedList players) {
		System.out.println("\n");
		System.out.println("------------------------------------------------------------------------");
		System.out.println("                H i g h e s t  S c o r e d  P l a y e r");
		System.out.println("------------------------------------------------------------------------");
		System.out.println("ID       Name                 Player Name      Type      Life      Score");
		System.out.println("------------------------------------------------------------------------");
		System.out.println(players.highScore());

	}

	private static void lowScore(PlayerLinkedList players) {
		System.out.println("\n");
		System.out.println("------------------------------------------------------------------------");
		System.out.println("                  L o w e s t  S c o r e d  P l a y e r");
		System.out.println("------------------------------------------------------------------------");
		System.out.println("ID       Name                 Player Name      Type      Life      Score");
		System.out.println("------------------------------------------------------------------------");
		System.out.println(players.lowScore());

	}

}
