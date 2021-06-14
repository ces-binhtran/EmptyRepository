<%@ include file="/init.jsp" %>

<portlet:actionURL name="<%= MVCCommandNames.SEARCH%>" var="searchURL">
</portlet:actionURL>

<div class="container-fluid-1280" >

	<aui:form action="${searchURL}" name="fm">
		<div class="row">
			<div class="col-md-8">
				<aui:input inlineLabel="left" label="" name="keywords" placeholder="search-entries" size="256" />
			</div>

			<div class="col-md-4">
				<aui:button type="submit" value="search" />
			</div>
		</div>
	</aui:form>

	<clay:navigation-bar inverted="<%= true %>" navigationItems="<%= newsletterManagementToolbarDisplayContext.getNavigationItems() %>" />
	<clay:dropdown-menu
			dropdownItems="<%= newsletterMonthDisplayContext.getDropdownItems()%>"
			label="<%= renderRequest.getParameter("tabs2") != null ? renderRequest.getParameter("tabs2") : "All" %>"
	/>

	<liferay-ui:search-container
			emptyResultsMessage="do-not-have-any-new-during-this-time"
			id="issueEntries"
			iteratorURL="${portletURL}"
			total="2">
		<liferay-ui:search-container-results results="${newsletterManagerUtil.getNewsletterIssueByMonthAndYear(
				renderRequest.getParameter('tabs1') != null ? Integer.valueOf(renderRequest.getParameter('tabs1')) : (date.year + 1900),
				renderRequest.getParameter('tabs2') != null ? renderRequest.getParameter('tabs2') : 'All')}" />
		<liferay-ui:search-container-row
				className="com.liferay.training.newsletter.model.NewsletterIssue"
				modelVar="issue">

			<%@ include file="issue/entry_search_columns.jspf" %>

		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator
				markupView="lexicon"
		/>
	</liferay-ui:search-container>

</div>
