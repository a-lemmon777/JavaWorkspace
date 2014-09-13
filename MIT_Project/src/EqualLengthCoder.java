// Aaron Lemmon

public class EqualLengthCoder {

	public static String removeNonLetters(String originalPhrase) {
		String result = "";
		for (int i = 0; i < originalPhrase.length(); i++) {
			char character = originalPhrase.charAt(i);
			if (isALetter(character)) {
				result += character;
			}
		}
		return result;
	}

	public static boolean isALetter(char character) {
		return (('A' <= character && character <= 'Z') || ('a' <= character && character <= 'z'));
	}

	// Assumes the input is a lower-case letter. 'a' is considered to be 0.
	public static int letterToNumber(char letter) {
		return letter - 'a';
	}

	// Assumes the input is an integer from 0 to 31. Inputs greater than 31 will return the same result as 31, which
	// is "11111"
	public static String numberToBinaryString(int number) {
		String result = "";
		for (int powerOfTwo = 16; powerOfTwo > 0; powerOfTwo /= 2) {
			if (number >= powerOfTwo) {
				result += "1";
				number -= powerOfTwo;
			} else {
				result += "0";
			}
		}
		return result;
	}

	public static String encode(String phrase) {
		String result = "";
		phrase = removeNonLetters(phrase);
		phrase = phrase.toLowerCase();
		for (int i = 0; i < phrase.length(); i++) {
			char letter = phrase.charAt(i);
			int numberOfLetter = letterToNumber(letter);
			result += numberToBinaryString(numberOfLetter);
		}
		return result;
	}

	// Converts an int to a character according to Unicode.
	public static char numberToLetter(int i) {
		return (char) ('a' + i);
	}

	public static String decode(String code) {
		String result = "";
		for (int i = 0; i < code.length(); i += 5) { // Increment by 5 since each encoding is 5 characters long.
			String encoding = code.substring(i, i + 5);
			int numberOfLetter = Integer.parseInt(encoding, 2);
			char letter = numberToLetter(numberOfLetter);
			result += letter;
		}
		return result;
	}
}
