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
 * Provides the remote service utility for AmfSearch. This utility wraps
 * <code>com.liferay.training.amf.service.impl.AmfSearchServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AmfSearchService
 * @generated
 */
public class AmfSearchServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.training.amf.service.impl.AmfSearchServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static long countUsers(String zipCode) {
		return getService().countUsers(zipCode);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.liferay.portal.kernel.model.User>
		searchUser(
			String zipCode, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.portal.kernel.model.User> comparator) {

		return getService().searchUser(zipCode, start, end, comparator);
	}

	public static AmfSearchService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AmfSearchService, AmfSearchService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AmfSearchService.class);

		ServiceTracker<AmfSearchService, AmfSearchService> serviceTracker =
			new ServiceTracker<AmfSearchService, AmfSearchService>(
				bundle.getBundleContext(), AmfSearchService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}