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

package com.liferay.training.newsletter.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.training.newsletter.model.NewsletterArticle;
import com.liferay.training.newsletter.service.base.NewsletterArticleLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the newsletter article local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.training.newsletter.service.NewsletterArticleLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Son Truong
 * @see NewsletterArticleLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.training.newsletter.model.NewsletterArticle",
	service = AopService.class
)
public class NewsletterArticleLocalServiceImpl
	extends NewsletterArticleLocalServiceBaseImpl {

	public NewsletterArticle addNewsletterArticle(long companyId, long groupId, long classNameId, long classPK, long resourcePrimKey, String title, String author, int status, int order, String content) {
		long newsletterArticleId = counterLocalService.increment(NewsletterArticle.class.getName());
		NewsletterArticle newsletterArticle = newsletterArticleLocalService.createNewsletterArticle(newsletterArticleId);
		newsletterArticle.setCompanyId(companyId);
		newsletterArticle.setGroupId(groupId);
		newsletterArticle.setClassNameId(classNameId);
		newsletterArticle.setClassPK(classPK);
		newsletterArticle.setResourcePrimKey(resourcePrimKey);
		newsletterArticle.setTitle(title);
		newsletterArticle.setAuthor(author);
		newsletterArticle.setStatus(status);
		newsletterArticle.setOrder(order);
		newsletterArticle.setContent(content);

		return super.addNewsletterArticle(newsletterArticle);
	}

	public NewsletterArticle updateNewsletterArticle(long companyId, long groupId, long newsletterArticleId,long classNameId, long classPK, long resourcePrimKey, String title, String author, int status, int order, String content) throws PortalException {
		NewsletterArticle newsletterArticle = getNewsletterArticle(newsletterArticleId);
		newsletterArticle.setCompanyId(companyId);
		newsletterArticle.setGroupId(groupId);
		newsletterArticle.setClassNameId(classNameId);
		newsletterArticle.setClassPK(classPK);
		newsletterArticle.setResourcePrimKey(resourcePrimKey);
		newsletterArticle.setTitle(title);
		newsletterArticle.setAuthor(author);
		newsletterArticle.setStatus(status);
		newsletterArticle.setOrder(order);
		newsletterArticle.setContent(content);

		return super.updateNewsletterArticle(newsletterArticle);
	}

	public NewsletterArticle findByResourcePrimKey(long resourcePrimKey) throws PortalException {
		return newsletterArticlePersistence.findByresourcePrimKey(resourcePrimKey);
	}
}