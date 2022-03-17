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
 * Provides the remote service utility for AmfAuditEvent. This utility wraps
 * <code>com.liferay.training.amf.service.impl.AmfAuditEventServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AmfAuditEventService
 * @generated
 */
public class AmfAuditEventServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.training.amf.service.impl.AmfAuditEventServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.training.amf.model.AmfAuditEvent addAmfAuditEvent(
		long userId, String userName, long groupId, long companyId,
		String ipAddress, String eventType, java.util.Date createdDate) {

		return getService().addAmfAuditEvent(
			userId, userName, groupId, companyId, ipAddress, eventType,
			createdDate);
	}

	public static long countAuditEventBytypeAndUser(
		Long userIdForSearch, String[] eventTypeForSearch) {

		return getService().countAuditEventBytypeAndUser(
			userIdForSearch, eventTypeForSearch);
	}

	public static java.util.List<com.liferay.training.amf.model.AmfAuditEvent>
		getAuditEventByTypeAndUser(
			Long userIdForSearch, String[] eventTypeForSearch, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.training.amf.model.AmfAuditEvent> comparator) {

		return getService().getAuditEventByTypeAndUser(
			userIdForSearch, eventTypeForSearch, start, end, comparator);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static AmfAuditEventService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AmfAuditEventService, AmfAuditEventService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AmfAuditEventService.class);

		ServiceTracker<AmfAuditEventService, AmfAuditEventService>
			serviceTracker =
				new ServiceTracker<AmfAuditEventService, AmfAuditEventService>(
					bundle.getBundleContext(), AmfAuditEventService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}