
 // TODO: Auto-generated Javadoc
/**
  * The Interface Displayable.
  * @author Katya Bezugla
  */
 public interface Displayable {
	 
 	/**
 	 * Displays either the object's class, or by default displays that the class can be displayed.
 	 *
 	 * @return the string
 	 */
 	default String  display() {
		return "This can be displayed.";
	}
}
