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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.training.amf.model.AmfAuditEvent;
import com.liferay.training.amf.service.base.AmfAuditEventServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the amf audit event remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.training.amf.service.AmfAuditEventService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmfAuditEventServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=amf",
		"json.web.service.context.path=AmfAuditEvent"
	},
	service = AopService.class
)
public class AmfAuditEventServiceImpl extends AmfAuditEventServiceBaseImpl {

	@Override
	public List<AmfAuditEvent> getAuditEventByTypeAndUser(Long userIdForSearch, String[] eventTypeForSearch, int start, int end, 
			OrderByComparator<AmfAuditEvent> comparator) {
		return amfAuditEventLocalService.getAuditEventByTypeAndUser(userIdForSearch, eventTypeForSearch, start, end, comparator);
	}

	@Override
	public AmfAuditEvent addAmfAuditEvent(long userId, String userName, long groupId, long companyId, String ipAddress,
			String eventType, Date createdDate) {
		return amfAuditEventLocalService.addAmfAuditEvent(userId, userName, groupId, companyId, ipAddress,
				eventType, createdDate);
	}

	@Override
	public long countAuditEventBytypeAndUser(Long userIdForSearch, String[] eventTypeForSearch) {
		return amfAuditEventLocalService.countAuditEventBytypeAndUser(userIdForSearch, eventTypeForSearch);
	}

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.liferay.training.amf.service.AmfAuditEventServiceUtil</code> to access the amf audit event remote service.
	 */
}