package core;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;

public class RandomString {
	protected static String generateString(MonkeyStress test) {
		int i = ThreadLocalRandom.current().nextInt(1, 5);
		String[] chars = {"a","b","c","d","e","f","g","h","i","j","k","l","m","o","p","q","r","s","t","u","v","x","y","z"};
		String[] symbols = {"!","#","¤","%","&","¤","%","&","/","(",")","=","?","`","@","£","<","<","{","[","]","}","|","¨","~","^","'","*",";",".",":","-","<",">","½","§"};		
		String randomString="";
		String stringlenght = Integer.toString(ThreadLocalRandom.current().nextInt(0,Integer.MAX_VALUE));
		switch (i) {
		case 1:
			for (int j = 0; j < stringlenght.length(); j++) {
				randomString = randomString+chars[ThreadLocalRandom.current().nextInt(0,chars.length)];
			}
			Logging.writeLog(test.testname, generateLog(i,test.currentIteration, randomString.length()));
			return randomString;
		case 2:
			for (int j = 0; j <stringlenght.length(); j++) {
				randomString = randomString+symbols[ThreadLocalRandom.current().nextInt(0,symbols.length)];
			}
			Logging.writeLog(test.testname, generateLog(i,test.currentIteration, randomString.length()));
			return randomString;
		case 3:
			for (int j = 0; j < stringlenght.length(); j++) {
				randomString = randomString+Integer.toString(ThreadLocalRandom.current().nextInt(0,10));
			}
			Logging.writeLog(test.testname, generateLog(i,test.currentIteration, randomString.length()));
			return randomString;
		case 4:
			for (int j = 0; j < stringlenght.length(); j++) {
				randomString = randomString+chars[ThreadLocalRandom.current().nextInt(0,chars.length)]+symbols[ThreadLocalRandom.current().nextInt(0,symbols.length)]+Integer.toString(ThreadLocalRandom.current().nextInt(0,10));
				j++;
				j++;
			}
			Logging.writeLog(test.testname, generateLog(i,test.currentIteration, randomString.length()));
			return randomString;
		default:
			MonkeyStress.logger.log(Level.WARNING, "Something went wrong generating a random string, i="+i+" with the testname="+test.testname);
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
