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

package com.liferay.training.amf.service.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.ListTypeConstants;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.AddressLocalServiceUtil;
import com.liferay.portal.kernel.service.CountryService;
import com.liferay.portal.kernel.service.ListTypeLocalServiceUtil;
import com.liferay.portal.kernel.service.PhoneLocalServiceUtil;
import com.liferay.portal.kernel.service.RegionService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.training.amf.constants.AmfAuditEventTypeConstants;
import com.liferay.training.amf.service.AmfAuditEventService;
import com.liferay.training.amf.service.base.AmfRegistrationLocalServiceBaseImpl;
import com.liferay.training.amf.validator.AmfRegistrationValidator;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the amf registration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.training.amf.service.AmfRegistrationLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmfRegistrationLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.training.amf.model.AmfRegistration",
	service = AopService.class
)
public class AmfRegistrationLocalServiceImpl
	extends AmfRegistrationLocalServiceBaseImpl {

	@Override
	public User addMember(long scopeGroupId, long companyId, String firstName, String lastName, String emailAddress,
			Locale locale, String username, boolean male, int monthOfBirth, int dayOfBirth, int yearOfBirth,
			String password, String confirmPassword, String homePhone, String mobilePhone, String address1,
			String address2, String city, String state, String zipCode, String securityQuestion, String answer,
			boolean termOfUse, ServiceContext serviceContext) throws PortalException {

		_amfRegistrationValidator.validate(firstName, lastName, emailAddress, username, monthOfBirth, dayOfBirth, yearOfBirth,
				password, confirmPassword, homePhone, mobilePhone, address1, address2, city, state, zipCode,
				securityQuestion, answer, termOfUse);
		
		long creatorUserId = 0;
		boolean autoPassword = false;
		boolean autoScreenName = false;
		String screenName = username;
		String middleName = StringPool.BLANK;
		long prefixId = 0;
		long suffixId = 0;
		String jobTitle = StringPool.BLANK;
		long[] groupIds = null;
		long[] organizationIds = null;
		long[] roleIds = null;
		long[] userGroupIds = null;
		boolean sendEmail = false;
		
		Country country = countryService.getCountryByName("united-states");
		Region region = regionService.getRegion(country.getCountryId(), state);
		
		if (scopeGroupId != 0) {
			groupIds = new long[] {scopeGroupId};
		}

		User user = userLocalService.addUser(creatorUserId, companyId, autoPassword, password, confirmPassword, autoScreenName,
				screenName, emailAddress, locale, firstName, middleName, lastName, prefixId, suffixId, male,
				monthOfBirth, dayOfBirth, yearOfBirth, jobTitle, groupIds, organizationIds, roleIds, userGroupIds,
				sendEmail, serviceContext);
		userLocalService.updateAgreedToTermsOfUse(user.getUserId(), termOfUse);
		userLocalService.updateReminderQuery(user.getUserId(), securityQuestion, answer);
		Contact contact = user.getContact();

		addAddressTypeId(user.getUserId(), contact, address1, address2, city, zipCode, region, country, serviceContext);
		addPhone(user.getUserId(), contact, homePhone, mobilePhone, serviceContext);

		_amfAuditEventService.addAmfAuditEvent(user.getUserId(), screenName, scopeGroupId, companyId,
				serviceContext.getRemoteAddr(), AmfAuditEventTypeConstants.REGISTRATION, new Date());
		
		return user;
	}
	
	private void addAddressTypeId(long userId, Contact contact, String address1, String address2, String city, String zipCode, 
			Region region, Country country, ServiceContext serviceContext) throws PortalException {
		
		String address3 = StringPool.BLANK;
		boolean mailing = false;
		boolean primary = false;
		
		List<ListType> addressListTypes = ListTypeLocalServiceUtil.getListTypes(ListTypeConstants.CONTACT_ADDRESS);
		ListType addressListType = addressListTypes.get(0);
		
		AddressLocalServiceUtil.addAddress(userId, Contact.class.getName(), contact.getClassPK(), address1,
				address2, address3, city, zipCode, region.getRegionId(), country.getCountryId(), addressListType.getListTypeId(),
				mailing, primary, serviceContext);
	}
	
	private void addPhone(long userId, Contact contact, String homePhone, String mobilePhone, ServiceContext serviceContext) 
			throws PortalException {
	
		String extension = StringPool.BLANK;
		boolean primary = false;

		List<ListType> phoneListTypes = ListTypeLocalServiceUtil.getListTypes(ListTypeConstants.CONTACT_PHONE);
		for (ListType listType : phoneListTypes) {
			if ("personal".equalsIgnoreCase(listType.getName())) {
				PhoneLocalServiceUtil.addPhone(userId, Contact.class.getName(), contact.getContactId(), mobilePhone,
						extension, listType.getListTypeId(), primary, serviceContext);
			} else if ("mobile-phone".equalsIgnoreCase(listType.getName())) {
				PhoneLocalServiceUtil.addPhone(userId, Contact.class.getName(), contact.getContactId(), homePhone,
						extension, listType.getListTypeId(), primary, serviceContext);
			}
		}
	}
	
	@Reference
	AmfRegistrationValidator _amfRegistrationValidator;
	
	@Reference
	private AmfAuditEventService _amfAuditEventService;

	@Reference(service = CountryService.class)
	protected CountryService countryService;

	@Reference(service = RegionService.class)
	protected RegionService regionService;
}