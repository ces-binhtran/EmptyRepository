package com.liferay.training.amf.search.portlet.actions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.training.amf.search.constants.MVCCommandNames;
import com.liferay.training.amf.search.constants.SearchPortletConstants;
import com.liferay.training.amf.search.constants.SearchPortletKeys;
import com.liferay.training.amf.search.permission.SearchPermissionChecker;

import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SearchPortletKeys.SEARCH, "mvc.command.name=/",
		"mvc.command.name=/" + MVCCommandNames.SUBMIT_SEARCH_VALUE
	},
	service = MVCRenderCommand.class
)
public class SearchMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		PortletSession session = renderRequest.getPortletSession();

		try {
			searchPermissionChecker.check(renderRequest);
		}
		catch (PortalException e) {
			session.setAttribute(
				"portletAccessStatus", false, PortletSession.APPLICATION_SCOPE);

			return SearchPortletConstants.PORTLET_ACCESS_DENIED;
		}

		session.setAttribute(
			"portletAccessStatus", true, PortletSession.APPLICATION_SCOPE);

		return SearchPortletConstants.SEARCH_FORM;
	}

	private SearchPermissionChecker searchPermissionChecker =
		new SearchPermissionChecker();

}