package Controller;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import Model.Player;

/**
 * GameFactory - Controller
 * This class creates 2 players
 * 
 * @author KitKat
 * @since 1.0
 */
public class GameFactory extends JDialog {

	public Player playerOne = new Player();
	public Player playerTwo = new Player();


	public GameFactory() {

		String pl1 = JOptionPane.showInputDialog("Player 1: ");
		this.playerOne.setName(pl1);

		String pl2 = JOptionPane.showInputDialog("Player 2: ");
		this.playerTwo.setName(pl2);

	}
	
	public Player getPlayerOne() {
		return playerOne;
	}

	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}

	public Player getPlayerTwo() {
		return playerTwo;
	}

	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}

}
