package core;
/**
 * 
 * @author Mathias Thejsen - Thejsen@live.dk - s175192
 *
 */
public class Testing {
	public static void main(String[] args) {
		MonkeyBase test1 = new MonkeyBase("test1", 2000);
		for (int i = 0; i <= 2000; i++) {
			test(test1.randomString(), test1.randomInt(), test1.randomByte(), test1.randomBoolean(), test1.randomLong());
		}
	}
	public static void test(String test1, int test2, byte test3, boolean test4, long test5) {
	}

}
