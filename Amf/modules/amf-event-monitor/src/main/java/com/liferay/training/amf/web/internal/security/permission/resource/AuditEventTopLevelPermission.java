package com.liferay.training.amf.web.internal.security.permission.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        service= AuditEventTopLevelPermission.class
)
public class AuditEventTopLevelPermission {

    public static final String RESOURCE_NAME = "com.liferay.portal.security.audit.storage.model";

    public static void check(PermissionChecker permissionChecker, long groupId, String actionId) throws PortalException {
        if(!contains(permissionChecker, groupId, actionId)) {
            throw new PrincipalException();
        }
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long groupId, String actionId) {

        return permissionChecker.hasPermission(
                groupId, RESOURCE_NAME, groupId, actionId);
    }

}