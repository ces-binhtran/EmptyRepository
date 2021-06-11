<%@ include file="/init.jsp" %>

<div class="container-fluid-1280" >
	<clay:navigation-bar inverted="<%= true %>" navigationItems="<%= newsletterManagementToolbarDisplayContext.getNavigationItems() %>" />
	<clay:dropdown-menu
			dropdownItems="<%= newsletterMonthDisplayContext.getDropdownItems()%>"
			label="<%= renderRequest.getParameter("tabs2") != null ? renderRequest.getParameter("tabs2") : "All" %>"
	/>

</div>
