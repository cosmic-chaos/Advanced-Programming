import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// TODO: Auto-generated Javadoc
/**
 * The Class InsertionSort.
 */
public class InsertionSort {
	
	/** The array. */
	public List<Integer> array;
	
	/** The time. */
	public double time;
	
	/**
	 * Sorts the array with insertion sort.
	 *
	 * @param input the array
	 */
	public InsertionSort(int[] input) {
		this.array = IntStream.of(input).boxed().collect(Collectors.toList());;
		
		double start = System.nanoTime();
		for (int i = 1; i < array.size(); i++) {
			if (array.get(i) < array.get(i-1)) {
				int insert = i;
				for (int j = i - 1; j >= 0; j--) {
					if (array.get(i) < array.get(j)) {
						insert = j;
					}
				}
				insert(i, insert);
			}
		}
		time = System.nanoTime() - start;
	}
	
	/**
	 * Insert an element to a different part of the array.
	 *
	 * @param index the index
	 * @param insertIndex the insert index
	 */
	private void insert(int index, int insertIndex) {
		int num = array.get(index);
		array.remove(index);
		array.add(insertIndex, num);
	}
}
