package week6;

public class PlayerLinkedList {
	PlayerNode head;
	PlayerNode tail;

	public static void main(String[] args) {

	}

	public void append(int playerID, String firstName, String lastName, String playerName, String playerType,
			double lifePoints, int totalScore) {
		if (head == null) {
			head = new PlayerNode(playerID, firstName, lastName, playerName, playerType, lifePoints, totalScore);
			return;
		}
		PlayerNode current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new PlayerNode(playerID, firstName, lastName, playerName, playerType, lifePoints, totalScore);
	}

	public void delete(int playerID) {
		if (head.playerID == playerID) {
			head = head.next;
			return;
		}
		PlayerNode current = head;
		while (current.next != null) {
			if (current.next.playerID == playerID) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
		System.out.println("The provided value is not found in this list\n");
	}

	public void length() {
		int leng = 0;
		PlayerNode current = head;
		while (current.next != null) {
			leng++;
			current = current.next;
		}

		System.out.println("The length of the list is " + (leng + 1) + ".");
		System.out.println("");
	}

	public void prepend(int playerID, String firstName, String lastName, String playerName, String playerType,
			double lifePoints, int totalScore) {
		PlayerNode prepend = new PlayerNode(playerID, firstName, lastName, playerName, playerType, lifePoints,
				totalScore);

		if (head == null) {
			head = prepend;
			tail = prepend;
		} else {
			PlayerNode cur = head;
			head = prepend;
			head.next = cur;
		}

	}

	public void printPlayerList() {
		PlayerNode current = head;
		System.out.println("------------------------------------------------------------------------");
		System.out.println("                          P l a y e r  L i s t");
		System.out.println("------------------------------------------------------------------------");
		System.out.println("ID       Name                 Player Name      Type      Life      Score");
		System.out.println("------------------------------------------------------------------------");
		while (current != null) {
			String name = current.firstName + " " + current.lastName;
			System.out.printf("%-9d%-21s%-17s%-10s%-10.2f%d\n", current.playerID, name, current.playerName,
					current.playerType, current.lifePoints, current.totalScore);
			current = current.next;
		}
		System.out.println();
	}

	public String search(int playerID) {
		String result = null;
		if (head == null) {
			return null;
		}
		PlayerNode current = head;
		if (head.playerID == playerID) {
			result = current.toString();
		} else {
			while (current.next != null) {
				if (current.next.playerID == playerID) {
					result = current.next.toString();
				}
				current = current.next;
			}
		}
		return result;
	}

	public String search(String firstName, String lastName) {
		String result = null;
		if (head == null) {
			return null;
		}
		PlayerNode current = head;
		if (head.firstName.equals(firstName) && head.lastName.equals(lastName)) {
			result = current.toString();
		} else {
			while (current.next != null) {
				if (current.next.firstName.equals(firstName) && current.next.lastName.equals(lastName)) {
					result = current.next.toString();
				}
				current = current.next;
			}
		}
		return result;
	}

	public String search(String playerName) {
		String result = null;
		if (head == null) {
			return null;
		}
		PlayerNode current = head;
		if (head.playerName.equals(playerName)) {
			result = current.toString();
		} else {
			while (current.next != null) {
				if (current.next.playerName.equals(playerName)) {
					result = current.next.toString();
				}
				current = current.next;
			}
		}
		return result;
	}

	public void searchType(String playerType) {
		PlayerNode current = head;
		System.out.println("------------------------------------------------------------------------");
		System.out.println("                          P l a y e r  L i s t");
		System.out.println("------------------------------------------------------------------------");
		System.out.println("ID       Name                 Player Name      Type      Life      Score");
		System.out.println("------------------------------------------------------------------------");
		while (current != null) {
			if (current.playerType.equals(playerType)) {
				String name = current.firstName + " " + current.lastName;
				System.out.printf("%-9d%-21s%-17s%-10s%-10.2f%d\n", current.playerID, name, current.playerName,
						current.playerType, current.lifePoints, current.totalScore);
			}
			current = current.next;
		}
		System.out.println();
	}

	public String highScore() {
		PlayerNode current = head;
		String player = null;
		int score = 0;
		if (head == null) {
			return null;
		} else {
			score = current.totalScore;
		}
		while (current != null) {
			if (current.totalScore > score) {
				score = current.totalScore;
				String name = current.firstName + " " + current.lastName;
				player = String.format("%-9d%-21s%-17s%-10s%-10.2f%d\n", current.playerID, name, current.playerName,
						current.playerType, current.lifePoints, current.totalScore);
			}
			current = current.next;
		}
		return player;

	}

	public String lowScore() {
		PlayerNode current = head;
		String player = null;
		int score = 0;
		if (head == null) {
			return null;
		} else {
			score = current.totalScore;
		}
		while (current != null) {
			if (current.totalScore < score) {
				score = current.totalScore;
				String name = current.firstName + " " + current.lastName;
				player = String.format("%-9d%-21s%-17s%-10s%-10.2f%d\n", current.playerID, name, current.playerName,
						current.playerType, current.lifePoints, current.totalScore);
			}
			current = current.next;
		}
		return player;

	}

	public String printReference(String ref) {
		PlayerNode current = head;
		String player = null;

		while (current != null) {
			if (current.toString().equals(ref)) {
				String name = current.firstName + " " + current.lastName;
				player = String.format("%-9d%-21s%-17s%-10s%-10.2f%d\n", current.playerID, name, current.playerName,
						current.playerType, current.lifePoints, current.totalScore);
			}
			current = current.next;
		}
		return player;
	}

}
