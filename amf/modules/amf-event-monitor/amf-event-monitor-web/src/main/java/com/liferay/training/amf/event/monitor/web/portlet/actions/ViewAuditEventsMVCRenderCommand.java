package com.liferay.training.amf.event.monitor.web.portlet.actions;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.audit.AuditEvent;
import com.liferay.training.amf.event.monitor.web.constants.AuditEventPortletKeys;
import com.liferay.training.amf.event.monitor.web.internal.security.permission.resource.AuditEventTopLevelPermission;
import com.liferay.training.amf.event.monitor.web.util.AuditEventManagerUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
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
        User currentUser = (User) renderRequest.getAttribute(WebKeys.USER);
        renderRequest.setAttribute("auditEventManagerUtil", auditEventManagerUtil);
        renderRequest.setAttribute("auditEventTopLevelPermission", _auditEventTopLevelPermission);
        return "/view.jsp";
    }

    @Reference
    private AuditEventTopLevelPermission _auditEventTopLevelPermission;

    @Reference
    private AuditEventManagerUtil auditEventManagerUtil;

}