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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.training.amf.service.http.AmfAuditEventServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class AmfAuditEventSoap implements Serializable {

	public static AmfAuditEventSoap toSoapModel(AmfAuditEvent model) {
		AmfAuditEventSoap soapModel = new AmfAuditEventSoap();

		soapModel.setAmfAuditEventId(model.getAmfAuditEventId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEventType(model.getEventType());
		soapModel.setIpAddress(model.getIpAddress());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());

		return soapModel;
	}

	public static AmfAuditEventSoap[] toSoapModels(AmfAuditEvent[] models) {
		AmfAuditEventSoap[] soapModels = new AmfAuditEventSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AmfAuditEventSoap[][] toSoapModels(AmfAuditEvent[][] models) {
		AmfAuditEventSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AmfAuditEventSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AmfAuditEventSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AmfAuditEventSoap[] toSoapModels(List<AmfAuditEvent> models) {
		List<AmfAuditEventSoap> soapModels = new ArrayList<AmfAuditEventSoap>(
			models.size());

		for (AmfAuditEvent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AmfAuditEventSoap[soapModels.size()]);
	}

	public AmfAuditEventSoap() {
	}

	public long getPrimaryKey() {
		return _amfAuditEventId;
	}

	public void setPrimaryKey(long pk) {
		setAmfAuditEventId(pk);
	}

	public long getAmfAuditEventId() {
		return _amfAuditEventId;
	}

	public void setAmfAuditEventId(long amfAuditEventId) {
		_amfAuditEventId = amfAuditEventId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getEventType() {
		return _eventType;
	}

	public void setEventType(String eventType) {
		_eventType = eventType;
	}

	public String getIpAddress() {
		return _ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		_ipAddress = ipAddress;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	private long _amfAuditEventId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _eventType;
	private String _ipAddress;
	private long _groupId;
	private long _companyId;

}