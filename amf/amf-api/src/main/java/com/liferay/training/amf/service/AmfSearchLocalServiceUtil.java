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
 * Provides the local service utility for AmfSearch. This utility wraps
 * <code>com.liferay.training.amf.service.impl.AmfSearchLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AmfSearchLocalService
 * @generated
 */
public class AmfSearchLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.training.amf.service.impl.AmfSearchLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static AmfSearchLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AmfSearchLocalService, AmfSearchLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AmfSearchLocalService.class);

		ServiceTracker<AmfSearchLocalService, AmfSearchLocalService>
			serviceTracker =
				new ServiceTracker
					<AmfSearchLocalService, AmfSearchLocalService>(
						bundle.getBundleContext(), AmfSearchLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}