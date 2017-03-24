package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controller.CheckWinner;
import Controller.GameFactory;
import Model.Card;
import Model.Game;
import Model.Singelton;

/**
 * Boxes - Controller/ Model. This class builds the main GUI of the cards and
 * gives them pairs with specific ID's.
 * 
 * @author KitKat
 * @since 1.0
 * 
 */
public class Boxes extends JPanel implements ActionListener {

	JButton[] button = new JButton[Singelton.getInstance().getGrids()];
	ArrayList<Card> card = new ArrayList<>();

	public Game game;
	public Timer timer = new Timer();
	public CheckWinner checkWinner;
	public GameFactory factory;
	
	int[] check = new int[2];
	String[] isValid = new String[2];
	static int count;
	static int addPoints;
	static int switchTurn = 0;

	/**
	 * No agrument constructor Creates pairs witch a specific ID for the cards,
	 * fills the JPanel witch a requested size of grids (see Singelotn)
	 */
	public Boxes() {
		int add = 0;
		for (int i = 0; i < button.length; i++) {
			add++;
			String num = Integer.toString((add + 1) / 2);

			card.add(new Card(this, num));

			button[i] = new JButton();
			button[i].setPreferredSize(new Dimension(85, 85));
			button[i].setText(null);
			this.add(button[i]);
			button[i].addActionListener(this);
		}

		for (Card s : card) {
			 //Collections.shuffle(card);
		}

		for (int i = 0; i < button.length; i++) {
			button[i].setActionCommand(Integer.toString(i));
		}

		this.setLayout(new GridLayout(4, 4));
	}

	/**
	 * Creates functions for every clicked button.
	 */
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();

		String icon = clicked.getActionCommand();
		int cardInt = Integer.parseInt(icon);

		card.get(cardInt).setToggle(true);

		isValid[count] = icon;
		check[count] = cardInt;
		count++;

		for (int i = 0; i < button.length; i++) {
			if (card.get(i).isToggle() == true) {
				button[i].setText(card.get(i).getId());
			}
		}

		if (count == 2) {
			switchTurn++;

			if (game != null) {
				int i = Integer.parseInt(card.get(check[0]).getId());
				int j = Integer.parseInt(card.get(check[1]).getId());
				game.move(i, j);
				game.switchTurn(switchTurn);			
			}

			if (isValid[0].equals(isValid[1])) {

				card.get(check[0]).toggleState();
				button[check[0]].setText(null);
				// System.out.println("UPPTAGEN RUTA!");

			} else if (card.get(check[0]).getId().equals(card.get(check[1]).getId())) {
				addPoints++;

				button[check[0]].setEnabled(false);
				button[check[1]].setEnabled(false);

				if (game != null) {
					int i = Integer.parseInt(card.get(check[0]).getId());
					int j = Integer.parseInt(card.get(check[1]).getId());
					game.getStatus(i, j);
				}

				if (checkWinner != null) {
					addPoints = addPoints + 1;
					int gridSize = Singelton.getInstance().getGrids();
					int checkedBoxes = addPoints;
					checkWinner.checkGrids(gridSize, checkedBoxes);
				}

			} else {
				button[check[0]].setText(null);
				card.get(check[0]).toggleState();
				card.get(check[1]).toggleState();

				timer.schedule(new java.util.TimerTask() {
					public void run() {
						button[check[1]].setText(null);
					}
				}, 1000);

			}
			count = 0;			
		}

	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void setCheckWinner(CheckWinner checkWinner) {
		this.checkWinner = checkWinner;
	}

}
