<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>
<%@ page import="com.liferay.portal.security.audit.AuditEvent" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.liferay.training.amf.event.monitor.web.util.AuditEventManagerUtil" %>
<%@ include file="/init.jsp" %>

<div class="container-fluid-1280">

	<h1><liferay-ui:message key="audit-events" /></h1>

<%--	<liferay-portlet:renderURL varImpl="iteratorURL">--%>
<%--		<portlet:param name="className" value="<%= className %>" />--%>
<%--		<portlet:param name="classPK" value="<%= classPK %>" />--%>
<%--		<portlet:param name="clientHost" value="<%= clientHost %>" />--%>
<%--		<portlet:param name="clientIP" value="<%= clientIP %>" />--%>
<%--		<portlet:param name="endDateAmPm" value="<%= String.valueOf(endDateAmPm) %>" />--%>
<%--		<portlet:param name="endDateDay" value="<%= String.valueOf(endDateDay) %>" />--%>
<%--		<portlet:param name="endDateHour" value="<%= String.valueOf(endDateHour) %>" />--%>
<%--		<portlet:param name="endDateMinute" value="<%= String.valueOf(endDateMinute) %>" />--%>
<%--		<portlet:param name="endDateMonth" value="<%= String.valueOf(endDateMonth) %>" />--%>
<%--		<portlet:param name="endDateYear" value="<%= String.valueOf(endDateYear) %>" />--%>
<%--		<portlet:param name="eventType" value="<%= eventType %>" />--%>
<%--		<portlet:param name="serverName" value="<%= serverName %>" />--%>
<%--		<portlet:param name="serverPort" value="<%= String.valueOf(serverPort) %>" />--%>
<%--		<portlet:param name="sessionID" value="<%= sessionID %>" />--%>
<%--		<portlet:param name="startDateAmPm" value="<%= String.valueOf(startDateAmPm) %>" />--%>
<%--		<portlet:param name="startDateDay" value="<%= String.valueOf(startDateDay) %>" />--%>
<%--		<portlet:param name="startDateHour" value="<%= String.valueOf(startDateHour) %>" />--%>
<%--		<portlet:param name="startDateMinute" value="<%= String.valueOf(startDateMinute) %>" />--%>
<%--		<portlet:param name="startDateMonth" value="<%= String.valueOf(startDateMonth) %>" />--%>
<%--		<portlet:param name="startDateYear" value="<%= String.valueOf(startDateYear) %>" />--%>
<%--		<portlet:param name="userId" value="<%= String.valueOf(userId) %>" />--%>
<%--		<portlet:param name="userName" value="<%= userName %>" />--%>
<%--	</liferay-portlet:renderURL>--%>

	<%-- Search container. --%>

	<clay:navigation-bar navigationItems="<%= auditEventsManagermentToolbarDisplayContext.getNavigationItems() %>" />

	<liferay-ui:search-container
			displayTerms="<%= new DisplayTerms(renderRequest) %>"
			emptyResultsMessage="there-are-no-events"
			headerNames="date,time,user-name,client-ip,resource-action"
			iteratorURL="${portalURL}">

		<%

			int endDateDayHour = (endDateAmPm != Calendar.PM) ? endDateHour : endDateHour + 12;
			int startDateDayHour = (startDateAmPm != Calendar.PM) ? startDateHour : startDateHour + 12;

			Date endDate = PortalUtil.getDate(endDateMonth, endDateDay, endDateYear, endDateDayHour, endDateMinute, timeZone, null);
			Date startDate = PortalUtil.getDate(startDateMonth, startDateDay, startDateYear, startDateDayHour, startDateMinute, timeZone, null);

			DisplayTerms displayTerms = searchContainer.getDisplayTerms();
			List<AuditEvent> auditEvents = new ArrayList<>();
			if (displayTerms.isAdvancedSearch()) {

				total = AuditEventManagerUtil.getAuditEventsCount(themeDisplay.getCompanyId(), userId, userName, startDate, endDate, eventType, className, classPK, clientHost, clientIP, serverName, serverPort, sessionID, displayTerms.isAndOperator());
				searchContainer.setTotal(total);

				auditEvents = AuditEventManagerUtil.getAuditEvents(themeDisplay.getCompanyId(), userId, userName, startDate, endDate, eventType, className, classPK, clientHost, clientIP, serverName, serverPort, sessionID, displayTerms.isAndOperator(), searchContainer.getStart(), searchContainer.getEnd(), new AuditEventCreateDateComparator());
				searchContainer.setResults(ConvertUtil.getEventsByCategory(ConvertUtil.getAllEvents(auditEvents), auditEventsManagermentToolbarDisplayContext.getTabs1()));
			}
			else {
				String keywords = displayTerms.getKeywords();

				String number = Validator.isNumber(keywords) ? keywords : String.valueOf(0);

				total = AuditEventManagerUtil.getAuditEventsCount(themeDisplay.getCompanyId(), Long.valueOf(number), keywords, null, null, keywords, keywords, keywords, keywords, keywords, keywords, Integer.valueOf(number), keywords, false);
				searchContainer.setTotal(total);

//				auditEvents = ConvertUtil.getEventsByCategory(ConvertUtil.getAllEvents(
//						AuditEventManagerUtil.getAuditEvents(themeDisplay.getCompanyId(), Long.valueOf(number), keywords, null, null, keywords, keywords, keywords, keywords, keywords, keywords, Integer.valueOf(number), keywords, false, searchContainer.getStart(), searchContainer.getEnd(), new AuditEventCreateDateComparator())
//				), auditEventsManagermentToolbarDisplayContext.getTabs1());

				searchContainer.setResults(AuditEventManagerUtil.getAuditEvents(themeDisplay.getCompanyId(), Long.valueOf(number), keywords, null, null, keywords, keywords, keywords, keywords, keywords, keywords, Integer.valueOf(number), keywords, false, searchContainer.getStart(), searchContainer.getEnd(), new AuditEventCreateDateComparator()));
			}
		%>
		<c:if test="${auditEventPermission.contains(permissionChecker, themeDisplay.getLayout().getGroupId(), 'VIEW')}">
			<h1>OK</h1>
		</c:if>
				<liferay-ui:search-container-row
						className="com.liferay.portal.security.audit.AuditEvent"
						escapedModel="<%= true %>"
						modelVar="event"
						keyProperty="auditEventId"
				>

					<%@ include file="/search_columns.jspf" %>

				</liferay-ui:search-container-row>

		<div class="separator"><!-- --></div>

		<liferay-ui:search-iterator
				searchContainer="<%= searchContainer %>"
		/>
	</liferay-ui:search-container>
</div>