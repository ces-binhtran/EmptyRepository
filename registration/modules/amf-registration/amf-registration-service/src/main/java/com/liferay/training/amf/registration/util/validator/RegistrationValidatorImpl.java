//package com.liferay.training.amf.registration.util.validator;
//
//import com.liferay.portal.kernel.util.Validator;
//import com.liferay.training.amf.registration.exception.RegistrationValidationException;
//import com.liferay.training.amf.registration.validator.RegistrationValidator;
//import org.osgi.service.component.annotations.Component;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Component(
//        immediate = true,
//        service = RegistrationValidator.class
//)
//public class RegistrationValidatorImpl implements RegistrationValidator {
//
//    @Override
//    public void validate(String firstName, String lastName, String emailAddress, String userName, Date birthday,
//                         String password1, String password2, String homePhone, String mobilePhone, String address,
//                         String address2, String city, String state, String zip, String securityQuestion, String securityAnswer,
//                         boolean acceptedTou) throws RegistrationValidationException {
//
//        List<String> errors = new ArrayList<>();
//        if(!isRegistrationValid(firstName, lastName, emailAddress, userName, birthday, password1, password2, homePhone,
//                mobilePhone, address, address2, city, state, zip, securityQuestion, securityAnswer, acceptedTou, errors)) {
//            throw new RegistrationValidationException(errors);
//        }
//    }
//
//    public boolean isRegistrationValid(String firstName, String lastName, String emailAddress, String userName, Date birthday,
//                                       String password1, String password2, String homePhone, String mobilePhone, String address,
//                                       String address2, String city, String state, String zip, String securityQuestion, String securityAnswer,
//                                       boolean acceptedTou, List<String> errors) {
//        boolean isValid = true;
//        isValid &= isNameValid(firstName, lastName, errors);
//        isValid &= isEmailAddressValid(emailAddress, errors);
//        isValid &= isUserNameValid(userName, errors);
//        isValid &= isBirthdayValid(birthday, errors);
//        isValid &= isPasswordValid(password1, password2, errors);
//        isValid &= isPhoneNumberValid(homePhone, mobilePhone, errors);
//        isValid &= isAddressValid(address, address2, errors);
//        isValid &= isCityValid(city, errors);
//        isValid &= isStateValid(state, errors);
//        isValid &= isZipValid(zip, errors);
//        isValid &= isSecurityQuestionValid(securityQuestion, errors);
//        isValid &= isSecurityAnswerValid(securityAnswer, errors);
//        isValid &= isAcceptedTouValid(acceptedTou, errors);
//        return isValid;
//    }
//
//    private boolean isBirthdayValid(Date birthday, List<String> errors) {
//        boolean result = true;
//        LocalDate
//        if (!Validator.isNull(emailAddress)) {
//            errors.add("registrationEmailAddressEmpty");
//            result = false;
//        }
//        return result;
//    }
//
//    private boolean isUserNameValid(String userName, List<String> errors) {
//        boolean result = true;
//        if (!Validator.isNull(userName)) {
//            errors.add("registrationUserNameEmpty");
//            result = false;
//        }
//        if (!Validator.isAlphanumericName(userName)) {
//            errors.add("registrationUserNameIsNotAlphanumeric");
//            result = false;
//        }
//        if (userName.length() > 16) {
//            errors.add("registrationEmailAddressToLong");
//            result = false;
//        }
//        if (userName.length() < 4) {
//            errors.add("registrationEmailAddressToShort");
//            result = false;
//        }
//        return result;
//    }
//
//    private boolean isEmailAddressValid(String emailAddress, List<String> errors) {
//        boolean result = true;
//        if (!Validator.isNull(emailAddress)) {
//            errors.add("registrationEmailAddressEmpty");
//            result = false;
//        }
//        if (!Validator.isAlphanumericName(emailAddress)) {
//            errors.add("registrationEmailAddressIsNotAlphanumeric");
//            result = false;
//        }
//        if (emailAddress.length() > 50) {
//            errors.add("registrationEmailAddressToLong");
//            result = false;
//        }
//        return result;
//    }
//
//    private boolean isNameValid(String firstName, String lastName, List<String> errors) {
//        boolean result = true;
//        if (!Validator.isNull(firstName)) {
//            errors.add("registrationFirstNameEmpty");
//            result = false;
//        }
//        if (!Validator.isAlphanumericName(firstName)) {
//            errors.add("registrationFirstNameIsNotAlphanumeric");
//            result = false;
//        }
//        if (firstName.length() > 50) {
//            errors.add("registrationFirstNameToLong");
//            result = false;
//        }
//
//        if (!Validator.isNull(lastName)) {
//            errors.add("registrationLastNameEmpty");
//            result = false;
//        }
//        if (!Validator.isAlphanumericName(lastName)) {
//            errors.add("registrationLastNameIsNotAlphanumeric");
//            result = false;
//        }
//        if (lastName.length() > 50) {
//            errors.add("registrationLastNameToLong");
//            result = false;
//        }
//        return result;
//    }
//}
