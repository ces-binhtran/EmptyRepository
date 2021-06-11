package com.liferay.training.newsletter.web.utils;

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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.training.newsletter.model.NewsletterArticle;
import com.liferay.training.newsletter.model.NewsletterIssue;
import com.liferay.training.newsletter.service.NewsletterArticleLocalService;
import com.liferay.training.newsletter.service.NewsletterIssueLocalService;
import com.liferay.training.newsletter.web.constants.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Son Truong
 */
@Component(
        immediate = true,
        service = NewsletterManagerUtil.class
)
public class NewsletterManagerUtil {

    public List<NewsletterIssue> getNewsletterIssueByMonthAndYear(int year, String month) {
        Date startDate = null;
        Date endDate = null;
        if(!month.equals("All")) {
            startDate = new Date(year, Constants.months.indexOf(month), 0);
            endDate = new Date(year, Constants.months.indexOf(month) + 1, 0);
        }
        else {
            startDate = new Date(year, 0, 0);
            endDate = new Date(year + 1, 0, 0);
        }
        DynamicQuery dynamicQuery = _newsletterIssueLocalService.dynamicQuery();
        dynamicQuery
                .add(
                        RestrictionsFactoryUtil.and(
                                RestrictionsFactoryUtil.between("issueDate", startDate, endDate),
                                RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_APPROVED)
                        ));
        return _newsletterIssueLocalService.dynamicQuery(dynamicQuery);
    }

    public List<NewsletterArticle> fetchByClassPK(long newsletterIssueId) {
        DynamicQuery dynamicQuery = _newsletterArticleLocalService.dynamicQuery();
        dynamicQuery
                .add(RestrictionsFactoryUtil.eq("classPK", newsletterIssueId));
        return _newsletterArticleLocalService.dynamicQuery(dynamicQuery);
    }

    public String getAuthors(List<NewsletterArticle> newsletterArticles) {
        String result = "";
        List<String> authorChecked = new ArrayList<>();
        for(NewsletterArticle newsletterArticle : newsletterArticles) {
            if(!checkExist(newsletterArticle.getAuthor(), authorChecked)) {
                result += newsletterArticle.getAuthor() + ", ";
                authorChecked.add(newsletterArticle.getAuthor());
            }
        }
        return result.substring(0, result.length() - 2);
    }

    public boolean checkExist(String checkAuthor, List<String> authors) {
        for(String author : authors) {
            if(author.equals(checkAuthor)) {
                return true;
            }
        }
        return false;
    }

    @Reference
    private NewsletterIssueLocalService _newsletterIssueLocalService;

    @Reference
    private NewsletterArticleLocalService _newsletterArticleLocalService;

}
