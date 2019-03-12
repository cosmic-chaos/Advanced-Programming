import java.util.Scanner;

public class SocSecProcessor {
	
	public static void main(String[] args) {
		String name;
		String ssn;
		boolean valid;
		Scanner reader = new Scanner(System.in);
		
		do {
			System.out.println("Name?");
			name = reader.nextLine();
			System.out.println("SSN?");
			ssn = reader.nextLine();
			
			try {
				isValid(ssn);
				System.out.println(name + " " + ssn + " is valid");
			} catch (SocSecException error) {
			} finally {
				System.out.println("\nContinue? ");
				
				if (reader.nextLine().toLowerCase().equals("n")) {
					valid = true;
					reader.close();
				} else {
					valid = false;
				}
			}


		} while (!valid);
		
	}
	
	public static boolean isValid(String ssn) throws SocSecException{
		
		if (ssn.matches("\\d\\d\\d-\\d\\d-\\d\\d\\d\\d")) {
			return true;
		} else {
			if (ssn.length() != 11) {
				throw new SocSecException(", wrong number of characters");
			} else if (ssn.charAt(3) != '-' || ssn.charAt(6) != '-') {
				throw new SocSecException(", dashes at wrong positions");
			} else if (!ssn.matches("\\d\\d\\d-\\d\\d-\\d\\d\\d\\d")) {
				throw new SocSecException(", contains a character that is not a digit");
			}
			return false;
		}
	}
}
