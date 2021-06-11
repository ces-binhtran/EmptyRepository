/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.training.newsletter.web.portlet.actions;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.newsletter.model.NewsletterArticle;
import com.liferay.training.newsletter.model.NewsletterIssue;
import com.liferay.training.newsletter.service.NewsletterIssueLocalService;
import com.liferay.training.newsletter.web.constants.MVCCommandNames;
import com.liferay.training.newsletter.web.constants.NewsletterPortletKeys;
import com.liferay.training.newsletter.web.utils.NewsletterManagerUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

/**
 * @author Son Truong
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + NewsletterPortletKeys.NEWSLETTER,
                "mvc.command.name=" + MVCCommandNames.VIEW_ISSUE
        },
        service = MVCRenderCommand.class
)
public class ViewIssueMVCRenderCommand implements  MVCRenderCommand{

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        NewsletterIssue newsletterIssue = _newsletterIssueLocalService.fetchNewsletterIssue(ParamUtil.getLong(renderRequest, "issueId"));
        List<NewsletterArticle> newsletterArticles = newsletterManagerUtil.fetchByClassPK(newsletterIssue.getNewsletterIssueId());
        renderRequest.setAttribute("newsletterIssue", newsletterIssue);
        renderRequest.setAttribute("articles", newsletterArticles);
        renderRequest.setAttribute("newsletterManagerUtil", newsletterManagerUtil);
        PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
        String redirect = renderRequest.getParameter("redirect");
        portletDisplay.setShowBackIcon(true);
        portletDisplay.setURLBack(redirect);
        return "/issue/view_issue.jsp";
    }

    @Reference
    private NewsletterIssueLocalService _newsletterIssueLocalService;

    @Reference
    private NewsletterManagerUtil newsletterManagerUtil;
}
