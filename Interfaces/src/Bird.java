import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Bird.
 * @author Katya Bezugla
 */
public class Bird implements Flier, Displayable{
	
	/** The minimum speed possible. */
	private final int speedMin = 20;
	
	/** The maximum speed possible. */
	private final int speedMax = 60;
	
	/** The minimum height possible. */
	private final int heightMin = 300;
	
	/** The maximum height possible. */
	private final int heightMax = 500;
	
	/** The possible events that could occur. */
	private final String[] events = {"You crashed into Dr. Aldawud's window.",
									 "You were eaten by Dr. Aldawud.",
									 "You were hit by a plane flown by Dr. Aldawud.",
									 "You ended your flight safely!"};
	
	/* (non-Javadoc)
	 * @see Flier#fly()
	 */
	public String fly() {
		Random rand = new Random();
		String output = "You are a bird. \n";
		
		int  n = rand.nextInt(speedMax) + speedMin;
		output += "Your average speed was " + n + " mph. \n";
		
		n = rand.nextInt(heightMax) + heightMin;
		output += "Your average height was " + n + " ft. \n";
		
		n = rand.nextInt(events.length);
		
		output += events[n] + " \n";
		
		return output;
		
	}
	
	/* (non-Javadoc)
	 * @see Displayable#display()
	 */
	public String display() {
		return "This is a bird.";
	}
	
	/* 
	 * Returns a formatted version of the object's class and fields.
	 * 
	 * @return formatted details of object
	 */
	public String toString() {
		String list = "";
		for (int i = 0; i < events.length; i++) {
			list += "  " + i + ". " + events[i] + " \n";			
		}
		
		return "Bird \n" +
			   " Minimum speed: " + speedMin + " \n" +
			   " Maximum speed: " + speedMax + " \n" +
			   " Minimum height: " + heightMin + " \n" +
			   " Maximum height: " + heightMax + " \n" +
			   " Events: \n" + list + " \n";
		
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
