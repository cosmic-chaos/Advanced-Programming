package hospital;

/**
 * The Pet Tester class tests the functionality of Animal Hospital and related classes.
 * @author Gunwati Agrawal and Katya Bezugla
 * Version: 1.0.0
 */
public class PetTester {
	
	/**
	 * The main method will test either the Console interactions or Window/GUI interactions.
	 */
	public static void main(String[] args) {
		GUITest();
		//GeneralTest();
	}
	
	/**
	 * This test method will test the GUI abilities of the Animal Hospital.
	 */
	private static void GUITest()
	{
		AnimalHospitalGUI gui = new AnimalHospitalGUI();
	}
	
	/**
	 * This test will construct a hospital based on a .txt file "petData.txt"
	 * It will print all the pets in this hospital, and the pets boarding as of 
	 * January 21, 2016
	 * January 5, 2016
	 * June 24, 2016
	 */
	private static void GeneralTest()
	{
		try {
			AnimalHospital hospital = new AnimalHospital("petData.txt");
			hospital.printAllPets();
			hospital.printPetsBoarding(1, 21, 2016);
			hospital.printPetsBoarding(1, 5, 2016);
			hospital.printPetsBoarding(6, 24, 2016);

		} catch (IllegalEmailException e) {
			e.printStackTrace();
		} catch (IllegalGenderException e) {
			e.printStackTrace();
		}
	}
}