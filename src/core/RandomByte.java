package core;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;

public class RandomByte {
	protected static byte generateByte(String testname, int iteration) {
		int i = ThreadLocalRandom.current().nextInt(1,3);
		String numbers = "1234567890";
		byte randomByte = 0;
		switch (i) {
		case 1:
			for (int j = 0; j < Byte.MAX_VALUE; j++) {
				randomByte = (byte) (randomByte+Byte.parseByte(Character.toString(numbers.charAt(ThreadLocalRandom.current().nextInt(1,numbers.length())))));
			}
			Logging.writeLog(testname, generateLog(i,iteration));
			return randomByte;
		case 2:
			for (int j = 0; j < Byte.MAX_VALUE; j++) {
				randomByte = (byte) (randomByte+Byte.parseByte(Character.toString(numbers.charAt(ThreadLocalRandom.current().nextInt(1,numbers.length())))));
			}
			Logging.writeLog(testname, generateLog(i,iteration));
			return (byte) (randomByte*-1);
		default:
			MonkeyBase.logger.log(Level.WARNING, "Something went wrong generating a random byte, i="+i+" with the testname="+testname);
			return 0;
		}
	}

	private static String generateLog(int i, int iteration) {
		switch (i) {
		case 1:
			return("i=1 |"+"iteration="+iteration+"|"+" testing with a a positive byte");			
		case 2:
			return("i=2 |"+"iteration="+iteration+"|"+" testing with a negative byte");
		default:
			return("I="+i+"|"+"ITERATION="+iteration+"|"+"SOMETHING WENT WRONG");
		}
	}
}
