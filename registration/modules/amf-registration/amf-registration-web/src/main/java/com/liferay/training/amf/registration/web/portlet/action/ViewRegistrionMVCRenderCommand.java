package com.liferay.training.amf.registration.web.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
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
                "mvc.command.name=" + MVCCommandNames.SIGNUP
        },
        service = MVCRenderCommand.class
)
public class ViewRegistrionMVCRenderCommand implements MVCRenderCommand{
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        return "/signUp/view.jsp";
    }
}
