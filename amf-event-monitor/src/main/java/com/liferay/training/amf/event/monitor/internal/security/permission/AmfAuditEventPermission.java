package com.liferay.training.amf.event.monitor.internal.security.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

public class AmfAuditEventPermission {

	public static final String VIEW_EVENTS_ALL_USERS = "VIEW_EVENTS_ALL_USERS"; 
	
	public static void check(PermissionChecker permissionChecker, long groupId, String actionId)
			throws PortalException {
		
		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId) {

		return permissionChecker.hasPermission(groupId, "com.liferay.training.amf.model.AmfAuditEvent", groupId, actionId);
	}
}