import java.util.Random;

public class Astronaut implements Flier, Athlete{
	/** The name of the astronaut. */
	private String name;
	
	/** The amount of hours trained. */
	private int trainingHours;
	
	/** The minimum speed possible. */
	private final int speedMin = 17140;
	
	/** The maximum speed possible. */
	private final int speedMax = 17160;
	
	/** The minimum height possible. */
	private final int heightMin =  240;
	
	/** The maximum height possible. */
	private final int heightMax = 260;
	
	/**
	 * Instantiates a new astronaut with a default name and training hours
	 */
	public Astronaut() {
		name = "Dr. Aldawud";
		trainingHours = 0;
	}
	
	/**
	 * Instantiates a new astronaut.
	 *
	 * @param name the ski jumper's name
	 * @param trainingHours the hours trained
	 */
	public Astronaut(String name, int trainingHours) {
		this.name = name;
		this.trainingHours = trainingHours;
	}
	
	/* (non-Javadoc)
	 * @see Athlete#train()
	 */
	public void train() {
		trainingHours += 10;
	}
	
	/* (non-Javadoc)
	 * @see Flier#fly()
	 */
	public String fly() {
		Random rand = new Random();
		String output = "You are an astronaut named " + name + ". \n";
		
		int  n = rand.nextInt(speedMax) + speedMin;
		output += "Your average speed orbiting the Earth is " + n + " mph. \n";
		
		n = rand.nextInt(heightMax) + heightMin;
		output += "Your average height above the Earth is " + n + " mi. \n";
		
				
		return output;
	}
	
	/**
	 * Gets the astronaut's name.
	 *
	 * @return the astronaut's name
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
		
		return "Astronaut: " + name + " \n" +
			   " Hours trained: " + trainingHours + " \n" +
			   " Minimum speed: " + speedMin + " \n" +
			   " Maximum speed: " + speedMax + " \n" +
			   " Minimum height: " + heightMin + " \n" +
			   " Maximum height: " + heightMax + " \n";		
	}
	
	/* 
	 * Checks if two objects are of the same class and fields.
	 * 
	 * @return true or false
	 */
	
	public boolean equals(Object object) {
		if (object != null) {
			if (getClass().equals(object.getClass())) {
				if (name.equals(((Astronaut) object).getName()) && trainingHours == ((Astronaut) object).getHours()) {
					return true;
				}
			}
		}
		
		return false;
	}
}
