
public class SocSecException extends Throwable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SocSecException(String error) {
		System.out.print("Invalid social security number" + error);
	}
}
