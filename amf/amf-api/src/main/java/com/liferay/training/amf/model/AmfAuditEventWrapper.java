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

package com.liferay.training.amf.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AmfAuditEvent}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmfAuditEvent
 * @generated
 */
public class AmfAuditEventWrapper
	extends BaseModelWrapper<AmfAuditEvent>
	implements AmfAuditEvent, ModelWrapper<AmfAuditEvent> {

	public AmfAuditEventWrapper(AmfAuditEvent amfAuditEvent) {
		super(amfAuditEvent);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("amfAuditEventId", getAmfAuditEventId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("eventType", getEventType());
		attributes.put("ipAddress", getIpAddress());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long amfAuditEventId = (Long)attributes.get("amfAuditEventId");

		if (amfAuditEventId != null) {
			setAmfAuditEventId(amfAuditEventId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String eventType = (String)attributes.get("eventType");

		if (eventType != null) {
			setEventType(eventType);
		}

		String ipAddress = (String)attributes.get("ipAddress");

		if (ipAddress != null) {
			setIpAddress(ipAddress);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}
	}

	/**
	 * Returns the amf audit event ID of this amf audit event.
	 *
	 * @return the amf audit event ID of this amf audit event
	 */
	@Override
	public long getAmfAuditEventId() {
		return model.getAmfAuditEventId();
	}

	/**
	 * Returns the company ID of this amf audit event.
	 *
	 * @return the company ID of this amf audit event
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this amf audit event.
	 *
	 * @return the create date of this amf audit event
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the event type of this amf audit event.
	 *
	 * @return the event type of this amf audit event
	 */
	@Override
	public String getEventType() {
		return model.getEventType();
	}

	/**
	 * Returns the group ID of this amf audit event.
	 *
	 * @return the group ID of this amf audit event
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ip address of this amf audit event.
	 *
	 * @return the ip address of this amf audit event
	 */
	@Override
	public String getIpAddress() {
		return model.getIpAddress();
	}

	/**
	 * Returns the modified date of this amf audit event.
	 *
	 * @return the modified date of this amf audit event
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this amf audit event.
	 *
	 * @return the primary key of this amf audit event
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this amf audit event.
	 *
	 * @return the user ID of this amf audit event
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this amf audit event.
	 *
	 * @return the user name of this amf audit event
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this amf audit event.
	 *
	 * @return the user uuid of this amf audit event
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the amf audit event ID of this amf audit event.
	 *
	 * @param amfAuditEventId the amf audit event ID of this amf audit event
	 */
	@Override
	public void setAmfAuditEventId(long amfAuditEventId) {
		model.setAmfAuditEventId(amfAuditEventId);
	}

	/**
	 * Sets the company ID of this amf audit event.
	 *
	 * @param companyId the company ID of this amf audit event
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this amf audit event.
	 *
	 * @param createDate the create date of this amf audit event
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the event type of this amf audit event.
	 *
	 * @param eventType the event type of this amf audit event
	 */
	@Override
	public void setEventType(String eventType) {
		model.setEventType(eventType);
	}

	/**
	 * Sets the group ID of this amf audit event.
	 *
	 * @param groupId the group ID of this amf audit event
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ip address of this amf audit event.
	 *
	 * @param ipAddress the ip address of this amf audit event
	 */
	@Override
	public void setIpAddress(String ipAddress) {
		model.setIpAddress(ipAddress);
	}

	/**
	 * Sets the modified date of this amf audit event.
	 *
	 * @param modifiedDate the modified date of this amf audit event
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this amf audit event.
	 *
	 * @param primaryKey the primary key of this amf audit event
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this amf audit event.
	 *
	 * @param userId the user ID of this amf audit event
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this amf audit event.
	 *
	 * @param userName the user name of this amf audit event
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this amf audit event.
	 *
	 * @param userUuid the user uuid of this amf audit event
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected AmfAuditEventWrapper wrap(AmfAuditEvent amfAuditEvent) {
		return new AmfAuditEventWrapper(amfAuditEvent);
	}

}