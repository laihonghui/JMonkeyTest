package core;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;

public class RandomByte {
	static int i = 1;
	protected static byte generateByte(String testname, int iteration) {
		if(i!=2) {i++;}else {i=1;}
		byte randomByte;
		switch (i) {
		case 1:
			randomByte = (byte) ThreadLocalRandom.current().nextInt(0,127);
			Logging.writeLog(testname, generateLog(i,iteration));
			return randomByte;
		case 2:
			randomByte = (byte) ThreadLocalRandom.current().nextInt(-127,0);
			Logging.writeLog(testname, generateLog(i,iteration));
			return randomByte;
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
