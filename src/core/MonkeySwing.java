package core;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;        

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
		frame.setSize(400, 600);
		frame.setVisible(true);
	}

	protected static List<Component> getAllComponents(final Container c) {
		MonkeyBase test1 = new MonkeyBase("test1", 1000);
		boolean testmode = Testing.testmode;
		Component[] comps = c.getComponents();
		List<Component> compList = new ArrayList<Component>();
		for (int i = 0; i < test1.getIterations(); i++) {

		for (Component comp : comps) {
			compList.add(comp);
			if (comp instanceof Container)
				compList.addAll(getAllComponents((Container) comp));
			if(comp instanceof JButton) { // Dealing with buttons
				JButton button = (JButton) comp;
				button.doClick();
			}
			if(comp instanceof JTextField){ // Dealing with textifled
				JTextField mytext = (JTextField) comp;
				mytext.setText(test1.randomString());
				try {
					if(testmode) {
						Thread.sleep(50);
					}
				} catch (Exception e) {
				}

			}
			
		}
		}   
		return compList;
	}}