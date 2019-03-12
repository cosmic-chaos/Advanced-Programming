import java.util.Arrays;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Tester.
 */
public class Tester {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		int[] A = {18, 13, 17, 14, 16, 19, 15};
		int n = A.length;
		int counter = 0;
		for (int i = 0; i < n-1; i++) 
		{
		  int cur_min = i;
		  for (int j = i+1; j < n; j++)
		  {
		    if (A[j] < A[cur_min])                  // each execution of this if-statement 
		    {                         // is counted as one comparison
		      System.out.println(A[j] +"<"+ A[cur_min]); 
		       A = swap(A, j, cur_min);
		    	cur_min = j;
		    	counter++;
				System.out.println(Arrays.toString(A));

		     }
		   }
		}
		System.out.println(counter);

		/*int[] small = populize(100);
		int[] medium = populize(10000);
		int[] large = populize(50000);

		SelectionSort selectSmall = new SelectionSort(small);
		SelectionSort selectMedium = new SelectionSort(medium);
		SelectionSort selectLarge = new SelectionSort(large);

		BubbleSort bubbleSmall = new BubbleSort(small);
		BubbleSort bubbleMedium = new BubbleSort(medium);
		BubbleSort bubbleLarge = new BubbleSort(large);
		
		InsertionSort insertSmall = new InsertionSort(small);
		InsertionSort insertMedium = new InsertionSort(medium);
		InsertionSort insertLarge = new InsertionSort(large);
		
		QuickSort quickSmall = new QuickSort(small);
		QuickSort quickMedium = new QuickSort(medium);
		QuickSort quickLarge = new QuickSort(large);
		
		MergeSort mergeSmall = new MergeSort(small);
		MergeSort mergeMedium = new MergeSort(medium);
		MergeSort mergeLarge = new MergeSort(large);

		System.out.println("Sorting Algorithm | 100 Elements | 10000 Elements | 50000 Elements");
		System.out.println("Selection sort    | " + selectSmall.time + "     | " + selectMedium.time + "   | " + selectLarge.time);
		System.out.println("Bubble sort       | " + bubbleSmall.time + "      | " + bubbleMedium.time + "      | " + bubbleLarge.time);
		System.out.println("Insertion sort    | " + insertSmall.time + "      | " + insertMedium.time + "      | " + insertLarge.time);
		System.out.println("Quick sort        | " + quickSmall.time + "      | " + quickMedium.time + "      | " + quickLarge.time);
		System.out.println("Merge sort        | " + mergeSmall.time + "      | " + mergeMedium.time + "      | " + mergeLarge.time);*/
	}
	
	private static int[] swap(int[] array, int index, int swapIndex) {
		Integer num = array[index];
		Integer nums = array[swapIndex];
		array[index] = nums;
		array[swapIndex] = num;
		return array;
	}
	
	/**
	 * Populizes the array.
	 *
	 * @param length the length of the array
	 * @return the populized array
	 */
	private static int[] populize(int length) {
		int[] ints = new int[length];
		Random rand = new Random();
		
		for (int i = 0; i < length; i++) {
			ints[i] = rand.nextInt() % 100;
		}
		
		return ints;
	}
}
