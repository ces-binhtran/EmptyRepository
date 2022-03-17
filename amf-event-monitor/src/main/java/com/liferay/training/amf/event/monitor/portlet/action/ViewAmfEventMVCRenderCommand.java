package com.liferay.training.amf.event.monitor.portlet.action;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.security.permission.resource.definition.PortletResourcePermissionDefinition;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.amf.constants.AmfAuditEventConstants;
import com.liferay.training.amf.constants.AmfAuditEventTypeConstants;
import com.liferay.training.amf.event.monitor.constants.AmfPortletKeys;
import com.liferay.training.amf.event.monitor.constants.MVCCommandNames;
import com.liferay.training.amf.event.monitor.internal.security.permission.AmfAuditEventPermission;
import com.liferay.training.amf.model.AmfAuditEvent;
import com.liferay.training.amf.service.AmfAuditEventService;

import java.util.Calendar;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

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
			System.out.println("not signedIn");
			return "/view.jsp";
		}
		
		User user = themeDisplay.getRealUser();
		
		// Resolve start and end for the search.
		int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = start + delta;
		
		PortletResourcePermissionDefinition p;
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		boolean isAdmin = permissionChecker.isOmniadmin();
		
		String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "createDate");
		String orderByType = ParamUtil.getString(renderRequest, "orderByType", "asc");
		// Create comparator
		OrderByComparator<AmfAuditEvent> comparator = OrderByComparatorFactoryUtil.create("AuditEvent", orderByCol,
				!("asc").equals(orderByType));

		Long userIdForSearch = null;
		boolean hasPermissionViewAllEvents = AmfAuditEventPermission.contains(permissionChecker,
				themeDisplay.getCompanyId(), AmfAuditEventPermission.VIEW_EVENTS_ALL_USERS);
		if (!isAdmin && !hasPermissionViewAllEvents) { 
			userIdForSearch = user.getUserId();
		}
		
		String[] eventTypesForSearch = verifyAuditEventType(currentTab);
		List<AmfAuditEvent> amfAuditEvents = amfAuditEventService.getAuditEventByTypeAndUser(userIdForSearch, eventTypesForSearch, start, end, comparator);
		long countAmfAuditEvents =  amfAuditEventService.countAuditEventBytypeAndUser(userIdForSearch, eventTypesForSearch);
		renderRequest.setAttribute("auditEvents", amfAuditEvents);
		renderRequest.setAttribute("auditEventCount", countAmfAuditEvents);
		renderRequest.setAttribute("timeZoneId", CalendarFactoryUtil.getCalendar().getTimeZone().getID());
		System.out.println("countAmfAuditEvents=" + countAmfAuditEvents);
		
		return "/view.jsp";
	}
	
	public static void main(String[] args) {
		System.out.println(Calendar.getInstance().getTimeZone().getID());
	}
	
	private String[] verifyAuditEventType(String inputType) {
		if (AmfAuditEventTypeConstants.REGISTRATION.equalsIgnoreCase(inputType)) {
			return new String[] {AmfAuditEventTypeConstants.REGISTRATION};
		}
		if (AmfAuditEventTypeConstants.LOGIN.equalsIgnoreCase(inputType)) {
			return new String[] {AmfAuditEventTypeConstants.LOGIN};
		} 
		return new String[] {};
	}

	@Reference
	private AmfAuditEventService amfAuditEventService;
	
}
