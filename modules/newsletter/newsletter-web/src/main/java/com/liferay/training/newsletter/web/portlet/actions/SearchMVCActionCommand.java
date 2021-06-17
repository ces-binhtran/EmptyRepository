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

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.training.newsletter.model.NewsletterIssue;
import com.liferay.training.newsletter.web.constants.MVCCommandNames;
import com.liferay.training.newsletter.web.constants.NewsletterPortletKeys;
import com.liferay.training.newsletter.web.utils.NewsletterManagerUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Son Truong
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + NewsletterPortletKeys.NEWSLETTER,
                "mvc.command.name=" + MVCCommandNames.SEARCH
        },
        service = MVCActionCommand.class
)
public class SearchMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(actionRequest);
        SearchContext searchContext = SearchContextFactory.getInstance(httpServletRequest);
        String keywords = ParamUtil.getString(actionRequest, "keywords");
        searchContext.setKeywords(keywords);
        searchContext.setAttribute("paginationType", "more");
        searchContext.setStart(0);
        searchContext.setEnd(20);
        List<NewsletterIssue> newsletterIssues = newsletterManagerUtil.search(searchContext);
    }

    @Reference
    private NewsletterManagerUtil newsletterManagerUtil;

}
