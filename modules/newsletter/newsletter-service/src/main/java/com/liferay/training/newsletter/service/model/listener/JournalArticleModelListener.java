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

package com.liferay.training.newsletter.service.model.listener;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.storage.Fields;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.journal.util.JournalConverter;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.training.newsletter.constant.NewsletterConstants;
import com.liferay.training.newsletter.model.NewsletterArticle;
import com.liferay.training.newsletter.model.NewsletterIssue;
import com.liferay.training.newsletter.service.NewsletterArticleLocalService;
import com.liferay.training.newsletter.service.NewsletterIssueLocalService;
import com.liferay.training.newsletter.util.ConvertUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Son Truong
 */

@Component(
        immediate = true,
        property = {},
        service = ModelListener.class
)
public class JournalArticleModelListener extends BaseModelListener<JournalArticle> {

    @Override
    public void onAfterCreate(JournalArticle model) throws ModelListenerException {
        try {
            DDMStructure ddmStructure = model.getDDMStructure();
            if(ddmStructure.getNameCurrentValue().equals(NewsletterConstants.NEWSLETTER_ISSUE)) {
                NewsletterIssue newsletterIssue = _newsletterIssueLocalService.findByResourcePrimKey(model.getResourcePrimKey());
                if (Validator.isNotNull(newsletterIssue)) {
                    update(model);
                } else {
                    add(model);
                }
            }
            if(ddmStructure.getNameCurrentValue().equals(NewsletterConstants.NEWSLETTER_ARTICLE)) {
                NewsletterArticle newsletterArticle = _newsletterArticleLocalService.findByResourcePrimKey(model.getResourcePrimKey());
                if (Validator.isNotNull(newsletterArticle)) {
                    update(model);
                } else {
                    add(model);
                }
            }

        } catch (PortalException e) {
            e.printStackTrace();
        }
        super.onAfterCreate(model);
    }


    @Override
    public void onAfterUpdate(JournalArticle model) throws ModelListenerException {

        try {
            update(model);
        } catch (PortalException e) {
            e.printStackTrace();
        }
        super.onAfterUpdate(model);
    }

    @Override
    public void onAfterRemove(JournalArticle model) throws ModelListenerException {
        try {
            delete(model);
        } catch (PortalException e) {
            e.printStackTrace();
        }
        super.onAfterRemove(model);
    }

    public void delete(JournalArticle journalArticle) throws PortalException {
        DDMStructure ddmStructure = journalArticle.getDDMStructure();
        switch (ddmStructure.getNameCurrentValue()) {
            case NewsletterConstants.NEWSLETTER_ISSUE: {
                NewsletterIssue newsletterIssues = _newsletterIssueLocalService.findByResourcePrimKey(journalArticle.getResourcePrimKey());
                if(Validator.isNotNull(newsletterIssues)) {
                    _newsletterIssueLocalService.deleteNewsletterIssue(newsletterIssues.getNewsletterIssueId());
                }
                break;
            }
            case NewsletterConstants.NEWSLETTER_ARTICLE: {
                NewsletterArticle newsletterArticles = _newsletterArticleLocalService.findByResourcePrimKey(journalArticle.getResourcePrimKey());
                if(Validator.isNotNull(newsletterArticles)) {
                    _newsletterArticleLocalService.deleteNewsletterArticle(newsletterArticles.getNewsletterArticleId());
                }
                break;
            }
            default: break;
        }
    }

