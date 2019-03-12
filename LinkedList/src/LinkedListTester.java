import java.util.Scanner;

public class LinkedListTester {

	public static void main(String[] args) {
		
		String cont = "y";
		LinkedList list = new LinkedList();
		Scanner scan = new Scanner(System.in);
		while (cont.equals("y")) {
			System.out.println(
					"Please choose one of the Singly Linked List Operations:\n\n" + 
						"1. insert at begining\n" +
						"2. insert at end\n" +
						"3. insert at position\n" +
						"4. delete at position\n" +
						"5. check empty\n" +
						"6. get size\n");
			int c = scan.nextInt();
			switch (c) {
			case 1:
				System.out.println("Enter integer element to insert");
				list.insertAtStart(scan.nextInt());
				break;
			case 2:
				System.out.println("Enter integer element to insert");
				list.insertAtEnd(scan.nextInt());
				break;
			case 3:
				System.out.println("Enter integer element to insert");
				int val = scan.nextInt();
				System.out.println("Enter position");
				list.insertAtPos(val, scan.nextInt());
				break;
			case 4:
				System.out.println("Enter position");
				list.deleteAtPos(scan.nextInt());
				break;
			case 5:
				System.out.println("Empty status = " + list.isEmpty());
				break;
			case 6:
				System.out.println("Size = " + list.getSize());
				break;
			}
			
			list.display();
			
			System.out.println("Do you want to continue (Type y or n)");
			cont = scan.next();

			while (!cont.equals("y") && !cont.equals("n")) {
				System.out.println("Please enter y or n");
				cont = scan.next();
			}
				
		}
		
		System.out.println("Thank you for using my Linked List");
		scan.close();

	}

}
