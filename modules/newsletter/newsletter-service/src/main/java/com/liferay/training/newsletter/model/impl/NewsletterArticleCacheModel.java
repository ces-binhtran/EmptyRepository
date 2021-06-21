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
import com.liferay.training.newsletter.model.NewsletterArticle;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing NewsletterArticle in entity cache.
 *
 * @author Son Truong
 * @generated
 */
public class NewsletterArticleCacheModel
	implements CacheModel<NewsletterArticle>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof NewsletterArticleCacheModel)) {
			return false;
		}

		NewsletterArticleCacheModel newsletterArticleCacheModel =
			(NewsletterArticleCacheModel)object;

		if (newsletterArticleId ==
				newsletterArticleCacheModel.newsletterArticleId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, newsletterArticleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", newsletterArticleId=");
		sb.append(newsletterArticleId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", resourcePrimKey=");
		sb.append(resourcePrimKey);
		sb.append(", title=");
		sb.append(title);
		sb.append(", author=");
		sb.append(author);
		sb.append(", status=");
		sb.append(status);
		sb.append(", order=");
		sb.append(order);
		sb.append(", content=");
		sb.append(content);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public NewsletterArticle toEntityModel() {
		NewsletterArticleImpl newsletterArticleImpl =
			new NewsletterArticleImpl();

		if (uuid == null) {
			newsletterArticleImpl.setUuid("");
		}
		else {
			newsletterArticleImpl.setUuid(uuid);
		}

		newsletterArticleImpl.setNewsletterArticleId(newsletterArticleId);
		newsletterArticleImpl.setCompanyId(companyId);
		newsletterArticleImpl.setGroupId(groupId);
		newsletterArticleImpl.setClassNameId(classNameId);
		newsletterArticleImpl.setClassPK(classPK);
		newsletterArticleImpl.setResourcePrimKey(resourcePrimKey);

		if (title == null) {
			newsletterArticleImpl.setTitle("");
		}
		else {
			newsletterArticleImpl.setTitle(title);
		}

		if (author == null) {
			newsletterArticleImpl.setAuthor("");
		}
		else {
			newsletterArticleImpl.setAuthor(author);
		}

		newsletterArticleImpl.setStatus(status);
		newsletterArticleImpl.setOrder(order);

		if (content == null) {
			newsletterArticleImpl.setContent("");
		}
		else {
			newsletterArticleImpl.setContent(content);
		}

		newsletterArticleImpl.resetOriginalValues();

		return newsletterArticleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		newsletterArticleId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		classNameId = objectInput.readLong();

		classPK = objectInput.readLong();

		resourcePrimKey = objectInput.readLong();
		title = objectInput.readUTF();
		author = objectInput.readUTF();

		status = objectInput.readInt();

		order = objectInput.readInt();
		content = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(newsletterArticleId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(classNameId);

		objectOutput.writeLong(classPK);

		objectOutput.writeLong(resourcePrimKey);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (author == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(author);
		}

		objectOutput.writeInt(status);

		objectOutput.writeInt(order);

		if (content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content);
		}
	}

	public String uuid;
	public long newsletterArticleId;
	public long companyId;
	public long groupId;
	public long classNameId;
	public long classPK;
	public long resourcePrimKey;
	public String title;
	public String author;
	public int status;
	public int order;
	public String content;

}