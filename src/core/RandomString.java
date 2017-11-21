package core;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RandomString {
	protected static String generateString(String testname, int iteration) {
		int i = ThreadLocalRandom.current().nextInt(1, 5);
		String chars = "abcdefghijklmnopqrstuvxyz";
		String symbols = "!#¤%&¤%&/()=?1`@£<<{[]}|¨~^'*,;.:-_<>½§";
		String numbers = "1234567890";
		String randomString="";
		switch (i) {
		case 1:
			for (int j = 0; j < ThreadLocalRandom.current().nextInt(100,10000)*10; j++) {
				randomString = randomString+chars.charAt(ThreadLocalRandom.current().nextInt(1,chars.length()));
			}
			Logging.writeLog(testname, generateLog(i,iteration, randomString.length()));
			return randomString;
		case 2:
			for (int j = 0; j < ThreadLocalRandom.current().nextInt(100,10000)*10; j++) {
				randomString = randomString+symbols.charAt(ThreadLocalRandom.current().nextInt(1,symbols.length()));
			}
			Logging.writeLog(testname, generateLog(i,iteration, randomString.length()));
			return randomString;
		case 3:
			for (int j = 0; j < ThreadLocalRandom.current().nextInt(100,10000)*10; j++) {
				randomString = randomString+numbers.charAt(ThreadLocalRandom.current().nextInt(1,numbers.length()));
			}
			Logging.writeLog(testname, generateLog(i,iteration, randomString.length()));
			return randomString;
		case 4:
			for (int j = 0; j < ThreadLocalRandom.current().nextInt(100,10000)*10; j++) {
				randomString = randomString+chars.charAt(ThreadLocalRandom.current().nextInt(1,chars.length()))+symbols.charAt(ThreadLocalRandom.current().nextInt(1,symbols.length()))+numbers.charAt(ThreadLocalRandom.current().nextInt(1,numbers.length()));
				j++;
				j++;
			}
			Logging.writeLog(testname, generateLog(i,iteration, randomString.length()));
			return randomString;
		default:
			MonkeyBase.logger.log(Level.WARNING, "Something went wrong generating a random string, i="+i+" with the testname="+testname);
			return "";
		}
	}
	private static String generateLog(int i, int iteration, int len) {
		switch (i) {
		case 1:
			return("i=1 |"+"iteration="+iteration+"|"+" Generating random sequence of chars, with a lenght of " + len);			
		case 2:
			return("i=2 |"+"iteration="+iteration+"|"+" Generating random sequence of symbols, with a lenght of " + len);
		case 3:
			return("i=3 |"+"iteration="+iteration+"|"+" Generating random sequence of numbers, with a lenght of " + len);
		case 4:
			return("i=1 |"+"iteration="+iteration+"|"+" Generating random sequence of chars,symbols and numbers, with a lenght of " + len);
		default:
			return("I="+i +"|"+"ITERATION="+iteration+"|"+"SOMETHING WENT WRONG WITH A LENGHT OF " + len);
		}
	}
}