    public void add(JournalArticle journalArticle) throws PortalException {
        DDMStructure ddmStructure = journalArticle.getDDMStructure();
        Fields fields = _journalConverter.getDDMFields(ddmStructure, journalArticle.getContent());
        switch (ddmStructure.getNameCurrentValue()) {
            case NewsletterConstants.NEWSLETTER_ISSUE: {
                NewsletterIssue newsletterIssue = _newsletterIssueLocalService.addNewsletterIssue(journalArticle.getCompanyId(), journalArticle.getGroupId() ,(Integer) fields.get("issueNumber").getValue(), (String) fields.get("title").getValue(),
                        (String) fields.get("description").getValue(), ConvertUtil.convertDate((String) fields.get("issueDate").getValue()),
                        journalArticle.getStatus(), journalArticle.getResourcePrimKey());
                break;
            }
            case NewsletterConstants.NEWSLETTER_ARTICLE: {
                JSONObject myObject = JSONFactoryUtil.createJSONObject((String) fields.get("newsletterIssue").getValue());
                JournalArticle newsletterIssue = journalArticleLocalService.fetchJournalArticleByUuidAndGroupId(myObject.getString("uuid"), myObject.getLong("groupId"));
                NewsletterIssue newsletterIssues = _newsletterIssueLocalService.findByResourcePrimKey(newsletterIssue.getResourcePrimKey());
                NewsletterArticle newsletterArticle = _newsletterArticleLocalService.addNewsletterArticle(journalArticle.getCompanyId(), journalArticle.getGroupId(), PortalUtil.getClassNameId(NewsletterIssue.class.getName()), newsletterIssues.getNewsletterIssueId(), journalArticle.getResourcePrimKey(),
                        (String) fields.get("title").getValue(), (String) fields.get("author").getValue(), journalArticle.getStatus(), (Integer) fields.get("order").getValue(), (String) fields.get("content").getValue());
                break;
            }
            default: break;
        }
    }

    public void update(JournalArticle journalArticle) throws PortalException {
        DDMStructure ddmStructure = journalArticle.getDDMStructure();
        Fields fields = _journalConverter.getDDMFields(ddmStructure, journalArticle.getContent());
        switch (ddmStructure.getNameCurrentValue()) {
            case NewsletterConstants.NEWSLETTER_ISSUE: {
                NewsletterIssue newsletterIssues = _newsletterIssueLocalService.findByResourcePrimKey(journalArticle.getResourcePrimKey());
                NewsletterIssue newsletterIssue = _newsletterIssueLocalService.updateNewsletterIssue(journalArticle.getCompanyId(), journalArticle.getGroupId(), newsletterIssues.getNewsletterIssueId(), (Integer) fields.get("issueNumber").getValue(), (String) fields.get("title").getValue(),
                        (String) fields.get("description").getValue(), ConvertUtil.convertDate((String) fields.get("issueDate").getValue()) , journalArticle.getStatus(), journalArticle.getResourcePrimKey());
                Indexer<NewsletterIssue> indexer = IndexerRegistryUtil.nullSafeGetIndexer(NewsletterIssue.class);
                indexer.reindex(newsletterIssue);
                break;
            }
            case NewsletterConstants.NEWSLETTER_ARTICLE: {
                JSONObject myObject = JSONFactoryUtil.createJSONObject((String) fields.get("newsletterIssue").getValue());
                JournalArticle newsletterIssue = journalArticleLocalService.fetchJournalArticleByUuidAndGroupId(myObject.getString("uuid"), myObject.getLong("groupId"));
                NewsletterIssue newsletterIssues = _newsletterIssueLocalService.findByResourcePrimKey(newsletterIssue.getResourcePrimKey());
                NewsletterArticle newsletterArticles = _newsletterArticleLocalService.findByResourcePrimKey(journalArticle.getResourcePrimKey());
                _newsletterArticleLocalService.updateNewsletterArticle(journalArticle.getCompanyId(), journalArticle.getGroupId(), newsletterArticles.getNewsletterArticleId(), PortalUtil.getClassNameId(NewsletterIssue.class.getName()), newsletterIssues.getNewsletterIssueId(), journalArticle.getResourcePrimKey(),
                        (String) fields.get("title").getValue(), (String) fields.get("author").getValue(), journalArticle.getStatus(), (Integer) fields.get("order").getValue(), (String) fields.get("content").getValue());
                break;
            }
            default: break;
        }
    }


    @Reference
    private JournalConverter _journalConverter;

    @Reference
    private JournalArticleLocalService journalArticleLocalService;

    @Reference
    private NewsletterIssueLocalService _newsletterIssueLocalService;

    @Reference
    private NewsletterArticleLocalService _newsletterArticleLocalService;
}
