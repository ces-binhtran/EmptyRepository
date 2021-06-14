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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.training.newsletter.service.http.NewsletterArticleServiceSoap}.
 *
 * @author Son Truong
 * @generated
 */
public class NewsletterArticleSoap implements Serializable {

	public static NewsletterArticleSoap toSoapModel(NewsletterArticle model) {
		NewsletterArticleSoap soapModel = new NewsletterArticleSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setNewsletterArticleId(model.getNewsletterArticleId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setResourcePrimKey(model.getResourcePrimKey());
		soapModel.setTitle(model.getTitle());
		soapModel.setAuthor(model.getAuthor());
		soapModel.setStatus(model.getStatus());
		soapModel.setOrder(model.getOrder());
		soapModel.setContent(model.getContent());

		return soapModel;
	}

	public static NewsletterArticleSoap[] toSoapModels(
		NewsletterArticle[] models) {

		NewsletterArticleSoap[] soapModels =
			new NewsletterArticleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NewsletterArticleSoap[][] toSoapModels(
		NewsletterArticle[][] models) {

		NewsletterArticleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new NewsletterArticleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NewsletterArticleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NewsletterArticleSoap[] toSoapModels(
		List<NewsletterArticle> models) {

		List<NewsletterArticleSoap> soapModels =
			new ArrayList<NewsletterArticleSoap>(models.size());

		for (NewsletterArticle model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NewsletterArticleSoap[soapModels.size()]);
	}

	public NewsletterArticleSoap() {
	}

	public long getPrimaryKey() {
		return _newsletterArticleId;
	}

	public void setPrimaryKey(long pk) {
		setNewsletterArticleId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getNewsletterArticleId() {
		return _newsletterArticleId;
	}

	public void setNewsletterArticleId(long newsletterArticleId) {
		_newsletterArticleId = newsletterArticleId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public long getResourcePrimKey() {
		return _resourcePrimKey;
	}

	public void setResourcePrimKey(long resourcePrimKey) {
		_resourcePrimKey = resourcePrimKey;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String author) {
		_author = author;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public int getOrder() {
		return _order;
	}

	public void setOrder(int order) {
		_order = order;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	private String _uuid;
	private long _newsletterArticleId;
	private long _companyId;
	private long _groupId;
	private long _classNameId;
	private long _classPK;
	private long _resourcePrimKey;
	private String _title;
	private String _author;
	private int _status;
	private int _order;
	private String _content;

}