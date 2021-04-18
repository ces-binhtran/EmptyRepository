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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.training.amf.registration.model.UserCustom;
import com.liferay.training.amf.registration.service.UserCustomLocalService;
import com.liferay.training.amf.registration.service.base.UserCustomServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Locale;

/**
 * The implementation of the user custom remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.training.amf.registration.service.UserCustomService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserCustomServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=amfregistration",
		"json.web.service.context.path=UserCustom"
	},
	service = AopService.class
)
public class UserCustomServiceImpl extends UserCustomServiceBaseImpl {

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

		return userCustomLocalService.addUserCustom(creatorUserId, companyId, autoPassword, password1, password2,
				autoScreenName, screenName, emailAddress, facebookId, openId,
				locale , firstName, middleName,
				lastName, prefixId, suffixId, male, birthdayMonth, birthdayDay,
				birthdayYear, jobTitle, groupIds, organizationIds, roleIds,
				userGroupIds, sendEmail, serviceContext, homePhone, mobilePhone, address, address2,
				city, state, zip, securityQuestion, securityAnswer, acceptedTou);

	}

}