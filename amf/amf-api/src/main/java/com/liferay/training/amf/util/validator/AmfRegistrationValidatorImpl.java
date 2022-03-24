package com.liferay.training.amf.util.validator;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.RegionCodeException;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.service.CountryService;
import com.liferay.portal.kernel.service.RegionService;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.training.amf.constants.AmfRegistrationConstants;
import com.liferay.training.amf.exception.UserValidationException;
import com.liferay.training.amf.validator.AmfRegistrationValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author ces-user
 *
 */
@Component(immediate = true, service = AmfRegistrationValidator.class)
public class AmfRegistrationValidatorImpl implements AmfRegistrationValidator {


	/**
	 * validate input fields of User 
	 */
	@Override
	public void validate(String firstName, String lastName, String emailAddress, String userName, int monthOfBirth,
			int dayOfBirth, int yearOfBirth, String password, String confirmPassword, String homePhone, String mobilePhone, String address1,
			String address2, String city, String state, String zip, String securityQuestion, String securityAnswer, boolean termsOfUse)
			throws UserValidationException {
		
		List<String> errors = new ArrayList<>();
		boolean result = true;

		if (!Validator.isAlphanumericName(firstName) || (firstName.length() > 50)) {
			result = false;
			errors.add("firstNameInvalid");
		}

		if (!Validator.isAlphanumericName(lastName) || (lastName.length() > 50)) {
			result = false;
			errors.add("lastNameInvalid");
		}

		if (Validator.isNull(emailAddress) || (emailAddress.length() > 75)) {
			result = false;
			errors.add("emailAddressInvalid");
		}

		if (!Validator.isAlphanumericName(userName) || ((userName.length() < 4) || (userName.length() > 16))) {
			result = false;
			errors.add("userNameInvalid");
		}

		// validate birthday
		result &= validateBirthday(monthOfBirth, dayOfBirth, yearOfBirth, errors);

		// validate password and confirmPassword
		result &= validatePassword(password, confirmPassword, errors);
		
		// validate homePhone
        if (!Validator.isDigit(homePhone) || (homePhone.length() != 10)) {
        	result = false;
			errors.add("homePhoneInvalid");
        }

		// validate mobilePhone
        if (!Validator.isDigit(mobilePhone) || (mobilePhone.length() != 10)) {
        	result = false;
			errors.add("mobilePhoneInvalid");
        }

        // validate address
        result &= validateAddress(address1, address2, city, state, zip, errors);
        
        if (! Arrays.asList(AmfRegistrationConstants.SECURITY_QUESTIONS).contains(securityQuestion)) {
        	result = false;
			errors.add("securityQuestionInvalid");
        }

		if (!Validator.isAlphanumericName(securityAnswer) || (securityAnswer.length() > 255)) {
			result = false;
			errors.add("securityAnswerInvalid");
		}

		if (!termsOfUse) {
			result = false;
			errors.add("termsOfUseNotChecked");
		}
		
		// check result
		if (!result) {
			throw new UserValidationException(errors);
		}
	}
	
	/**
	 * validate address field
	 * @param address1
	 * @param address2
	 * @param city
	 * @param state
	 * @param zip
	 * @param result
	 * @param errors
	 */
	protected boolean validateAddress(String address1, String address2, String city, String state, String zip, List<String> errors) {
		boolean result = true;
		if (Validator.isNull(address1) || (address1.length() > 255)) {
			result = false;
			errors.add("address1Invalid");
		}
		if (address2 != null && (Validator.isNull(address2) || (address2.length() > 255))) {
			result = false;
			errors.add("address2Invalid");
		}
		result &= validateState(state, errors);
		if (!Validator.isDigit(zip) || (zip.length() != 5)) {
			result = false;
			errors.add("zipInvalid");
		}
		return result;
	}
	
	/**
	 * validate state field
	 * @param state
	 * @param result
	 * @param errors
	 */
	protected boolean validateState(String state, List<String> errors) {
		try {
			// Assumptions: Registration is open to US users only.
			Country country = countryService.getCountryByName("united-states");
			Region region = regionService.getRegion(country.getCountryId(), state);
			if (region == null) {
				throw new RegionCodeException();
			}
		} catch (PortalException e) {
			e.printStackTrace();
			errors.add("stateInvalid");
			return false;
		}
		return true;
	}

	/**
	 * validate birthday fields
	 * @param monthOfBirth
	 * @param dayOfBirth
	 * @param yearOfBirth
	 * @param result
	 * @param errors
	 */
	protected boolean validateBirthday(int monthOfBirth, int dayOfBirth, int yearOfBirth, List<String> errors) {
		if (!CalendarUtil.isDate(monthOfBirth - 1, dayOfBirth, yearOfBirth)) {
			errors.add("birthdayInvalid");
			return false;
		} else {
			Calendar cal = CalendarFactoryUtil.getCalendar();
			cal.set(yearOfBirth, monthOfBirth - 1, dayOfBirth, 0, 0, 0);
			Date birthday = cal.getTime();

			int age = CalendarUtil.getAge(birthday, CalendarFactoryUtil.getCalendar());

			if (age < 13) {
				errors.add("birthdayInvalidAgeLessThan13");
				return false;
			}
			return true;
		}
	}
	
	/**
	 * validate password field and password confirm field
	 * @param password
	 * @param confirmPassword
	 * @param result
	 * @param errors
	 */
	protected boolean validatePassword(String password, String confirmPassword, List<String> errors) {
		boolean result = true;
		if (!password.equals(confirmPassword)) {
			result = false;
			errors.add("confirmPasswordNotMatch");
        }
		
		if (password.length() < 6) {
			result = false;
			errors.add("passwordInvalid");
			return result;
		}

		boolean hasNumber = false;
        boolean hasUpperCase = false;
        boolean hasSpecialCharater = false;

        for (char c : password.toCharArray()) {
        	
        	if (!hasNumber && Validator.isDigit(c)) {
        		hasNumber = true;
        	}
        	
            if (!hasUpperCase && Character.isUpperCase(c)) {
                hasUpperCase = true;
            }

            if (!hasSpecialCharater && AmfRegistrationConstants.SPECIAL_CHARACTERS.contains(c)) {
            	hasSpecialCharater = true;
            }

            if (hasUpperCase && hasNumber && hasSpecialCharater) {
                break;
            }
        }
        
        if (!(hasUpperCase && hasNumber && hasSpecialCharater)) {
        	result = false;
			errors.add("passwordInvalid");
        }
        return result;
	}

	@Reference(service = CountryService.class)
	protected CountryService countryService;

	@Reference(service = RegionService.class)
	protected RegionService regionService;
}
