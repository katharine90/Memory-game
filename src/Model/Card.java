package Model;

import java.util.EventObject;

/**
 * Card - Model
 * This class represents a single card. It extends a Eventobject that is compounded to a single click
 * @author KitKat
 * @ since 1.0
 */
public class Card extends EventObject{

	private String id;
	private boolean toggle;

	/**
	 * This constructor gets a source from the Eventobject and id for the card
	 * @param source
	 * @param id
	 */
	public Card(Object source, String id) {
		super(source);
		this.id = id;
	}
	
	public Card(Object source){
		super(source);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isToggle() {
		return toggle;
	}

	public void setToggle(boolean toggle) {
		this.toggle = toggle;
	}

	/**
	 * Toggles the card, so that the card has 2 different states.
	 * If the toggle is equal to true, the card is supposed to reveal the id. 
	 */
	public void toggleState() {
		if (this.toggle == true) {
			this.toggle = false;
		} else {
			this.toggle = true;
		}
	}

}
