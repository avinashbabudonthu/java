# Generate random password
* Generate 6 character alpha numeric random password  with combination of lowercase, uppercase, special character, number, 2 random characters
```
import java.util.Random;

/**
* Example: 
* password: rC$6it
* before-password: rC$6it
* after-password: rC\$6it
* str: This is your password: rC$6it
*/
@Test
public void replaceAll(){
	String str = "This is your password: {password}";
	// If password contains backslash(\) or dollar($) symbols then exception will be thrown so escape them with Matcher.quoteReplacement
	String password = generatePasswordV2(6);
	System.out.println("before-password:" + password);
	password = Matcher.quoteReplacement(password);
	System.out.println("after-password:" + password);
	str = str.replaceAll("\\{password\\}", password);
	System.out.println("str: " + str);
}

public char[] generatePassword(int length) {
		String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
		String specialCharacters = "!@#$";
		String numbers = "1234567890";
		String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
		Random random = new Random();
		char[] password = new char[length];

		password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
		password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
		password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
		password[3] = numbers.charAt(random.nextInt(numbers.length()));

		for(int i = 4; i< length ; i++) {
			password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
		}
		return password;
	}

	public String generatePasswordV2(int length) {
		char[] password = generatePassword(length);
		return new String(password);
	}
```
