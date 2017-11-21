package core;

public class Testing {

	
	
	public static void main(String[] args) {
		MonkeyBase test1 = new MonkeyBase("test1", 2000);
		System.out.println("hi");
		test(test1.randomString());
	}
	public static void test( String test2) {
		System.out.println(test2);
	}
}
