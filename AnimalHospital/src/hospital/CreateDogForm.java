/**
 * 
 */
package hospital;

import javax.swing.JDialog;
import javax.swing.JTextField;

/**
 * This class has the guidelines for the Animal Hospital Create Dog Window/GUI.
 * @author Gunwati Agrawal and Katya Bezugla
 * Version: 1.0.0.
 */
public class CreateDogForm extends CreatePetForm {
	
	/**
	 * Holds the JTextField for the Dog's size.
	 */
	private JTextField size;
	
	/**
	 * Creates a window based on CreatePetForm and adds the specific size input.
	 */
	public CreateDogForm() {
		super();
		size = new JTextField("Size", 10);
		panel.add(size);
		size.setVisible(true);
	}
	
	/**
	 * Triggers when the submit button is pressed.
	 */
	public void submit(){
		try {
			Dog dog = new Dog(name.getText(), ownerName.getText(), ownerEmail.getText(), color.getText(), size.getText());
			dog.setGender(gender.getText());
			pet = dog;
			panel.setVisible(false);
			frame.setVisible(false);
			frame.dispose();
		
		} catch(NullPointerException exception)
		{
			JDialog dialog = new JDialog(frame, "You didn't fill in one of them!");
			frame.add(dialog);
			dialog.setVisible(true);
		} catch(IllegalEmailException exception)
		{
			JDialog dialog = new JDialog(frame, "The email isn't valid!");
			frame.add(dialog);
			dialog.setVisible(true);
		} catch(IllegalGenderException exception)
		{
			JDialog dialog = new JDialog(frame, "The gender isn't valid!");
			frame.add(dialog);
			dialog.setVisible(true);			
		}
	}
}
