package com.liferay.training.newsletter.web.portlet;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.newsletter.model.NewsletterArticle;
import com.liferay.training.newsletter.model.NewsletterIssue;
import com.liferay.training.newsletter.service.NewsletterIssueLocalService;
import com.liferay.training.newsletter.web.constants.NewsletterPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.training.newsletter.web.utils.NewsletterManagerUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ces-user
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.css-class-wrapper=newsletter-portlet",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Newsletter",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + NewsletterPortletKeys.NEWSLETTER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class NewsletterPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		String keywords = ParamUtil.getString(renderRequest, "keywords");
		if(Validator.isNotNull(keywords)) {
			int currentPage = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_CUR);
			int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 5);
			int start = (currentPage > 0 ? (currentPage - 1) : 0) * delta;
			int end = start + delta;
			List<NewsletterIssue> newsletterIssues = new ArrayList<>();
			HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
			try {
				newsletterIssues = _newsletterManagerUtil.searchIssue(httpServletRequest, keywords);
			} catch (PortalException e) {
				e.printStackTrace();
			}
			renderRequest.setAttribute("total", newsletterIssues.size());
			renderRequest.setAttribute("newsletterIssues",
					end >= newsletterIssues.size() ? getIssueByPage(newsletterIssues, start, newsletterIssues.size()) : getIssueByPage(newsletterIssues, start, end));
		}
		renderRequest.setAttribute("newsletterManagerUtil", _newsletterManagerUtil);
		renderRequest.setAttribute("newsletterIssueLocalService", newsletterIssueLocalService);
		super.render(renderRequest, renderResponse);
	}

	public List<NewsletterIssue> getIssueByPage(List<NewsletterIssue> newsletterIssues, int start, int end) {
		List<NewsletterIssue> result = new ArrayList<>();
		for(int count = start; count < end; count ++) {
			result.add(newsletterIssues.get(count));
		}
		return result;
	}
	@Reference
	private NewsletterManagerUtil _newsletterManagerUtil;

	@Reference
	private NewsletterIssueLocalService newsletterIssueLocalService;
}