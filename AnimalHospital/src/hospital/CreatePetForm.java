/**
 * 
 */
package hospital;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.*;

import javax.swing.*;

/**
 * This class has the guidelines for the Animal Hospital Create Pet Window/GUI.
 * @author Gunwati Agrawal and Katya Bezugla
 * Version: 1.0.0.
 */

public abstract class CreatePetForm {
	
	/**
	 * Holds the JComponents
	 */
	protected Pet pet;
	protected JFrame frame;
	protected JPanel panel;
	protected JTextField name;
	protected JTextField ownerName;
	protected JTextField ownerEmail;
	protected JTextField color;
	protected JTextField gender;
	
	/**
	 * Creates a new window with the generic form items for any pet.
	 */
	public CreatePetForm()
	{
		frame = new JFrame();
		panel = new JPanel(new GridBagLayout());
		panel.setBackground(new Color(0, 150, 50));
		name = new JTextField("Name", 30);
		ownerName = new JTextField("Owner's Name", 30);
		ownerEmail = new JTextField("Owner's Email", 30);
		color = new JTextField("Color", 30);
		gender = new JTextField("Gender", 30);
		panel.add(name);
		panel.add(ownerName);
		panel.add(ownerEmail);
		panel.add(color);
		panel.add(gender);
		JButton submit = new JButton("Submit!");
		panel.add(submit);
		frame.add(panel);
		submit.setVisible(true);
		name.setVisible(true);
		ownerName.setVisible(true);
		ownerEmail.setVisible(true);
		color.setVisible(true);
		gender.setVisible(true);
		panel.setVisible(true);
		frame.setVisible(true);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            submit();
	         }
		});
	}
	
	/**
	 * Returns the pet that has been created.
	 * @return The pet.
	 */
	public Pet getPet()
	{
		return pet;
	}
	
	/**
	 * Triggers when the submit button is pressed.
	 */
	public abstract void submit();
}
