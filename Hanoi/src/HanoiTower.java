
/**
 * The Class HanoiTower.
 * @author katya and gunwati
 */
public class HanoiTower {
	
	/** The number of moves */
	public static int moves = 1;
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		moveDisks(20, 1, 2, 3);
	}
	
	/**
	 * Moves the disks.
	 *
	 * @param disk the disk number
	 * @param source the source peg
	 * @param middle the middle peg
	 * @param dest the destination peg
	 */
	public static void moveDisks(int disk, int source, int middle, int dest) {
		if (disk == 1) {
			System.out.println(moves + ". Move disk " + disk + " from peg " + source + " to peg " + dest);
			moves++;
		} else {
			moveDisks(disk - 1, source, dest, middle);
			System.out.println(moves + ". Move disk " + disk + " from peg " + source + " to peg " + dest);
			moves++;
			moveDisks(disk - 1, middle, source, dest);  
		}
	}
}
