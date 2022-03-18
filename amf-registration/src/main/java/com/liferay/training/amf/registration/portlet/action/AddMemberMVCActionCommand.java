package com.liferay.training.amf.registration.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.amf.exception.UserValidationException;
import com.liferay.training.amf.registration.constants.AmfPortletKeys;
import com.liferay.training.amf.registration.constants.MVCCommandNames;
import com.liferay.training.amf.service.AmfRegistrationService;

import java.lang.reflect.Member;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + AmfPortletKeys.AMF,
		"mvc.command.name=" + MVCCommandNames.ADD_MEMBER }, service = MVCActionCommand.class)
public class AddMemberMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		System.out.println("========AddMemberMVCActionCommand#doProcessAction========");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Company company = themeDisplay.getCompany();
		Locale locale = themeDisplay.getLocale();
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Member.class.getName(), actionRequest);

		String firstName = ParamUtil.getString(actionRequest, "first_name", null);
		String lastName = ParamUtil.getString(actionRequest, "last_name", null);
		String emailAddress = ParamUtil.getString(actionRequest, "email_address", null);
		String username = ParamUtil.getString(actionRequest, "username", null);
		boolean male = ParamUtil.getBoolean(actionRequest, "male", false);
		int monthOfBirth = ParamUtil.getInteger(actionRequest, "b_month", 0);
		int dayOfBirth = ParamUtil.getInteger(actionRequest, "b_day", 0);
		int yearOfBirth = ParamUtil.getInteger(actionRequest, "b_year", 0);
		String password = ParamUtil.getString(actionRequest, "password1", null);
		String confirmPassword = ParamUtil.getString(actionRequest, "password2", null);
		String homePhone = ParamUtil.getString(actionRequest, "home_phone", null);
		String mobilePhone = ParamUtil.getString(actionRequest, "mobile_phone", null);
		String address1 = ParamUtil.getString(actionRequest, "address", null);
		String address2 = ParamUtil.getString(actionRequest, "address2", null);
		String city = ParamUtil.getString(actionRequest, "city", null);
		String state = ParamUtil.getString(actionRequest, "state", null);
		String zipCode = ParamUtil.getString(actionRequest, "zip", null);
		String securityQuestion = ParamUtil.getString(actionRequest, "security_question", null);
		String answer = ParamUtil.getString(actionRequest, "security_answer", null);
		boolean termOfUse = ParamUtil.getBoolean(actionRequest, "accepted_tou", false);

		System.out.println("========Register========");
		System.out.println("firstName: " + firstName + ", lastName: " + lastName + ", emailAddress: " + emailAddress
				+ ", userName: " + username + ", male: " + male + ", monthOfBirth: " + monthOfBirth + ", dayOfBirth: "
				+ dayOfBirth + ", yearOfBirth: " + yearOfBirth + ", password: " + password + ", confirmPassword: "
				+ confirmPassword + ", homePhone: " + homePhone + ", mobilePhone: " + mobilePhone + ", address1: "
				+ address1 + ", address2: " + address2 + ", city: " + city + ", state: " + state + ", zipCode: "
				+ zipCode + ", securityQuestion: " + securityQuestion + ", answer: " + answer + ", termOfUse: "
				+ termOfUse);

		try {

			// call service to add member
			_amfRegistrationService.addMember(themeDisplay.getScopeGroupId(), company.getCompanyId(),
					firstName, lastName, emailAddress, locale, username, male, monthOfBirth, dayOfBirth, yearOfBirth,
					password, confirmPassword, homePhone, mobilePhone, address1, address2, city, state, zipCode,
					securityQuestion, answer, termOfUse, serviceContext);

		} catch (UserValidationException ave) {

			ave.printStackTrace();
			ave.getErrors().forEach(key -> SessionErrors.add(actionRequest, key));
			actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.ADD_MEMBER);
		} catch (PortalException pe) {

			pe.printStackTrace();
			SessionErrors.add(actionRequest, "serviceErrorDetails", pe);
			actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.ADD_MEMBER);
		}

	}

	@Reference
	private AmfRegistrationService _amfRegistrationService;
}
