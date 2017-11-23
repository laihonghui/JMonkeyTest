/**
 * 
 */
package core;

import java.util.Date;
import java.util.logging.Logger;


/**
 * @author Mathias Thejsen - Thejsen@live.dk - s175192
 *
 */
public class MonkeyBase {
	public static Logger logger = Logger.getLogger(MonkeyBase.class.getName());
	protected String testname;
	protected int iterations;
	private int currentIteration;
	private Date date;
	public MonkeyBase(String testname, int iterations) {
		this.testname = testname;
		this.iterations = iterations;
		this.currentIteration = 0;
		this.date = new Date();
		Logging.clearLog(this.testname);
		Logging.writeLog(this.testname, date.toString()+"|Started test");
	}

	public String randomString() {
		this.currentIteration++;
		return RandomString.generateString(this.testname, this.currentIteration);
	}

	public int randomInt() {
		this.currentIteration++;
		return RandomInteger.generateInt(this.testname, this.currentIteration);
	}

	public long randomLong() {	
		this.currentIteration++;
		return RandomInteger.generateInt(this.testname, this.currentIteration)*10000;
	}

	public boolean randomBoolean() {
		this.currentIteration++;
		return RandomBoolean.generateBoolean(this.testname, this.currentIteration);
	}

	public byte randomByte() {
		this.currentIteration++;
		return RandomByte.generateByte(this.testname, this.currentIteration);
	}

	public char randomChar() {
		this.currentIteration++;
		return RandomChar.generateChar(this.testname, this.currentIteration);
	}

	public short randomShort() {
		this.currentIteration++;
		return RandomShort.generateShort(this.testname, this.currentIteration);
	}

	public float randomFloat() {
		this.currentIteration++;
		return RandomFloat.generateFloat(this.testname, this.currentIteration);
	}


	public double randomDouble() {
		this.currentIteration++;
		return RandomDouble.generateDouble(this.testname, this.currentIteration);
	}

	public int getIterations() {
		return iterations;
	}
}
