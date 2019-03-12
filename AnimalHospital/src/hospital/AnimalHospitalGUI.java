/**
 * 
 */
package hospital;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;
import java.util.Iterator;

import javax.swing.*;

/**
 * This class has the GUI for the Animal Hospital Main Window.
 * @author Gunwati Agrawal and Katya Bezugla
 * Version: 1.0.0.
 */
public class AnimalHospitalGUI {
	
	/**
	 * Holds the frame, panel, and wraps the AnimalHospital.
	 */
	private AnimalHospital hospital;
	private JFrame frame;
	private JPanel panel;
	
	/**
	 * Creates the main window for the GUI.
	 */
	public AnimalHospitalGUI() {
		frame = new JFrame();
		panel = new JPanel(new GridBagLayout());
		//GridBagConstraints() c = new GridBagConstraints();
		JButton createCat = new JButton("Admit a cat into the Animal Hospital");
		panel.add(createCat);
		createCat.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		            CreateCatForm catForm = new CreateCatForm();
		            hospital.addPet(catForm.getPet()); //not working
		         }          
		});
		
		JButton createDog = new JButton("Admit a dog into the Animal Hospital");
		panel.add(createDog);
		createDog.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		            CreateDogForm dogForm = new CreateDogForm();
		            hospital.addPet(dogForm.getPet());
		         }          
		});
		
		JButton createBird = new JButton("Admit a bird into the Animal Hospital");
		panel.add(createBird);
		createBird.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		            CreateBirdForm birdForm = new CreateBirdForm();
		            hospital.addPet(birdForm.getPet());
		         }          
		});
		
		frame.add(panel);
		panel.setVisible(true);
		frame.setVisible(true);
		createCat.setVisible(true);
		createDog.setVisible(true);
		createBird.setVisible(true);
		
		JTextArea area = new JTextArea(50, 50);
		GridBagConstraints textarea = new GridBagConstraints();
		panel.add(area, textarea);
		
		JButton printInfo1 = new JButton("Print the information about the pets.");
		panel.add(printInfo1);
		printInfo1.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 String s = "";
		         Iterator<Pet> iter = hospital.getPets().iterator();
		         while(iter.hasNext())
		         {
		            	s = s + "/n /n" + iter.next().toString();
		            }
		            area.setText(s);
		         }          
		});
		
		printInfo1.setVisible(true);
		
	}
}