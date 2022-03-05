/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Run_Length;

/**
 *
 * @author Dell
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunLength {

	public static void main(String[] args) {
		String s = "AAABBBBBBCCDDDEEEEEE";
		
		String e = encode(s);
		String d = decode(e);
		
		System.out.println("Encode: " + e);
		System.out.println("Decode: " + d);
		System.out.println("Result: " + s.equals(d));
	}

	static String encode(String source) {
		StringBuffer stringBuffer = new StringBuffer();

		for (int i = 0; i < source.length(); i++) {
			int runLength = 1;

			while (i + 1 < source.length() && source.charAt(i) == source.charAt(i + 1)) {
				runLength++;
				i++;
			}

			stringBuffer.append(runLength); // AAA -> 3
			stringBuffer.append(source.charAt(i)); // A
		}

		return stringBuffer.toString();
	}

    static String decode(String source) {
	StringBuffer stringBuffer = new StringBuffer();

		Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]");
		Matcher matcher = pattern.matcher(source);

		while (matcher.find()) {
			int num = Integer.parseInt(matcher.group());
			matcher.find();
			while (num-- != 0) {
				stringBuffer.append(matcher.group());
			}
		}

            return stringBuffer.toString();
	}
}