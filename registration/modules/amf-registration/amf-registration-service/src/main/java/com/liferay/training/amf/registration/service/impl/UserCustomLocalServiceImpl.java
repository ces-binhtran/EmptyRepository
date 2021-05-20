/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.training.amf.registration.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.training.amf.registration.exception.*;
import com.liferay.training.amf.registration.model.UserCustom;
import com.liferay.training.amf.registration.service.base.UserCustomLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Locale;

/**
 * The implementation of the user custom local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.training.amf.registration.service.UserCustomLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserCustomLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.training.amf.registration.model.UserCustom",
	service = AopService.class
)
public class UserCustomLocalServiceImpl extends UserCustomLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.training.amf.registration.service.UserCustomLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.training.amf.registration.service.UserCustomLocalServiceUtil</code>.
	 */
	public UserCustom addUserCustom(long creatorUserId, long companyId,
										  boolean autoPassword, String password1,
										  String password2, boolean autoScreenName,
										  String screenName, String emailAddress,
										  long facebookId, String openId, Locale locale,
										  String firstName, String middleName,
										  String lastName, long prefixId, long suffixId, boolean male,
										  int birthdayMonth, int birthdayDay, int birthdayYear,
										  String jobTitle, long[] groupIds, long[] organizationIds,
										  long[] roleIds, long[] userGroupIds, boolean sendEmail,
										  ServiceContext serviceContext, String homePhone, String mobilePhone,
										  String address, String address2, String city, String state,
										  String zip, String securityQuestion, String securityAnswer, boolean acceptedTou) throws PortalException {

		LocalDate birthday = LocalDate.of(birthdayYear, birthdayMonth, birthdayDay);

		validate(companyId, firstName, lastName, emailAddress, screenName, birthday, password1, password2, homePhone, mobilePhone,
				address, address2, city, state, zip, securityQuestion, securityAnswer, acceptedTou);

		_userLocalService.addUser(0, companyId, autoPassword, password1, password2,
				autoScreenName, screenName, emailAddress, facebookId, openId,
				locale , firstName, middleName,
				lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay,
				birthdayYear, jobTitle, groupIds, organizationIds, roleIds,
				userGroupIds, sendEmail, serviceContext);

		User user = _userLocalService.fetchUserByEmailAddress(companyId, emailAddress);
		long userId = counterLocalService.increment(User.class.getName());

		addAddress(userId);

		UserCustom userCustom = createUserCustom(userId);
		userCustom.setUserId(user.getUserId());
		userCustom.setHomePhone(homePhone);
		userCustom.setMobilePhone(mobilePhone);
		userCustom.setAddress(address);
		userCustom.setAddress2(address2);
		userCustom.setCity(city);
		userCustom.setState(state);
		userCustom.setZip(zip);
		userCustom.setSecurityQuestion(securityQuestion);
		userCustom.setSecurityAnswer(securityAnswer);
		userCustom.setAcceptedTou(acceptedTou);

		return super.updateUserCustom(userCustom);
	}

	private void addAddress(long userId, Locale locale, String state) throws PortalException {
		DynamicQuery dynamicQuery = contactLocalService.dynamicQuery();
		dynamicQuery.add(
				RestrictionsFactoryUtil.eq("classPK", userId)
		);
		List<Contact> contacts = contactLocalService.dynamicQuery(dynamicQuery);

		long countryId = CountryServiceUtil.getCountryByA2(locale.getCountry()).getCountryId();
		long regionId = RegionServiceUtil.getRegion(countryId, state).getRegionId();

	}

	protected void validate(long companyId, String firstName, String lastName, String emailAddress, String screenName, LocalDate birthday, String password1,
							String password2, String homePhone, String mobilePhone, String address, String address2, String city, String state,
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
		validateCity(state);
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

		User user = _userPersistence.fetchByC_SN(companyId, screenName);
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

	@Reference
	private ContactLocalService contactLocalService;

	@Reference
	private UserLocalService _userLocalService;

	@Reference
	private UserPersistence _userPersistence;

	private static final int _CHAR_UPPER_CASE_BEGIN = 65;

	private static final int _CHAR_UPPER_CASE_END = 90;

	private static final int _CHAR_LOWER_CASE_BEGIN = 97;

	private static final int _CHAR_LOWER_CASE_END = 122;
}