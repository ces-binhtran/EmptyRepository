package com.liferay.training.amf.search.result.portlet.action;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.amf.search.result.constants.AmfSearchResultsPortletKeys;
import com.liferay.training.amf.search.result.constants.MVCCommandNames;
import com.liferay.training.amf.search.result.display.content.AmfSearchUserManagementToolbarDisplayContext;
import com.liferay.training.amf.search.result.internal.security.permission.AmfSearchUserPermission;
import com.liferay.training.amf.service.AmfSearchService;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + AmfSearchResultsPortletKeys.AMFSEARCHRESULTS,
		"mvc.command.name=/", "mvc.command.name=" + MVCCommandNames.SEARCH_USER_RESULT }, service = MVCRenderCommand.class)
public class ViewUserSearchResultMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String zipCode = ParamUtil.getString(renderRequest, "zipCode", null);
		
		if (!themeDisplay.isSignedIn() || zipCode == null) {
			return "/view.jsp";
		}
		
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		boolean hasPermissionSearchUser = AmfSearchUserPermission.contains(permissionChecker,
				themeDisplay.getCompanyId(), AmfSearchUserPermission.TEC_SEARCH_USER);
		
		if (!hasPermissionSearchUser) {
			SessionErrors.add(renderRequest, "noPermission");
			return "/view.jsp";
		}
		
		// Resolve start and end for the search.
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = start + delta;
		
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "createDate");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "asc");
		// Create comparator
		OrderByComparator<User> comparator = OrderByComparatorFactoryUtil.create("AuditEvent", orderByCol,
				!("asc").equals(orderByType));
		
		if (zipCode != null) {
			List<User> userSearchResult = _amfSearchService.searchUser(zipCode, start, end, comparator);
			long countUsers = _amfSearchService.countUsers(zipCode);
			renderRequest.setAttribute("users", userSearchResult);
			renderRequest.setAttribute("countUsers", countUsers);
			System.out.println("countUsers=" + countUsers);
		}
		addManagementToolbarAttributes(renderRequest, renderResponse);
		return "/view.jsp";
	}

	/**
	 * Adds Clay management toolbar context object to the request.
	 *
	 * @param renderRequest
	 * @param renderResponse
	 */
	private void addManagementToolbarAttributes(RenderRequest renderRequest, RenderResponse renderResponse) {
		LiferayPortletRequest liferayPortletRequest = _portal.getLiferayPortletRequest(renderRequest);
		LiferayPortletResponse liferayPortletResponse = _portal.getLiferayPortletResponse(renderResponse);
		AmfSearchUserManagementToolbarDisplayContext amfSearchUserManagementToolbarDisplayContext = new AmfSearchUserManagementToolbarDisplayContext(
				liferayPortletRequest, liferayPortletResponse, _portal.getHttpServletRequest(renderRequest));
		renderRequest.setAttribute(
				"assignmentsManagementToolbarDisplayContext", amfSearchUserManagementToolbarDisplayContext);
	}
	
	@Reference
	private AmfSearchService _amfSearchService;
	
	@Reference
	private Portal _portal;
}
