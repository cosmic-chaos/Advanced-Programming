package hospital;

/**
 * 
 * @author devsu
 *
 */
public class Bird extends Pet{

	/**
	 * Holds the state of the feathers.
	 */
	boolean featherClipped = false;
	
	/**
	 * Constructs an instance of Bird with a specified name, owner's name, owner's email,
	 * color.
	 * @param name The name of the cat.
	 * @param ownerName The name of the owner.
	 * @param ownerEmail The email of the owner.
	 * @param color The color of the cat.
	 * @throws IllegalEmailException If the owner's email is invalid, throw Illegal Email Exception.
	 */
	public Bird(String name, String ownerName, String ownerEmail, String color) throws IllegalEmailException {
		super(name, ownerName, ownerEmail, color);
	}
	
	/**
	 * Sets the featherClipped field to true.
	 */
	public void setClipped() {
		featherClipped = true;
	}
	
	/**
	 * Returns the state of featherClipped
	 * @return True if the feathers are clipped.
	 */
	public boolean getClipped() {
		return featherClipped;
	}
	
	/**
	 * Overrides java.lang.toString()
	 * @return A string representation of the Bird object.
	 */
	public String toString() {
		return "BIRD\n" + super.toString() + "Feathers clipped: " + featherClipped + "\n";
	}
	
	/**
	 * Overrides java.lang.Object equals() method.
	 */
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		} else if(obj instanceof Cat) {
			Bird obje = (Bird) obj;
			if(this.getPetName().equals(obje.getPetName()) && this.getOwnerName().equals(obje.getOwnerName()) && this.getEmail().equals(obje.getEmail()) && this.getColor().equals(obje.getColor()) && this.getGender().equals(obje.getGender()) && start.equals(obje.getStartDate()) && end.equals(obje.getEndDate())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * Overrides java.lang.Object clone() method.
	 */
	public Bird clone()
	{
		Bird pet = null;
		try {
		pet = new Bird(this.getPetName(), this.getOwnerName(), this.getEmail(), this.getColor());
		pet.setGender(this.getGender());
		} catch(IllegalEmailException e)
		{
			System.out.println(e.getMessage());
		} catch (IllegalGenderException e)
		{
			System.out.println(e.getMessage());
		} finally {
			return pet;
		}
	}
}

