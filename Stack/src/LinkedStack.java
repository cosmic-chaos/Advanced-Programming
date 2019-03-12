
public class LinkedStack implements Stack {
	protected Node start;
    private int size;
    
    public LinkedStack(int size) throws PostFixException {
    	if (size > 0) {
        	this.size = size;	
    	} else {
    		this.size = 10;
    	}
    }
    
	@Override
	public void push(double s) throws PostFixException{
		if (isEmpty()) {
	        start = new Node(s, start);
		} else {
		
			Node end = new Node();
	        end.setData(s);
	        
	        Node current = start;
	        int tsize = 1;
	        while (current.getLink() != null) {
	        	current = current.getLink();
	        	tsize++;

	        	if (tsize >= size) {
	        		throw new PostFixException("Push attempted on a full stack. ");
	        	}
	        }
	        current.setLink(end);
		}
		
	}

	@Override
	public void pop() throws PostFixException {
		if (isEmpty()) {
			throw new PostFixException("Pop attempted on an empty stack. ");
    	} else {
	        Node current = start;
	        Node prev = start;
	        while (current.getLink() != null) {
	        	prev = current;
	        	current = current.getLink();
	        }
	        if (current.equals(start)) {
	        	start = null;
	        } else {
	        	prev.setLink(null);
	        }
    	}		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public double top() {
		Node current = start;
		
		try {
	        while (current.getLink() != null) {
	        	current = current.getLink();
	        }
		} catch (NullPointerException e) {
			return start.data;
		}
        
        return current.data;
	}

	@Override
	public boolean isEmpty() {
        try {
        	start.getLink();
            return false;

        } catch (NullPointerException e) {
        	return true;
        }
	}
	
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
