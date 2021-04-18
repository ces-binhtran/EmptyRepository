package com.liferay.training.amf.registration.validator;

import com.liferay.training.amf.registration.exception.RegistrationValidationException;

import java.util.Date;

public interface RegistrationValidator {
    public void validate(String firstName, String lastName, String emailAddress, String UserName, Date birthday,
                         String password1, String password2, String homePhone, String mobilePhone,
                         String address, String address2, String city, String state, String zip,
                         String securityQuestion, String securityAnswer, boolean acceptedTou) throws RegistrationValidationException;
}
