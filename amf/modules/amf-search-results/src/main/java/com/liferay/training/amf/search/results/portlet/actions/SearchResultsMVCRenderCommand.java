package com.liferay.training.amf.search.results.portlet.actions;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.amf.search.results.constants.MVCCommandNames;
import com.liferay.training.amf.search.results.constants.SearchResultsPortletKeys;
import com.liferay.training.amf.search.results.util.SearchManagerUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

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

                addUsersListAttributes(renderRequest);
                String searchValue = ParamUtil.getString(renderRequest, "searchValue");
                renderRequest.setAttribute("value", searchValue);
                return "/view.jsp";
        }

        private void addUsersListAttributes(RenderRequest renderRequest) {
                String searchValue = ParamUtil.getString(renderRequest, "searchValue");
                int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
                int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 5);
                int start = (currentPage > 0 ? (currentPage - 1) : 0) * delta;
                int end = start + delta;
                List<User> users = searchManagerUtil.getUsersByZipCodeUseDynamicQuery(searchValue, start, end);
                long total = searchManagerUtil.dynamicQueryCount(searchValue);
                renderRequest.setAttribute("total", total);
                renderRequest.setAttribute("users", users);
        }

        @Reference
        private SearchManagerUtil searchManagerUtil;

}
