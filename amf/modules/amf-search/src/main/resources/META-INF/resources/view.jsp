<%@ page import="com.liferay.training.amf.search.exception.SearchException" %>
<%@ include file="/init.jsp" %>

<portlet:actionURL var="searchActionURL" name="<%= MVCCommandNames.SUBMIT_SEARCH_VALUE %>">
	<portlet:param name="redirect" value="${currentURL}" />
</portlet:actionURL>

<div class="container-fluid-1280">
	<liferay-ui:error exception="<%= SearchException.MustNotBeNull.class%>" message="value.must.not.be.null"/>
	<liferay-ui:error exception="<%= SearchException.MustBeDigit.class%>" message="value.must.be.5.digit.postal.code"/>
	<aui:form action="${searchActionURL}" name="fm" method="post">
		<aui:input name="zip" type="text">
		</aui:input>
		<aui:button type="submit" value="Search" />
	</aui:form>
</div>