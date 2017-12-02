package core;

/**
 * 
 * @author Mathias Thejsen - Thejsen@live.dk - s175192
 *
 */
public class Testing {
	public static void main(String[] args) throws InterruptedException {
		MonkeyStress test1 = new MonkeyStress("test1",2000); // Initializing a new test
		while(test1.currentIteration <= test1.iterations) { // Run while current iteration is less than the target
			test(test1.randomString(), test1.randomInt(), test1.randomByte(), test1.randomBoolean(), test1.randomLong(), test1.randomChar(), test1.randomDouble(), test1.randomFloat(),test1.randomShort());
		}
		MonkeySwing test2 = new MonkeySwing("test", 100);// Testing swing ui
	}
	
	
	/**
	 * Just an empty method to feed random input
	 * @param test1
	 * @param test2
	 * @param test3
	 * @param test4
	 * @param test5
	 * @param test6
	 * @param test7
	 * @param test8
	 * @param test9
	 */
	public static void test(String test1, int test2, byte test3, boolean test4, long test5, char test6, double test7, float test8, short test9) {
		System.out.println(test1 + " "+ test2 + " "+ test3 + " "+ test4 + " "+ test5 + " " + test6 + " "+ test7+ " " + test8+ " " + test9);
	} 

}
