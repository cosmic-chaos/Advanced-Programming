
public class SearchTester {

	public static void main(String[] args) {
		Search search = new Search("employees.csv");
		int id = 10321;
		
		double startBin = System.nanoTime();
		int posBin = search.binarySearch(id);
		double endBin = System.nanoTime();
		System.out.println("Binary search found the ID " + id + " at position " + posBin + " in 13 lines of code and " + (endBin - startBin) + " ns.");
		
		double startLin = System.nanoTime();
		int posLin = search.linearSearch(id);
		double endLin = System.nanoTime();
		System.out.println("Linear search found the ID " + id + " at position " + posLin + " in 3 lines of code and " + (endLin - startLin) + " ns.");
		
		

	}

}
