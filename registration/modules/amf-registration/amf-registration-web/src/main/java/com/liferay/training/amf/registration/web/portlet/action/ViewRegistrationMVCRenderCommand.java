package com.liferay.training.amf.registration.web.portlet.action;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.amf.registration.web.constants.MVCCommandNames;
import com.liferay.training.amf.registration.web.constants.RegistrationPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + RegistrationPortletKeys.REGISTRATION,
                "mvc.command.name=/",
                "mvc.command.name=" + MVCCommandNames.SIGNUP
        },
        service = MVCRenderCommand.class
)
public class ViewRegistrationMVCRenderCommand implements MVCRenderCommand{

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        User currentUser = (User) renderRequest.getAttribute(WebKeys.USER);
        if(currentUser != null) {
            renderRequest.setAttribute("userId", currentUser.getUserId());
        }
        return "/view.jsp";
    }

}
