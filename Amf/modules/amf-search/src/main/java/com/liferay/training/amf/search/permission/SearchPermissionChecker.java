package com.liferay.training.amf.search.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletSession;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.amf.search.constants.ActionKeys;
import com.liferay.training.amf.search.constants.SearchPortletKeys;

import javax.portlet.RenderRequest;

public class SearchPermissionChecker {

    public void check(RenderRequest renderRequest) throws PortalException {
        ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
                WebKeys.THEME_DISPLAY);

        PermissionChecker permissionChecker =
                themeDisplay.getPermissionChecker();
        User currentUser = themeDisplay.getUser();
        String primKey =
                themeDisplay.getLayout(
                ).getPlid() + LiferayPortletSession.LAYOUT_SEPARATOR +
                        PortalUtil.getPortletId(renderRequest);
        long portletGroupId = themeDisplay.getScopeGroupId();

        if (!hasPermission(permissionChecker, portletGroupId, primKey)) {
            throw new PrincipalException.MustHavePermission(
                    currentUser.getUserId(), ActionKeys.SEARCH);
        }
    }

    public boolean hasPermission(
            PermissionChecker permissionChecker, long portletGroupId,
            String primKey)
            throws PortalException {

        if (permissionChecker.hasPermission(
                portletGroupId, SearchPortletKeys.SEARCH, primKey,
                ActionKeys.SEARCH)) {

            return true;
        }

        return false;
    }

}