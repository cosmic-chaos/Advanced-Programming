import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * Playground for testing classes and methods.
 * @author Katya Bezugla
 */
public class TestPolice {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		ArrayList<Patrolman> policeForce= new ArrayList<Patrolman>();
		
		Patrolman patrol = new Patrolman("Road", "Runner", 5);
		policeForce.add(patrol);
		Sergeant sergeant = new Sergeant("Elmer", "Fudd", 12);
		policeForce.add(sergeant);
		Lieutenant lieutenant = new Lieutenant("Daffy", "Duck", 14);
		policeForce.add(lieutenant);
		
		System.out.println(patrol.toString());
		System.out.println(sergeant.toString());
		System.out.println(lieutenant.toString());
		
		double average = average(policeForce);
		
		System.out.println("The average base pay of a "
							+ "patrolman, sergeant, and lieutenant is $"
							+ average + " per month.");
	}
	
	/**
	 * Rounds a number to two decimal places.
	 *
	 * @param num the number to be rounded
	 * @return the rounded number
	 */
	public static double round(double num) {
		return Math.round(num * 100.0)/100.0;
	}
	
	/**
	 * Finds the average of base pay from a list of patrolman objects.
	 *
	 * @param policeforce the list of patrolman objects
	 * @return the average of the base pay
	 */
	public static double average(ArrayList<Patrolman> policeforce) {
		double total = 0;
		
		for (int i = 0; i < policeforce.size(); i++) {
			total += policeforce.get(i).getBasePay();
		}
		
		return round(total/policeforce.size());
	}
}
