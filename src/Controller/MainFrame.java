package Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Game;
import Model.Player;
import View.Boxes;
import View.Dialog;

/**
 * MainFrame - Controller This class implements Game methods, crates enum values
 * for both players and builds a GUI for the main frame.
 * 
 * @author KitKat
 * @since 1.0
 */
public class MainFrame extends JFrame {

	public Boxes boxes;
	public Player player;
	public Dialog dialog;
	public GameFactory factory;
	static int turn;
	static int player1Score;
	static int player2Score;

	JPanel panel = new JPanel();
	JLabel[] labels = new JLabel[4];

	public enum Players {
		PLAYERONE, PLAYERTWO
	}
	
	Players players;

	/**
	 * No argument constructor
	 */
	public MainFrame() {
		factory = new GameFactory();
		boxes = new Boxes();

		/**
		 * Implements new game methods for every click 
		 */
		boxes.setGame(new Game() {
			
			/**
			 * Switches between two players
			 * @return - returns a boolean value
			 */
			@Override
			public boolean switchTurn(int i) {
				i = turn++;
				return turn % 2 == 0;
			}

			/**
			 * Switches the current player for every 2 piced cards
			 * @return - returns current player
			 */
			@Override
			public Player move(int i, int j) {
				if (switchTurn(0) == true) {
					switchTurn(0);
					return factory.playerOne;
				} else {
					switchTurn(0);
					return factory.playerTwo;
				}
			}

			@Override
			public int getStatus(int i, int j) {
				if (move(0, 0) == factory.playerOne) {
					if (i == j) {
						player1Score++;
						factory.playerOne.setPlayerscore(player1Score);
						labels[1].setText("" + factory.playerOne.getPlayerscore());
					}
				} else if (move(0, 0) == factory.playerTwo) {
					if (i == j) {
						player2Score++;
						factory.playerTwo.setPlayerscore(player2Score);
						labels[3].setText("" + factory.playerTwo.getPlayerscore());
					}
				}
				return 0;
			}
			
			@Override
			public String getMessage() {
				return null;
			}		
		});


		/**
		 * Gets the number of the grids and checks if all the cards in the grid are used
		 */
		boxes.setCheckWinner(new CheckWinner() {
			@Override
			public void checkGrids(int gridSize, int checkedBoxes) {
				if (checkedBoxes == gridSize) {
					if (factory.playerOne.getPlayerscore() > factory.playerTwo.getPlayerscore()) {
						labels[0].setText(" " + factory.getPlayerOne().getName() + " wins!");
						labels[0].setForeground(Color.BLUE);
					} else if(factory.playerOne.getPlayerscore() < factory.playerTwo.getPlayerscore()){
						labels[2].setText(" " + factory.getPlayerTwo().getName() + " wins!");
						labels[2].setForeground(Color.BLUE);						
					} else if(factory.playerOne.getPlayerscore() == factory.playerTwo.getPlayerscore()){
						labels[2].setText(" " + factory.getPlayerTwo().getName() + " it's a tie!");
						labels[0].setText(" " + factory.getPlayerOne().getName() + " it's a tie!");
					}
				}

			}
		});

		
		this.add(boxes);
		this.add(panel);

		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel();
			panel.add(labels[i]);
			labels[i].setFont(new Font(Font.DIALOG, Font.BOLD, 20));
			labels[i].setOpaque(true);

			if (i == 0 || i == 1) {
				labels[i].setBackground(Color.WHITE);
			}
		}
		labels[0].setText(" " + players.PLAYERONE.toString());
		labels[2].setText(" " + players.PLAYERTWO.toString());

		panel.setLayout(new GridLayout(2, 2));

		this.setTitle("Memory");
		this.setLayout(new GridLayout(2, 1));
		this.setSize(500, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.pack(); // Anpassar komponenter efter ()perferedSize
	}

}