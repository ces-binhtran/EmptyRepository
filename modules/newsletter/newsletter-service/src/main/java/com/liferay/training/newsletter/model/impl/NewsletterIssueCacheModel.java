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

package com.liferay.training.newsletter.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.training.newsletter.model.NewsletterIssue;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing NewsletterIssue in entity cache.
 *
 * @author Son Truong
 * @generated
 */
public class NewsletterIssueCacheModel
	implements CacheModel<NewsletterIssue>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof NewsletterIssueCacheModel)) {
			return false;
		}

		NewsletterIssueCacheModel newsletterIssueCacheModel =
			(NewsletterIssueCacheModel)object;

		if (newsletterIssueId == newsletterIssueCacheModel.newsletterIssueId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, newsletterIssueId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", newsletterIssueId=");
		sb.append(newsletterIssueId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", issueNumber=");
		sb.append(issueNumber);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", issueDate=");
		sb.append(issueDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", resourcePrimKey=");
		sb.append(resourcePrimKey);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public NewsletterIssue toEntityModel() {
		NewsletterIssueImpl newsletterIssueImpl = new NewsletterIssueImpl();

		if (uuid == null) {
			newsletterIssueImpl.setUuid("");
		}
		else {
			newsletterIssueImpl.setUuid(uuid);
		}

		newsletterIssueImpl.setNewsletterIssueId(newsletterIssueId);
		newsletterIssueImpl.setCompanyId(companyId);
		newsletterIssueImpl.setGroupId(groupId);
		newsletterIssueImpl.setIssueNumber(issueNumber);

		if (title == null) {
			newsletterIssueImpl.setTitle("");
		}
		else {
			newsletterIssueImpl.setTitle(title);
		}

		if (description == null) {
			newsletterIssueImpl.setDescription("");
		}
		else {
			newsletterIssueImpl.setDescription(description);
		}

		if (issueDate == Long.MIN_VALUE) {
			newsletterIssueImpl.setIssueDate(null);
		}
		else {
			newsletterIssueImpl.setIssueDate(new Date(issueDate));
		}

		newsletterIssueImpl.setStatus(status);
		newsletterIssueImpl.setResourcePrimKey(resourcePrimKey);

		newsletterIssueImpl.resetOriginalValues();

		return newsletterIssueImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		newsletterIssueId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		issueNumber = objectInput.readInt();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		issueDate = objectInput.readLong();

		status = objectInput.readInt();

		resourcePrimKey = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(newsletterIssueId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeInt(issueNumber);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(issueDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(resourcePrimKey);
	}

	public String uuid;
	public long newsletterIssueId;
	public long companyId;
	public long groupId;
	public int issueNumber;
	public String title;
	public String description;
	public long issueDate;
	public int status;
	public long resourcePrimKey;

}