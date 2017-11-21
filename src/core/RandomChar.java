package core;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;

public class RandomChar {
	public static char generateChar(String testname, int iteration) {
		int i = ThreadLocalRandom.current().nextInt(1,4);
		String chars = "abcdefghijklmnopqrstuvxyz";
		String symbols = "!#¤%&¤%&/()=?1`@£<<{[]}|¨~^'*,;.:-_<>½§";
		String numbers = "1234567890";
		char randomChar;
		switch (i) {
		case 1:
			randomChar = chars.charAt(ThreadLocalRandom.current().nextInt(1,chars.length()));		
			Logging.writeLog(testname, generateLog(i,iteration, randomChar));
			return randomChar;
		case 2:
			randomChar = symbols.charAt(ThreadLocalRandom.current().nextInt(1,symbols.length()));
			Logging.writeLog(testname, generateLog(i,iteration, randomChar));
			return randomChar;
		case 3:
			randomChar = numbers.charAt(ThreadLocalRandom.current().nextInt(1,numbers.length()));
			Logging.writeLog(testname, generateLog(i,iteration, randomChar));
			return randomChar;

		default:
			MonkeyBase.logger.log(Level.WARNING, "Something went wrong generating a random string, i="+i+" with the testname="+testname);
			return 0;
		}
	}
	private static String generateLog(int i, int iteration, char character) {
		switch (i) {
		case 1:
			return("i=1 |"+"iteration="+iteration+"|"+" Generating random character char: " + character);			
		case 2:
			return("i=2 |"+"iteration="+iteration+"|"+" Generating random symbol char: " + character);
		case 3:
			return("i=3 |"+"iteration="+iteration+"|"+" Generating random number char: " + character);
		default:
			return("I="+i +"|"+"ITERATION="+iteration+"|"+"SOMETHING WENT WRONG WITH THE CHAR: " + character );
		}
	}
}
