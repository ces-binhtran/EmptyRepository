package com.liferay.training.newsletter.service.search.result;
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

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

/**
 * @author Son Truong
 */

@Component(
        immediate = true,
        property = "indexer.class.name=com.liferay.training.newsletter.model.NewsletterIssue",
        service = ModelSummaryContributor.class
)
public class NewsletterIssueModelSummaryContributor implements ModelSummaryContributor {
    @Override
    public Summary getSummary(Document document, Locale locale, String snippet) {
        String languageId = LocaleUtil.toLanguageId(locale);
        return createSummary(
                document,
                LocalizationUtil.getLocalizedName(Field.DESCRIPTION, languageId),
                LocalizationUtil.getLocalizedName(Field.TITLE, languageId));
    }

    private Summary createSummary(Document document, String descriptionField, String titleField) {
        String prefix = Field.SNIPPET + StringPool.UNDERLINE;
        Summary summary = new Summary(
                document.get(prefix + titleField, titleField),
                document.get(prefix + descriptionField, descriptionField));

        summary.setMaxContentLength(200);

        return summary;
    }

}
