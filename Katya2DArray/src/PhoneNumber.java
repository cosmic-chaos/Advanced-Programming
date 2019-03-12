import java.util.HashMap;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class PhoneNumber.
 * @author katya
 */
public class PhoneNumber {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		char[][] array = new char[3][];
		
		String number;
		do {
			System.out.println("Enter phone number (XXX-XXX-XXXX): \n");

			number = scanner.next();
		}
		while (!number.matches("[a-zA-Z0-9]{3}[-][a-zA-Z0-9]{3}[-][a-zA-Z0-9]{4}"));
		
		String[] splitNumber = number.split("-");
		for (int row = 0; row < splitNumber.length; row ++) {
				array[row] = splitNumber[row].toCharArray();
		}
		
		scanner.close();
		
		decode(array);
		
		System.out.println("Your number is: \n");
		for (int row = 0; row < array.length; row ++) {
			for (int col = 0; col < array[row].length; col ++) {
				System.out.print(array[row][col]);
			}
			
			if (row != array.length - 1) {
				System.out.print("-");
			}
		}
	}
	
	/**
	 * Decodes phone number into digits.
	 *
	 * @param array the array
	 * @return the char[][]
	 */
	private static char[][] decode(char[][] array) {
	      HashMap<Character, Character> hmap = new HashMap<Character, Character>();

	      hmap.put('A', '2');
	      hmap.put('B', '2');
	      hmap.put('C', '2');
	      
	      hmap.put('D', '3');
	      hmap.put('E', '3');
	      hmap.put('F', '3');
	      
	      hmap.put('G', '4');
	      hmap.put('H', '4');
	      hmap.put('I', '4');
	      
	      hmap.put('J', '5');
	      hmap.put('K', '5');
	      hmap.put('L', '5');

	      hmap.put('M', '6');
	      hmap.put('N', '6');
	      hmap.put('O', '6');
	      
	      hmap.put('P', '7');
	      hmap.put('Q', '7');
	      hmap.put('R', '7');
	      hmap.put('S', '7');
	      
	      hmap.put('T', '8');
	      hmap.put('U', '8');
	      hmap.put('V', '8');
	      
	      hmap.put('W', '9');
	      hmap.put('X', '9');
	      hmap.put('Z', '9');
	      
	      for (int row = 0; row < array.length; row ++) {
				for (int col = 0; col < array[row].length; col ++) {
					if (Character.isLetter(array[row][col]))
					{
						array[row][col] = hmap.get(Character.toUpperCase(array[row][col]));
					}
				}
			}
	      
	      return array;
	}

}
