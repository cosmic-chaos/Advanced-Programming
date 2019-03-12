import java.util.Arrays;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class Money.
 * @author Katya Bezugla
 */
public class Money {
	
	/** The money. */
	private double money;
	
	/**
	 * Instantiates a new object from an inputed field value.
	 *
	 * @param amount the amount
	 */
	public Money(double amount) {
		money = amount;
	}
	
	/**
	 * Instantiates a new money equivalent to the one inputed.
	 *
	 * @param anotherObject the another object
	 */
	public Money(Money anotherObject) {
		money = anotherObject.getMoney();
	}
	
	/**
	 * Adds two money values from objects
	 *
	 * @param anotherObject the object being added
	 * @return a money object
	 */
	public Money add(Money anotherObject) {
		Money output = new Money(money + anotherObject.getMoney());
		return output;
	}
	
	/**
	 * Subtracts two money values from objects
	 *
	 * @param anotherObject the object being subtracted
	 * @return a new Money object
	 */
	public Money subtract(Money anotherObject) {
		Money output = new Money(money - anotherObject.getMoney());
		return output;
	}
	
	/**
	 * Compares whether two Money objects have greater, lesser, or equivalent values for money.
	 *
	 * @param anotherObject the another object
	 * @return 1 if inputed object is greater, -1 if less, 0 if equivalent
	 */
	public int compareTo(Money anotherObject) {
		if (anotherObject.getMoney() > money) {
			return 1;
		} else if (anotherObject.getMoney() == money) {
			return 0;
		} else {
			return -1;
		}
	}
	
	/**
	 * Checks if two Money objects are equal in field values.
	 *
	 * @param anotherObject the object being compared to
	 * @return true, if successful
	 */
	public boolean equals(Money anotherObject) {
		if (anotherObject.getMoney() == money) {
			return true;
		}
		return false;
	}
	
	/* 
	 * return a nicely formatted version of the money value.
	 * @return the money
	 */
	public String toString() {
		String round = Double.toString(Math.round(money * 100.0) / 100.0);

	    List<String> array = Arrays.asList(round.split("\\."));

		if (array.get(1).length() == 1) {
			round += "0";
		}
		
		return "$"+round;
	}
	
	/**
	 * Gets the money value.
	 *
	 * @return the money
	 */
	public double getMoney() {
		return money;
	}
}
