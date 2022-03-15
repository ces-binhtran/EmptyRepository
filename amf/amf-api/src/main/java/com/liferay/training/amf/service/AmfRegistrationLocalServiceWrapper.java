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

package com.liferay.training.amf.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AmfRegistrationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AmfRegistrationLocalService
 * @generated
 */
public class AmfRegistrationLocalServiceWrapper
	implements AmfRegistrationLocalService,
			   ServiceWrapper<AmfRegistrationLocalService> {

	public AmfRegistrationLocalServiceWrapper(
		AmfRegistrationLocalService amfRegistrationLocalService) {

		_amfRegistrationLocalService = amfRegistrationLocalService;
	}

	@Override
	public com.liferay.portal.kernel.model.User addMember(
			long scopeGroupId, long companyId, String firstName,
			String lastName, String emailAddress, java.util.Locale locale,
			String username, boolean male, int monthOfBirth, int dayOfBirth,
			int yearOfBirth, String password, String confirmPassword,
			String homePhone, String mobilePhone, String address1,
			String address2, String city, String state, String zipCode,
			String securityQuestion, String answer, boolean termOfUse,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfRegistrationLocalService.addMember(
			scopeGroupId, companyId, firstName, lastName, emailAddress, locale,
			username, male, monthOfBirth, dayOfBirth, yearOfBirth, password,
			confirmPassword, homePhone, mobilePhone, address1, address2, city,
			state, zipCode, securityQuestion, answer, termOfUse,
			serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _amfRegistrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public AmfRegistrationLocalService getWrappedService() {
		return _amfRegistrationLocalService;
	}

	@Override
	public void setWrappedService(
		AmfRegistrationLocalService amfRegistrationLocalService) {

		_amfRegistrationLocalService = amfRegistrationLocalService;
	}

	private AmfRegistrationLocalService _amfRegistrationLocalService;

}