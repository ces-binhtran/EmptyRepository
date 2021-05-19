<%@ page import="com.liferay.portal.kernel.exception.PortalException" %><%@
page import="com.liferay.portal.kernel.security.auth.PrincipalException" %><%@
page import="com.liferay.training.amf.search.exception.SearchException" %>

<%@ include file="/init.jsp" %>

<portlet:actionURL name="<%= MVCCommandNames.SUBMIT_SEARCH_VALUE %>" var="searchActionURL">
	<portlet:param name="redirect" value="${currentURL}" />
</portlet:actionURL>

<div class="container-fluid-1280">
	<liferay-ui:error exception="<%= PortalException.class %>" message="you-do-not-have-the-required-permissions" />
	<liferay-ui:error exception="<%= PrincipalException.MustHavePermission.class %>" message="you-do-not-have-the-required-permissions" />
	<liferay-ui:error exception="<%= SearchException.MustBeDigit.class %>" message="value.must.be.5.digit.postal.code" />
	<liferay-ui:error exception="<%= SearchException.MustNotBeNull.class %>" message="value.must.not.be.null" />

	<aui:form action="${searchActionURL}" method="post" name="fm">
		<aui:input label="Enter zip code" name="searchValue" type="text">
		</aui:input>

		<aui:button type="submit" value="Search" />
	</aui:form>
</div>