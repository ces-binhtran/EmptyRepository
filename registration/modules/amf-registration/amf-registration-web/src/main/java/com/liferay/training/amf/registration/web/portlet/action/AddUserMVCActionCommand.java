package com.liferay.training.amf.registration.web.portlet.action;

import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.amf.registration.service.UserCustomService;
import com.liferay.training.amf.registration.web.constants.MVCCommandNames;
import com.liferay.training.amf.registration.web.constants.RegistrationPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + RegistrationPortletKeys.REGISTRATION,
                "mvc.command.name=" + MVCCommandNames.SIGNUP
        },
        service = MVCActionCommand.class
)
public class AddUserMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        ThemeDisplay themeDisplay =
                (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);



        Company company = themeDisplay.getCompany();
        boolean autoPassword = false;
        String password1 = ParamUtil.getString(actionRequest, "password1");
        String password2 = ParamUtil.getString(actionRequest, "password2");
        boolean autoScreenName = false;
        String screenName = ParamUtil.getString(actionRequest, "userName");
        String emailAddress = ParamUtil.getString(
                actionRequest, "emailAddress");
        long facebookId = ParamUtil.getLong(actionRequest, "facebookId");
        String openId = ParamUtil.getString(actionRequest, "openId");
        String languageId = ParamUtil.getString(actionRequest, "languageId");
        String firstName = ParamUtil.getString(actionRequest, "firstName");
        String middleName = ParamUtil.getString(actionRequest, "middleName");
        String lastName = ParamUtil.getString(actionRequest, "lastName");
        long prefixId = ParamUtil.getInteger(actionRequest, "prefixId");
        long suffixId = ParamUtil.getInteger(actionRequest, "suffixId");
        boolean male = ParamUtil.getBoolean(actionRequest, "male", true);
        int birthdayMonth = ParamUtil.getInteger(
                actionRequest, "birthdayMonth");
        int birthdayDay = ParamUtil.getInteger(actionRequest, "birthdayDay");
        int birthdayYear = ParamUtil.getInteger(actionRequest, "birthdayYear");
        String jobTitle = ParamUtil.getString(actionRequest, "jobTitle");
        long[] groupIds = null;
        long[] organizationIds = null;
        long[] roleIds = null;
        long[] userGroupIds = null;
        boolean sendEmail = true;

        String homePhone = ParamUtil.getString(actionRequest, "homePhone");
        String mobilePhone = ParamUtil.getString(actionRequest, "mobilePhone");
        String address = ParamUtil.getString(actionRequest, "address");
        String address2 = ParamUtil.getString(actionRequest, "address2");
        String city = ParamUtil.getString(actionRequest, "city");
        String state = ParamUtil.getString(actionRequest, "state");
        String zip = ParamUtil.getString(actionRequest, "zip");
        String securityQuestion = ParamUtil.getString(actionRequest, "securityQuestion");
        String securityAnswer = ParamUtil.getString(actionRequest, "securityAnswer");
        boolean acceptedTou = ParamUtil.getBoolean(actionRequest, "acceptedTou");

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                User.class.getName(), actionRequest);

        _userCustomService.addUserCustom(0, company.getCompanyId(), autoPassword, password1, password2,
                autoScreenName, screenName, emailAddress, facebookId, openId,
                LocaleUtil.fromLanguageId(languageId) , firstName, middleName,
                lastName, prefixId, suffixId, male, birthdayMonth + 1, birthdayDay,
                birthdayYear, jobTitle, groupIds, organizationIds, roleIds,
                userGroupIds, sendEmail, serviceContext, homePhone, mobilePhone, address, address2,
                city, state, zip, securityQuestion, securityAnswer, acceptedTou);

        SessionMessages.add(actionRequest, "registerSuccess");
        sendRedirect(actionRequest, actionResponse);
    }

    @Reference
    private UserCustomService _userCustomService;
}