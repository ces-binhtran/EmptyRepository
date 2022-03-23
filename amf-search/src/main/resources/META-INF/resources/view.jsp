<%@ include file="init.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-md-3 portlet-column portlet-column-first">
			<portlet:actionURL var="searchUserActionURL" name="<%=MVCCommandNames.SEARCH_USER%>"></portlet:actionURL>
			<aui:form action="${searchUserActionURL}" name="fm">
				<aui:fieldset-group markupView="lexicon">
					<aui:fieldset label="Enter US Zip">
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
	</div>
</div>