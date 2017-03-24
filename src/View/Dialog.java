package View;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Player;

public class Dialog extends JDialog{

	private int gridSize;
	
	public Dialog(){

		while(gridSize < 1){
			try{
		String grid = JOptionPane.showInputDialog("Enter a even size of the grids");
        gridSize = Integer.parseInt(grid);		 
			}catch(Exception e){						
			}	
		}	
	}
	
	public int getGridSize() {
		return gridSize;
	}

	public void setGridSize(int gridSize) {
		this.gridSize = gridSize;
	}
}
