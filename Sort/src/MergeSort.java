import java.util.Arrays;

// TODO: Auto-generated Javadoc
/**
 * The Class MergeSort.
 */
public class MergeSort {
	
	/** The array. */
	public int[] array;
	
	/** The time. */
	public double time;

	/**
	 * Sorts the entire array using merge sort.
	 *
	 * @param input the input
	 */
	public MergeSort(int[] input) {
		this.array = input.clone();

		double start = System.nanoTime();
		array = sort(array);

		time = System.nanoTime() - start;

	}
	
	/**
	 * Splits the array into segments and sorts those to merge them together.
	 *
	 * @param a the array
	 * @return the sorted array
	 */
	private int[] sort(int[] a) {
		if (a.length < 2) {
	        return a;
		}

	    int[] left = sort(Arrays.copyOfRange(a, 0, a.length/2));
	    int[] right = sort(Arrays.copyOfRange(a, a.length/2, a.length));
	    return merge(left, right);
	}
	
	/**
	 * Merges array subsegments.
	 *
	 * @param left the left array
	 * @param right the right array
	 * @return the merged array
	 */
	private int[] merge(int[] left, int[] right) {
		int i = 0;
		int j = 0;
		int[] newA = new int[left.length + right.length];
		int place = 0;
		while ( i < left.length && j < right.length) {
			if(left[i] <= right[j]) {
	            newA[place] = left[i];
	            i++;
	            place++;
			} else {
	            newA[place] = right[j];
	            j++;
	            place++;
			}
		}
		
		while ( i < left.length) {
			newA[place] = left[i];
			i++;
			place++;
		}
		while (j < right.length) {
			newA[place] = right[j];
			j++;
			place++;
		}

		return newA;
	}
}
