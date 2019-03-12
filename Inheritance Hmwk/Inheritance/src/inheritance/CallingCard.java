package inheritance;

/**
 * Used to create a calling card with an owner, a card number, and a PIN.
 *
 * @author Katya Bezugla
 */

public class CallingCard extends Card {
	
	/**
	 * Represents the card's number.
	 */
	
	private String cardNum;
	
	/**
	 * Represents the card's PIN.
	 */
	
	private String pin;
	
	/**
	 * Constructs the object, setting the owner's name, and the card's number and PIN.
	 *
	 * @param  n card owner's name.
	 * @param num card's number.
	 * @param pinNum card's PIN.
	 */
	
	public CallingCard(String n, String num, String pinNum) {
		super(n);
		cardNum = num;
		pin = pinNum;
	}
	
	/**
	 * Returns a formatted version of the card's information.
	 *
	 * @return  Card holder: card owner's name, Card Number: card's number, PIN: card's pin.
	 */
	
	public String format() {
		return super.format() + ", Card Number: " + cardNum + ", PIN: " + pin;
	}
	
	/**
	 * Returns a formatted version of the card's instance fields, including the class name it belongs to.
	 *
	 * @return CallingCard[name=card owner's name][cardNum=card's number,pin=card's pin].
	 */
	
	public String toString()
    {
    	return super.toString() + "[cardNum=" + cardNum + ",pin=" + pin + "]";
    }
	
	/**
	 * Gets the card's number.
	 *
	 * @return  the card's number.
	 */
	
	public String getNumber() {
		return cardNum;
	}
}
