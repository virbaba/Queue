import java.util.* ;
import java.io.*; 
public class Solution {
	public static char firstNonRepeating(String str) {
		// Write your code here
		HashMap < Character, Integer > freqOfCharacters = new HashMap< Character, Integer > ();

		// Loop to calculate frequency of each character
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			int number = freqOfCharacters.getOrDefault(ch, 0);
			freqOfCharacters.put(ch, number + 1);

		}

		// Loop to return the first non-repeating character
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (freqOfCharacters.get(ch).intValue() == 1) {
				return ch;
			}
		}
		// Return first character of string if all are repeating characters
		return '#';
	}
}
