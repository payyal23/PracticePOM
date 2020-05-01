package com.qa.hubspot.util;

import org.apache.commons.lang3.RandomStringUtils;

public class Randomutil {

	public static String Useremail() {
		String generateString = RandomStringUtils.randomAlphabetic(4);
		return (generateString + "@gmail.com");

	}

	public static String firstName() {
		String generateString = RandomStringUtils.randomAlphabetic(4);
		return ("p" + generateString);
	}

	public static String LastName() {
		String generateString = RandomStringUtils.randomAlphabetic(4);
		return ("J" + generateString);
	}

	public static String jobTitle() {
		String generateString = RandomStringUtils.randomAlphabetic(3);
		return ("IT" + generateString);
	}

}
