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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for AmfRegistration. This utility wraps
 * <code>com.liferay.training.amf.service.impl.AmfRegistrationServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AmfRegistrationService
 * @generated
 */
public class AmfRegistrationServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.training.amf.service.impl.AmfRegistrationServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.model.User addMember(
			long scopeGroupId, long companyId, String firstName,
			String lastName, String emailAddress, java.util.Locale locale,
			String username, boolean male, int monthOfBirth, int dayOfBirth,
			int yearOfBirth, String password, String confirmPassword,
			String homePhone, String mobilePhone, String address1,
			String address2, String city, String state, String zipCode,
			String securityQuestion, String answer, boolean termOfUse,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addMember(
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
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static AmfRegistrationService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AmfRegistrationService, AmfRegistrationService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AmfRegistrationService.class);

		ServiceTracker<AmfRegistrationService, AmfRegistrationService>
			serviceTracker =
				new ServiceTracker
					<AmfRegistrationService, AmfRegistrationService>(
						bundle.getBundleContext(), AmfRegistrationService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}