
// TODO: Auto-generated Javadoc
/**
 * Class to create a lieutenant.
 * @author Katya Bezugla
 */
public class Lieutenant extends Sergeant
{
	
	/** The base lieutenant pay. */
	protected static double baseLieutenantPay = 5900;
	
	/**
	 * Instantiates a new lieutenant.
	 *
	 * @param first the first name
	 * @param last the last name
	 * @param y the years of service
	 */
	public Lieutenant(String first, String last,int y)
	{
		super(first, last, y);
	}
	
	/* (non-Javadoc)
	 * @see Sergeant#earnings()
	 */
	public double earnings()
	{
		return .8 * baseLieutenantPay + 1.3 * Math.sqrt(baseLieutenantPay) * y;

	}
	
	/* (non-Javadoc)
	 * @see Sergeant#benefitLevel()
	 */
	public int benefitLevel()
	{
		return super.benefitLevel() + 3;
	}
	
	/* (non-Javadoc)
	 * @see Sergeant#getBasePay()
	 */
	public double getBasePay() {
		return baseLieutenantPay;
	}
	
	/**
	 * Returns a formatted version of the objects aspects, including its class name.
	 * @return string of objects aspects
	 */
	public String toString() {
		return "Lieutenant: " + first + " " + last
				+ "\n years of service = " + y
				+ "\n earnings = " + round(earnings())
				+ "\n benefit level = " + benefitLevel();
	}
}