package hospital;

import java.util.Calendar;
import java.util.regex.Pattern;


/**
 * The Pet Class implements Boardable and contains the information and describes the behavior of a Pet.
 * @author Gunwati Agrawal and Katya Bezugla
 * Version: 1.0.0
 */
public class Pet implements Boardable {
	
	/**
	 * Holds the name, owner's name, color, owner's email, and gender.
	 */
	private String name;
	private String ownerName;
	private String color;
	private String ownerEmail;
	private String gender;
	
	Calendar start;
	Calendar end;
	
	/**
	 * Constructs a Pet object with the specified name, owner's name, owner's email, and color.
	 * @param name The name of the pet.
	 * @param ownerName The name of the owner.
	 * @param ownerEmail The email of the owner.
	 * @param color The color of the pet.
	 * @throws IllegalEmailException If the owner's email is invalid, throw Illegal Email Exception.
	 */
	public Pet(String name, String ownerName, String ownerEmail, String color) throws IllegalEmailException {
		this.name = name;
		this.ownerName = ownerName;
		this.color = color;
		if (Pattern.matches("[_A-Za-z0-9-\\+]+([_A-Za-z0-9-]+)*@[A-Za-z0-9-]+([A-Za-z0-9]+)*.[A-Za-z]{3}", ownerEmail)) {
			this.ownerEmail = ownerEmail;
		} else {
			throw new IllegalEmailException();
		}
	}
	
	/**
	 * Returns the name of the pet.
	 * @return The name of the pet.
	 */
	public String getPetName() {
		return name;
	}
	
	/**
	 * Returns the name of the owner.
	 * @return The name of the owner.
	 */
	public String getOwnerName() {
		return ownerName;
	}
	
	/**
	 * Returns the color of the pet.
	 * @return The color of the pet.
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * Sets the gender of the pet.
	 * @param genderId The string containing the gender of the pet.
	 * @throws IllegalGenderException If the gender string does not match one of the options, it is invalid and Illegal Gender Exception is thrown.
	 */
	public void setGender(String genderId) throws IllegalGenderException {
		if (genderId.equals("male") || genderId.equals("female") || genderId.equals("spayed") || genderId.equals("neutered")) {
			gender = genderId;		
		} else {
			throw new IllegalGenderException(genderId);
		}
	}
	
	/**
	 * Returns the gender of the pet.
	 * @return The gender of the pet.
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * Returns the email of the owner.
	 * @return The email of the owner.
	 */
	public String getEmail() {
		return ownerEmail;
	}
	
	/**
	 * Checks to see if the pet is boarding at a given time.
	 * @param month The month you wish to check.
	 * @param day The day you wish to check.
	 * @param year The year you wish to check.
	 * @return True if the pet is boarding at the given time.
	 */
	public boolean boarding(int month, int day, int year) {
		Calendar inputDate = Calendar.getInstance();
		inputDate.set(year, month, day);
		if(!start.after(inputDate) && !end.before(inputDate)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Sets the end of the time the pet will be boarded.
	 * @param month The month of the time.
	 * @param day The day of the time.
	 * @param year The year of the time.
	 * @throws IllegalDateException If the date is not valid, throw Illegal Date Exception.
	 */
	public void setBoardEnd(int month, int day, int year) throws IllegalDateException {
		end = Calendar.getInstance();

		if (month >= 1 && month <=12 && day >=1 && day <= 31 && year >= 2000 && year <= 2016) {
			end.clear();
			end.set(year, month, day);
		}
		else
		{
			throw new IllegalDateException();
		}
	}
	
	/**
	 * Sets the beginning of the time the pet will be boarded.
	 * @param month The month of the time.
	 * @param day The day of the time.
	 * @param year The year of the time.
	 * @throws IllegalDateException If the date is not valid, throw Illegal Date Exception.
	 */
	public void setBoardStart(int month, int day, int year) throws IllegalDateException {
		start = Calendar.getInstance();
		if (month >= 1 && month <=12 && day >=1 && day <= 31 && year >= 2000 && year <= 2016) {
			start.clear();
			start.set(year, month, day);
		}
		else
		{
			throw new IllegalDateException();
		}
	}
	
	/**
	 * Returns the start board date as a Calendar object.
	 * @return A Calendar object holding the start board date.
	 */
	public Calendar getStartDate()
	{
		return start;
	}
	
	/**
	 * Returns the ending board date as a Calendar object.
	 * @return A Calendar object holding the ending board date.
	 */
	public Calendar getEndDate()
	{
		return end;
	}

	/**
	 * Overrides java.lang.Object toString() method.
	 * @return A String representation of the object.
	 */
	public String toString() {
		return name + " owned by " + ownerName + " \n" +
				"owner's email: " + ownerEmail + " \n" +
				"Pet Color: " + color + " \n" +
				"Gender: " + gender + "\n";

	}
	
	/**
	 * Overrides java.lang.Object equals() method.
	 */
	public boolean equals(Object obj) {
		if(obj == null){
			return false;
		} else if(obj instanceof Pet) {
			Pet obje = (Pet) obj;
			if(name.equals(obje.getPetName()) && ownerName.equals(obje.getOwnerName()) && ownerEmail.equals(obje.getEmail()) && color.equals(obje.getColor()) && gender.equals(obje.getGender()) && start.equals(obje.getStartDate()) && end.equals(obje.getEndDate()) ) {
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
	public Pet clone()
	{
		Pet pet = null;
		try {
		pet = new Pet(name, ownerName, ownerEmail, color);
		pet.setGender(this.gender);
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

