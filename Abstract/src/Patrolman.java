
// TODO: Auto-generated Javadoc
/**
 * Class to create a patrolman.
 * @author Katya Bezugla
 */
public class Patrolman extends Policeman
{
	
	/** The base patrol pay. */
	protected static double basePatrolPay = 3600;
	
	/**
	 * Instantiates a new patrolman.
	 *
	 * @param first the first name.
	 * @param last the last name.
	 * @param y the years of service.
	 */
	Patrolman(String first, String last, int y)
	{
		super(first,last,y);
	}
	
	/* (non-Javadoc)
	 * @see Policeman#earnings()
	 */
	public double earnings()
	{
		return .85 * basePatrolPay + .06 * Math.sqrt(basePatrolPay) * y;
	}
	
	/* (non-Javadoc)
	 * @see Policeman#benefitLevel()
	 */
	public int benefitLevel()
	{
		return 1;
	}
	
	/**
	 * Gets the base pay of the patrolman.
	 *
	 * @return the base pay
	 */
	public double getBasePay() {
		return basePatrolPay;
	}
	
	/**
	 * Returns a formatted version of the objects aspects, including its class name.
	 * @return string of objects aspects
	 */
	public String toString() {
		return "Patrolman: " + first + " " + last
				+ "\n years of service = " + y
				+ "\n earnings = " + round(earnings())
				+ "\n benefit level = " + benefitLevel();
	}
}
