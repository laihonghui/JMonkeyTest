package core;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;

public class RandomByte {
	protected static byte generateByte(MonkeyStress test) {
		int i = ThreadLocalRandom.current().nextInt(1,3);
		byte randomByte;
		switch (i) {
		case 1:
			randomByte = (byte) ThreadLocalRandom.current().nextInt(0,127);
			Logging.writeLog(test.testname, generateLog(i,test.currentIteration));
			return randomByte;
		case 2:
			randomByte = (byte) ThreadLocalRandom.current().nextInt(-127,0);
			Logging.writeLog(test.testname, generateLog(i,test.currentIteration));
			return randomByte;
		default:
			MonkeyStress.logger.log(Level.WARNING, "Something went wrong generating a random byte, i="+i+" with the testname="+test.testname);
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
