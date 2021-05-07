<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>
<%@ taglib prefix="liferay-security" uri="http://liferay.com/tld/security" %>
<%@ include file="/init.jsp" %>

<div class="container-fluid-1280">

	<c:choose>
		<c:when test="${auditEventTopLevelPermission.contains(permissionChecker, scopeGroupId, 'VIEW')}">

			<div style="display: flex; justify-content: space-between;">
				<h1><liferay-ui:message key="audit-events" /></h1>
				<c:if test="${auditEventTopLevelPermission.contains(permissionChecker, scopeGroupId, 'PERMISSIONS')}">
					<liferay-ui:icon-menu
							direction="right-side"
							icon="<%= StringPool.BLANK %>"
							markupView="lexicon"
							message="<%= StringPool.BLANK %>"
							showWhenSingleIcon="<%= true %>"
					>
						<liferay-security:permissionsURL
								modelResource="com.liferay.portal.security.audit.storage.model"
								modelResourceDescription="{modelResourceDescription}"
								resourcePrimKey="${scopeGroupId}"
								var="permissionsURL"
								windowState="<%= LiferayWindowState.POP_UP.toString() %>"
						/>
						<liferay-ui:icon
								method="get"
								message="permissions"
								url="${permissionsURL}"
								useDialog="<%= true %>"/>
					</liferay-ui:icon-menu>
				</c:if>
			</div>

			<clay:navigation-bar navigationItems="<%= auditEventsManagermentToolbarDisplayContext.getNavigationItems() %>" />

			<liferay-ui:search-container
					displayTerms="<%= new DisplayTerms(renderRequest) %>"
					emptyResultsMessage="there-are-no-events"
					headerNames="date,time,user-name,client-ip,resource-action"
					iteratorURL="${portalURL}"
					total="${auditEventManagerUtil.dynamicQueryCount(auditEventTopLevelPermission.contains(permissionChecker, scopeGroupId, 'VIEW_ALL') ? true : false,
							themeDisplay.getUser().getUserId(),
							eventType)}"
					delta="20"
					deltaConfigurable="true">

				<liferay-ui:search-container-results results="${auditEventManagerUtil.getAuditEventsByDynamicQuery(searchContainer.getStart(),
					searchContainer.getEnd(), auditEventTopLevelPermission.contains(permissionChecker, scopeGroupId, 'VIEW_ALL') ? true : false,
					themeDisplay.getUser().getUserId(), eventType)}" />

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