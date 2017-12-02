package core;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;

public class RandomBoolean {
	protected static boolean generateBoolean(MonkeyStress test) {
		int i = ThreadLocalRandom.current().nextInt(1,3);
		switch (i) {
		case 1:
			Logging.writeLog(test.testname, generateLog(i,test.currentIteration));
			return true;
		case 2:
			Logging.writeLog(test.testname, generateLog(i,test.currentIteration));
			return false;
		default:
			MonkeyStress.logger.log(Level.WARNING, "Something went wrong generating a random boolean, i="+i+" with the testname="+test.testname);
			return false;
		}
	}

	private static String generateLog(int i, int iteration) {
		switch (i) {
		case 1:
			return("i=1 |"+"iteration="+iteration+"|"+" testing with true");			
		case 2:
			return("i=2 |"+"iteration="+iteration+"|"+" testing with false");
		default:
			return("I="+i+"|"+"ITERATION="+iteration+"|"+"SOMETHING WENT WRONG");
		}
	}
}
