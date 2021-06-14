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

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.BatchIndexingHelper;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.liferay.training.newsletter.model.NewsletterIssue;
import com.liferay.training.newsletter.service.NewsletterIssueLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Son Truong
 */

@Component(
        immediate = true,
        property = "indexer.class.name=com.liferay.training.newsletter.model.NewsletterIssue",
        service = ModelIndexerWriterContributor.class
)
public class NewsletterIssueModelIndexerWriterContributor implements ModelIndexerWriterContributor<NewsletterIssue> {
    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable, ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        batchIndexingActionable.setPerformActionMethod((NewsletterIssue newsletterIssue) -> {
            Document document = modelIndexerWriterDocumentHelper.getDocument(newsletterIssue);
            batchIndexingActionable.addDocuments(document);
        });
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(newsletterIssueLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(NewsletterIssue newsletterIssue) {
        return newsletterIssue.getCompanyId();
    }

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory
            dynamicQueryBatchIndexingActionableFactory;

    @Reference
    protected NewsletterIssueLocalService newsletterIssueLocalService;

}
