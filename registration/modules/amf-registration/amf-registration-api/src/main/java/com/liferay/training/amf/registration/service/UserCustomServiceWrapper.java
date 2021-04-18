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

package com.liferay.training.amf.registration.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserCustomService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserCustomService
 * @generated
 */
public class UserCustomServiceWrapper
	implements ServiceWrapper<UserCustomService>, UserCustomService {

	public UserCustomServiceWrapper(UserCustomService userCustomService) {
		_userCustomService = userCustomService;
	}

	@Override
	public com.liferay.training.amf.registration.model.UserCustom addUserCustom(
			long creatorUserId, long companyId, boolean autoPassword,
			String password1, String password2, boolean autoScreenName,
			String screenName, String emailAddress, long facebookId,
			String openId, java.util.Locale locale, String firstName,
			String middleName, String lastName, long prefixId, long suffixId,
			boolean male, int birthdayMonth, int birthdayDay, int birthdayYear,
			String jobTitle, long[] groupIds, long[] organizationIds,
			long[] roleIds, long[] userGroupIds, boolean sendEmail,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			String homePhone, String mobilePhone, String address,
			String address2, String city, String state, String zip,
			String securityQuestion, String securityAnswer, boolean acceptedTou)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userCustomService.addUserCustom(
			creatorUserId, companyId, autoPassword, password1, password2,
			autoScreenName, screenName, emailAddress, facebookId, openId,
			locale, firstName, middleName, lastName, prefixId, suffixId, male,
			birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds,
			organizationIds, roleIds, userGroupIds, sendEmail, serviceContext,
			homePhone, mobilePhone, address, address2, city, state, zip,
			securityQuestion, securityAnswer, acceptedTou);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userCustomService.getOSGiServiceIdentifier();
	}

	@Override
	public UserCustomService getWrappedService() {
		return _userCustomService;
	}

	@Override
	public void setWrappedService(UserCustomService userCustomService) {
		_userCustomService = userCustomService;
	}

	private UserCustomService _userCustomService;

}