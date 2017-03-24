package Model;

public interface Game {

	public boolean switchTurn(int i);
	public Player move(int i, int j); 
	public int getStatus(int i, int j); 
	public String getMessage();
}
