
// TODO: Auto-generated Javadoc
/**
 * Class to create a policeman.
 * @author Katya Bezugla
 */
public abstract class Policeman {
	
	/** The first name. */
	protected String first;
	
	/** The last name. */
	protected String last;
	
	/** The years of service. */
	protected int y;
	
	/**
	 * Instantiates a new policeman.
	 *
	 * @param first the first name
	 * @param last the last name
	 * @param y the years of service
	 */
	public Policeman(String first, String last, int y)
	{
		this.first = first;
		this.last = last;
		this.y = y;
	}
	
	/**
	 * Calculates the policeman's earnings.
	 *
	 * @return the double
	 */
	abstract double earnings();
	
	/**
	 * Returns the policeman's benefit level.
	 *
	 * @return the int
	 */
	abstract int benefitLevel();
	
	/**
	 * Compares against another object to see if they are equivalent.
	 *
	 * @param compare the object to compare against
	 * @return true, if successful
	 */
	public boolean equals(Policeman compare)
	{
		if(toString().equals(compare.toString())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Rounds a number to two decimal places.
	 *
	 * @param num the number to be rounded
	 * @return the rounded number
	 */
	public double round(double num) {
		return Math.round(num * 100.0)/100.0;
		//return num;
	}
}
