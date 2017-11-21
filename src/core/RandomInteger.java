package core;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
/**
 * 
 *@author Mathias Thejsen - Thejsen@live.dk - s175192
 *
 */
public class RandomInteger {
	protected static int generateInt(String testname, int iteration) {
		int i = ThreadLocalRandom.current().nextInt(1,3);
		String numbers = "1234567890";
		int randomInteger = 0;
		switch (i) {
		case 1:
			for (int j = 0; j < ThreadLocalRandom.current().nextInt(1,10000)*100; j++) {
				randomInteger = randomInteger+j*10*Integer.parseInt(Character.toString(numbers.charAt(ThreadLocalRandom.current().nextInt(1,numbers.length()))));
			}
			Logging.writeLog(testname, generateLog(i,iteration,Integer.toString(randomInteger).length()));
			return randomInteger;
		case 2:
			for (int j = 0; j < ThreadLocalRandom.current().nextInt(1,10000)*100; j++) {
				randomInteger = randomInteger+j*10*Integer.parseInt(Character.toString(numbers.charAt(ThreadLocalRandom.current().nextInt(1,numbers.length()))));
			}
			if(randomInteger > 0) {
				randomInteger = randomInteger*-1;
			}
			Logging.writeLog(testname, generateLog(i,iteration,Integer.toString(randomInteger).length()));
			return 0;
		default:
			MonkeyBase.logger.log(Level.WARNING, "Something went wrong generating a random string, i="+i+" with the testname="+testname);
			return 0;
		}
	}

	private static String generateLog(int i, int iteration, int len) {
		switch (i) {
		case 1:
			return("i=1 |"+"iteration="+iteration+"|"+" Generating random sequence of positive numbers, with a lenght of " + len);			
		case 2:
			return("i=2 |"+"iteration="+iteration+"|"+" Generating random sequence of negtive numbers, with a lenght of " + len);
		default:
			return("I="+i+"|"+"ITERATION="+iteration+"|"+"SOMETHING WENT WRONG WITH A LENGHT OF " + len);
		}
	}
}
