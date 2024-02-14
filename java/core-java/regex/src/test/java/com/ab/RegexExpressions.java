package com.ab;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class RegexExpressions {

	/**
	 * 123456789 matched=true
	 * 1234567890 matched=false
	 * 123456789 matched=true
	 * 1234567890 matched=false
	 * 123456789 matched=true
	 * 1234567890 matched=false
	 */
	@Test
	public void maximum9Digits() {
		final String regex = "[0-9]{9}";
		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher("123456789");
		Boolean result1 = matcher.matches();
		log.info("123456789 matched={}", result1);

		Matcher matcher2 = pattern.matcher("1234567890");
		Boolean result2 = matcher2.matches();
		log.info("1234567890 matched={}", result2);

		final String regex2 = "\\d{9}";
		final Pattern pattern2 = Pattern.compile(regex2);

		Matcher matcher3 = pattern2.matcher("123456789");
		Boolean result3 = matcher3.matches();
		log.info("123456789 matched={}", result3);

		Matcher matcher4 = pattern2.matcher("1234567890");
		Boolean result4 = matcher4.matches();
		log.info("1234567890 matched={}", result4);

		final String regex3 = "^\\d{9}$";
		final Pattern pattern3 = Pattern.compile(regex3);

		Matcher matcher5 = pattern3.matcher("123456789");
		Boolean result5 = matcher5.matches();
		log.info("123456789 matched={}", result5);

		Matcher matcher6 = pattern3.matcher("1234567890");
		Boolean result6 = matcher6.matches();
		log.info("1234567890 matched={}", result6);
	}

	/**
	 * ^[a-zA-Z0-9]*$ == Regular expression for Alpha numeric
	 * 
	 * ^ - Start of string
	 * 
	 * [a-zA-Z0-9]* - multiple characters to include
	 * 
	 * $ -&gt; End of string
	 */
	@Test
	public void isAlphaNumeric() {
		String pattern = "^[a-zA-Z0-9]*$";

		System.out.println("pattern: " + pattern);
		System.out.println("\"abc\".matches(pattern): " + "abc".matches(pattern));
		System.out.println("\"abc123\".matches(pattern): " + "abc123".matches(pattern));
		System.out.println("\"abc@12#def&\".matches(pattern): " + "abc@12#def&".matches(pattern));
		System.out.println("\"abc def\".matches(pattern): " + "abc def".matches(pattern));
	}

	@Test
	public void singleCharacter() {
		// method 1
		Pattern pattern = Pattern.compile(".s"); // .(dot) represents single character
		Matcher m = pattern.matcher("as");
		boolean value1 = m.matches();
		System.out.println("value1: " + value1); // value1: true

		// method 2
		boolean value2 = Pattern.compile(".s").matcher("as").matches();
		System.out.println("value2: " + value2); // value2: true

		// method 3
		boolean value3 = Pattern.matches(".s", "as");
		System.out.println("value3: " + value3); // value3: true

		boolean value4 = Pattern.matches(".s", "abs");
		System.out.println("value4: " + value4); // value4: false
	}

	@Test
	public void characterMatcher() {
		System.out.println(Pattern.matches("[adf]", "a")); // true
		System.out.println(Pattern.matches("[adf]", "abc")); // false
	}

	@Test
	public void quantifiers() {
		System.out.println("? quantifier");
		System.out.println(Pattern.matches("[abc]?", "a")); // true
		System.out.println(Pattern.matches("[abc]?", "aa")); // false
		System.out.println(Pattern.matches("[abc]?", "abcabc")); // false
		System.out.println(Pattern.matches("[abc]?", "abc")); // false. a or b or c must occur only once

		System.out.println("+ quantifier");
		System.out.println(Pattern.matches("[abc]+", "a")); // true
		System.out.println(Pattern.matches("[abc]+", "abc")); // true
		System.out.println(Pattern.matches("[abc]+", "abde")); // false. d and e are not matching pattern

		System.out.println("* quantifier");
		System.out.println(Pattern.matches("[abc]*", "a")); // true
		System.out.println(Pattern.matches("[abc]*", "abc")); // true
		System.out.println(Pattern.matches("[abc]*", "abcabc")); // true
	}

	@Test
	public void regexMetaCharacters() {
		System.out.println("d metacharacter");
		System.out.println(Pattern.matches("\\d", "1")); // true
		System.out.println(Pattern.matches("\\d", "a")); // false
		System.out.println(Pattern.matches("\\d", "abc")); // false
		System.out.println(Pattern.matches("\\d", "123")); // false
		System.out.println(Pattern.matches("\\d", "123abc")); // false

		System.out.println("D metacharacter");
		System.out.println(Pattern.matches("\\D", "1")); // false
		System.out.println(Pattern.matches("\\D", "a")); // true
		System.out.println(Pattern.matches("\\D", "abc")); // false
		System.out.println(Pattern.matches("\\D", "123")); // false
		System.out.println(Pattern.matches("\\D", "123abc")); // false
		System.out.println(Pattern.matches("\\D*", "abc")); // true - non-digit 0 or more times
	}

	@Test
	public void finder() {
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				System.out.println("Enter regex pattern: ");
				Pattern pattern = Pattern.compile(scanner.nextLine());
				System.out.println("Enter text: ");
				Matcher matcher = pattern.matcher(scanner.nextLine());
				boolean found = false;
				while (matcher.find()) {
					System.out.println("Found the text \"" + matcher.group() + "\" starting at index: "
							+ matcher.start() + " and ending at index: " + matcher.end());
					found = true;
				}

				if (!found) {
					System.out.println("No match found");
				}
			}
		}
	}

	/**
	 * Get all words in { and }
	 */
	@Test
	public void readPlaceHoldersInAString() {
		String str = "Hello {world}. welcome to {java} {regex}";
		Pattern pattern = Pattern.compile("\\{\\w+\\}");
		Matcher matcher = pattern.matcher(str);
		List<String> placeHolders = new ArrayList<>();
		while (matcher.find()) {
			placeHolders.add(matcher.group());
		}
		System.out.println(placeHolders);
	}

	@Test
	public void extractNumber50() {
		String input = "class PRIORITY-CLASS-GROUP\n  bandwidth remaining percent 50";

		// below 2 are valid patterns
		Pattern pattern = Pattern.compile("(?m)\\s+(bandwidth remaining percent)\\s+(?<bandwidth>\\d*)");
		// Pattern pattern = Pattern.compile(".(bandwidth remaining percent)\\s+(?<bandwidth>\\d*)");

		System.out.println(input);

		Matcher matcher = pattern.matcher(input);
		System.out.println("matcher.find()==" + matcher.find());
		System.out.println("result==" + matcher.group("bandwidth"));
	}

	/**
	 * <ol>
	 * 	<li>Email start with character (small or capital) or digits or dots</li>
	 *  <li>Contain only one @</li>
	 *  <li>characters (small and capital) after @</li>
	 *  <li>dot after domain characters</li>
	 *  <li>Ending with characters (small and capital)</li>
	 *  <li>Should match from entire input string start to end - so ^ at the start and $ at the end</li>
	 * </ol>
	 */
	@Test
	public void validateEmailAddress() {
		String emailId1 = "jack.123@gmail.com";
		String emailId2 = "johngmail.com";
		String regexString = "^(?<emailID>[a-zA-Z0-9\\.]+)@{1}(?<domainID>[a-zA-Z]+)\\.(?<extn>[a-zA-z]+)$";

		Pattern pattern = Pattern.compile(regexString);
		Matcher emailId1Matcher = pattern.matcher(emailId1);
		System.out.println("find()=" + emailId1Matcher.find());
		System.out.println("group(emailID)=" + emailId1Matcher.group("emailID"));
		System.out.println("group(domainID)=" + emailId1Matcher.group("domainID"));
		System.out.println("group(extn)=" + emailId1Matcher.group("extn"));

		Matcher emailId2Matcher = pattern.matcher(emailId2);
		System.out.println("find()-2==" + emailId2Matcher.find());
	}

	@Test
	public void dash() {
		String input = "abcd-";
		Pattern pattern = Pattern.compile("[a-z]-");

		Matcher matcher = pattern.matcher(input);
		System.out.println(matcher.find());
	}

	@Test
	public void bracket() {
		String input = "[abcd]";
		Pattern pattern = Pattern.compile("[a-z]\\]");

		Matcher matcher = pattern.matcher(input);
		System.out.println(matcher.find());
	}

	@Test
	public void maxNoOfRepetitions() {
		String input = "aaa";
		Pattern pattern = Pattern.compile("[a]{0,3}");

		Matcher matcher = pattern.matcher(input);
		System.out.println(matcher.find());
	}

	@Test
	public void extractBandwidthAndBytes() {
		String input = " class REGULAR_EXPRESSION-CLASS-3\n" + "  remaining percent bandwidth 45\n"
				+ "  limit-queue 6400 kbytes\n" + "  random-number dscp af42 2560 kbytes 4480 kbytes";
		Pattern pattern = Pattern.compile("(?m) (remaining percent bandwidth)\\s+(?<bandwidth>\\d*\\s?(\r\n|\n))\\s+"
				+ "(limit-queue\\s(?<limitValue>\\d*)\\s(?<limitUnits>[a-z]+))?");

		Matcher matcher = pattern.matcher(input);
		System.out.println(input);
		System.out.println(matcher.find());
		System.out.println(matcher.group("bandwidth").replaceAll("\\n", ""));
		System.out.println(matcher.group("limitValue"));
	}

	@Test
	public void extractStringInSingleQuotes() {
		String input = "'hello' world, 'welcome' to core java 'regex'";
		log.info("input={}", input); // input='hello' world, 'welcome' to core java 'regex'

		final String pattern3 = "'([^']*?)'";
		Pattern pattern = Pattern.compile(pattern3, Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(input);

		List<String> list = new ArrayList<>();
		if (matcher.find()) {
			list.add(StringUtils.replace(matcher.group(), "'", StringUtils.EMPTY));
			while (matcher.find()) {
				list.add(StringUtils.replace(matcher.group(), "'", StringUtils.EMPTY));
			}
		} else {
			log.info("No match");
		}
		log.info("single quoted strings list={}", list); // single quoted strings list=[hello, welcome, regex]
	}

}