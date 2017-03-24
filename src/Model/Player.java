package Model;

/**
 * Player - Model. This card represents a player
 * 
 * @author KitKat
 * @since 1.0
 */
public class Player {

	private String name;
	private int playerscore;
	private int computerScore;

	/**
	 * @param name - the name for the player
	 */
	public Player(String name) {
		this.name = name;
	}

	/**
	 * No argument constructor
	 */
	public Player() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlayerscore() {
		return playerscore;
	}

	public void setPlayerscore(int playerscore) {
		this.playerscore = playerscore;
	}

	public int getComputerScore() {
		return computerScore;
	}

	public void setComputerScore(int computerScore) {
		this.computerScore = computerScore;
	}

}
