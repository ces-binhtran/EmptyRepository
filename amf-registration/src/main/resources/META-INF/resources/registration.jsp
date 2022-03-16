<%@ include file="init.jsp"%>
<liferay-ui:error key="serviceErrorDetails">
	<liferay-ui:message key="error.member-service-error"
		arguments='<%=SessionErrors.get(liferayPortletRequest, "serviceErrorDetails")%>' />
</liferay-ui:error>
<liferay-ui:error key="firstNameInvalid" message="error.first-name-invalid" />
<liferay-ui:error key="lastNameInvalid" message="error.last-name-invalid" />
<liferay-ui:error key="emailAddressInvalid" message="error.email-address-invalid" />
<liferay-ui:error key="userNameInvalid" message="error.user-name-invalid"/>
<liferay-ui:error key="homePhoneInvalid" message="error.home-phone-invalid" />
<liferay-ui:error key="mobilePhoneInvalid" message="error.mobile-phone-invalid" />
<liferay-ui:error key="securityQuestionInvalid" message="error.security-question-invalid" />
<liferay-ui:error key="securityAnswerInvalid" message="error.security-answer-invalid" />
<liferay-ui:error key="termsOfUseNotChecked" message="error.term-of-user-must-checked" />
<liferay-ui:error key="address1Invalid" message="error.address1-invalid" />
<liferay-ui:error key="address2Invalid" message="error.address2-invalid" />
<liferay-ui:error key="zipInvalid" message="error.zip-invalid" />
<liferay-ui:error key="stateInvalid" message="error.state-invalid" />
<liferay-ui:error key="birthdayInvalid" message="error.birthday-invalid" />
<liferay-ui:error key="confirmPasswordNotMatch" message="error.confirm-password-not-match" />
<liferay-ui:error key="passwordInvalid" message="error.password-invalid" />
<liferay-ui:error key="birthdayInvalidAgeLessThan13" message="error.assignment-description-empty" />


