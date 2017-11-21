package core;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;

public class RandomShort {
	public static short generateShort(String testname, int iteration) {
		int i = ThreadLocalRandom.current().nextInt(1,3);
		String numbers = "1234567890";
		short randomShort = 0;
		switch (i) {
		case 1:
			for (int j = 0; j < ThreadLocalRandom.current().nextInt(0,Short.MAX_VALUE); j++) {
				randomShort = (short) (randomShort+Short.parseShort(Character.toString(numbers.charAt(ThreadLocalRandom.current().nextInt(0,numbers.length())))));
			}
			Logging.writeLog(testname, generateLog(i,iteration,Integer.toString(randomShort).length()));
			return randomShort;
		case 2:
			for (int j = 0; j < ThreadLocalRandom.current().nextInt(0,Short.MAX_VALUE); j++) {
				randomShort = (short) (randomShort+Short.parseShort(Character.toString(numbers.charAt(ThreadLocalRandom.current().nextInt(0,numbers.length())))));
			}
			Logging.writeLog(testname, generateLog(i,iteration,Integer.toString(randomShort).length()));
			return randomShort;
		default:
			MonkeyBase.logger.log(Level.WARNING, "Something went wrong generating a random string, i="+i+" with the testname="+testname);
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
