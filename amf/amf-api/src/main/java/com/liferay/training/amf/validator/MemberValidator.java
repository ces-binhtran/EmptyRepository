package com.liferay.training.amf.validator;

import com.liferay.training.amf.exception.MemberValidationException;

public interface MemberValidator {
	public void validate(String firstName, String lastName, String emailAddress, String userName, int monthOfBirth,
			int dayOfBirth, int yearOfBirth, String password, String confirmPassword, String homePhone,
			String mobilePhone, String address1, String address2, String city, String state, String zip,
			String securityQuestion, String securityAnswer, boolean termsOfUse) throws MemberValidationException;
}
