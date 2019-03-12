import java.util.ArrayList;

public class ArrayStack implements Stack {

	private int size;
	private ArrayList<Double> array = new ArrayList<Double>();
	
	public ArrayStack(int size) throws PostFixException {
    	if (size > 0) {
        	this.size = size;	
    	} else {
    		this.size = 10;
    	}
    }
	
	@Override
	public void push(double s) throws PostFixException {
		if (array.size() <= size) {
			array.add(s);
		} else {
			throw new PostFixException("Push attempted on a full stack. ");
		}
	}

	@Override
	public void pop() throws PostFixException {
		if (array.size() > 0) {
			array.remove(array.size() - 1);
		} else {
			throw new PostFixException("Pop attempted on an empty stack. ");
		}
		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public double top() {
		return array.get(array.size() - 1);
	}

	@Override
	public boolean isEmpty() {
		if (array.size() > 0) {
			return false;
		} else {
			return true;
		}
	}

}
