package com.liferay.training.newsletter.service.search.index;
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

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.liferay.training.newsletter.model.NewsletterIssue;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

/**
 * @author Son Truong
 */

@Component(
        immediate = true,
        property = "indexer.class.name=com.liferay.training.newsletter.model.NewsletterIssue",
        service = ModelDocumentContributor.class
)
public class NewsletterIssueModelDocumentContributor implements ModelDocumentContributor<NewsletterIssue> {
    @Override
    public void contribute(Document document, NewsletterIssue newsletterIssue) {

        document.addNumber("issueId", newsletterIssue.getNewsletterIssueId());
        document.addText(Field.DESCRIPTION, newsletterIssue.getDescription());
        document.addText(Field.TITLE, newsletterIssue.getTitle());

        document.addNumber(Field.SCOPE_GROUP_ID, newsletterIssue.getGroupId());
        document.addNumber(Field.GROUP_ID, newsletterIssue.getGroupId());

        for (Locale locale : LanguageUtil.getAvailableLocales(
                newsletterIssue.getGroupId())) {

            String languageId = LocaleUtil.toLanguageId(locale);

            document.addText(
                    LocalizationUtil.getLocalizedName(
                            Field.DESCRIPTION, languageId),
                    newsletterIssue.getDescription());
            document.addText(
                    LocalizationUtil.getLocalizedName(Field.TITLE, languageId),
                    newsletterIssue.getTitle());
        }
    }

}
