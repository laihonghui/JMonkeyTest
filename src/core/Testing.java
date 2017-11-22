package core;

import java.awt.Frame;

/**
 * 
 * @author Mathias Thejsen - Thejsen@live.dk - s175192
 *
 */
public class Testing {
	protected static boolean testmode = true;
	public static void main(String[] args) throws InterruptedException {
		//MonkeyBase test1 = new MonkeyBase("test1");
		for (int i = 0; i <= 2000; i++) {
			//test(test1.randomString(), test1.randomInt(), test1.randomByte(), test1.randomBoolean(), test1.randomLong(), test1.randomChar(), test1.randomDouble(), test1.randomFloat(),test1.randomShort());
		}
		//Create our jframe
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
					MonkeySwing.createAndShowGUI();
					System.out.println("Test");
				}
			});
		Thread.sleep(100);
		
		//Proof of concept for swing
		for (int i = 0; i < Frame.getFrames().length; i++) {
			MonkeySwing.getAllComponents(Frame.getFrames()[i]); // Method finds our components and then feeds it random values
		}
		
	}
	public static void test(String test1, int test2, byte test3, boolean test4, long test5, char test6, double test7, float test8, short test9) {
		
	}
	
	
	
}
