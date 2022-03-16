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

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.training.amf.service.base.AmfRegistrationServiceBaseImpl;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the amf registration remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.training.amf.service.AmfRegistrationService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmfRegistrationServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=amf",
		"json.web.service.context.path=AmfRegistration"
	},
	service = AopService.class
)
public class AmfRegistrationServiceImpl extends AmfRegistrationServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.liferay.training.amf.service.AmfRegistrationServiceUtil</code> to access the amf registration remote service.
	 */

	@Override
	public User addMember(long scopeGroupId, long companyId, String firstName, String lastName, String emailAddress,
			Locale locale, String username, boolean male, int monthOfBirth, int dayOfBirth, int yearOfBirth,
			String password, String confirmPassword, String homePhone, String mobilePhone, String address1,
			String address2, String city, String state, String zipCode, String securityQuestion, String answer,
			boolean termOfUse, ServiceContext serviceContext) throws PortalException {
		
		return amfRegistrationLocalService.addMember(scopeGroupId, companyId,
				firstName, lastName, emailAddress, locale, username, male, monthOfBirth, dayOfBirth, yearOfBirth,
				password, confirmPassword, homePhone, mobilePhone, address1, address2, city, state, zipCode,
				securityQuestion, answer, termOfUse, serviceContext);
	}

}