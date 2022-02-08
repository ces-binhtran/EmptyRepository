package com.liferay.training.amf.web.util;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.security.audit.AuditEvent;
import com.liferay.portal.security.audit.storage.service.AuditEventLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(
		immediate = true,
		service = AuditEventManagerUtil.class
)
public class AuditEventManagerUtil {

	public List<AuditEvent> getAuditEventsByDynamicQuery(int start, int end, boolean viewAllPermission, long userId, String eventType) {
		List<AuditEvent> auditEvents = _auditEventLocalService.dynamicQuery(createDynamicQuery(viewAllPermission, userId, eventType), start, end);
		return auditEvents;
	}

	public DynamicQuery createDynamicQuery(boolean viewAllPermission, long userId, String eventType) {

		Order order = OrderFactoryUtil.desc("createDate");
		DynamicQuery dynamicQuery = _auditEventLocalService.dynamicQuery();
		if(viewAllPermission) {
			if(eventType.equals("registration")) {
				dynamicQuery
					.add(RestrictionsFactoryUtil.eq("eventType", "ADD"));
			}
			else
				if(eventType.equals("login")) {
					dynamicQuery
						.add(RestrictionsFactoryUtil.eq("eventType", "LOGIN"));
				}
				else {
					dynamicQuery
						.add(RestrictionsFactoryUtil.or(
								RestrictionsFactoryUtil.eq("eventType", "LOGIN"),
								RestrictionsFactoryUtil.eq("eventType", "ADD")
						));
					}
		}
		else {
			if(eventType.equals("registration")) {
				dynamicQuery
						.add(RestrictionsFactoryUtil.and(
							RestrictionsFactoryUtil.eq("eventType", "ADD"),
							RestrictionsFactoryUtil.eq("userId", userId)
						));
			}
			else
				if(eventType.equals("login")) {
					dynamicQuery
							.add(RestrictionsFactoryUtil.and(
									RestrictionsFactoryUtil.eq("eventType", "LOGIN"),
									RestrictionsFactoryUtil.eq("userId", userId)
							));
				}
				else {
					dynamicQuery
							.add(RestrictionsFactoryUtil.and(
									RestrictionsFactoryUtil.or(
											RestrictionsFactoryUtil.eq("eventType", "LOGIN"),
											RestrictionsFactoryUtil.eq("eventType", "ADD")
									),
									RestrictionsFactoryUtil.eq("userId", userId)
							));
				}
		}
		dynamicQuery.addOrder(order);

		return dynamicQuery;
	}

	public long dynamicQueryCount(boolean viewAllPermission, long userId, String eventType) {
		return _auditEventLocalService.dynamicQueryCount(createDynamicQuery(viewAllPermission, userId, eventType));
	}

	@Reference
	private AuditEventLocalService _auditEventLocalService;

}