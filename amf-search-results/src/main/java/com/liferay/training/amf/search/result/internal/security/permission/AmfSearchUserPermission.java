package com.liferay.training.amf.search.result.internal.security.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

public class AmfSearchUserPermission {

public static final String TEC_SEARCH_USER = "TEC_SEARCH_USER"; 
	
	public static void check(PermissionChecker permissionChecker, long groupId, String actionId)
			throws PortalException {
		
		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId) {

		return permissionChecker.hasPermission(groupId, "com.liferay.portal.kernel.model.User", groupId, actionId);
	}
}
