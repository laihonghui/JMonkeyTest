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
			test(test1.randomString(), test1.randomInt());
		}
	}
	public static void test(String test2, int test1) {

	}

}
