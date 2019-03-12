

// TODO: Auto-generated Javadoc
/**
 * The Class SelectionSort.
 */
public class SelectionSort {
	
	/** The array. */
	public int[] array;
	
	/** The time. */
	public double time;
	
	/**
	 * Sorts the array with selection sort.
	 *
	 * @param input the array
	 */
	public SelectionSort(int[] input) {
		this.array = input.clone();
		
		double start = System.nanoTime();
		for (int i = 0; i < array.length; i++) {
			int s = findMin(i);
			swap(i, s);
		}
		time = System.nanoTime() - start;
	}
	
	/**
	 * Find min of the array segment.
	 *
	 * @param startIndex the start index
	 * @return the min
	 */
	private int findMin(int startIndex) {
		int min = array[startIndex];
		int minIndex = startIndex;
		for (int i = startIndex; i < array.length; i++) {
			if ( array[i] < min) {
				min = array[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	/**
	 * Swaps two array elements.
	 *
	 * @param index the index
	 * @param swapIndex the swap index
	 */
	private void swap(int index, int swapIndex) {
		int num = array[index];
		int num2 = array[swapIndex];
		array[index] = num2;
		array[swapIndex] = num;
	}
}
