import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Search {
	private ArrayList<Integer> ids = new ArrayList<Integer>();
	
	public Search(String inputFile) {
		populateArray(inputFile);
		
	}
	
	private void populateArray(String inputFile) {
		File file = new File(inputFile);
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (scanner.hasNextLine()) {
			String[] data = scanner.nextLine().split(",");
			ids.add(Integer.parseInt(data[0]));
		}
		scanner.close();
		Collections.sort(ids);
	}
	
	public int binarySearch(int id) {
		int lo = 1;
		int hi = ids.size();
		while(lo <= hi) {
			int mid = lo + (hi-lo)/2;
			if (ids.get(mid) == id) {
				return mid;        
			} else if (ids.get(mid) < id) { 
				lo = mid+1;
			} else {
				hi = mid-1;
			}
		}
		return -1;
	}
	
	public int linearSearch(int id) {
		for(int i = 0; i < ids.size(); i++) {
			if (ids.get(i) == id) {
				return i;
			}
		}
		return -1;
	}
}
