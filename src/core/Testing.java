package core;
/**
 * 
 * @author Mathias Thejsen - Thejsen@live.dk - s175192
 *
 */
public class Testing {
	public static void main(String[] args) {
		MonkeyBase test1 = new MonkeyBase("test1", 20000);
		for (int i = 0; i <= 20000; i++) {
			test(test1.randomString(), 1, test1.randomByte(), test1.randomBoolean(), 1);
		}
	}
	public static void test(String test1, int test2, byte test3, boolean test4, long test5) {
	}

}
