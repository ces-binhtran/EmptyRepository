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
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.model.ResourceAction;
import com.liferay.portal.kernel.model.ResourcePermission;
import com.liferay.portal.kernel.service.persistence.ResourceActionPersistence;
import com.liferay.portal.kernel.service.persistence.ResourcePermissionPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.training.amf.model.AmfAuditEvent;
import com.liferay.training.amf.service.base.AmfAuditEventLocalServiceBaseImpl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the amf audit event local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.liferay.training.amf.service.AmfAuditEventLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmfAuditEventLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.liferay.training.amf.model.AmfAuditEvent", service = AopService.class)
public class AmfAuditEventLocalServiceImpl extends AmfAuditEventLocalServiceBaseImpl {

	@Override
	public List<AmfAuditEvent> getAuditEventByTypeAndUser(Long userIdForSearch, String[] eventTypeForSearch, int start, int end, 
			OrderByComparator<AmfAuditEvent> comparator) {
		System.out.println();
		return amfAuditEventLocalService.dynamicQuery(
				getAuditEventSearchDynamicQuery(userIdForSearch, eventTypeForSearch), start, end, comparator);
	}

	@Override
	public long countAuditEventBytypeAndUser(Long userIdForSearch, String[] eventTypeForSearch) {
		return amfAuditEventLocalService.dynamicQueryCount(
				getAuditEventSearchDynamicQuery(userIdForSearch, eventTypeForSearch));
	}
	private DynamicQuery getAuditEventSearchDynamicQuery(Long userIdForSearch, String[] eventTypeForSearch) {
		DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.isNotNull("groupId"));
		System.out.println("userId=" + userIdForSearch);
		if (userIdForSearch != null) {
			Disjunction disjuntionQuery = RestrictionsFactoryUtil.disjunction();
			disjuntionQuery.add(RestrictionsFactoryUtil.eq("userId", userIdForSearch));
			dynamicQuery.add(disjuntionQuery);
		}
		if (eventTypeForSearch != null && eventTypeForSearch.length > 0) {
			Disjunction disjuntionQuery = RestrictionsFactoryUtil.disjunction();
			for (String eventType : eventTypeForSearch) {
				System.out.println("typeSearch="+eventType);
				disjuntionQuery.add(RestrictionsFactoryUtil.eq("eventType", eventType));
				dynamicQuery.add(disjuntionQuery);
			}
		}
		return dynamicQuery;
	}

	@Override
	public AmfAuditEvent addAmfAuditEvent(long userId, String userName, long groupId, long companyId, String ipAddress,
			String eventType, Date createdDate) {
		long amfAuditEventId = counterLocalService.increment(AmfAuditEvent.class.getName());
		AmfAuditEvent amfAuditEvent = createAmfAuditEvent(amfAuditEventId);
		amfAuditEvent.setUserId(userId);
		amfAuditEvent.setUserName(userName);
		amfAuditEvent.setGroupId(groupId);
		amfAuditEvent.setCompanyId(companyId);
		amfAuditEvent.setCreateDate(createdDate);
		amfAuditEvent.setModifiedDate(createdDate);
		amfAuditEvent.setEventType(eventType);
		amfAuditEvent.setIpAddress(ipAddress);
		return super.addAmfAuditEvent(amfAuditEvent);
		
	}
	
	@Reference
	private ResourcePermissionPersistence rpp;
	
	@Reference
	private ResourceActionPersistence rpp2;

}

