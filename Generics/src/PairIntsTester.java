import java.util.Random;

public class PairIntsTester {

	
	public static void main(String[] args) {
		Random rand = new Random();

		System.out.println("Exercise 1\n");
		e1(10, rand);
		System.out.println("\nExercise 2\n");
		e2(10, rand);
		System.out.println("\nExercise 3\n");
		e3(10, rand);
		System.out.println("\nExercise 4\n");
		e4(10, rand);

	}

	public static PairInts[] e1(int amount, Random rand) {
		PairInts[] answer = new PairInts[amount];
		for (int i = 0; i < amount; i++) {
			int num = rand.nextInt(10);
			int fib = fibinocci(num);

			answer[i] = new PairInts(num, fib);
			System.out.println(answer[i]);
		}
		
		return answer;
	}
	
	public static Pair<Integer, Integer>[] e2(int amount, Random rand) {
		Pair<Integer,Integer>[] answer = new Pair[amount];
		for (int i = 0; i < amount; i++) {
			int num = rand.nextInt(10);
			int fib = fibinocci(num);

			answer[i] = new Pair(num, fib);
			System.out.println(answer[i]);
		}
		
		return answer;
	}
	
	public static Pair<String, Integer>[] e3(int amount, Random rand) {
		String[] names = {"Evan", "Yugan", "Rohit", "Jessica",
						  "Nathaniel", "Ankhit", "Alyssa", "Sam",
						  "Andriy", "Shane", "Nick", "Ben", "George", "Shannon"};
		Pair<String,Integer>[] answer = new Pair[amount];
		for (int i = 0; i < amount; i++) {
			String name = names[rand.nextInt(names.length)];
			int age = rand.nextInt((18 - 14) + 1) + 14;

			answer[i] = new Pair(name, age);
			System.out.println(answer[i]);
		}
		
		return answer;
	}
	
	public static Pair<String, PairInts>[] e4(int amount, Random rand) {
		String[] names = {"Evan", "Yugan", "Rohit", "Jessica",
						  "Nathaniel", "Ankhit", "Alyssa", "Sam",
						  "Andriy", "Shane", "Nick", "Ben", "George", "Shannon"};
		Pair<String,PairInts>[] answer = new Pair[amount];
		for (int i = 0; i < amount; i++) {
			String name = names[rand.nextInt(names.length)];
			int year = rand.nextInt((2010 - 1990) + 1) + 1990;

			answer[i] = new Pair(name, new PairInts(year, 2017 - year));
			System.out.println(answer[i]);
		}
		
		return answer;
	}
	
	public static int fibinocci(int num) {
		if (num == 0) {
			return 0;
		} else if (num == 1) {
			return 1;
		} else {
			return fibinocci(num - 2) + fibinocci(num - 1);
		}
	}
}
