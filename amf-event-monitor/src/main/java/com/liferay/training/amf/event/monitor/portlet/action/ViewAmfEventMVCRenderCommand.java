package com.liferay.training.amf.event.monitor.portlet.action;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.security.permission.resource.definition.PortletResourcePermissionDefinition;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.audit.event.generators.constants.EventTypes;
import com.liferay.portal.security.audit.storage.model.AuditEvent;
import com.liferay.training.amf.event.monitor.constants.AmfPortletKeys;
import com.liferay.training.amf.event.monitor.constants.MVCCommandNames;
import com.liferay.training.amf.service.AmfAuditEventService;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + AmfPortletKeys.AMF_EVENT_MONITOR,
		"mvc.command.name=/", "mvc.command.name=" + MVCCommandNames.VIEW_EVENTS }, service = MVCRenderCommand.class)
public class ViewAmfEventMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL portletURL = renderResponse.createRenderURL();
		
		String currentTab = ParamUtil.getString(renderRequest, "tab", "all");
		System.out.println("load tab: " + currentTab);

		portletURL.setParameter("tab", currentTab);
		renderRequest.setAttribute("currentTab", currentTab);
		
		if (!themeDisplay.isSignedIn()) {
			return "/view.jsp";
		}
		
		User user = themeDisplay.getRealUser();
		
		// Resolve start and end for the search.
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,
				SearchContainer.DEFAULT_DELTA);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = start + delta;
		
		com.liferay.portal.security.audit.storage.service.AuditEventLocalService a;
//		com.liferay.portal.security.audit.event.generators.constants.EventTypes x;
		PortletResourcePermissionDefinition p;
		
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		boolean isAdmin = permissionChecker.isOmniadmin();
		
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "createDate");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "asc");
		// Create comparator
		OrderByComparator<AuditEvent> comparator = OrderByComparatorFactoryUtil.create("AuditEvent", orderByCol,
				!("asc").equals(orderByType));
		// Get keywords.
		// Notice that cleaning keywords is not implemented.
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		// Call the service to get the list of assignments.
		
		Long userIdForSearch = null;
		if (!isAdmin) {
			userIdForSearch = user.getUserId();
		}
		
//		List<AuditEvent> events = AmfEventMonitorService.getAuditEventByTypeAndUser(themeDisplay.getScopeGroupId(),
//				userIdForSearch, start, end, comparator);
//		long count = _assignmentService.getAssignmentsCountByKeywords(themeDisplay.getScopeGroupId(), keywords);
//		// Set request attributes.
//		renderRequest.setAttribute("auditEvents", events);
//		renderRequest.setAttribute("auditEventCount", count);
		
		return "/view.jsp";
	}
	
	private String[] verifyAuditEventType(String inputType) {
		if ("registration".equalsIgnoreCase(inputType)) {
			return new String[] {EventTypes.ADD};
		}
		if ("login".equalsIgnoreCase(inputType)) {
			return new String[] {EventTypes.LOGIN};
		} 
		return new String[] {EventTypes.ADD, EventTypes.LOGIN};
	}

	
}
