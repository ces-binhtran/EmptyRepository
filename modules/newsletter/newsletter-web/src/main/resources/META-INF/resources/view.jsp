<%@ page import="com.liferay.training.newsletter.model.NewsletterIssue" %>
<%@ page import="com.liferay.portal.kernel.search.*" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ include file="/init.jsp" %>

<portlet:renderURL var="searchURL">
	<portlet:param name="mvcRenderCommandName" value="/"/>
</portlet:renderURL>

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

	<c:if test="<%= Validator.isNull(renderRequest.getParameter("keywords")) %>">
		<clay:navigation-bar inverted="<%= true %>" navigationItems="<%= newsletterManagementToolbarDisplayContext.getNavigationItems() %>" />
		<clay:dropdown-menu
				dropdownItems="<%= newsletterMonthDisplayContext.getDropdownItems()%>"
				label="<%= renderRequest.getParameter("tabs2") != null ? renderRequest.getParameter("tabs2") : "All" %>"
		/>
	</c:if>
	<liferay-ui:search-container
			emptyResultsMessage="<%= Validator.isNull(renderRequest.getParameter("keywords")) ? "do-not-have-any-new-during-this-time" : "no-results-found-please-try-searching-with-other-keywords" %>"
			id="issueEntries"
			iteratorURL="${portletURL}"
			delta="5"
			total="${(renderRequest.getParameter('keywords') == '' || renderRequest.getParameter('keywords') == null)
						? (newsletterManagerUtil.count(renderRequest.getParameter('tabs1') != null ? Integer.valueOf(renderRequest.getParameter('tabs1')) : year,
						renderRequest.getParameter('tabs2') != null ? renderRequest.getParameter('tabs2') : 'All')) : total}"
	>
		<liferay-ui:search-container-results
				results="${(renderRequest.getParameter('keywords') == '' || renderRequest.getParameter('keywords') == null)
							? newsletterManagerUtil.getNewsletterIssueByMonthAndYear(
							renderRequest.getParameter('tabs1') != null ? Integer.valueOf(renderRequest.getParameter('tabs1')) : year,
							renderRequest.getParameter('tabs2') != null ? renderRequest.getParameter('tabs2') : 'All', searchContainer.getStart(), searchContainer.getEnd())
							: newsletterIssues}"
		/>
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
