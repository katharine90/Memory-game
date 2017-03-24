package Model;

public class Singelton {

	private static Singelton instance = new Singelton();
	private int grids;
	
	private Singelton(){}

	public static Singelton getInstance() {
		return instance;
	}

	public static void setInstance(Singelton instance) {
		Singelton.instance = instance;
	}

	public int getGrids() {
		return grids;
	}

	public void setGrids(int grids) {
		this.grids = grids;
	}
	
	
}
