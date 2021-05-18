package com.liferay.training.amf.search.portlet.actions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.training.amf.search.constants.MVCCommandNames;
import com.liferay.training.amf.search.constants.SearchPortletConstants;
import com.liferay.training.amf.search.constants.SearchPortletKeys;
import com.liferay.training.amf.search.permission.SearchPermissionChecker;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + SearchPortletKeys.SEARCH,
                "mvc.command.name=/",
                "mvc.command.name=/" + MVCCommandNames.SUBMIT_SEARCH_VALUE
        },
        service = MVCRenderCommand.class
)
public class SearchMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        try {
            searchPermissionChecker.check(renderRequest);
        } catch (PortalException e) {
            return SearchPortletConstants.PORTLET_ACCESS_DENIED;
        }
        return SearchPortletConstants.SEARCH_FORM;
    }

    private SearchPermissionChecker searchPermissionChecker = new SearchPermissionChecker();
}
