package core;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.*;        

public class MonkeySwing extends MonkeyStress {
	protected int currentiteration;
	protected boolean running;
	protected boolean testingmode = true;
	private Date date;
	public MonkeySwing(String testname, int iterations) {
		super(testname, iterations);
		this.testname = testname;
		this.iterations = iterations;
		this.currentiteration = 0;
		this.running = true;
		this.date = new Date();
		Logging.clearLog(this.testname); // Clear old log
		Logging.writeLog(this.testname, date.toString()+"|Started test"); // start new log with date/time stamp
		if(testingmode==true) {
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					createAndShowGUI();
					try {
						Thread.sleep(200); //Wait a bit performing the tests until our gui has been initialized
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}


		while(this.running && this.currentiteration <= this.iterations ) {
			for (int i = 0; i < Frame.getFrames().length; i++) {// Loop through all active swing frames
				this.getAllComponents(Frame.getFrames()[i]); // Method finds our components and then feeds it random values
			}
		}
	}

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
		JCheckBox check = new JCheckBox("checkbox");
		check.setBounds(10, 50, 165, 125);
		frame.add(check);
		JRadioButton button2 = new JRadioButton("testradio");
		button2.setBounds(10, 50, 165, 25);
		frame.add(button2);

		frame.pack();
		frame.setSize(400, 600);
		frame.setVisible(true);
	}

	//Method below finds all components, and then either digs deeper into containers or test the components

	public List<Component> getAllComponents(final Container c){
		Component[] comps = c.getComponents();
		List<Component> compList = new ArrayList<Component>();
		for (int i = 0; i < this.iterations; i++) {

			for (Component comp : comps) {
				compList.add(comp);
				if (comp instanceof Container) {
					compList.addAll(getAllComponents((Container) comp));//Dealing with containers, so leets travel deeper into the ui
				}
				if(comp instanceof JFrame) {
					JFrame frame = (JFrame) comp;
					compList.addAll(getAllComponents(frame));
				}
				if(comp instanceof JInternalFrame) {
					JInternalFrame frame = (JInternalFrame) comp;
					compList.addAll(getAllComponents(frame));
				}
				if(comp instanceof JPanel) {
					JPanel panel = (JPanel) comp;
					compList.addAll(getAllComponents(panel));
				}
								
				if(comp instanceof JButton) { // Dealing with buttons
					JButton button = (JButton) comp;
					button.doClick();
					Logging.writeLog(this.testname, "Clicking button with the name of: "+button.getName());
				}
				if (comp instanceof JComboBox) { // Combobox
					JComboBox combobox = (JComboBox) comp;
					combobox.setSelectedIndex(ThreadLocalRandom.current().nextInt(1, combobox.getItemCount()+1));
					Logging.writeLog(this.testname, "Selecting random item in combobox, item name: "+combobox.toString()+" component name: "+combobox.getName());
				}
				if(comp instanceof JCheckBox) { // Checkbox
					JCheckBox checkbox = (JCheckBox) comp;
					if(checkbox.isSelected()) {
						checkbox.setSelected(false);
						Logging.writeLog(this.testname, "Unselecting checkbox with the name of "+checkbox.getName());
					}else {
						checkbox.setSelected(true);
						Logging.writeLog(this.testname, "Selecting checkbox with the name of "+checkbox.getName());
					}
				}
				if(comp instanceof JTextField){ // Textfield
					JTextField mytext = (JTextField) comp;
					String text = this.randomString();
					mytext.setText(text); // Fill with random string
					Logging.writeLog(this.testname, "Filling textfield with the name of: "+mytext.getName()+" with the string: "+text + " and pressing enter");
				}

				if (comp instanceof JPasswordField) {
					JPasswordField passwordfield = (JPasswordField) comp;
					String text = this.randomString();
					passwordfield.setText(this.randomString());
					Logging.writeLog(this.testname, "Filling passwordfield with the name of: "+passwordfield.getName()+" with the string: "+text + " and pressing enter");

				}
				if(comp instanceof JTextField){ 
					JTextField mytext = (JTextField) comp;
					mytext.setText(this.randomString());

				}
				if(comp instanceof JRadioButton) {
					JRadioButton button = (JRadioButton) comp;
					button.doClick();
					Logging.writeLog(this.testname, "Pressing radiobutton with the name of: "+button.getName() );
				}
				
			}
		}   
		return compList;
	}}