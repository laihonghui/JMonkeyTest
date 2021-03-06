package core;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
/**
 * 
 *@author Mathias Thejsen - Thejsen@live.dk - s175192
 *
 */
public class RandomInteger {
	protected static int generateInt(MonkeyStress test) {
		int i = ThreadLocalRandom.current().nextInt(1,3);
		int randomInteger = 0;
		switch (i) {
		case 1:
			randomInteger = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
			Logging.writeLog(test.testname, generateLog(i,test.currentIteration,Integer.toString(randomInteger).length()));
			return randomInteger;
		case 2:
			randomInteger = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
			Logging.writeLog(test.testname, generateLog(i,test.currentIteration,Integer.toString(randomInteger).length()));
			return randomInteger*-1;
		default:
			MonkeyStress.logger.log(Level.WARNING, "Something went wrong generating a random integer, i="+i+" with the testname="+test.testname);
			return 0;
		}
	}

	private static String generateLog(int i, int iteration, int len) {
		switch (i) {
		case 1:
			return("i=1 |"+"iteration="+iteration+"|"+" Generating random positive integer, with a lenght of " + len);			
		case 2:
			return("i=2 |"+"iteration="+iteration+"|"+" Generating random negative integer, with a lenght of " + len);
		default:
			return("I="+i+"|"+"ITERATION="+iteration+"|"+"SOMETHING WENT WRONG WITH A LENGHT OF " + len);
		}
	}
}
