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

package com.liferay.training.newsletter.web.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItemList;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.training.newsletter.model.NewsletterIssue;
import com.liferay.training.newsletter.service.NewsletterIssueLocalService;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Son Truong
 */
public class NewsletterManagementToolbarDisplayContext {

    public NewsletterManagementToolbarDisplayContext(RenderRequest renderRequest, RenderResponse renderResponse,
                                                     NewsletterIssueLocalService newsletterIssueLocalService) {
        _renderRequest = renderRequest;
        _newsletterIssueLocalService = newsletterIssueLocalService;
        _renderResponse = renderResponse;
        _httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
    }

    public List<Integer> getYears() {
        List<Integer> years = new ArrayList<>();
        int newsletterIssueCount = _newsletterIssueLocalService.getNewsletterIssuesCount();
        List<NewsletterIssue> newsletterIssues = _newsletterIssueLocalService.getNewsletterIssues(0, newsletterIssueCount);
        for(NewsletterIssue newsletterIssue: newsletterIssues) {
            Integer year = newsletterIssue.getIssueDate().getYear();
            if(!isYearExist(years, year)) {
                years.add(year);
            }
        }
        return years;
    }

    public boolean isYearExist(List<Integer> years, Integer year) {
        for(Integer yearElement: years) {
            if(Objects.equals(yearElement, year)) return true;
        }
        return false;
    }

    public List<NavigationItem> getNavigationItems() {
        List<Integer> years = getYears();
        return new NavigationItemList() {
            {
                for(Integer year: years) {
                    add(
                            navigationItem -> {
                                navigationItem.setActive(Objects.equals(getTabs1(), Integer.toString(year)));
                                navigationItem.setHref(getPortletURL(), "tabs1", Integer.toString(year));
                                navigationItem.setLabel(LanguageUtil.get(_httpServletRequest, Integer.toString(year)));
                            }
                    );
                }
            }
        };
    }

    public PortletURL getPortletURL() {

        PortletURL portletURL = _renderResponse.createRenderURL();
        portletURL.setParameter("tabs1", getTabs1());
        portletURL.setParameter("tabs2", ParamUtil.getString(_renderRequest, "tabs2", "All"));
        return portletURL;
    }

    public String getTabs1() {
        List<Integer> years = getYears();
        if (_tabs1 != null) {
            return _tabs1;
        }
        _tabs1 = ParamUtil.getString(_renderRequest, "tabs1", Integer.toString(years.get(0)));
        return _tabs1;
    }

    private NewsletterIssueLocalService _newsletterIssueLocalService;
    private final RenderRequest _renderRequest;
    private final RenderResponse _renderResponse;
    private final HttpServletRequest _httpServletRequest;
    private String _tabs1;
}
