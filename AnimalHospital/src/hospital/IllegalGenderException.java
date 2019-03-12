package hospital;

/**
 * The Illegal Gender Exception throws when the string holding the gender is not valid
 * @author Gunwati Agrawal and Katya Bezugla
 * Version: 1.0.0
 */
public class IllegalGenderException extends Throwable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * No-argument constructor
	 */
	public IllegalGenderException()
	{
		super("Invalid gender.");
	}
	
	/**
	 * Constructs an Illegal Gender Exception with the Error Message containing the invalid string.
	 * @param error
	 */
	public IllegalGenderException(String error) {
		super("Invalid gender " + error);
	}

}