<div class="container-fluid-1280 edit-member">
<c:choose>
	<c:when test="<%= themeDisplay.isSignedIn() %>">
			<liferay-ui:message key="user-logged-in-already" />
	</c:when>
	<c:otherwise>
		
		<portlet:actionURL var="memberActionURL" name="<%=MVCCommandNames.ADD_MEMBER%>"></portlet:actionURL>
		<c:set var="editMember" value="add-member" />
		<h1>
			<liferay-ui:message key="${editMember}" />
		</h1>
		<aui:model-context bean="${member}" model="${memberClass}" />
		<aui:form action="${memberActionURL}" name="fm">
			<aui:input name="member_id" field="memberId" type="hidden" />
			<aui:fieldset-group markupView="lexicon">
				<aui:fieldset label="Basic">
					<aui:row>
						<aui:col width="<%= 50 %>">
							<%-- first_name field. --%>
							<aui:input label="First name" name="first_name" field="firstName">
								<aui:validator name="required" />
							</aui:input>
						</aui:col>
						<aui:col width="<%= 50 %>">
							<%-- last_name field. --%>
							<aui:input label="Last name" name="last_name" field="lastName">
								<aui:validator name="required" />
							</aui:input>
						</aui:col>
					</aui:row>
					
					<aui:row>
					    <aui:col width="<%= 50 %>">
					       	<%-- email_address field. --%>
							<aui:input label="Email address" name="email_address" field="emailAddress">
								<aui:validator name="required" />
							</aui:input>
					    </aui:col>
					    <aui:col width="<%= 50 %>">
					       	<%-- username field. --%>
							<aui:input  label="Username" name="username" field="userName">
								<aui:validator name="required" />
							</aui:input>
					    </aui:col>
					</aui:row>
					
					<aui:row>
					    <aui:col width="<%= 50 %>">
						    <%-- male field. --%>
							<aui:select label="Gender" name="male" required="true" value="${male}">
								<aui:option label="male" value="true" />
								<aui:option label="female" value="false" />
							</aui:select>
					    </aui:col>
					    <aui:col width="<%= 50 %>">
					    </aui:col>
					</aui:row>
	
					<aui:row>
					    <aui:col width="<%= 50 %>">
					       	<%-- b_month field. --%>
							<aui:input label="Month of birth" name="b_month" field="monthOfBirth">
								<aui:validator name="required" />
							</aui:input>
					    </aui:col>
					    <aui:col width="<%= 25 %>">
					       	<%-- b_day field. --%>
							<aui:input label="Day of birth" name="b_day" field="dayOfBirth">
								<aui:validator name="required" />
							</aui:input>
					    </aui:col>
					    <aui:col width="<%= 25 %>">
					       	<%-- b_year field. --%>
							<aui:input label="Year of birth" name="b_year" field="yearOfBirth">
								<aui:validator name="required" />
							</aui:input>
					    </aui:col>
					</aui:row>
					
					<aui:row>
					    <aui:col width="<%= 50 %>">
					       	<%-- password1 field. --%>
							<aui:input label="Password" name="password1" field="password" type="password">
								<aui:validator name="required" />
							</aui:input>
					    </aui:col>
					    <aui:col width="<%= 50 %>">
					       	<%-- password2 field. --%>
							<aui:input label="Confirm password" name="password2" field="confirmPassword" type="password">
								<aui:validator name="required" />
							</aui:input>
						    </aui:col>
					</aui:row>
				</aui:fieldset>
			</aui:fieldset-group>
			
			<aui:fieldset-group markupView="lexicon">
				<aui:fieldset label="phone">
					<aui:row>
					    <aui:col width="<%= 50 %>">
					       	<%-- home_phone field. --%>
							<aui:input label="Home phone" name="home_phone" field="homePhone">
								<aui:validator name="required" />
							</aui:input>
					    </aui:col>
					    <aui:col width="<%= 50 %>">
					       	<%-- mobile_phone field. --%>
							<aui:input label="Mobile phone" name="mobile_phone" field="mobilePhone">
								<aui:validator name="required" />
							</aui:input>
					    </aui:col>
					</aui:row>
				</aui:fieldset>
			</aui:fieldset-group>
			
					
			<aui:fieldset-group markupView="lexicon">
				<aui:fieldset label="Billing Address (US-Only)">
					<aui:row>
					    <aui:col width="<%= 50 %>">
							<%-- address field. --%>
							<aui:input label="Address 1" name="address" field="address1">
								<aui:validator name="required" />
							</aui:input>
					    </aui:col>
					    <aui:col width="<%= 50 %>">
					       	<%-- address2 field. --%>
							<aui:input label="Address 2" name="address2" field="address2">
								<aui:validator name="required" />
							</aui:input>
					    </aui:col>
					</aui:row>
					
	<aui:script use="liferay-dynamic-select">
	new Liferay.DynamicSelect([
		{
			select: '<portlet:namespace />countryId',
			selectData: Liferay.Address.getCountries,
			selectDesc: 'nameCurrentValue',
			selectSort: true,
			selectId: 'countryId',
			selectVal: '19'
		},
		{
			select: '<portlet:namespace />state',
			selectData: Liferay.Address.getRegions,
			selectDesc: 'name',
			selectSort: true,
			selectId: 'regionCode',
			selectVal: ''
		}
	]);
	</aui:script>
	
					<aui:row>
					    <aui:col width="<%= 50 %>">
					       	<%-- city field. --%>
							<aui:input label="City" name="city" field="city">
								<aui:validator name="required" />
							</aui:input>
					    </aui:col>
					    <aui:col width="<%= 50 %>">
					    
					    	<div hidden="true">
							   	<aui:field-wrapper>
									<aui:select label="" name="countryId"/>
								</aui:field-wrapper>
							</div>
							<aui:field-wrapper>
								<aui:select label="State" name="state" />
							</aui:field-wrapper>
					       	<%-- state field. --%>
							<%-- <aui:input label="State" name="state" field="state">
								<aui:validator name="required" />
							</aui:input> --%>
					    </aui:col>
					</aui:row>
					<aui:row>
					    <aui:col width="<%= 50 %>">
					       	<%-- zip field. --%>
							<aui:input label="Zip" name="zip" field="zipCode">
								<aui:validator name="required" />
							</aui:input>
					    </aui:col>
					    <aui:col width="<%= 50 %>">
					       
					    </aui:col>
					</aui:row>
					
				</aui:fieldset>
			</aui:fieldset-group>
	
			
			<aui:fieldset-group markupView="lexicon">
				<aui:fieldset label="Misc">
					<aui:row>
					    <aui:col width="<%= 50 %>">
					       	<%-- security_question field. --%>
							<aui:select label="Security question" name="security_question" required="true" value="${security_question}">
								<c:forEach items="<%=AmfRegistrationConstants.SECURITY_QUESTIONS%>" var="securityQuestion">
									<aui:option label="${securityQuestion}" />
								</c:forEach>
							</aui:select>
					    </aui:col>
					    <aui:col width="<%= 50 %>">
					       	<%-- email address field. --%>
							<aui:input label="Security answer" name="security_answer" field="answer">
								<aui:validator name="required" />
							</aui:input>
					    </aui:col>
					</aui:row>
					<aui:row>
						<%-- accepted_tou field. --%>
						<aui:input label="term-of-use" name="accepted_tou" field="termOfUse" type="checkbox">
							<aui:validator name="required" />
						</aui:input>
					</aui:row>
				</aui:fieldset>
			</aui:fieldset-group>
	
			<%--Buttons. --%>
			<aui:button-row>
				<aui:button cssClass="btn btn-primary" type="submit" />
				<aui:button cssClass="btn btn-secondary" onClick="${param.redirect}"
					type="cancel" />
			</aui:button-row>
		</aui:form>
	</c:otherwise>
</c:choose>
</div>
