package com.liferay.training.amf.search.results.portlet.actions;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.amf.search.results.constants.MVCCommandNames;
import com.liferay.training.amf.search.results.constants.SearchResultsPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + SearchResultsPortletKeys.SEARCHRESULTS,
                "mvc.command.name=/",
                "mvc.command.name=/" + MVCCommandNames.VIEW_SEARCH_RESULTS
        },
        service = MVCRenderCommand.class
)
public class SearchResultsMVCRenderCommand implements MVCRenderCommand{
        @Override
        public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
                String searchValue = ParamUtil.getString(renderRequest, "searchValue");
                renderRequest.setAttribute("value", searchValue);
                return "/view.jsp";
        }
}
