package core;

import java.util.logging.Level;

public class RandomBoolean {
	static int i = 1;
	protected static boolean generateBoolean(String testname, int iteration) {
		if(i!=2) {i++;}else {i=1;}
		switch (i) {
		case 1:
			Logging.writeLog(testname, generateLog(i,iteration));
			return true;
		case 2:
			Logging.writeLog(testname, generateLog(i,iteration));
			return false;
		default:
			MonkeyBase.logger.log(Level.WARNING, "Something went wrong generating a random boolean, i="+i+" with the testname="+testname);
			return false;
		}
	}

	private static String generateLog(int i, int iteration) {
		switch (i) {
		case 1:
			return("i=1 |"+"iteration="+iteration+"|"+" testing with true");			
		case 2:
			return("i=2 |"+"iteration="+iteration+"|"+" testing with false");
		default:
			return("I="+i+"|"+"ITERATION="+iteration+"|"+"SOMETHING WENT WRONG");
		}
	}
}
