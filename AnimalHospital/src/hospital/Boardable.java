package hospital;

/**
 * 
 * @author Gunwati Agrawal and Katya Bezugla
 *
 */
public interface Boardable {
	
	/**
	 * 
	 * @param month
	 * @param day
	 * @param year
	 * @throws IllegalDateException
	 */
	void setBoardStart(int month, int day, int year) throws IllegalDateException;
	
	/**
	 * 
	 * @param month
	 * @param day
	 * @param year
	 * @throws IllegalDateException
	 */
	void setBoardEnd(int month, int day, int year) throws IllegalDateException;
	
	/**
	 * 
	 * @param month
	 * @param day
	 * @param year
	 * @return
	 */
	boolean boarding(int month, int day, int year);
}

