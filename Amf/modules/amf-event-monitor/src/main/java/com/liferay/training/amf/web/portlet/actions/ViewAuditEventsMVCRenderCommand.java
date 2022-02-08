package com.liferay.training.amf.web.portlet.actions;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.training.amf.web.constants.AuditEventPortletKeys;
import com.liferay.training.amf.web.internal.security.permission.resource.AuditEventTopLevelPermission;
import com.liferay.training.amf.web.util.AuditEventManagerUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AuditEventPortletKeys.AUDITEVENT,
                "mvc.command.name=/",
        },
        service = MVCRenderCommand.class
)
public class ViewAuditEventsMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        renderRequest.setAttribute("auditEventManagerUtil", auditEventManagerUtil);
        renderRequest.setAttribute("auditEventTopLevelPermission", _auditEventTopLevelPermission);
        return "/view.jsp";
    }

    @Reference
    private AuditEventTopLevelPermission _auditEventTopLevelPermission;

    @Reference
    private AuditEventManagerUtil auditEventManagerUtil;

}