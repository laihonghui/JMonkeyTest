package core;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;
import javax.swing.plaf.metal.MetalComboBoxButton;        

public class MonkeySwing {
	/**
	 * Creating a gui here only for proof of concept
	 */
	public static void createAndShowGUI() {
		JFrame frame = new JFrame("MonkeySwing testing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		JTextField field1 = new JTextField();
		field1.setBounds(10,20,165,25);
		frame.add(field1);
		JTextField field2 = new JTextField();
		field2.setBounds(10,50,165,25);
		frame.add(field2);
		JButton button1 = new JButton("test");
		button1.setBounds(10,50,165,25);
		frame.add(button1);
		
		frame.pack();
		//frame.setSize(400, 600);
		frame.setVisible(true);
	}

	//Method below finds all components, and then tests the various components.

	public static List<Component> getAllComponents(final Container c){
		MonkeyBase test1 = new MonkeyBase("test1", 1000);
		Component[] comps = c.getComponents();
		List<Component> compList = new ArrayList<Component>();
		for (int i = 0; i < test1.getIterations(); i++) {

			for (Component comp : comps) {
				compList.add(comp);
				if(comp instanceof JFrame) {
					System.out.println("hi");
				}
				if (comp instanceof Container) {
					compList.addAll(getAllComponents((Container) comp));//Dealing with containers, so leets travel deeper into the ui
				}
				if(comp instanceof JButton) { // Dealing with buttons
					JButton button = (JButton) comp;
					button.doClick();
				}
				
				if(comp instanceof JTextField){ 
					JTextField mytext = (JTextField) comp;
					mytext.setText(test1.randomString());

				}

			}
		}   
		return compList;
	}}