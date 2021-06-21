package com.liferay.training.amf.registration.web.portlet.action;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.amf.registration.web.constants.MVCCommandNames;
import com.liferay.training.amf.registration.web.constants.RegistrationPortletKeys;
import com.liferay.training.amf.registration.web.exception.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Locale;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + RegistrationPortletKeys.REGISTRATION,
                "mvc.command.name=" + MVCCommandNames.ADD_USER
        },
        service = MVCActionCommand.class
)
public class AddUserMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        ThemeDisplay themeDisplay =
                (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        Company company = themeDisplay.getCompany();

        boolean autoPassword = false;
        String password1 = ParamUtil.getString(actionRequest, "password1");
        String password2 = ParamUtil.getString(actionRequest, "password2");
        boolean autoScreenName = false;
        String screenName = ParamUtil.getString(actionRequest, "userName");
        String emailAddress = ParamUtil.getString(
                actionRequest, "emailAddress");
        long facebookId = ParamUtil.getLong(actionRequest, "facebookId");
        String openId = ParamUtil.getString(actionRequest, "openId");
        String languageId = ParamUtil.getString(actionRequest, "languageId");
        String firstName = ParamUtil.getString(actionRequest, "firstName");
        String middleName = ParamUtil.getString(actionRequest, "middleName");
        String lastName = ParamUtil.getString(actionRequest, "lastName");
        long prefixId = ParamUtil.getInteger(actionRequest, "prefixId");
        long suffixId = ParamUtil.getInteger(actionRequest, "suffixId");
        boolean male = ParamUtil.getBoolean(actionRequest, "male", true);
        int birthdayMonth = ParamUtil.getInteger(
                actionRequest, "birthdayMonth");
        int birthdayDay = ParamUtil.getInteger(actionRequest, "birthdayDay");
        int birthdayYear = ParamUtil.getInteger(actionRequest, "birthdayYear");
        String jobTitle = ParamUtil.getString(actionRequest, "jobTitle");
        long[] groupIds = null;
        long[] organizationIds = null;
        long[] roleIds = null;
        long[] userGroupIds = null;
        boolean sendEmail = true;

        String homePhone = ParamUtil.getString(actionRequest, "homePhone");
        String mobilePhone = ParamUtil.getString(actionRequest, "mobilePhone");
        String address = ParamUtil.getString(actionRequest, "address");
        String address2 = ParamUtil.getString(actionRequest, "address2");
        String city = ParamUtil.getString(actionRequest, "city");
        long regionId = ParamUtil.getLong(actionRequest, "state");
        String zip = ParamUtil.getString(actionRequest, "zip");
        String securityQuestion = ParamUtil.getString(actionRequest, "securityQuestion");
        String securityAnswer = ParamUtil.getString(actionRequest, "securityAnswer");
        boolean acceptedTou = ParamUtil.getBoolean(actionRequest, "agreedToTermsOfUse");

        LocalDate birthday = LocalDate.of(birthdayYear, birthdayMonth, birthdayDay);

        validate(company.getCompanyId(), firstName, lastName, emailAddress, screenName, birthday, password1, password2, homePhone, mobilePhone,
                address, address2, city, zip, securityQuestion, securityAnswer, acceptedTou);

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                User.class.getName(), actionRequest);

        _userLocalService.addUser(0, company.getCompanyId(), autoPassword, password1, password2,
                autoScreenName, screenName, emailAddress, facebookId, openId,
                LocaleUtil.fromLanguageId(languageId) , firstName, middleName,
                lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay,
                birthdayYear, jobTitle, groupIds, organizationIds, roleIds,
                userGroupIds, sendEmail, serviceContext);

        User user = _userLocalService.fetchUserByEmailAddress(company.getCompanyId(), emailAddress);
        Contact contact = user.getContact();
        _userLocalService.updateAgreedToTermsOfUse(user.getUserId(), acceptedTou);
        _userLocalService.updateReminderQuery(user.getUserId(), securityQuestion, securityAnswer);

        addAddress(company.getCompanyId(), emailAddress, LocaleUtil.fromLanguageId(languageId), regionId, address, address2, city, zip, serviceContext);
        if(Validator.isNotNull(homePhone)) {
            PhoneLocalServiceUtil.addPhone(user.getUserId(), Contact.class.getName(), contact.getContactId(), homePhone, "", 11011, true, serviceContext);
        }
        if(Validator.isNotNull(mobilePhone)) {
            PhoneLocalServiceUtil.addPhone(user.getUserId(), Contact.class.getName(), contact.getContactId(), mobilePhone, "", 11008, false, serviceContext);
        }
        SessionMessages.add(actionRequest, "registerSuccess");
        sendRedirect(actionRequest, actionResponse);
    }

    private void addAddress(long companyId, String emailAddress, Locale locale, long regionId, String address, String address2, String city, String zip, ServiceContext serviceContext) throws PortalException {
        User user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
        DynamicQuery dynamicQuery = contactLocalService.dynamicQuery();
        dynamicQuery.add(
                RestrictionsFactoryUtil.eq("classPK", user.getUserId())
        );
        List<Contact> contacts = contactLocalService.dynamicQuery(dynamicQuery);
        long countryId = CountryServiceUtil.getCountryByA2(locale.getCountry()).getCountryId();
        addressLocalService.addAddress(user.getUserId(), Contact.class.getName(), contacts.get(0).getContactId(), address, address2, null,
                city, zip, regionId, countryId, 11002, false, false, serviceContext);
    }

    protected void validate(long companyId, String firstName, String lastName, String emailAddress, String screenName, LocalDate birthday, String password1,
                            String password2, String homePhone, String mobilePhone, String address, String address2, String city,
                            String zip, String securityQuestion, String securityAnswer, boolean acceptedTou) throws PortalException{

        validateFirstName(firstName);
        validateLastName(lastName);
        validateEmailAddress(emailAddress);
        validateScreenName(companyId, screenName);
        validateBirthday(birthday);
        validatePassword(password1, password2);
        validatePhoneNumber(homePhone, mobilePhone);
        validateAddress(address, address2);
        validateCity(city);
        validateZip(zip);
        validateReminderQuery(securityAnswer, securityQuestion);
        validateAcceptedTou(acceptedTou);
    }

    protected void validateScreenName(long companyId, String screenName) throws PortalException{

        if(Validator.isNull(screenName)) {
            throw new UserScreenNameException.MustNotBeNull();
        }

        if(screenName.length() < 4 || screenName.length() > 16) {
            throw new UserScreenNameException.MustBeValidate();
        }

        User user = _userLocalService.fetchUserByScreenName(companyId, screenName);
        if(user != null) {
            throw new UserScreenNameException.MustBeUnique();
        }
    }

    protected void validateAcceptedTou(boolean acceptedTou) throws PortalException{
        if(acceptedTou == false) {
            throw new UserAcceptedTouException("You must accept the Terms of Use.");
        }
    }

    protected void validateReminderQuery(String securityAnswer, String securityQuestion) throws PortalException{
        if(Validator.isNull(securityAnswer) || Validator.isNull(securityQuestion)) {
            throw new UserSecurityQueryException("Reminder query must not be null.");
        }
        if(!Validator.isAlphanumericName(securityAnswer)) {
            throw new UserSecurityQueryException.MustBeAlphanumeric();
        }
        if(securityAnswer.length() > 255) {
            throw new UserSecurityQueryException.MustNotBeTooLong();
        }
    }

    protected void validateZip(String zip) throws PortalException{
        if(Validator.isNull(zip)) {
            throw new UserZipException.MustNotBeNull();
        }
        if(zip.length() != 5 || !Validator.isDigit(zip)) {
            throw new UserZipException.MustBeValidate();
        }
    }

    protected void validateCity(String city) throws PortalException{
        if(Validator.isNull(city)) {
            throw new UserCityException.MustNotBeNull();
        }
        if(!Validator.isAlphanumericName(city)) {
            throw new UserCityException.MustBeAlphanumeric();
        }
        if(city.length() > 255) {
            throw new UserCityException.MustNotBeTooLong();
        }
    }

    protected void validateAddress(String address, String address2) throws PortalException{
        if(Validator.isNull(address)) {
            throw new UserEmailAddressException.MustNotBeNull();
        }
        if(!Validator.isAlphanumericName(address) && !Validator.isAlphanumericName(address2)) {
            throw new UserEmailAddressException.MustBeAlphanumeric();
        }
        if(address.length() > 255 || address2.length() > 255) {
            throw new UserAddressException.MustNotBeTooLong();
        }
    }

    protected void validatePhoneNumber(String homePhone, String mobilePhone) throws PortalException{
        if(!Validator.isNull(homePhone) || !Validator.isNull(mobilePhone)) {
            if(homePhone.length() != 10 || mobilePhone.length() != 10) {
                throw new UserPhoneNumberException.MustBeValidate();
            }
            if(!Validator.isPhoneNumber(homePhone) && !Validator.isPhoneNumber(mobilePhone)) {
                throw new UserPhoneNumberException("Phone number must contain digits.");
            }
        }
    }

    protected void validatePassword(String password1, String password2) throws PortalException{
        if(Validator.isNull(password1) || Validator.isNull(password2)) {
            throw new UserPasswordException.MustNotBeNull();
        }
        if(!password1.equals(password2)) {
            throw new UserPasswordException.MustMatch();
        }
        if(password1.length() < 6) {
            throw new UserPasswordException.MustNotBeTooShort();
        }
        if(!isValidPassword(password1)) {
            throw new UserPasswordException.MustContain();
        }
    }

    public static boolean isValidPassword(String password) {
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasNum = false;
        boolean hasSpe = false;
        for(char c : password.toCharArray()) {
            if(!Validator.isChar(c) && !Validator.isDigit(c)) {
                hasSpe = true;
            }
            if(((int)c >= _CHAR_UPPER_CASE_BEGIN) && ((int)c <= _CHAR_UPPER_CASE_END)) {
                hasUpper = true;
            }
            if(((int)c >= _CHAR_LOWER_CASE_BEGIN) && ((int)c <= _CHAR_LOWER_CASE_END)) {
                hasLower = true;
            }
            if(Validator.isDigit(c)) {
                hasNum = true;
            }
        }
        return hasLower && hasUpper && hasNum && hasSpe;
    }

    protected void validateBirthday(LocalDate birthday) throws PortalException{

        if(Period.between(birthday,  LocalDate.now()).getYears() < 13) {
            throw new UserBirthdayException.MustNotTooYoung();
        }
    }

    protected void validateEmailAddress(String emailAddress) throws PortalException{
        if(Validator.isNull(emailAddress)) {
            throw new UserEmailAddressException.MustNotBeNull();
        }
        if(!Validator.isEmailAddress(emailAddress)) {
            throw new UserEmailAddressException("Invalid email address.");
        }
        if (!Validator.isAlphanumericName(emailAddress.substring(0, emailAddress.indexOf('@')))) {
            throw new UserEmailAddressException.MustBeAlphanumeric();
        }
        if (emailAddress.length() > 255) {
            throw new UserEmailAddressException.MustNotBeTooLong();
        }
    }

    protected void validateLastName(String lastName) throws PortalException{

        if(Validator.isNull(lastName)) {
            throw new UserLastNameException.MustNotBeNull();
        }
        if (!Validator.isAlphanumericName(lastName)) {
            throw new UserLastNameException.MustBeAlphanumeric();
        }
        if (lastName.length() > 50) {
            throw new UserLastNameException.MustNotBeTooLong();
        }
    }

    protected void validateFirstName(String firstName) throws PortalException{

        if(Validator.isNull(firstName)) {
            throw new UserFirstNameException.MustNotBeNull();
        }
        if (!Validator.isAlphanumericName(firstName)) {
            throw new UserFirstNameException.MustBeAlphanumeric();
        }
        if (firstName.length() > 50) {
            throw new UserFirstNameException.MustNotBeTooLong();
        }
    }

    private static final int _CHAR_UPPER_CASE_BEGIN = 65;

    private static final int _CHAR_UPPER_CASE_END = 90;

    private static final int _CHAR_LOWER_CASE_BEGIN = 97;

    private static final int _CHAR_LOWER_CASE_END = 122;

    @Reference
    private ContactLocalService contactLocalService;

    @Reference
    private AddressLocalService addressLocalService;

    @Reference
    private UserLocalService _userLocalService;
}