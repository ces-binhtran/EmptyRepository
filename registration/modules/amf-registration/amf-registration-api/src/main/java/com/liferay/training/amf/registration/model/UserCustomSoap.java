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

package com.liferay.training.amf.registration.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.training.amf.registration.service.http.UserCustomServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserCustomSoap implements Serializable {

	public static UserCustomSoap toSoapModel(UserCustom model) {
		UserCustomSoap soapModel = new UserCustomSoap();

		soapModel.setUserCustomId(model.getUserCustomId());
		soapModel.setHomePhone(model.getHomePhone());
		soapModel.setMobilePhone(model.getMobilePhone());
		soapModel.setUserId(model.getUserId());
		soapModel.setAddress(model.getAddress());
		soapModel.setAddress2(model.getAddress2());
		soapModel.setCity(model.getCity());
		soapModel.setState(model.getState());
		soapModel.setZip(model.getZip());
		soapModel.setSecurityQuestion(model.getSecurityQuestion());
		soapModel.setSecurityAnswer(model.getSecurityAnswer());
		soapModel.setAcceptedTou(model.isAcceptedTou());

		return soapModel;
	}

	public static UserCustomSoap[] toSoapModels(UserCustom[] models) {
		UserCustomSoap[] soapModels = new UserCustomSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserCustomSoap[][] toSoapModels(UserCustom[][] models) {
		UserCustomSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserCustomSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserCustomSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserCustomSoap[] toSoapModels(List<UserCustom> models) {
		List<UserCustomSoap> soapModels = new ArrayList<UserCustomSoap>(
			models.size());

		for (UserCustom model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserCustomSoap[soapModels.size()]);
	}

	public UserCustomSoap() {
	}

	public long getPrimaryKey() {
		return _userCustomId;
	}

	public void setPrimaryKey(long pk) {
		setUserCustomId(pk);
	}

	public long getUserCustomId() {
		return _userCustomId;
	}

	public void setUserCustomId(long userCustomId) {
		_userCustomId = userCustomId;
	}

	public String getHomePhone() {
		return _homePhone;
	}

	public void setHomePhone(String homePhone) {
		_homePhone = homePhone;
	}

	public String getMobilePhone() {
		return _mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		_mobilePhone = mobilePhone;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getAddress2() {
		return _address2;
	}

	public void setAddress2(String address2) {
		_address2 = address2;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public String getZip() {
		return _zip;
	}

	public void setZip(String zip) {
		_zip = zip;
	}

	public String getSecurityQuestion() {
		return _securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		_securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return _securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		_securityAnswer = securityAnswer;
	}

	public boolean getAcceptedTou() {
		return _acceptedTou;
	}

	public boolean isAcceptedTou() {
		return _acceptedTou;
	}

	public void setAcceptedTou(boolean acceptedTou) {
		_acceptedTou = acceptedTou;
	}

	private long _userCustomId;
	private String _homePhone;
	private String _mobilePhone;
	private long _userId;
	private String _address;
	private String _address2;
	private String _city;
	private String _state;
	private String _zip;
	private String _securityQuestion;
	private String _securityAnswer;
	private boolean _acceptedTou;

}