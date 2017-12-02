package core;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;

public class RandomShort {
	public static short generateShort(MonkeyStress test) {
		int i = ThreadLocalRandom.current().nextInt(1,3);
		short randomShort = 0;
		switch (i) {
		case 1:
			randomShort = (short) ThreadLocalRandom.current().nextInt(Short.MIN_VALUE,Short.MAX_VALUE);
			Logging.writeLog(test.testname, generateLog(i,test.currentIteration,Integer.toString(randomShort).length()));
			return randomShort;
		case 2:
			randomShort = (short) ThreadLocalRandom.current().nextInt(Short.MIN_VALUE,Short.MAX_VALUE);
			Logging.writeLog(test.testname, generateLog(i,test.currentIteration,Integer.toString(randomShort).length()));
			return randomShort;
		default:
			MonkeyStress.logger.log(Level.WARNING, "Something went wrong generating a random short, i="+i+" with the testname="+test.testname);
			return 0;
		}
	}
	private static String generateLog(int i, int iteration, int len) {
		switch (i) {
		case 1:
			return("i=1 |"+"iteration="+iteration+"|"+" Generating random positive short, with a lenght of " + len);			
		case 2:
			return("i=2 |"+"iteration="+iteration+"|"+" Generating random negative short with a lenght of " + len);
		default:
			return("I="+i+"|"+"ITERATION="+iteration+"|"+"SOMETHING WENT WRONG WITH A LENGHT OF " + len);
		}
	}
}
