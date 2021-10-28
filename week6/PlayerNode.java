package week6;

public class PlayerNode {

	PlayerNode next;
	int playerID;
	String firstName;
	String lastName;
	String playerName;
	String playerType;
	double lifePoints;
	int totalScore;

	public PlayerNode(int playerID, String firstName, String lastName, String playerName, String playerType,
			double lifePoints, int totalScore) {
		this.playerID = playerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.playerName = playerName;
		this.playerType = playerType;
		this.lifePoints = lifePoints;
		this.totalScore = totalScore;

	}
}
