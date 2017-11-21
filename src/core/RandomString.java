package core;

import java.util.concurrent.ThreadLocalRandom;

public class RandomString {
	protected static String generateString() {
		int i = ThreadLocalRandom.current().nextInt(1, 5);
		String chars = "abcdefghijklmnopqrstuvxyz";
		String symbols = "!#¤%&¤%&/()=?1`@£<<{[]}|¨~^'*,;.:-_<>½§";
		String numbers = "1234567890";
		String randomString="";
		i=1;
		switch (i) {
		case 1:
			for (int j = 0; j < Integer.MAX_VALUE; j++) {
				randomString = randomString+chars.charAt(ThreadLocalRandom.current().nextInt(1,chars.length()));
				System.out.println(randomString);
			}
			return randomString;
		case 2:
			for (int j = 0; j < Integer.MAX_VALUE; j++) {
				randomString = randomString+symbols.charAt(ThreadLocalRandom.current().nextInt(1,symbols.length()));
			}
			return randomString;
		case 3:
			for (int j = 0; j < Integer.MAX_VALUE; j++) {
				randomString = randomString+numbers.charAt(ThreadLocalRandom.current().nextInt(1,numbers.length()));
			}
			return randomString;
		case 4:
			for (int j = 0; j < Integer.MAX_VALUE; j++) {
				randomString = randomString+chars.charAt(ThreadLocalRandom.current().nextInt(1,chars.length()))+symbols.charAt(ThreadLocalRandom.current().nextInt(1,symbols.length()))+numbers.charAt(ThreadLocalRandom.current().nextInt(1,numbers.length()));
				j++;
				j++;
			}
			return randomString;
		default:
			// Insert logger here
			return "bla";
		}
	}
}
