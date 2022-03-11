package com.liferay.training.amf.registration.constants;

import java.util.Arrays;
import java.util.List;

public class AmfRegistrationConstants {

	public static final String[] SECURITY_QUESTIONS = {
			"what-is-your-mothers-maiden-name", 
			"what-is-the-make-of-your-first-car", 
			"what-is-your-high-school-mascot",
			"who-is-your-favorite-actor"
		};
	
	// Password special characters is a selection of punctuation characters that are present on standard US keyboard 
	// and frequently used in passwords.
	public static final List<Character> SPECIAL_CHARACTERS = Arrays.asList('!', '\'', '#', '$', '%', '&', '\'', '(', ')', '*', '+',
				',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_', '`', '{', '|', '}', '~');
}
