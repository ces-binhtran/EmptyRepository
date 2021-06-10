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
import com.liferay.training.newsletter.model.NewsletterIssue;
import com.liferay.training.newsletter.service.base.NewsletterIssueLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.Date;

/**
 * The implementation of the newsletter issue local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.training.newsletter.service.NewsletterIssueLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Son Truong
 * @see NewsletterIssueLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.training.newsletter.model.NewsletterIssue",
	service = AopService.class
)
public class NewsletterIssueLocalServiceImpl
	extends NewsletterIssueLocalServiceBaseImpl {

	public NewsletterIssue addNewsletterIssue(long companyId, long groupId, int issueNumber, String title, String description, Date issueDate, int status, long resourcePrimKey) {
		long newsletterIssueId = counterLocalService.increment(NewsletterIssue.class.getName());

		NewsletterIssue newsletterIssue = createNewsletterIssue(newsletterIssueId);
		newsletterIssue.setCompanyId(companyId);
		newsletterIssue.setGroupId(groupId);
		newsletterIssue.setIssueNumber(issueNumber);
		newsletterIssue.setTitle(title);
		newsletterIssue.setDescription(description);
		newsletterIssue.setIssueDate(issueDate);
		newsletterIssue.setStatus(status);
		newsletterIssue.setResourcePrimKey(resourcePrimKey);

		return super.addNewsletterIssue(newsletterIssue);
	}

	public NewsletterIssue updateNewsletterIssue(long companyId, long groupId, long newsletterIssueId, int issueNumber, String title, String description, Date issueDate, int status, long resourcePrimKey) throws PortalException {

		NewsletterIssue newsletterIssue = getNewsletterIssue(newsletterIssueId);
		newsletterIssue.setCompanyId(companyId);
		newsletterIssue.setGroupId(groupId);
		newsletterIssue.setIssueNumber(issueNumber);
		newsletterIssue.setTitle(title);
		newsletterIssue.setDescription(description);
		newsletterIssue.setIssueDate(issueDate);
		newsletterIssue.setStatus(status);
		newsletterIssue.setResourcePrimKey(resourcePrimKey);

		newsletterIssue = super.updateNewsletterIssue(newsletterIssue);
		return newsletterIssue;
	}

	public NewsletterIssue findByResourcePrimKey(long resourcePrimKey) {
		return newsletterIssuePersistence.fetchByresourcePrimKey(resourcePrimKey);
	}
}