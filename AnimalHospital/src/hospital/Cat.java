package hospital;

/**
 * The Cat class is a Pet that contains information regarding as well describes the behavior of a cat.
 * @author Gunwati Agrawal and Katya Bezugla
 * Version: 1.0.0
 */
public class Cat extends Pet{
	
	/**
	 * Holds the type of hair the cat has, in terms of length.
	 */
	String hairLength;
	
	/**
	 * Constructs an instance of Cat with a specified name, owner's name, owner's email,
	 * color and hair length.
	 * @param name The name of the cat.
	 * @param ownerName The name of the owner.
	 * @param ownerEmail The email of the owner.
	 * @param color The color of the cat.
	 * @param hairLength The hair type (in terms of length) of the cat.
	 * @throws IllegalEmailException If the owner's email is invalid, throw Illegal Email Exception.
	 */
	public Cat(String name, String ownerName, String ownerEmail, String color, String hairLength) throws IllegalEmailException {
		super(name, ownerName, ownerEmail, color);
		this.hairLength = hairLength;
	}
	
	/**
	 * Returns the hair length of the cat.
	 * @return The hair length of the cat.
	 */
	public String getHairLength() {
		return hairLength;
	}
	
	/**
	 * Overrides java.lang.Object toString() method.
	 * @return A String representation of the object.
	 */
	public String toString() {
		return "CAT\n" + super.toString() + "Hair: " + hairLength + "\n";
	}
	
	/**
	 * Overrides java.lang.Object equals() method.
	 */
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		} else if(obj instanceof Cat) {
			Cat obje = (Cat) obj;
			if(this.getPetName().equals(obje.getPetName()) && this.getOwnerName().equals(obje.getOwnerName()) && this.getEmail().equals(obje.getEmail()) && this.getColor().equals(obje.getColor()) && this.getGender().equals(obje.getGender()) && start.equals(obje.getStartDate()) && end.equals(obje.getEndDate()) && hairLength.equals(obje.getHairLength())) {
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
	public Cat clone()
	{
		Cat pet = null;
		try {
		pet = new Cat(this.getPetName(), this.getOwnerName(), this.getEmail(), this.getColor(), hairLength);
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
