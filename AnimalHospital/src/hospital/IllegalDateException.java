package hospital;

/**
 * The IllegalDateException is thrown when an invalid date is registered.
 * @author Gunwati Agrawal and Katya Bezugla
 * Version: 1.0.0
 */
public class IllegalDateException extends Throwable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructs an instance of IllegalDateException with generic message: "Invalid date."
	 */
	public IllegalDateException() {
		super("Invalid date.");
	}
	
	/**
	 * Constructs an instance of IllegalDateException with invalid date in specific message.
	 */
	public IllegalDateException(String date) {
		super("Invalid date: " + date);
	}
}
