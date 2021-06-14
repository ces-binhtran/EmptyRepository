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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.training.newsletter.service.http.NewsletterIssueServiceSoap}.
 *
 * @author Son Truong
 * @generated
 */
public class NewsletterIssueSoap implements Serializable {

	public static NewsletterIssueSoap toSoapModel(NewsletterIssue model) {
		NewsletterIssueSoap soapModel = new NewsletterIssueSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setNewsletterIssueId(model.getNewsletterIssueId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setIssueNumber(model.getIssueNumber());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setIssueDate(model.getIssueDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setResourcePrimKey(model.getResourcePrimKey());

		return soapModel;
	}

	public static NewsletterIssueSoap[] toSoapModels(NewsletterIssue[] models) {
		NewsletterIssueSoap[] soapModels =
			new NewsletterIssueSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NewsletterIssueSoap[][] toSoapModels(
		NewsletterIssue[][] models) {

		NewsletterIssueSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new NewsletterIssueSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NewsletterIssueSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NewsletterIssueSoap[] toSoapModels(
		List<NewsletterIssue> models) {

		List<NewsletterIssueSoap> soapModels =
			new ArrayList<NewsletterIssueSoap>(models.size());

		for (NewsletterIssue model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NewsletterIssueSoap[soapModels.size()]);
	}

	public NewsletterIssueSoap() {
	}

	public long getPrimaryKey() {
		return _newsletterIssueId;
	}

	public void setPrimaryKey(long pk) {
		setNewsletterIssueId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getNewsletterIssueId() {
		return _newsletterIssueId;
	}

	public void setNewsletterIssueId(long newsletterIssueId) {
		_newsletterIssueId = newsletterIssueId;
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

	public int getIssueNumber() {
		return _issueNumber;
	}

	public void setIssueNumber(int issueNumber) {
		_issueNumber = issueNumber;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getIssueDate() {
		return _issueDate;
	}

	public void setIssueDate(Date issueDate) {
		_issueDate = issueDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getResourcePrimKey() {
		return _resourcePrimKey;
	}

	public void setResourcePrimKey(long resourcePrimKey) {
		_resourcePrimKey = resourcePrimKey;
	}

	private String _uuid;
	private long _newsletterIssueId;
	private long _companyId;
	private long _groupId;
	private int _issueNumber;
	private String _title;
	private String _description;
	private Date _issueDate;
	private int _status;
	private long _resourcePrimKey;

}