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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link NewsletterArticle}.
 * </p>
 *
 * @author Son Truong
 * @see NewsletterArticle
 * @generated
 */
public class NewsletterArticleWrapper
	extends BaseModelWrapper<NewsletterArticle>
	implements ModelWrapper<NewsletterArticle>, NewsletterArticle {

	public NewsletterArticleWrapper(NewsletterArticle newsletterArticle) {
		super(newsletterArticle);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("newsletterArticleId", getNewsletterArticleId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("resourcePrimKey", getResourcePrimKey());
		attributes.put("title", getTitle());
		attributes.put("author", getAuthor());
		attributes.put("status", getStatus());
		attributes.put("order", getOrder());
		attributes.put("content", getContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long newsletterArticleId = (Long)attributes.get("newsletterArticleId");

		if (newsletterArticleId != null) {
			setNewsletterArticleId(newsletterArticleId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		Long resourcePrimKey = (Long)attributes.get("resourcePrimKey");

		if (resourcePrimKey != null) {
			setResourcePrimKey(resourcePrimKey);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String author = (String)attributes.get("author");

		if (author != null) {
			setAuthor(author);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}
	}

	/**
	 * Returns the author of this newsletter article.
	 *
	 * @return the author of this newsletter article
	 */
	@Override
	public String getAuthor() {
		return model.getAuthor();
	}

	/**
	 * Returns the fully qualified class name of this newsletter article.
	 *
	 * @return the fully qualified class name of this newsletter article
	 */
	@Override
	public String getClassName() {
		return model.getClassName();
	}

	/**
	 * Returns the class name ID of this newsletter article.
	 *
	 * @return the class name ID of this newsletter article
	 */
	@Override
	public long getClassNameId() {
		return model.getClassNameId();
	}

	/**
	 * Returns the class pk of this newsletter article.
	 *
	 * @return the class pk of this newsletter article
	 */
	@Override
	public long getClassPK() {
		return model.getClassPK();
	}

	/**
	 * Returns the company ID of this newsletter article.
	 *
	 * @return the company ID of this newsletter article
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the content of this newsletter article.
	 *
	 * @return the content of this newsletter article
	 */
	@Override
	public String getContent() {
		return model.getContent();
	}

	/**
	 * Returns the group ID of this newsletter article.
	 *
	 * @return the group ID of this newsletter article
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the newsletter article ID of this newsletter article.
	 *
	 * @return the newsletter article ID of this newsletter article
	 */
	@Override
	public long getNewsletterArticleId() {
		return model.getNewsletterArticleId();
	}

	/**
	 * Returns the order of this newsletter article.
	 *
	 * @return the order of this newsletter article
	 */
	@Override
	public int getOrder() {
		return model.getOrder();
	}

	/**
	 * Returns the primary key of this newsletter article.
	 *
	 * @return the primary key of this newsletter article
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the resource prim key of this newsletter article.
	 *
	 * @return the resource prim key of this newsletter article
	 */
	@Override
	public long getResourcePrimKey() {
		return model.getResourcePrimKey();
	}

	/**
	 * Returns the status of this newsletter article.
	 *
	 * @return the status of this newsletter article
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the title of this newsletter article.
	 *
	 * @return the title of this newsletter article
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the uuid of this newsletter article.
	 *
	 * @return the uuid of this newsletter article
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
	 * Sets the author of this newsletter article.
	 *
	 * @param author the author of this newsletter article
	 */
	@Override
	public void setAuthor(String author) {
		model.setAuthor(author);
	}

	@Override
	public void setClassName(String className) {
		model.setClassName(className);
	}

	/**
	 * Sets the class name ID of this newsletter article.
	 *
	 * @param classNameId the class name ID of this newsletter article
	 */
	@Override
	public void setClassNameId(long classNameId) {
		model.setClassNameId(classNameId);
	}

	/**
	 * Sets the class pk of this newsletter article.
	 *
	 * @param classPK the class pk of this newsletter article
	 */
	@Override
	public void setClassPK(long classPK) {
		model.setClassPK(classPK);
	}

	/**
	 * Sets the company ID of this newsletter article.
	 *
	 * @param companyId the company ID of this newsletter article
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the content of this newsletter article.
	 *
	 * @param content the content of this newsletter article
	 */
	@Override
	public void setContent(String content) {
		model.setContent(content);
	}

	/**
	 * Sets the group ID of this newsletter article.
	 *
	 * @param groupId the group ID of this newsletter article
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the newsletter article ID of this newsletter article.
	 *
	 * @param newsletterArticleId the newsletter article ID of this newsletter article
	 */
	@Override
	public void setNewsletterArticleId(long newsletterArticleId) {
		model.setNewsletterArticleId(newsletterArticleId);
	}

	/**
	 * Sets the order of this newsletter article.
	 *
	 * @param order the order of this newsletter article
	 */
	@Override
	public void setOrder(int order) {
		model.setOrder(order);
	}

	/**
	 * Sets the primary key of this newsletter article.
	 *
	 * @param primaryKey the primary key of this newsletter article
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the resource prim key of this newsletter article.
	 *
	 * @param resourcePrimKey the resource prim key of this newsletter article
	 */
	@Override
	public void setResourcePrimKey(long resourcePrimKey) {
		model.setResourcePrimKey(resourcePrimKey);
	}

	/**
	 * Sets the status of this newsletter article.
	 *
	 * @param status the status of this newsletter article
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the title of this newsletter article.
	 *
	 * @param title the title of this newsletter article
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the uuid of this newsletter article.
	 *
	 * @param uuid the uuid of this newsletter article
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected NewsletterArticleWrapper wrap(
		NewsletterArticle newsletterArticle) {

		return new NewsletterArticleWrapper(newsletterArticle);
	}

}