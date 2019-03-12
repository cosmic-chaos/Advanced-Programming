import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Array.
 * @author katya
 */
public class Array {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Rows in array: ");
		int rows = scanner.nextInt();
		System.out.println("Columns in array: ");
		int columns = scanner.nextInt();
		
		double[][] array = new double[rows][columns];
		
		System.out.println("Populate array: \n");

		for (int row = 0; row < rows; row ++) {
			for (int col = 0; col < columns; col ++) {
				array[row][col] = scanner.nextDouble();
			}
		}

		scanner.close();
		
		System.out.print("Value total: " + getTotal(array) + "/n");
		System.out.print("Value average: " + getAverage(array) + "/n");
		System.out.print("Row 0 total: " + getRowTotal(array, 0) + "/n");
		System.out.print("Column 0 total: " + getColumnTotal(array, 0) + "/n");
		System.out.print("Highest in row 0: " + getHighestInRow(array, 0) + "/n");
		System.out.print("Lowest in row 0: " + getLowestInRow(array, 0) + "/n");
		
		
	}
	
	/**
	 * Gets the total.
	 *
	 * @param array the array
	 * @return the total
	 */
	private static double getTotal(double[][] array) {
		double total = 0;
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col ++) {
				total += array[row][col];
			}
		}
		return total;
	}
	
	/**
	 * Gets the average.
	 *
	 * @param array the array
	 * @return the average
	 */
	private static double getAverage(double[][] array) {
		double total = 0;
		int totalNums = 0;
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col ++) {
				total += array[row][col];
				totalNums++;
			}
		}
		return total / totalNums;
	}
	
	/**
	 * Gets the row total.
	 *
	 * @param array the array
	 * @param row the row subscript 
	 * @return the row total
	 */
	private static double getRowTotal(double[][] array, int row) {
		double total = 0;
		for (double num : array[row]) {
			total += num;
		}
		return total;
	}
	
	/**
	 * Gets the column total.
	 *
	 * @param array the array
	 * @param col the column subscript 
	 * @return the column total
	 */
	private static double getColumnTotal(double[][] array, int col) {
		double total = 0;
		for (int row = 0; row < array.length; row++) {
				total += array[row][col];
		}
		return total;
	}

	/**
	 * Gets the highest in row.
	 *
	 * @param array the array
	 * @param row the row subscript 
	 * @return the highest in row
	 */
	private static double getHighestInRow(double[][] array, int row) {
		double highest = array[row][0];
		for (double num : array[row]) {
			if (num > highest) {
				highest = num;
			}
		}
		return highest;
	}
	
	/**
	 * Gets the lowest in row.
	 *
	 * @param array the array
	 * @param row the row subscript 
	 * @return the lowest in row
	 */
	private static double getLowestInRow(double[][] array, int row) {
		double lowest = array[row][0];
		for (double num : array[row]) {
			if (num < lowest) {
				lowest = num;
			}
		}
		return lowest;
	}
}
