import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class SkiJumper.
 * @author Katya Bezugla
 */
public class SkiJumper implements Flier, Athlete, Displayable{
	
	/** The name of the ski jumper. */
	private String name;
	
	/** The amount of hours trained. */
	private int trainingHours;

	/** The maximum jumps possible. */
	private final int jumpsMax = Math.round(trainingHours/5 + 2);
	
	/** The minimum speed possible. */
	private final int speedMin = 59;
	
	/** The maximum speed possible. */
	private final int speedMax = 65;
	
	/** The minimum height possible. */
	private final int heightMin =  200;
	
	/** The maximum height possible. */
	private final int heightMax = 400;
	
	/**
	 * Instantiates a new ski jumper with a default name and training hours
	 */
	public SkiJumper() {
		name = "Dr. Aldawud";
		trainingHours = 0;
	}
	
	/**
	 * Instantiates a new ski jumper.
	 *
	 * @param name the ski jumper's name
	 * @param trainingHours the hours trained
	 */
	public SkiJumper(String name, int trainingHours) {
		this.name = name;
		this.trainingHours = trainingHours;
	}
	
	/* (non-Javadoc)
	 * @see Athlete#train()
	 */
	public void train() {
		trainingHours++;
	}
	
	/* (non-Javadoc)
	 * @see Flier#fly()
	 */
	public String fly() {
		Random rand = new Random();
		String output = "You are a ski jumper named " + name + ". \n";
		
		int  n = rand.nextInt(speedMax) + speedMin;
		output += "Your average speed was " + n + " mph. \n";
		
		n = rand.nextInt(heightMax) + heightMin;
		output += "Your average height was " + n + " ft. \n";
		
		n = rand.nextInt(jumpsMax);
		
		output += "You did " + n + " jumps. ";
		
		if (n == 0) {
			output += "Sad. :c";
		} else if (n >= 10 && n < 50) {
			output += "Woah there buddy, you might want to slow down.";
		} else if (n >= 50) {
			output += "No seriously, please slow down. I don't think that many jumps is humanly possible.";
		}
		
				
		return output + "\n";
	}
	
	/**
	 * Gets the ski jumper's name.
	 *
	 * @return the ski jumper's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the hours trained.
	 *
	 * @return the hours trained
	 */
	public int getHours() {
		return trainingHours;
	}
	
	/* 
	 * Returns a formatted version of the object's class and fields.
	 * 
	 * @return formatted details of object
	 */
	
	public String toString() {
		
		return "Ski Jumper: " + name + " \n" +
			   " Hours trained: " + trainingHours + " \n" +
			   " Minimum speed: " + speedMin + " \n" +
			   " Maximum speed: " + speedMax + " \n" +
			   " Minimum height: " + heightMin + " \n" +
			   " Maximum height: " + heightMax + " \n" +
			   " Maximum jumps: " + jumpsMax + " \n";
		
	}
	
	/* 
	 * Checks if two objects are of the same class and fields.
	 * 
	 * @return true or false
	 */
	
	public boolean equals(Object object) {
		if (object != null) {
			if (getClass().equals(object.getClass())) {
				if (name.equals(((SkiJumper) object).getName()) && trainingHours == ((SkiJumper) object).getHours()) {
					return true;
				}
			}
		}
		
		return false;
	}
}
