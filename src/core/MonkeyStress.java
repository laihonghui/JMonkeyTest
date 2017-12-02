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
public class MonkeyStress {
	public static Logger logger = Logger.getLogger(MonkeyStress.class.getName());
	protected String testname;
	protected int iterations;
	protected int currentIteration;
	private Date date;
	public MonkeyStress(String testname, int iterations) {
		this.testname = testname;
		this.iterations = iterations;
		this.currentIteration = 0;
		this.date = new Date();
		Logging.clearLog(this.testname);
		Logging.writeLog(this.testname, date.toString()+"|Started test");
	}

	public String randomString() {
		while(this.currentIteration<=this.iterations) {
			this.currentIteration++;
			return RandomString.generateString(this);
		}return "";
	}

	public int randomInt() {
		this.currentIteration++;
		return RandomInteger.generateInt(this);
	}

	public long randomLong() {	
		while(this.currentIteration<=this.iterations) {
			this.currentIteration++;
			return RandomInteger.generateInt(this)*10000;
		}return 0;
	}

	public boolean randomBoolean() {
		while(this.currentIteration<=this.iterations) {
			this.currentIteration++;
			return RandomBoolean.generateBoolean(this);
		}return false;
	}

	public byte randomByte() {
		while(this.currentIteration <= this.iterations) {
			this.currentIteration++;
			return RandomByte.generateByte(this);
		}return 0;
	}

	public char randomChar() {
		while(this.currentIteration<=this.iterations) {

			this.currentIteration++;
			return RandomChar.generateChar(this);
		}return ' ';
	}

	public short randomShort() {
		while(this.currentIteration<=this.iterations) {
			this.currentIteration++;
			return RandomShort.generateShort(this);
		}return 0;
	}

	public float randomFloat() {
		while(this.currentIteration<=this.iterations) {
			this.currentIteration++;
			return RandomFloat.generateFloat(this);
		} return 0;
	}


	public double randomDouble() {
		while(this.currentIteration<=this.iterations) {
			this.currentIteration++;
			return RandomDouble.generateDouble(this);
		} return 0;
	}

	public int getIterations() {
		return iterations;
	}
}
