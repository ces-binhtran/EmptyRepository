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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.training.newsletter.model.NewsletterArticle;
import com.liferay.training.newsletter.model.NewsletterIssue;
import com.liferay.training.newsletter.service.NewsletterArticleLocalService;
import com.liferay.training.newsletter.service.NewsletterIssueLocalService;
import com.liferay.training.newsletter.web.constants.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.http.HttpServletRequest;
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

    public List<NewsletterIssue> searchIssue(HttpServletRequest httpServletRequest, String keywords) throws PortalException {
        List<NewsletterIssue> newsletterIssues = new ArrayList<>();

        SearchContext articleSearchContext = SearchContextFactory.getInstance(httpServletRequest);
        articleSearchContext.setKeywords(keywords);
        articleSearchContext.setAttribute("paginationType", "more");
        articleSearchContext.setStart(0);
        articleSearchContext.setEnd(20);
        Indexer<NewsletterArticle> articleIndexer = IndexerRegistryUtil.getIndexer(NewsletterArticle.class);
        Hits articleHits = articleIndexer.search(articleSearchContext);

        SearchContext issueSearchContext = SearchContextFactory.getInstance(httpServletRequest);
        issueSearchContext.setKeywords(keywords);
        issueSearchContext.setAttribute("paginationType", "more");
        issueSearchContext.setStart(0);
        issueSearchContext.setEnd(20);
        Indexer<NewsletterIssue> issueIndexer = IndexerRegistryUtil.getIndexer(NewsletterIssue.class);
        Hits issueHits = issueIndexer.search(issueSearchContext);

        Document[] issueDocuments = issueHits.getDocs();
        for(Document document : issueDocuments) {
            NewsletterIssue newsletterIssue = _newsletterIssueLocalService.getNewsletterIssue(GetterUtil.getLong(document.get("issueId")));
            newsletterIssues.add(newsletterIssue);
        }

        Document[] articleDocuments = articleHits.getDocs();
        for(Document document : articleDocuments) {
            NewsletterIssue newsletterIssue = _newsletterIssueLocalService.getNewsletterIssue(GetterUtil.getLong(document.get("classPK")));
            if(!isExist(newsletterIssues, newsletterIssue)) {
                newsletterIssues.add(newsletterIssue);
            }
        }
        return newsletterIssues;

    }

    public boolean isExist(List<NewsletterIssue> newsletterIssues, NewsletterIssue newsletterIssue) {
        for(NewsletterIssue newsletterIssueElement : newsletterIssues) {
            if(newsletterIssue.getNewsletterIssueId() == newsletterIssueElement.getNewsletterIssueId()) {
                return true;
            }
        }
        return false;
    }

    public List<NewsletterIssue> getNewsletterIssueByMonthAndYear(int year, String month, int start, int end) {

        return _newsletterIssueLocalService.dynamicQuery(createDynamicQuery(year, month), start, end);
    }

    public DynamicQuery createDynamicQuery(int year, String month) {
        Date startDate = null;
        Date endDate = null;
        if(!month.equals("All")) {
            startDate = new Date(year, Constants.months.indexOf(month) - 1, 0);
            endDate = new Date(year, Constants.months.indexOf(month), 0);
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
        return dynamicQuery;
    }

    public long count(int year, String month) {
        return _newsletterIssueLocalService.dynamicQueryCount(createDynamicQuery(year, month));
    }

    public List<NewsletterArticle> fetchByClassPK(long newsletterIssueId) {
        DynamicQuery dynamicQuery = _newsletterArticleLocalService.dynamicQuery();
        dynamicQuery
                .add(RestrictionsFactoryUtil.eq("classPK", newsletterIssueId));
        return _newsletterArticleLocalService.dynamicQuery(dynamicQuery);
    }

    public String getAuthors(List<NewsletterArticle> newsletterArticles) {
        if(newsletterArticles.size() == 0) return "";
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

    public List<NewsletterIssue> search(SearchContext searchContext) throws SearchException {
        Indexer issueIndexer = IndexerRegistryUtil.getIndexer(NewsletterIssue.class);
        Indexer articleIndexer = IndexerRegistryUtil.getIndexer(NewsletterArticle.class);
        Hits articleHits = articleIndexer.search(searchContext);
        Hits issueHits = issueIndexer.search(searchContext);
        return null;
    }

    @Reference
    private NewsletterIssueLocalService _newsletterIssueLocalService;

    @Reference
    private NewsletterArticleLocalService _newsletterArticleLocalService;

}
