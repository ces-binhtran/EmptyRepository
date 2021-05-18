<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.liferay.portal.kernel.security.auth.PrincipalException" %>
<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@ include file="/init.jsp" %>

<div class="container-fluid-1280">
	<c:if test="<%= renderRequest.getAttribute("value") == null %>">
		<div style="font-size: 2rem; font-weight: 500">
			<liferay-ui:message key="search-results-for-x" arguments="${value}"/>
		</div>
	</c:if>

	<liferay-ui:search-container
			displayTerms="<%= new DisplayTerms(renderRequest) %>"
			emptyResultsMessage="no-results-found-please-try-a-different-search-criteria"
			headerNames="user-name,screen-name,email"
			total="${total}"
			delta="5"
			deltaConfigurable="true"
	>

		<liferay-ui:search-container-results results="${users}" />

		<liferay-ui:search-container-row
				className="com.liferay.portal.kernel.model.User"
				modelVar="user"
				keyProperty="userId"
		>
			<%@ include file="search_columns.jspf" %>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
				searchContainer="<%= searchContainer%>"
				markupView="lexicon"
		/>
	</liferay-ui:search-container>

</div>