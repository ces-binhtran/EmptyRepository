<%@ include file="init.jsp"%>


<div class="container">
	<c:choose>
		<c:when test="<%= !themeDisplay.isSignedIn() %>">
				<liferay-ui:message key="error.not-signed-in" />
		</c:when>
		<c:otherwise>
			<div style="float:left; width:29%; margin-right: 2%">
				<portlet:actionURL var="searchUserActionURL" name="<%=MVCCommandNames.SEARCH_USER%>"></portlet:actionURL>
				<aui:form action="${searchUserActionURL}" name="fm">
					<aui:fieldset-group markupView="lexicon">
						<aui:fieldset label="Enter US Zip">
							<liferay-ui:error key="notSignedIn" message="error.not-signed-in" />
							<liferay-ui:error key="zipInvalid" message="error.zip-invalid" />
							<aui:input name="zipCode" label="Zip Code">
								<aui:validator name="required" />
							</aui:input>
							<aui:button-row>
								<aui:button cssClass="btn btn-primary" type="submit" value="Search" />
							</aui:button-row>
						</aui:fieldset>
					</aui:fieldset-group>
				</aui:form>
			</div>
		</c:otherwise>
	</c:choose>

</div>

