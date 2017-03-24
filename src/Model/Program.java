package Model;

import Controller.MainFrame;
import View.Dialog;


public class Program {

	public static void main(String[] args) {
		
		
     	Dialog dialog = new Dialog();  
     	while(dialog.getGridSize()%2 != 0){
     		dialog = new Dialog();
     	}
     	
		Singelton singelton = Singelton.getInstance();
		singelton.setGrids(dialog.getGridSize());
		
		MainFrame frame = new MainFrame();

		

	}

}
