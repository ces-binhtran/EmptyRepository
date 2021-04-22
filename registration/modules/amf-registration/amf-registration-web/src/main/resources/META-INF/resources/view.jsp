<%@ page import="com.liferay.training.amf.registration.model.UserCustom" %>
<%@ page import="com.liferay.training.amf.registration.util.StateUtil" %>
<%@ page import="com.liferay.training.amf.registration.exception.*" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.servlet.SessionMessages" %>
<%@ page import="com.liferay.training.amf.registration.util.State" %>
<%@ include file="/init.jsp" %>
<%
    State[] states = StateUtil.STATES;
    Date now = new Date();
    Calendar birthdayCalendar = CalendarFactoryUtil.getCalendar();
    birthdayCalendar.set(Calendar.MONTH, now.getMonth());
    birthdayCalendar.set(Calendar.DATE, now.getDate());
    birthdayCalendar.set(Calendar.YEAR, now.getYear() + 1900 - 14);
%>

<portlet:actionURL var="registrationActionURL" name="<%=MVCCommandNames.ADD_USER %>">
    <portlet:param name="redirect" value="${param.redirect}"/>
</portlet:actionURL>

<div class="container-fluid-1280">
    <liferay-ui:error exception="<%= UserFirstNameException.MustNotBeNull.class %>" message="first-name-must-not-be-null" focusField="firstName"/>
    <liferay-ui:error exception="<%= UserFirstNameException.MustBeAlphanumeric.class %>" message="first-name-must-be-alphanumeric" focusField="firstName"/>
    <liferay-ui:error exception="<%= UserFirstNameException.MustNotBeTooLong.class %>" message="first-name-can't-have-more-than-50-characters" focusField="firstName"/>
    <liferay-ui:error exception="<%= UserLastNameException.MustNotBeNull.class %>" message="last-name-must-not-be-null" focusField="lastName"/>
    <liferay-ui:error exception="<%= UserLastNameException.MustBeAlphanumeric.class %>" message="last-name-must-be-alphanumeric" focusField="lastName"/>
    <liferay-ui:error exception="<%= UserLastNameException.MustNotBeTooLong.class %>" message="last-name-can't-have-more-than-50-characters" focusField="lastName"/>
    <liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeNull.class %>" message="email-address-must-not-be-null" focusField="emailAddress"/>
    <liferay-ui:error exception="<%= UserEmailAddressException.MustBeAlphanumeric.class %>" message="email-address-must-be-alphanumeric" focusField="emailAddress"/>
    <liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeTooLong.class %>" message="email-address-can't-have-more-than-255-characters" focusField="emailAddress"/>
    <liferay-ui:error exception="<%= UserBirthdayException.MustNotBeNull.class %>" message="birthday-must-not-be-null" focusField="birthday"/>
    <liferay-ui:error exception="<%= UserBirthdayException.MustNotTooYoung.class %>" message="must-be-at-least-13-to-register" focusField="birthday"/>
    <liferay-ui:error exception="<%= UserScreenNameException.MustNotBeNull.class %>" message="screen-name-must-not-be-null" focusField="userName"/>
    <liferay-ui:error exception="<%= UserScreenNameException.MustBeValidate.class %>" message="screen-name-must-be-have-from-4-to-16-characters" focusField="userName"/>
    <liferay-ui:error exception="<%= UserScreenNameException.MustBeUnique.class %>" message="screen-name-must-be-unique" focusField="userName"/>
    <liferay-ui:error exception="<%= UserPasswordException.MustNotBeNull.class %>" message="password-must-not-be-null" focusField="password"/>
    <liferay-ui:error exception="<%= UserPasswordException.MustMatch.class %>" message="passwords-must-be-match" focusField="password"/>
    <liferay-ui:error exception="<%= UserPasswordException.MustNotBeTooShort.class %>" message="password-must-at-least-6-characters" focusField="password"/>
    <liferay-ui:error exception="<%= UserPasswordException.MustContain.class %>" message="password-must-contain-uppercase-number-special-character" focusField="password"/>
    <liferay-ui:error exception="<%= UserPhoneNumberException.MustBeValidate.class %>" message="phone-number-must-be-10-digits-long" focusField="homePhone"/>
    <liferay-ui:error exception="<%= UserAddressException.MustNotBeNull.class %>" message="address-must-not-be-null" focusField="address"/>
    <liferay-ui:error exception="<%= UserAddressException.MustBeAlphanumeric.class %>" message="address-must-be-alphanumeric" focusField="address"/>
    <liferay-ui:error exception="<%= UserAddressException.MustNotBeTooLong.class %>" message="address-must-have-maximum-255-characters" focusField="address"/>
    <liferay-ui:error exception="<%= UserCityException.MustNotBeNull.class %>" message="city-must-not-be-null" focusField="city"/>
    <liferay-ui:error exception="<%= UserCityException.MustBeAlphanumeric.class %>" message="city-must-be-alphanumeric" focusField="city"/>
    <liferay-ui:error exception="<%= UserCityException.MustNotBeTooLong.class %>" message="city-must-have-maximum-255-characters" focusField="city"/>
    <liferay-ui:error exception="<%= UserZipException.MustNotBeNull.class %>" message="zip-code-must-not-be-null" focusField="zip"/>
    <liferay-ui:error exception="<%= UserZipException.MustBeValidate.class %>" message="zip-code-must-be-5-digits-long" focusField="zip"/>
    <liferay-ui:error exception="<%= UserSecurityQueryException.MustNotBeNull.class %>" message="reminder-query-must-not-be-null" focusField="securityAnswer"/>
    <liferay-ui:error exception="<%= UserSecurityQueryException.MustBeAlphanumeric.class %>" message="security-answer-must-be-alphanumeric" focusField="securityAnswer"/>
    <liferay-ui:error exception="<%= UserSecurityQueryException.MustNotBeTooLong.class %>" message="security-answer-must-have-maximum-255-characters" focusField="securityAnswer"/>
    <liferay-ui:error exception="<%= UserAcceptedTouException.class %>" message="you-must-accept-the-terms-of-use" focusField="acceptedTou"/>
    <liferay-ui:success key="registerSuccess" message="sign-up-successfully" />

    <c:choose>
        <c:when test="<%= request.getAttribute("userId") != null %>">
            <div class="alert alert-info">
                <liferay-ui:message key="you-has-logged-in" />
            </div>
        </c:when>
        <c:otherwise>
            <aui:form action="${registrationActionURL}" name="fm" method="post">
                <aui:model-context model="<%= Contact.class %>"/>
                <aui:fieldset column="<%= true %>">
                    <aui:col width="<%= 50 %>">
                        <aui:fieldset-group markupView="lexicon">
                            <h3>Basic Info</h3>
                            <aui:fieldset>

                                <aui:input name="firstName">
                                    <aui:validator name="required"/>
                                </aui:input>

                                <aui:input name="lastName">
                                    <aui:validator name="required"/>
                                </aui:input>

                                <aui:input name="emailAddress">
                                    <aui:validator name="required"/>
                                </aui:input>

                                <aui:input name="userName">
                                    <aui:validator name="required"/>
                                </aui:input>

                                <aui:select label="gender" name="male">
                                    <aui:option label="male" value="1" />
                                    <aui:option label="female" value="0" />
                                    <aui:validator name="required"/>
                                </aui:select>

                                <aui:input name="birthday" value="<%= birthdayCalendar %>">
                                    <aui:validator name="required"/>
                                </aui:input>

                                <aui:input name="password1" value="" label="Password" type="password">
                                    <aui:validator name="required"/>
                                </aui:input>

                                <aui:input name="password2" label="Confirm Password" value="" type="password">
                                    <aui:validator name="required"/>
                                </aui:input>

                            </aui:fieldset>
                        </aui:fieldset-group>

                        <aui:model-context model="<%= UserCustom.class %>"/>
                        <aui:fieldset-group markupView="lexicon">
                            <h3>Phone</h3>
                            <aui:fieldset>

                                <aui:input name="homePhone">

                                </aui:input>

                                <aui:input name="mobilePhone">

                                </aui:input>

                            </aui:fieldset>
                        </aui:fieldset-group>
                    </aui:col>
                    <aui:col width="<%= 50 %>">
                        <aui:fieldset-group markupView="lexicon">
                            <h3>Billing Address (US-Only)</h3>
                            <aui:fieldset>

                                <aui:input name="address">
                                    <aui:validator name="required"/>
                                </aui:input>

                                <aui:input name="address2">

                                </aui:input>

                                <aui:input name="city">
                                    <aui:validator name="required"/>
                                </aui:input>

                                <aui:select name="state">
                                    <% for(State state : states)
                                        {
                                    %>
                                        <aui:option value="<%= state.getId() %>" label="<%= state.getName() %>" />
                                    <% } %>
                                </aui:select>

                                <aui:input name="zip" label="Zip Code">
                                    <aui:validator name="required"/>
                                </aui:input>

                            </aui:fieldset>
                        </aui:fieldset-group>
                        <aui:fieldset-group markupView="lexicon">
                            <h3>Misc.</h3>
                            <aui:fieldset>

                                <aui:select name="securityQuestion" label="Security Question">
                                    <aui:option value="" label="" />
                                    <aui:option value="what-is-your-mother's-maiden-name" label="what-is-your-mother's-maiden-name"/>
                                    <aui:option value="what-is-the-make-of-your-first-car" label="what-is-the-make-of-your-first-car"/>
                                    <aui:option value="what-is-your-high-school-mascot" label="what-is-your-high-school-mascot" />
                                    <aui:option value="who-is-your-favorite-actor" label="who-is-your-favorite-actor" />
                                    <aui:validator name="required"/>
                                </aui:select>

                                <aui:input name="securityAnswer" label="Answer">
                                    <aui:validator name="required"/>
                                </aui:input>

                                <aui:input name="acceptedTou" label="Terms of Use">
                                    <%--                            <aui:validator name="required"/>--%>
                                </aui:input>
                                <p style="margin-left: 2rem; margin-top: -1rem">I have read, understand, and agree with the
                                    Terms of Use governing my
                                    access to and use of the Acme Movie Fanatics
                                    web site.</p>
                            </aui:fieldset>
                        </aui:fieldset-group>
                    </aui:col>
                </aui:fieldset>

                <aui:button-row>
                    <aui:button cssClass="btn btn-primary" type="submit"/>
                    <aui:button cssClass="btn btn-secondary" onClick="${param.redirect}" type="cancel"/>
                </aui:button-row>
            </aui:form>
        </c:otherwise>
    </c:choose>
</div>