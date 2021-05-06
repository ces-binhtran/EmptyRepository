<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>
<%@ include file="/init.jsp" %>

<div class="container-fluid-1280">

	<h1><liferay-ui:message key="audit-events" /></h1>

	<c:choose>
		<c:when test="${auditEventTopLevelPermission.contains(permissionChecker, scopeGroupId, 'VIEW')}">

			<clay:navigation-bar navigationItems="<%= auditEventsManagermentToolbarDisplayContext.getNavigationItems() %>" />

			<liferay-ui:search-container
					displayTerms="<%= new DisplayTerms(renderRequest) %>"
					emptyResultsMessage="there-are-no-events"
					headerNames="date,time,user-name,client-ip,resource-action"
					iteratorURL="${portalURL}"
					total="${auditEventManagerUtil.dynamicQueryCount(auditEventTopLevelPermission.contains(permissionChecker, scopeGroupId, 'VIEW_ALL') ? true : false)}"
					delta="5"
					deltaConfigurable="true">

				<liferay-ui:search-container-results results="${auditEventManagerUtil.getAuditEventsByDynamicQuery(searchContainer.getStart(),
					searchContainer.getEnd(), auditEventTopLevelPermission.contains(permissionChecker, scopeGroupId, 'VIEW_ALL') ? true : false)}" />

				<liferay-ui:search-container-row
						className="com.liferay.portal.security.audit.storage.model.AuditEvent"
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
		</c:when>
		<c:otherwise>
			<div class="alert alert-info">
				<liferay-ui:message key="you-do-not-have-permission-to-access-this-portlet" />
			</div>
		</c:otherwise>
	</c:choose>

</div>