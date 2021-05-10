package com.liferay.training.amf.search.portlet.actions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.training.amf.search.constants.MVCCommandNames;
import com.liferay.training.amf.search.constants.SearchPortletKeys;
import com.liferay.training.amf.search.exception.SearchException;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Component(
        immediate = true,
        property = {
            "javax.portlet.name=" + SearchPortletKeys.SEARCH,
            "mvc.command.name=" + MVCCommandNames.SUBMIT_SEARCH_VALUE
        },
        service = MVCActionCommand.class
)
public class SearchMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        String value = ParamUtil.getString(actionRequest, "zip");
        validate(value);
        actionRequest.setAttribute("value", value);
        sendRedirect(actionRequest, actionResponse);
    }

    private void validate(String value) throws PortalException {
        if(Validator.isNull(value)) {
            throw new SearchException.MustNotBeNull();
        }
        if(value.length() != 5 || !Validator.isDigit(value)) {
            throw new SearchException.MustBeDigit();
        }
    }
}
