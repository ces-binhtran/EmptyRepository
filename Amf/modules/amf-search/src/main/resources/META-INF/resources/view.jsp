<%@ include file="/init.jsp" %>


<portlet:actionURL name="<%= MVCCommandNames.SUBMIT_SEARCH_VALUE %>" var="searchActionURL">
	<portlet:param name="redirect" value="${currentURL}" />
</portlet:actionURL>

<div class="container-fluid-1280">
	<aui:form method="post" action="${searchActionURL}" name="searchBar">
		<aui:input label="Enter US Zip code" name="searchValue" type="text" placeholder="5 Digits Long" >
			<aui:validator name="required"/>
			<aui:validator name="maxLength" errorMessage="zip-code-must-be-5-digits-long">5</aui:validator>
			<aui:validator name="minLength" errorMessage="zip-code-must-be-5-digits-long">5</aui:validator>
			<aui:validator name="digits" ></aui:validator>
		</aui:input>
		<aui:button type="submit" value="Search"></aui:button>
	</aui:form>
</div>