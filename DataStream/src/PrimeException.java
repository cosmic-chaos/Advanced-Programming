
public class PrimeException extends Throwable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PrimeException() {
		System.out.print("This number is not prime.");
	}
	
	public PrimeException(int num) {
		System.out.print("This number, " + num + ", is not prime.");
	}
}
