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

package com.liferay.training.amf.registration.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.training.amf.registration.model.UserCustom;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UserCustom in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserCustomCacheModel
	implements CacheModel<UserCustom>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserCustomCacheModel)) {
			return false;
		}

		UserCustomCacheModel userCustomCacheModel =
			(UserCustomCacheModel)object;

		if (userCustomId == userCustomCacheModel.userCustomId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userCustomId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{userCustomId=");
		sb.append(userCustomId);
		sb.append(", homePhone=");
		sb.append(homePhone);
		sb.append(", mobilePhone=");
		sb.append(mobilePhone);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", address=");
		sb.append(address);
		sb.append(", address2=");
		sb.append(address2);
		sb.append(", city=");
		sb.append(city);
		sb.append(", state=");
		sb.append(state);
		sb.append(", zip=");
		sb.append(zip);
		sb.append(", securityQuestion=");
		sb.append(securityQuestion);
		sb.append(", securityAnswer=");
		sb.append(securityAnswer);
		sb.append(", acceptedTou=");
		sb.append(acceptedTou);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserCustom toEntityModel() {
		UserCustomImpl userCustomImpl = new UserCustomImpl();

		userCustomImpl.setUserCustomId(userCustomId);

		if (homePhone == null) {
			userCustomImpl.setHomePhone("");
		}
		else {
			userCustomImpl.setHomePhone(homePhone);
		}

		if (mobilePhone == null) {
			userCustomImpl.setMobilePhone("");
		}
		else {
			userCustomImpl.setMobilePhone(mobilePhone);
		}

		userCustomImpl.setUserId(userId);

		if (address == null) {
			userCustomImpl.setAddress("");
		}
		else {
			userCustomImpl.setAddress(address);
		}

		if (address2 == null) {
			userCustomImpl.setAddress2("");
		}
		else {
			userCustomImpl.setAddress2(address2);
		}

		if (city == null) {
			userCustomImpl.setCity("");
		}
		else {
			userCustomImpl.setCity(city);
		}

		if (state == null) {
			userCustomImpl.setState("");
		}
		else {
			userCustomImpl.setState(state);
		}

		if (zip == null) {
			userCustomImpl.setZip("");
		}
		else {
			userCustomImpl.setZip(zip);
		}

		if (securityQuestion == null) {
			userCustomImpl.setSecurityQuestion("");
		}
		else {
			userCustomImpl.setSecurityQuestion(securityQuestion);
		}

		if (securityAnswer == null) {
			userCustomImpl.setSecurityAnswer("");
		}
		else {
			userCustomImpl.setSecurityAnswer(securityAnswer);
		}

		userCustomImpl.setAcceptedTou(acceptedTou);

		userCustomImpl.resetOriginalValues();

		return userCustomImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userCustomId = objectInput.readLong();
		homePhone = objectInput.readUTF();
		mobilePhone = objectInput.readUTF();

		userId = objectInput.readLong();
		address = objectInput.readUTF();
		address2 = objectInput.readUTF();
		city = objectInput.readUTF();
		state = objectInput.readUTF();
		zip = objectInput.readUTF();
		securityQuestion = objectInput.readUTF();
		securityAnswer = objectInput.readUTF();

		acceptedTou = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(userCustomId);

		if (homePhone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(homePhone);
		}

		if (mobilePhone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobilePhone);
		}

		objectOutput.writeLong(userId);

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (address2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address2);
		}

		if (city == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (zip == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(zip);
		}

		if (securityQuestion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(securityQuestion);
		}

		if (securityAnswer == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(securityAnswer);
		}

		objectOutput.writeBoolean(acceptedTou);
	}

	public long userCustomId;
	public String homePhone;
	public String mobilePhone;
	public long userId;
	public String address;
	public String address2;
	public String city;
	public String state;
	public String zip;
	public String securityQuestion;
	public String securityAnswer;
	public boolean acceptedTou;

}