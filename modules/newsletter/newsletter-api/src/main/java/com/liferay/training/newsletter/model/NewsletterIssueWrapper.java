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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link NewsletterIssue}.
 * </p>
 *
 * @author Son Truong
 * @see NewsletterIssue
 * @generated
 */
public class NewsletterIssueWrapper
	extends BaseModelWrapper<NewsletterIssue>
	implements ModelWrapper<NewsletterIssue>, NewsletterIssue {

	public NewsletterIssueWrapper(NewsletterIssue newsletterIssue) {
		super(newsletterIssue);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("newsletterIssueId", getNewsletterIssueId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("issueNumber", getIssueNumber());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("issueDate", getIssueDate());
		attributes.put("status", getStatus());
		attributes.put("resourcePrimKey", getResourcePrimKey());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long newsletterIssueId = (Long)attributes.get("newsletterIssueId");

		if (newsletterIssueId != null) {
			setNewsletterIssueId(newsletterIssueId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Integer issueNumber = (Integer)attributes.get("issueNumber");

		if (issueNumber != null) {
			setIssueNumber(issueNumber);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date issueDate = (Date)attributes.get("issueDate");

		if (issueDate != null) {
			setIssueDate(issueDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long resourcePrimKey = (Long)attributes.get("resourcePrimKey");

		if (resourcePrimKey != null) {
			setResourcePrimKey(resourcePrimKey);
		}
	}

	/**
	 * Returns the company ID of this newsletter issue.
	 *
	 * @return the company ID of this newsletter issue
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the description of this newsletter issue.
	 *
	 * @return the description of this newsletter issue
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this newsletter issue.
	 *
	 * @return the group ID of this newsletter issue
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the issue date of this newsletter issue.
	 *
	 * @return the issue date of this newsletter issue
	 */
	@Override
	public Date getIssueDate() {
		return model.getIssueDate();
	}

	/**
	 * Returns the issue number of this newsletter issue.
	 *
	 * @return the issue number of this newsletter issue
	 */
	@Override
	public int getIssueNumber() {
		return model.getIssueNumber();
	}

	/**
	 * Returns the newsletter issue ID of this newsletter issue.
	 *
	 * @return the newsletter issue ID of this newsletter issue
	 */
	@Override
	public long getNewsletterIssueId() {
		return model.getNewsletterIssueId();
	}

	/**
	 * Returns the primary key of this newsletter issue.
	 *
	 * @return the primary key of this newsletter issue
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the resource prim key of this newsletter issue.
	 *
	 * @return the resource prim key of this newsletter issue
	 */
	@Override
	public long getResourcePrimKey() {
		return model.getResourcePrimKey();
	}

	/**
	 * Returns the status of this newsletter issue.
	 *
	 * @return the status of this newsletter issue
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the title of this newsletter issue.
	 *
	 * @return the title of this newsletter issue
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the uuid of this newsletter issue.
	 *
	 * @return the uuid of this newsletter issue
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public boolean isResourceMain() {
		return model.isResourceMain();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this newsletter issue.
	 *
	 * @param companyId the company ID of this newsletter issue
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the description of this newsletter issue.
	 *
	 * @param description the description of this newsletter issue
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this newsletter issue.
	 *
	 * @param groupId the group ID of this newsletter issue
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the issue date of this newsletter issue.
	 *
	 * @param issueDate the issue date of this newsletter issue
	 */
	@Override
	public void setIssueDate(Date issueDate) {
		model.setIssueDate(issueDate);
	}

	/**
	 * Sets the issue number of this newsletter issue.
	 *
	 * @param issueNumber the issue number of this newsletter issue
	 */
	@Override
	public void setIssueNumber(int issueNumber) {
		model.setIssueNumber(issueNumber);
	}

	/**
	 * Sets the newsletter issue ID of this newsletter issue.
	 *
	 * @param newsletterIssueId the newsletter issue ID of this newsletter issue
	 */
	@Override
	public void setNewsletterIssueId(long newsletterIssueId) {
		model.setNewsletterIssueId(newsletterIssueId);
	}

	/**
	 * Sets the primary key of this newsletter issue.
	 *
	 * @param primaryKey the primary key of this newsletter issue
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the resource prim key of this newsletter issue.
	 *
	 * @param resourcePrimKey the resource prim key of this newsletter issue
	 */
	@Override
	public void setResourcePrimKey(long resourcePrimKey) {
		model.setResourcePrimKey(resourcePrimKey);
	}

	/**
	 * Sets the status of this newsletter issue.
	 *
	 * @param status the status of this newsletter issue
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the title of this newsletter issue.
	 *
	 * @param title the title of this newsletter issue
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the uuid of this newsletter issue.
	 *
	 * @param uuid the uuid of this newsletter issue
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected NewsletterIssueWrapper wrap(NewsletterIssue newsletterIssue) {
		return new NewsletterIssueWrapper(newsletterIssue);
	}

}