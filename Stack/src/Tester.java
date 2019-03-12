import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Tester {

	public static void main(String[] args) {
		
		System.out.println("Would you like to use 1. array implementation or 2. linkedlist implementation of a stack?  1/2:");
		Scanner s = new Scanner(System.in);
		int type = s.nextInt();

		while (!(type == 1 || type == 2)) {
			System.out.println("Would you like to use 1. array implementation or 2. linkedlist implementation of a stack?  1/2:");
			type = s.nextInt();
		}
		s.close();
		File file = new File("postfix.txt");
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while (scanner.hasNextLine()) {
			try {
				String str = scanner.nextLine();
				System.out.println("PostFixEvaluation of " + str + " is: " + solve(str, type)); 				
			} catch (PostFixException e) {
				e.printStackTrace();
			} catch (ScriptException e) {
				e.printStackTrace();
			}
		}
		scanner.close();


	}
	
	public static double solve(String postfix, int type) throws PostFixException, ScriptException {
	    ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
	    
		String[] pf = postfix.split(" ");
		Stack stack;
		if (type == 1) {
			stack = new ArrayStack(10);
		} else {
			stack = new LinkedStack(10);
		}
		
		for (String c : pf) {
			try {
				double num = Double.parseDouble(c);
				stack.push(num);
			} catch (NumberFormatException e) {
				String num2 = Double.toString(stack.top());
				stack.pop();
				String num1 = Double.toString(stack.top());
				stack.pop();

			    stack.push((double) engine.eval(num1 + c + num2));

			}
		}
		return stack.top();		

	}

}
