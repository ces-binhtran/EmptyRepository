package com.liferay.training.amf.search.result.portlet.action;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.amf.search.result.constants.AmfSearchResultsPortletKeys;
import com.liferay.training.amf.search.result.constants.MVCCommandNames;
import com.liferay.training.amf.service.AmfSearchService;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + AmfSearchResultsPortletKeys.AMFSEARCHRESULTS,
		"mvc.command.name=/", "mvc.command.name=" + MVCCommandNames.SEARCH_USER_RESULT }, service = MVCRenderCommand.class)
public class ViewUserSearchResultMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		String zipCode = ParamUtil.getString(renderRequest, "zipCode", null);
		if (zipCode != null) {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			List<User> userSearchResult = _amfSearchService.searchUser(zipCode);
			long countUsers = _amfSearchService.countUsers(zipCode);
			renderRequest.setAttribute("users", userSearchResult);
			renderRequest.setAttribute("countUsers", countUsers);
		}
		return "/view.jsp";
	}

	@Reference
	private AmfSearchService _amfSearchService;
}
