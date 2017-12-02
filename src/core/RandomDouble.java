package core;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;

public class RandomDouble {
	public static double generateDouble(MonkeyStress test) {
		int i = ThreadLocalRandom.current().nextInt(1,3);
		double randomDouble;
		switch (i) {
		case 1:
			randomDouble = ThreadLocalRandom.current().nextDouble(Double.MIN_VALUE, Double.MAX_VALUE);
			Logging.writeLog(test.testname, generateLog(i,test.iterations,Double.toString(randomDouble).length()));
			return randomDouble;
		case 2:
			randomDouble = ThreadLocalRandom.current().nextDouble(Double.MIN_VALUE, Double.MAX_VALUE);
			Logging.writeLog(test.testname, generateLog(i,test.iterations,Double.toString(randomDouble).length()));
			return randomDouble*-1.0;
		default:
			MonkeyStress.logger.log(Level.WARNING, "Something went wrong generating a random double, i="+i+" with the testname="+test.iterations);
			return 0;
		}
	}
	private static String generateLog(int i, int iteration, int len) {
		switch (i) {
		case 1:
			return("i=1 |"+"iteration="+iteration+"|"+" Generating random positive double, with a lenght of " + len);			
		case 2:
			return("i=2 |"+"iteration="+iteration+"|"+" Generating random negative double with a lenght of " + len);
		default:
			return("I="+i+"|"+"ITERATION="+iteration+"|"+"SOMETHING WENT WRONG WITH A LENGHT OF " + len);
		}
	}
}
