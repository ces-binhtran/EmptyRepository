<%@ include file="init.jsp" %>

<div class="container-fluid-1280 edit-member">

	<portlet:renderURL var="viewEventsRenderURL">
		<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_EVENTS%>" />
	</portlet:renderURL> 

	<liferay-ui:tabs names="All,Registration,Login" tabsValues="all,registration,login" param="tab"
		value="${currentTab}">

	</liferay-ui:tabs>
	
</div>