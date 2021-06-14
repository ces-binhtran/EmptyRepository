/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.training.newsletter.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the NewsletterArticle service. Represents a row in the &quot;TS_NewsletterArticle&quot; database table, with each column mapped to a property of this class.
 *
 * @author Son Truong
 * @see NewsletterArticleModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.training.newsletter.model.impl.NewsletterArticleImpl"
)
@ProviderType
public interface NewsletterArticle
	extends NewsletterArticleModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.training.newsletter.model.impl.NewsletterArticleImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<NewsletterArticle, Long>
		NEWSLETTER_ARTICLE_ID_ACCESSOR =
			new Accessor<NewsletterArticle, Long>() {

				@Override
				public Long get(NewsletterArticle newsletterArticle) {
					return newsletterArticle.getNewsletterArticleId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<NewsletterArticle> getTypeClass() {
					return NewsletterArticle.class;
				}

			};

}