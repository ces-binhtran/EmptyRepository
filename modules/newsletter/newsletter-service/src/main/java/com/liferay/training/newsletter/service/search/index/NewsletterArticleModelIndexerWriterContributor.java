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
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;
import com.liferay.training.newsletter.model.NewsletterArticle;
import com.liferay.training.newsletter.service.NewsletterArticleLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Son Truong
 */

@Component(
        immediate = true,
        property = "indexer.class.name=com.liferay.training.newsletter.model.NewsletterArticle",
        service = ModelIndexerWriterContributor.class
)
public class NewsletterArticleModelIndexerWriterContributor implements ModelIndexerWriterContributor<NewsletterArticle> {
    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable, ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
        batchIndexingActionable.setPerformActionMethod((NewsletterArticle newsletterArticle) -> {
            Document document = modelIndexerWriterDocumentHelper.getDocument(newsletterArticle);
            batchIndexingActionable.addDocuments(document);
        });
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {
        return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(newsletterArticleLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(NewsletterArticle newsletterArticle) {
        return newsletterArticle.getCompanyId();
    }

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory
            dynamicQueryBatchIndexingActionableFactory;

    @Reference
    protected NewsletterArticleLocalService newsletterArticleLocalService;

}
