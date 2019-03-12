import java.util.Random;

public class SkyDiver implements Flier, Athlete{
	/** The name of the sky diver. */
	private String name;
	
	/** The amount of hours trained. */
	private int trainingHours;

	/** Chances the parachute opened. */
	private final int parachute = Math.round(trainingHours/5 + 2);
	
	/** The minimum speed possible. */
	private final int speedMin = 150;
	
	/** The maximum speed possible. */
	private final int speedMax = 180;
	
	/** The minimum height possible. */
	private final int heightMin =  12500;
	
	/** The maximum height possible. */
	private final int heightMax = 18000;
	
	/**
	 * Instantiates a new sky diver with a default name and training hours
	 */
	public SkyDiver() {
		name = "Dr. Aldawud";
		trainingHours = 0;
	}
	
	/**
	 * Instantiates a new sky diver.
	 *
	 * @param name the ski jumper's name
	 * @param trainingHours the hours trained
	 */
	public SkyDiver(String name, int trainingHours) {
		this.name = name;
		this.trainingHours = trainingHours;
	}
	
	/* (non-Javadoc)
	 * @see Athlete#train()
	 */
	public void train() {
		trainingHours += 5;
	}
	
	/* (non-Javadoc)
	 * @see Flier#fly()
	 */
	public String fly() {
		Random rand = new Random();
		String output = "You are a sky diver named " + name + ". \n";
		
		int  n = rand.nextInt(speedMax) + speedMin;
		output += "Your average speed was " + n + " mph. \n";
		
		n = rand.nextInt(heightMax) + heightMin;
		output += "Your average height was " + n + " ft. \n";
		
		n = rand.nextInt(parachute);
				
		if (n <= 10) {
			output += "Your parachute didn't open. Sad. :c";
		} else if (n > 10) {
			output += "You survived!.";
		}
		
				
		return output + "\n";
	}
	
	/**
	 * Gets the sky diver name.
	 *
	 * @return the sky diver's name
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
		
		return "Sky Diver: " + name + " \n" +
			   " Hours trained: " + trainingHours + " \n" +
			   " Minimum speed: " + speedMin + " \n" +
			   " Maximum speed: " + speedMax + " \n" +
			   " Minimum height: " + heightMin + " \n" +
			   " Maximum height: " + heightMax + " \n" +
			   " Odds the parachute doesn't wors: 10:" + parachute + " \n";
		
	}
	
	/* 
	 * Checks if two objects are of the same class and fields.
	 * 
	 * @return true or false
	 */
	
	public boolean equals(Object object) {
		if (object != null) {
			if (getClass().equals(object.getClass())) {
				if (name.equals(((SkyDiver) object).getName()) && trainingHours == ((SkyDiver) object).getHours()) {
					return true;
				}
			}
		}
		
		return false;
	}
}
