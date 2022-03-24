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

package com.liferay.training.amf.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.training.amf.model.AmfAuditEvent;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AmfAuditEvent in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AmfAuditEventCacheModel
	implements CacheModel<AmfAuditEvent>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AmfAuditEventCacheModel)) {
			return false;
		}

		AmfAuditEventCacheModel amfAuditEventCacheModel =
			(AmfAuditEventCacheModel)object;

		if (amfAuditEventId == amfAuditEventCacheModel.amfAuditEventId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, amfAuditEventId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{amfAuditEventId=");
		sb.append(amfAuditEventId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", eventType=");
		sb.append(eventType);
		sb.append(", ipAddress=");
		sb.append(ipAddress);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AmfAuditEvent toEntityModel() {
		AmfAuditEventImpl amfAuditEventImpl = new AmfAuditEventImpl();

		amfAuditEventImpl.setAmfAuditEventId(amfAuditEventId);
		amfAuditEventImpl.setUserId(userId);

		if (userName == null) {
			amfAuditEventImpl.setUserName("");
		}
		else {
			amfAuditEventImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			amfAuditEventImpl.setCreateDate(null);
		}
		else {
			amfAuditEventImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			amfAuditEventImpl.setModifiedDate(null);
		}
		else {
			amfAuditEventImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (eventType == null) {
			amfAuditEventImpl.setEventType("");
		}
		else {
			amfAuditEventImpl.setEventType(eventType);
		}

		if (ipAddress == null) {
			amfAuditEventImpl.setIpAddress("");
		}
		else {
			amfAuditEventImpl.setIpAddress(ipAddress);
		}

		amfAuditEventImpl.setGroupId(groupId);
		amfAuditEventImpl.setCompanyId(companyId);

		amfAuditEventImpl.resetOriginalValues();

		return amfAuditEventImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		amfAuditEventId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		eventType = objectInput.readUTF();
		ipAddress = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(amfAuditEventId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (eventType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eventType);
		}

		if (ipAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ipAddress);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
	}

	public long amfAuditEventId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String eventType;
	public String ipAddress;
	public long groupId;
	public long companyId;

}