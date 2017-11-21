/**
 * 
 */
package core;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author Mathias Thejsen - Thejsen@live.dk - s175192
 *
 */
public class MonkeyBase {
	public static Logger logger = Logger.getLogger(MonkeyBase.class.getName());
	private String testname;
	private int iterations, currentIteration;
	private Date date;
	public MonkeyBase(String testname, int iterations) {
		this.testname = testname;
		this.iterations = iterations;
		this.currentIteration = 0;
		this.date = new Date();
		Logging.clearLog(this.testname);
		Logging.writeLog(this.testname, date.toString()+"|Started test, with "+this.iterations+" iterations");
	}

	public String randomString() {
		if(this.currentIteration == this.iterations) {
			finishTest();
		}
		while(this.currentIteration <= this.iterations) {
			this.currentIteration++;
			return RandomString.generateString(this.testname, this.currentIteration);
		}
		return RandomString.generateString(this.testname, this.currentIteration);
	}

	public int randomInt() {
		if(this.currentIteration == this.iterations) {
			finishTest();
		}
		while(this.currentIteration <= this.iterations) {
			this.currentIteration++;
			return RandomInteger.generateInt(this.testname, this.currentIteration);
		}
		return RandomInteger.generateInt(this.testname, this.currentIteration);
	}

	public long randomLong() {
		//Needs to be implemented
		return 1234;
	}

	private void finishTest() {
		logger.log(Level.INFO,"Finished test: "+this.testname+" with "+this.iterations+" iterations"+" see log file for more info");
		Logging.writeLog(this.testname, date.toString()+"|Finished test, with"+this.iterations+" iteratoins");
	}


}
