package hospital;

import javax.swing.*;

/**
 * This class has the guidelines for the Animal Hospital Create Cat Window/GUI.
 * @author Gunwati Agrawal and Katya Bezugla
 * Version: 1.0.0.
 */

public class CreateCatForm extends CreatePetForm{

	/**
	 * Holds the hairlength.
	 */
	private JTextField hairLength;
	
	/**
	 * Creates a window based on CreatePetForm and adds the specific hair length input.
	 */
	public CreateCatForm() {
		super();
		hairLength = new JTextField("Hair", 30);
		panel.add(hairLength);
		hairLength.setVisible(true);
	}
	
	/**
	 * Triggers when the submit button is pressed.
	 */
	public void submit(){
		try {
			Cat cat = new Cat(name.getText(), ownerName.getText(), ownerEmail.getText(), color.getText(), hairLength.getText());
			cat.setGender(gender.getText());
			pet = cat;
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
