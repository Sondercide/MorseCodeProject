import java.util.*;

/**
 * Code that decodes each possible output from a string of morsecode
 * @author Jacob Brown
 */
public class MorseCode {
	
	static HashMap <String, String> Morsecode= new HashMap<>();
	
	public static void main(String[] args) {
		String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
				"w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
				"9", "0"};
		
		String[] morseCodes = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
				"....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
				"--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
				"-.--", "--..", ".----", "..---", "...--", "....-", ".....",
				"-....", "--...", "---..", "----.", "-----"};
		
		for(int i = 0; i < alphabet.length; i++) 
			Morsecode.put(morseCodes[i], alphabet[i]);
		
			morse("-.-.-", "");		
	}
	
	/**
	 * recursive call that decodes morsecode input
	 * @param s Morsecode input
	 * @param f previous morsecode inputs that have been decoded
	 */
	public static void morse(String s, String f) {
		if(s.length() == 0) {
				System.out.println(f);
		}
		else {
			for(int i = 1; i <= s.length() ; i++) {
				String d = decode(s.substring(0, i)); 
				if(d.length() != 0)
					morse(s.substring(i),f+d);					
			}
		}
	}
	
	/**
	 * takes in morsecode and returns its letter equivalent 
	 * @param s morsecode input
	 * @return translated morsecode
	 */
	public static String decode(String s) {
		if(!Morsecode.containsKey(s)) 
			return "";
		else 
			return Morsecode.get(s);		
	}

}
