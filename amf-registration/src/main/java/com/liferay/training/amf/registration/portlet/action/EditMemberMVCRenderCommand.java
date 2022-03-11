package com.liferay.training.amf.registration.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.amf.model.Member;
import com.liferay.training.amf.registration.constants.AmfPortletKeys;
import com.liferay.training.amf.registration.constants.MVCCommandNames;
import com.liferay.training.amf.service.MemberService;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" +  AmfPortletKeys.AMF, 
		"mvc.command.name=" + MVCCommandNames.EDIT_MEMBER}, service = MVCRenderCommand.class)
public class EditMemberMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long memberId = ParamUtil.getLong(renderRequest, "memberId", 0);
		// find member by id
		Member member = null;

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		// Set back icon visible.
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		portletDisplay.setShowBackIcon(true);
		String redirect = renderRequest.getParameter("redirect");

		portletDisplay.setURLBack(redirect);

		// Set member to the request attributes.
		renderRequest.setAttribute("member", member);
		renderRequest.setAttribute("memberClass", Member.class);
		return "registration.jsp";
	}
	
	@Reference
	private MemberService _memberService;
}
