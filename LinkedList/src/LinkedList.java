/* @author N Pandya
   March 2016
   LinkedList class
*/
public class LinkedList

{
    // instance fields 

    protected Node start;
    protected Node end;
    public int size ;
    
    /*  Constructor  */
    public LinkedList()
    {
        size = 0;

    }

    /*  Function to check if list is empty  */
    public boolean isEmpty()
    {

        try {
        	start.getLink();
            return false;

        } catch (NullPointerException e) {
        	return true;
        }

    }

    /*  Function to get size of list  */
    public int getSize()
    {
        return size;
    }    

    /*  Function to insert an element at beginning  */
    public void insertAtStart(int val)
    {
    	
        start = new Node(val, start);
        size++;
    }

    
    /*  Function to insert an element at end  */
    public void insertAtEnd(int val)
    {
    	
        end = new Node();
        end.setData(val);
        
        Node current = start;
        while (current.getLink() != null) {
        	current = current.getLink();
        }
        current.setLink(end);
        size++;
    }

    
    /*  Function to insert an element at position  */
    public void insertAtPos(int val , int pos)
    {
    	Node current = start;
    	int iter = 1;
        while (current.getLink() != null && iter < (pos - 1)) {
        	current = current.getLink();
        	iter++;
        }
        
        Node node = new Node(val, current.getLink());
        current.setLink(node);
        size++;

    }

    /*  Function to delete an element at position  */
    public void deleteAtPos(int pos)
    {        
    	if (pos == 1) {
    		start = start.getLink();
    	} else {
	    	Node current = start;
	    	int iter = 1;
	        while (current.getLink() != null && iter < (pos - 1)) {
	        	current = current.getLink();
	        	iter++;
	        }
	        
	        current.setLink(current.getLink().getLink());
    	}
	    size--;
    }    

    /*  Function to display elements  */

    public void display()
    {
    	if (isEmpty()) {
    		System.out.println("Singly Linked List is empty");
    	} else {
	    	System.out.println("Singly Linked List = ");
	    	Node current = start;
	        while (current.getLink() != null) {
	        	System.out.print(current.getData() + " -> ");
	        	current = current.getLink();
	        }
	        System.out.println(current.getData());
    	}

    }
}