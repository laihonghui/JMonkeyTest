package core;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;        

public class MonkeySwing {
	public static final int FIVE_SECONDS = 5000;
	public static final int MAX_Y = 400;
	public static final int MAX_X = 400;


	/**
	 * Create the GUI and show it.  For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
	public static void createAndShowGUI() {
		JFrame frame = new JFrame("HelloWorldSwing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTextField field = new JTextField("aa");
		frame.getContentPane().add(field);
		frame.pack();
		frame.setVisible(true);




	}

	public static void main(String[] args) throws InterruptedException{
		

		

	}


	protected static List<Component> getAllComponents(final Container c) {
		MonkeyBase test1 = new MonkeyBase("test1", 1000);
		boolean testmode = Testing.testmode;
		Component[] comps = c.getComponents();
		List<Component> compList = new ArrayList<Component>();
		for (Component comp : comps) {
			compList.add(comp);
			if (comp instanceof Container)
				compList.addAll(getAllComponents((Container) comp));

			if(comp instanceof JTextField){ // Dealing with textifled
				JTextField mytext = (JTextField) comp;
				for (int i = 0; i < test1.getIterations(); i++) {
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