
public interface Stack {
	void push(double s) throws PostFixException;
	
    void pop() throws PostFixException;
	
    int size();
    
    double top();

	
    boolean isEmpty();

}
