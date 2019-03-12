package hospital;

/**
 * The IllegalEmailException is thrown when an invalid email is registered.
 * @author Gunwati Agrawal and Katya Bezugla
 * Version: 1.0.0
 */
public class IllegalEmailException extends Throwable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructs an instance of IllegalEmailException with a generic message: "Invalid email."
	 */
	public IllegalEmailException() {
		super("Invalid email.");
	}
	
	/**
	 * Constructs an instance of IllegalEmailException with invalid email in specific message.
	 */
	public IllegalEmailException(String email) {
		super("Invalid email: " + email);
	}
}
