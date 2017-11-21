/**
 * 
 */
package core;

/**
 * @author Mathias Thejsen - Thejsen@live.dk
 *
 */
public class MonkeyBase {
	private String testname;
	private int iterations;
	
	public MonkeyBase(String testname, int iterations) {
		this.testname = testname;
		this.iterations = iterations;
	}
	
	public String randomString() {
		return RandomString.generateString();
	}
	
	public int randomInt() {
		int random = 0;
		return random;
	}
	
	public long randomLong() {
		return 1234;
	}
	 
	
}
