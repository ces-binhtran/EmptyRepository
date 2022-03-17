<%@ include file="init.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container-fluid-1280 edit-member">

	<portlet:renderURL var="viewEventsRenderURL">
		<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_EVENTS%>" />
	</portlet:renderURL> 

	<liferay-ui:tabs names="All,Registration,Login" tabsValues="all,registration,login" param="tab"
		value="${currentTab}">
	</liferay-ui:tabs>
	
	<%-- Clay management toolbar. --%>
<%-- 	<clay:management-toolbar disabled="${auditEventCount eq 0}"
		displayContext="${amfAuditEventManagementToolbarDisplayContext}"
		itemsTotal="${auditEventCount}" searchContainerId="amfAuditEventEntries"
		selectable="false" /> --%>

	<%-- Search container. --%>
	<liferay-ui:search-container emptyResultsMessage="no-amf-audit-event"
		id="amfAuditEventEntries" iteratorURL="${portletURL}"
		total="${auditEventCount}">
		<liferay-ui:search-container-results results="${auditEvents}" />
		<liferay-ui:search-container-row
			className="com.liferay.training.amf.model.AmfAuditEvent"
			modelVar="entry">

			<liferay-ui:search-container-column-text name="col.create-date">
				 <fmt:formatDate  pattern="yyyy-MM-dd HH:mm:ss" value="${entry.createDate}"/>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="user-name" 
				value="<%= entry.getUserName() %>" />
			<liferay-ui:search-container-column-user name="user-id"
				userId="${entry.userId}" />
			<liferay-ui:search-container-column-text name="col.ip-address" 
				value="<%= entry.getIpAddress() %>" />
			<liferay-ui:search-container-column-text name="col.event-type" 
				value="<%= entry.getEventType() %>" />
			
		</liferay-ui:search-container-row>
		<%-- Iterator / Paging --%>
		<liferay-ui:search-iterator
			displayStyle="${amfAuditEventManagementToolbarDisplayContext.getDisplayStyle()}"
			markupView="lexicon" />
	</liferay-ui:search-container>
</div>