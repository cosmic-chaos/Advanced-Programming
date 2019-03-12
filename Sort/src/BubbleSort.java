

// TODO: Auto-generated Javadoc
/**
 * The Class BubbleSort.
 */
public class BubbleSort {
	
	/** The array. */
	public int[] array;
	
	/** The time. */
	public double time;
	
	/**
	 * Sorts the array with bubble sort.
	 *
	 * @param input the array
	 */
	public BubbleSort(int[] input) {
		this.array = input.clone();
		
		double start = System.nanoTime();
		boolean done = false;
		while (done == false) {
			done = true;
			for (int i = 0; i <array.length-1; i++) {
				if (array[i] > array[i+1]) {
					swap(i, i+1);
					done = false;
				}
			}
		}
		time = System.nanoTime() - start;
	}
	
	/**
	 * Swaps two array elements.
	 *
	 * @param index the index
	 * @param swapIndex the swap index
	 */
	private void swap(int index, int swapIndex) {
		Integer num = array[index];
		Integer nums = array[swapIndex];
		array[index] = nums;
		array[swapIndex] = num;
	}
}
