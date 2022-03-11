package com.liferay.training.amf.registration.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.training.amf.model.Member;
import com.liferay.training.amf.registration.constants.AmfPortletKeys;
import com.liferay.training.amf.registration.constants.MVCCommandNames;
import com.liferay.training.amf.service.MemberService;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + AmfPortletKeys.AMF, 
		"mvc.command.name=" + MVCCommandNames.VIEW_MEMBERS}, service = MVCRenderCommand.class)
public class ViewMembersMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		List<Member> members = _memberService.getAllMembers();
		renderRequest.setAttribute("members", members);
		return "/view_members.jsp";
	}
	
	@Reference
	protected MemberService _memberService;
}
