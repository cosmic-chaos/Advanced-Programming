/**
 * 
 */
package hospital;

import java.awt.event.*;

import javax.swing.*;

/**
 * This class has the guidelines for the Animal Hospital Create Bird Window/GUI.
 * @author Gunwati Agrawal and Katya Bezugla
 * Version: 1.0.0.
 */

public class CreateBirdForm extends CreatePetForm {
	
	/**
	 * Holds the state of the feathers.
	 */
	private boolean isClipped;
	
	/**
	 * Creates a window based on CreatePetForm and adds the specific feather state.
	 */
	public CreateBirdForm() {
		super();
		JToggleButton feathers = new JToggleButton("Click to clip its feathers");
		panel.add(feathers);
		feathers.setVisible(true);
		feathers.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
		            feathers.setText("Click to unclip its feathers");
		            if(isClipped)
		            {
		            	isClipped = false;
		            } else {
		            	isClipped = true;
		            }
		         }          
		});
	}
	
	/**
	 * Triggers when the submit button is pressed.
	 */
	public void submit(){
		try {
			Bird bird = new Bird(name.getText(), ownerName.getText(), ownerEmail.getText(), color.getText());
			if(isClipped)
			{
				bird.setClipped();
			}
			bird.setGender(gender.getText());
			pet = bird;
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
