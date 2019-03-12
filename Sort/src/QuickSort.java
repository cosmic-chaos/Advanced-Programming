

// TODO: Auto-generated Javadoc
/**
 * The Class QuickSort.
 */
public class QuickSort {
	
	/** The array. */
	public int[] array;
	
	/** The time. */
	public double time;
	
	/**
	 * Sort the entire array using quick sort.
	 *
	 * @param input the input
	 */
	public QuickSort(int[] input) {
		this.array = input.clone();

		double start = System.nanoTime();
		sort(0,array.length-1);

		time = System.nanoTime() - start;

	}
	
	/**
	 * Sorts the array segment using quick sort.
	 *
	 * @param l the left index
	 * @param r the right index
	 */
	private void sort(int l, int r) {
		int right = r;
		int left = l;
		int pivot = left + (right - left) / 2;

		
		while (left < right) {
			
			while (array[left] < array[pivot]) {
				left++;
			}
			
			while (array[right] > array[pivot]) {
				right--;
			}
			
			if (left <= right) {
				swap(left, right);
				left++;
				right--;
			}
		}
		
		if(l < right) {
            sort(l,right);
		}
		
        if(left < r) {
            sort(left,r);
        }
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
