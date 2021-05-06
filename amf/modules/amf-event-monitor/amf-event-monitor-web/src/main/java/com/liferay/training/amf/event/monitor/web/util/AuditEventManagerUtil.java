/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.training.amf.event.monitor.web.util;

import com.liferay.portal.kernel.audit.AuditMessage;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.security.audit.AuditEvent;
import com.liferay.portal.security.audit.AuditEventManager;
import com.liferay.portal.security.audit.storage.service.AuditEventLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Greenwald
 * @author Prathima Shreenath
 */
@Component(
		immediate = true,
		service = AuditEventManagerUtil.class
)
public class AuditEventManagerUtil {

	public List<AuditEvent> getAuditEventsByDynamicQuery(int start, int end, boolean isAll) {
		List<AuditEvent> auditEvents = _auditEventLocalService.dynamicQuery(createDynamicQuery(isAll), start, end);
		return auditEvents;
	}

	public DynamicQuery createDynamicQuery(boolean isAll) {
		Order order = OrderFactoryUtil.desc("createDate");
		DynamicQuery dynamicQuery = _auditEventLocalService.dynamicQuery();
		if(isAll) {
			dynamicQuery
				.add(RestrictionsFactoryUtil.or(
				RestrictionsFactoryUtil.eq("eventType", "LOGIN"),
				RestrictionsFactoryUtil.eq("eventType", "ADD")
				))
				.addOrder(order);
		}
		else {
			dynamicQuery
				.add(RestrictionsFactoryUtil.and(
					RestrictionsFactoryUtil.or(
						RestrictionsFactoryUtil.eq("eventType", "LOGIN"),
						RestrictionsFactoryUtil.eq("eventType", "ADD")
					),
					RestrictionsFactoryUtil.eq("userId", 3)
				))
				.addOrder(order);
		}

		return dynamicQuery;
	}

	public long dynamicQueryCount(boolean isAll) {
		return _auditEventLocalService.dynamicQueryCount(createDynamicQuery(isAll));
	}

	@Reference
	private AuditEventLocalService _auditEventLocalService;

}