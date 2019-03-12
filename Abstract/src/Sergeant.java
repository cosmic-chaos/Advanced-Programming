
// TODO: Auto-generated Javadoc
/**
 * Class to create a sergeant.
 * @author Katya Bezugla
 */
public class Sergeant extends Patrolman
{
	
	/** The base sergeant pay. */
	protected static double baseSgtPay = 4700;
	
	/**
	 * Instantiates a new sergeant.
	 *
	 * @param first the first name
	 * @param last the last name
	 * @param y the years of service
	 */
	public Sergeant(String first, String last,int y)
	{
		super(first, last, y);
	}
	
	/* (non-Javadoc)
	 * @see Patrolman#earnings()
	 */
	public double earnings()
	{
		return .82 * baseSgtPay + 1.2 * Math.sqrt(baseSgtPay) * y;
	}
	
	/* (non-Javadoc)
	 * @see Patrolman#benefitLevel()
	 */
	public int benefitLevel()
	{
		return super.benefitLevel() + 2;
	}
	
	/* (non-Javadoc)
	 * @see Patrolman#getBasePay()
	 */
	public double getBasePay() {
		return baseSgtPay;
	}
	
	/**
	 * Returns a formatted version of the objects aspects, including its class name.
	 * @return string of objects aspects
	 */
	
	public String toString() {
		return "Sergeant: " + first + " " + last
				+ "\n years of service = " + y
				+ "\n earnings = " + round(earnings())
				+ "\n benefit level = " + benefitLevel();
	}
}
