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
 * Provides a wrapper for {@link AmfAuditEventService}.
 *
 * @author Brian Wing Shun Chan
 * @see AmfAuditEventService
 * @generated
 */
public class AmfAuditEventServiceWrapper
	implements AmfAuditEventService, ServiceWrapper<AmfAuditEventService> {

	public AmfAuditEventServiceWrapper(
		AmfAuditEventService amfAuditEventService) {

		_amfAuditEventService = amfAuditEventService;
	}

	@Override
	public com.liferay.training.amf.model.AmfAuditEvent addAmfAuditEvent(
		long userId, String userName, long groupId, long companyId,
		String ipAddress, String eventType, java.util.Date createdDate) {

		return _amfAuditEventService.addAmfAuditEvent(
			userId, userName, groupId, companyId, ipAddress, eventType,
			createdDate);
	}

	@Override
	public long countAuditEventBytypeAndUser(
		Long userIdForSearch, String[] eventTypeForSearch) {

		return _amfAuditEventService.countAuditEventBytypeAndUser(
			userIdForSearch, eventTypeForSearch);
	}

	@Override
	public java.util.List<com.liferay.training.amf.model.AmfAuditEvent>
		getAuditEventByTypeAndUser(
			Long userIdForSearch, String[] eventTypeForSearch, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.training.amf.model.AmfAuditEvent> comparator) {

		return _amfAuditEventService.getAuditEventByTypeAndUser(
			userIdForSearch, eventTypeForSearch, start, end, comparator);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _amfAuditEventService.getOSGiServiceIdentifier();
	}

	@Override
	public AmfAuditEventService getWrappedService() {
		return _amfAuditEventService;
	}

	@Override
	public void setWrappedService(AmfAuditEventService amfAuditEventService) {
		_amfAuditEventService = amfAuditEventService;
	}

	private AmfAuditEventService _amfAuditEventService;

}