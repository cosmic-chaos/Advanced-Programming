package inheritance;

/**
 * Used to create an ID card with an owner and an ID number.
 *
 * @author  Katya Bezugla
 */

public class IDCard extends Card {
	
	/**
	 * Represents the card's ID number.
	 */
	
	private String idNum;
	
	/**
	 * Constructs the object, setting the owner's name and the ID number.
	 *
	 * @param  n card owner's name.
	 * @param id card's ID number.
	 */
	
	public IDCard(String n, String id) {
		super(n);
		idNum = id;
	}
	
	/**
	 * Returns a formatted version of the card's information.
	 *
	 * @return  Card holder: card owner's name, ID Number: card's ID number.
	 */
	
	public String format() {
		return super.format() + ", ID Number: " + idNum;
	}
	
	/**
	 * Returns a formatted version of the card's instance fields, including the class name it belongs to.
	 *
	 * @return IDCard[name=card owner's name][idNum=card's ID number].
	 */
	
	public String toString()
    {
    	return super.toString() + "[idNum=" + idNum + "]";
    }
	
	/**
	 * Gets the card's ID number.
	 *
	 * @return  an ID number.
	 */
	
	public String getID() {
		return idNum;
	}
}
