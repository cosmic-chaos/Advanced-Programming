import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Airplane.
 * @author Katya Bezugla
 */
public class Airplane implements Flier, Displayable {
	
	/** The minimum speed possible. */
	private final int speedMin = 500;
	
	/** The maximum speed possible. */
	private final int speedMax = 600;
	
	/** The minimum height possible. */
	private final int heightMin =  30000;
	
	/** The maximum height possible. */
	private final int heightMax = 40000;
	
	/** The maximum barrel rolls possible. */
	private final int barrelMax = 10;
	
	/* (non-Javadoc)
	 * @see Flier#fly()
	 */
	public String fly() {
		Random rand = new Random();
		String output = "You are an airplane. \n";
		
		int  n = rand.nextInt(speedMax) + speedMin;
		output += "Your average speed was " + n + " mph. \n";
		
		n = rand.nextInt(heightMax) + heightMin;
		output += "Your average height was " + n + " ft. \n";
		
		n = rand.nextInt(barrelMax);
		output += "You did " + n + " barrel rolls. ";
		
		if (n == 0) {
			output += "Sad. :c";
		} else if (n == 10) {
			output += "Woah there buddy, you might want to slow down.";
		}
		
				
		return output + "\n";
	}
	
	/* (non-Javadoc)
	 * @see Displayable#display()
	 */
	public String display() {
		return "This is a airplane.";
	}
	
	/* 
	 * Returns a formatted version of the object's class and fields.
	 * 
	 * @return formatted details of object
	 */
	
	public String toString() {
				
		return "Airplane \n" +
			   " Minimum speed: " + speedMin + " \n" +
			   " Maximum speed: " + speedMax + " \n" +
			   " Minimum height: " + heightMin + " \n" +
			   " Maximum height: " + heightMax + " \n" +
			   " Maximum barrel rolls: " + barrelMax + " \n";
		
	}
	/* 
	 * Checks if two objects are of the same class and fields.
	 * 
	 * @return true or false
	 */
	public boolean equals(Object object) {
		if (object != null) {
			if (this.getClass().equals(object.getClass())) {
				return true;
			}
		}
		
		return false;
	}
}
