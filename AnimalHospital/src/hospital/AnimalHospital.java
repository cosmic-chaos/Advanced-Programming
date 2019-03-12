package hospital;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * The Animal Hospital class holds an ArrayList of Pets
 * @author Gunwati Agrawal and Katya Bezugla
 * Version: 1.0.0
 */
public class AnimalHospital {
	
	/**
	 * Holds an ArrayList of the pets.
	 */
	private ArrayList<Pet> pets = new ArrayList<Pet>();
	
	/**
	 * Creates an AnimalHospital based on the input file.
	 * @param inputFile The input file.
	 * @throws IllegalEmailException If the email is invalid for any pet.
	 * @throws IllegalGenderException If the gender is invalid for any pet.
	 */
	public AnimalHospital(String inputFile) throws IllegalEmailException, IllegalGenderException {
		File file = new File(inputFile);
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (scanner.hasNextLine()) {
			String animal = scanner.nextLine();
			
			if (!animal.equals("END")) {
				String name = scanner.nextLine();
				String ownerName = scanner.nextLine();
				String ownerEmail = scanner.nextLine();
				String color = scanner.nextLine();
				String gender = scanner.nextLine();
				
				if (animal.equals("DOG")) {
					Dog dog = new Dog(name, ownerName, ownerEmail, color, scanner.nextLine());
					dog.setGender(gender);
					pets.add(dog);
					
				} else if (animal.equals("CAT")) {
					Cat cat = new Cat(name, ownerName, ownerEmail, color, scanner.nextLine());
					cat.setGender(gender);
					pets.add(cat);
				} else {
					Bird bird = new Bird(name, ownerName, ownerEmail, color);
					bird.setGender(gender);
					pets.add(bird);
				}
			}
		}
		
		scanner.close();
		
		
		setBoardDates();
	}
	
	/**
	 * Sets the board dates for all the pets.
	 */
	public void setBoardDates() {
		Scanner input = new Scanner(System.in);

		for (Pet pet : pets) {
			
			System.out.println("Enter " + pet.getPetName() + "'s start boarding date (YYYY-MM-DD):\n");
			String start = input.next();
			while (!Pattern.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}", start)) {
				System.out.println("Please use proper format (YYYY-MM-DD):\n");
				start = input.next();
			}
			String[] formattedStart = start.split("-");
			try {				
				pet.setBoardStart(Integer.parseInt(formattedStart[1]), Integer.parseInt(formattedStart[2]), Integer.parseInt(formattedStart[0]));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IllegalDateException e) {
				e.printStackTrace();
			}
			
			System.out.println("Enter " + pet.getPetName() + "'s end boarding date (YYYY-MM-DD):\n");
			String end = input.next();
			while (!Pattern.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}", end)) {
				System.out.println("Please use proper format (YYYY-MM-DD):\n");
				end = input.next();
			}
			String[] formattedEnd = end.split("-");
			try {

				pet.setBoardEnd(Integer.parseInt(formattedEnd[1]), Integer.parseInt(formattedEnd[2]), Integer.parseInt(formattedEnd[0]));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IllegalDateException e) {
				e.printStackTrace();
			}
		}
		input.close();

	}
	
	/**
	 * Prints the info of pets with that name.
	 * @param name The specified name.
	 */
	public void printPetInfoByName(String name) {
		System.out.println("List of Animals with the name " + name + ":");
		
		for (Pet pet : pets) {
			if (pet.getPetName().equals(name)) {
				System.out.println(pet.toString());
			}
		}
	}
	
	/**
	 * Prints the info of pets with owners of that name.
	 * @param name The specified name.
	 */
	public void printPetInfoByOwner(String name) {
		System.out.println("********************************************");

		System.out.println("List of Animals with the owner " + name + ":");
		for (Pet pet : pets) {
			if (pet.getOwnerName().equals(name)) {
				System.out.println(pet.toString());
			}
		}
		System.out.println("********************************************\n");
	}
	
	/**
	 * Prints the info of pets with that boarding date.
	 * @param month The month.
	 * @param day The day.
	 * @param year The year.
	 */
	public void printPetsBoarding(int month, int day, int year) {
		System.out.println("********************************************");
		System.out.println("List of Animals boarded on " + year + "-" + month + "-" + day + ":");

		for (Pet pet : pets) {
			if (pet.boarding(month, day, year)) {
				System.out.println(pet.toString());
			}
		}
		System.out.println("********************************************\n");

	}
	
	/**
	 * Prints all pet info.
	 */
	public void printAllPets() {
		for (Pet pet : pets) {
			System.out.println("**************************");
			System.out.println(pet.toString());
			System.out.println("**************************");
		}
	}
	
	/**
	 * Adds a pet to the array list.
	 * @param pet The pet.
	 */
	public void addPet(Pet pet)
	{
		if(pet.start != null && pet.end != null)
		{
			pets.add(pet);
		} else {
			try {
			pet.setBoardStart(3, 3, 2017);
			pet.setBoardEnd(4, 1, 2017);
			} catch (IllegalDateException e)
			{
			} finally {
				pets.add(pet);
			}
		}
	}
	
	/**
	 * Returns the array list.
	 * @return The array list.
	 */
	public ArrayList<Pet> getPets()
	{
		return pets;
	}
}

