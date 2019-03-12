/**
 * 
 */
package hospital;

/**
 * The Dog class is a type of Pet that contains information regarding and describes the behavior of a dog.
 * @author Gunwati Agrawal and Katya Bezugla
 * Version: 1.0.0
 */
public class Dog extends Pet{
	
	/**
	 * Holds the size of the dog.
	 */
	String size;
	
	/**
	 * Constructs an instance of Dog with a specified name, owner's name, owner's email,
	 * color and size.
	 * @param name The name of the dog.
	 * @param ownerName The name of the owner.
	 * @param ownerEmail The email of the owner.
	 * @param color The color of the dog.
	 * @param size The size of the dog.
	 * @throws IllegalEmailException If the owner's email is invalid, throw Illegal Email Exception.
	 */
	public Dog(String name, String ownerName, String ownerEmail, String color, String size) throws IllegalEmailException {
		super(name, ownerName, ownerEmail, color);
		this.size = size;
	}
	
	/**
	 * Returns the size of the dog.
	 * @return The size of the dog.
	 */
	public String getSize() {
		return size;
	}
	
	/**
	 * Overrides java.lang.Object toString() method.
	 * @return A String representation of the object.
	 */
	public String toString() {
		return "DOG\n" + super.toString() + "Size: " + size + "\n";
	}
	
	/**
	 * Overrides java.lang.Object equals() method.
	 */
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		} else if(obj instanceof Dog) {
			Dog obje = (Dog) obj;
			if(this.getPetName().equals(obje.getPetName()) && this.getOwnerName().equals(obje.getOwnerName()) && this.getEmail().equals(obje.getEmail()) && this.getColor().equals(obje.getColor()) && this.getGender().equals(obje.getGender()) && start.equals(obje.getStartDate()) && end.equals(obje.getEndDate()) && size.equals(obje.getSize())) {
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
	public Dog clone()
	{
		Dog pet = null;
		try {
		pet = new Dog(this.getPetName(), this.getOwnerName(), this.getEmail(), this.getColor(), size);
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
