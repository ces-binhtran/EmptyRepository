<%@ include file="init.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix ="fn" %>

<c:choose>
	<c:when test="<%= themeDisplay.isSignedIn() %>">
		<div class="container">
			<div class="" style="float:left; width:68%;">
				<liferay-ui:error key="noPermission" message="error.no-permission" />
				<liferay-ui:search-container emptyResultsMessage="no-user"
					id="amfSearchUserEntries" iteratorURL="${portletURL}" total="${countUsers}">
					<liferay-ui:search-container-results results="${users}" />
					<liferay-ui:search-container-row className="com.liferay.portal.kernel.model.User" modelVar="entry">
						<liferay-ui:search-container-column-text name="col.nameOfUser">
							<c:set var="firstName" value="<%=entry.getFirstName() %>"/>
							<c:set var="lastName" value="<%=entry.getLastName()%>"/>
							<c:set var="lastNameInitial" value="${fn:substring(lastName, 0, 1)}" />
								${firstName}&nbsp;${lastNameInitial}&#8228;
						</liferay-ui:search-container-column-text>
						<liferay-ui:search-container-column-text name="col.userScreenName" value="<%=entry.getScreenName()%>"/>
						<liferay-ui:search-container-column-text name="col.emailAddress" value="<%=entry.getEmailAddress()%>" />
					</liferay-ui:search-container-row>
					<%-- Iterator / Paging --%>
					<liferay-ui:search-iterator displayStyle="${amfSearchUserManagementToolbarDisplayContext.getDisplayStyle()}" markupView="lexicon" />
				</liferay-ui:search-container>
			</div>
		</div>
	</c:when>
</c:choose>

