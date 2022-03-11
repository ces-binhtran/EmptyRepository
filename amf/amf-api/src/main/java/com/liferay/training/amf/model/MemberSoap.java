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
 * This class is used by SOAP remote services, specifically {@link com.liferay.training.amf.service.http.MemberServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class MemberSoap implements Serializable {

	public static MemberSoap toSoapModel(Member model) {
		MemberSoap soapModel = new MemberSoap();

		soapModel.setMemberId(model.getMemberId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setMale(model.isMale());
		soapModel.setMonthOfBirth(model.getMonthOfBirth());
		soapModel.setDayOfBirth(model.getDayOfBirth());
		soapModel.setYearOfBirth(model.getYearOfBirth());
		soapModel.setPassword(model.getPassword());
		soapModel.setHomePhone(model.getHomePhone());
		soapModel.setMobilePhone(model.getMobilePhone());
		soapModel.setAddress1(model.getAddress1());
		soapModel.setAddress2(model.getAddress2());
		soapModel.setCity(model.getCity());
		soapModel.setState(model.getState());
		soapModel.setZipCode(model.getZipCode());
		soapModel.setSecurityQuestion(model.getSecurityQuestion());
		soapModel.setAnswer(model.getAnswer());
		soapModel.setTermOfUse(model.isTermOfUse());

		return soapModel;
	}

	public static MemberSoap[] toSoapModels(Member[] models) {
		MemberSoap[] soapModels = new MemberSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MemberSoap[][] toSoapModels(Member[][] models) {
		MemberSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MemberSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MemberSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MemberSoap[] toSoapModels(List<Member> models) {
		List<MemberSoap> soapModels = new ArrayList<MemberSoap>(models.size());

		for (Member model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MemberSoap[soapModels.size()]);
	}

	public MemberSoap() {
	}

	public long getPrimaryKey() {
		return _memberId;
	}

	public void setPrimaryKey(long pk) {
		setMemberId(pk);
	}

	public long getMemberId() {
		return _memberId;
	}

	public void setMemberId(long memberId) {
		_memberId = memberId;
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

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public boolean getMale() {
		return _male;
	}

	public boolean isMale() {
		return _male;
	}

	public void setMale(boolean male) {
		_male = male;
	}

	public int getMonthOfBirth() {
		return _monthOfBirth;
	}

	public void setMonthOfBirth(int monthOfBirth) {
		_monthOfBirth = monthOfBirth;
	}

	public int getDayOfBirth() {
		return _dayOfBirth;
	}

	public void setDayOfBirth(int dayOfBirth) {
		_dayOfBirth = dayOfBirth;
	}

	public int getYearOfBirth() {
		return _yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		_yearOfBirth = yearOfBirth;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
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

	public String getAddress1() {
		return _address1;
	}

	public void setAddress1(String address1) {
		_address1 = address1;
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

	public String getZipCode() {
		return _zipCode;
	}

	public void setZipCode(String zipCode) {
		_zipCode = zipCode;
	}

	public String getSecurityQuestion() {
		return _securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		_securityQuestion = securityQuestion;
	}

	public String getAnswer() {
		return _answer;
	}

	public void setAnswer(String answer) {
		_answer = answer;
	}

	public boolean getTermOfUse() {
		return _termOfUse;
	}

	public boolean isTermOfUse() {
		return _termOfUse;
	}

	public void setTermOfUse(boolean termOfUse) {
		_termOfUse = termOfUse;
	}

	private long _memberId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _firstName;
	private String _lastName;
	private String _emailAddress;
	private boolean _male;
	private int _monthOfBirth;
	private int _dayOfBirth;
	private int _yearOfBirth;
	private String _password;
	private String _homePhone;
	private String _mobilePhone;
	private String _address1;
	private String _address2;
	private String _city;
	private String _state;
	private String _zipCode;
	private String _securityQuestion;
	private String _answer;
	private boolean _termOfUse;

}