import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * Playground for testing classes.
 * @author Katya Bezugla
 */
public class Test {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		ArrayList<Flier> objects = new ArrayList<Flier>();
		Bird bird = new Bird();
		Airplane airplane = new Airplane();
		SkiJumper skiJumper = new SkiJumper();
		
		SkyDiver skyDiver = new SkyDiver();
		Astronaut astronaut = new Astronaut();
		
		System.out.println(bird.toString());
		System.out.println(airplane.toString());
		System.out.println(skiJumper.toString());
		System.out.println(skyDiver.toString());
		System.out.println(astronaut.toString());
		
		objects.add(bird);
		objects.add(airplane);
		objects.add(skiJumper);
		objects.add(skyDiver);
		objects.add(astronaut);
		
		for (int i = 0; i < objects.size(); i++) {
			System.out.println(objects.get(i).fly());
		}
		
	}

}
