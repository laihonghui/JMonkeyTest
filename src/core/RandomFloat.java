package core;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;

public class RandomFloat {
	public static float generateFloat(MonkeyStress test) {
		int i = ThreadLocalRandom.current().nextInt(1,3);
		float randomFloat;
		switch (i) {
		case 1:
			randomFloat = ThreadLocalRandom.current().nextFloat();
			Logging.writeLog(test.testname, generateLog(i,test.iterations,Float.toString(randomFloat).length()));
			return randomFloat;
		case 2:
			randomFloat = ThreadLocalRandom.current().nextFloat();
			Logging.writeLog(test.testname, generateLog(i,test.iterations,Float.toString(randomFloat).length()));
			return (float) (randomFloat*-1.0);
		default:
			MonkeyStress.logger.log(Level.WARNING, "Something went wrong generating a random float, i="+i+" with the testname="+test.testname);
			return 0;
		}
	}
	private static String generateLog(int i, int iteration, int len) {
		switch (i) {
		case 1:
			return("i=1 |"+"iteration="+iteration+"|"+" Generating random positive float, with a lenght of " + len);			
		case 2:
			return("i=2 |"+"iteration="+iteration+"|"+" Generating random negative float with a lenght of " + len);
		default:
			return("I="+i+"|"+"ITERATION="+iteration+"|"+"SOMETHING WENT WRONG WITH A LENGHT OF " + len);
		}
	}
}
