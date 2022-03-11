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
import com.liferay.training.amf.model.Member;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Member in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MemberCacheModel implements CacheModel<Member>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MemberCacheModel)) {
			return false;
		}

		MemberCacheModel memberCacheModel = (MemberCacheModel)object;

		if (memberId == memberCacheModel.memberId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, memberId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{memberId=");
		sb.append(memberId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", male=");
		sb.append(male);
		sb.append(", monthOfBirth=");
		sb.append(monthOfBirth);
		sb.append(", dayOfBirth=");
		sb.append(dayOfBirth);
		sb.append(", yearOfBirth=");
		sb.append(yearOfBirth);
		sb.append(", password=");
		sb.append(password);
		sb.append(", homePhone=");
		sb.append(homePhone);
		sb.append(", mobilePhone=");
		sb.append(mobilePhone);
		sb.append(", address1=");
		sb.append(address1);
		sb.append(", address2=");
		sb.append(address2);
		sb.append(", city=");
		sb.append(city);
		sb.append(", state=");
		sb.append(state);
		sb.append(", zipCode=");
		sb.append(zipCode);
		sb.append(", securityQuestion=");
		sb.append(securityQuestion);
		sb.append(", answer=");
		sb.append(answer);
		sb.append(", termOfUse=");
		sb.append(termOfUse);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Member toEntityModel() {
		MemberImpl memberImpl = new MemberImpl();

		memberImpl.setMemberId(memberId);
		memberImpl.setGroupId(groupId);
		memberImpl.setCompanyId(companyId);
		memberImpl.setUserId(userId);

		if (userName == null) {
			memberImpl.setUserName("");
		}
		else {
			memberImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			memberImpl.setCreateDate(null);
		}
		else {
			memberImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			memberImpl.setModifiedDate(null);
		}
		else {
			memberImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (firstName == null) {
			memberImpl.setFirstName("");
		}
		else {
			memberImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			memberImpl.setLastName("");
		}
		else {
			memberImpl.setLastName(lastName);
		}

		if (emailAddress == null) {
			memberImpl.setEmailAddress("");
		}
		else {
			memberImpl.setEmailAddress(emailAddress);
		}

		memberImpl.setMale(male);
		memberImpl.setMonthOfBirth(monthOfBirth);
		memberImpl.setDayOfBirth(dayOfBirth);
		memberImpl.setYearOfBirth(yearOfBirth);

		if (password == null) {
			memberImpl.setPassword("");
		}
		else {
			memberImpl.setPassword(password);
		}

		if (homePhone == null) {
			memberImpl.setHomePhone("");
		}
		else {
			memberImpl.setHomePhone(homePhone);
		}

		if (mobilePhone == null) {
			memberImpl.setMobilePhone("");
		}
		else {
			memberImpl.setMobilePhone(mobilePhone);
		}

		if (address1 == null) {
			memberImpl.setAddress1("");
		}
		else {
			memberImpl.setAddress1(address1);
		}

		if (address2 == null) {
			memberImpl.setAddress2("");
		}
		else {
			memberImpl.setAddress2(address2);
		}

		if (city == null) {
			memberImpl.setCity("");
		}
		else {
			memberImpl.setCity(city);
		}

		if (state == null) {
			memberImpl.setState("");
		}
		else {
			memberImpl.setState(state);
		}

		if (zipCode == null) {
			memberImpl.setZipCode("");
		}
		else {
			memberImpl.setZipCode(zipCode);
		}

		if (securityQuestion == null) {
			memberImpl.setSecurityQuestion("");
		}
		else {
			memberImpl.setSecurityQuestion(securityQuestion);
		}

		if (answer == null) {
			memberImpl.setAnswer("");
		}
		else {
			memberImpl.setAnswer(answer);
		}

		memberImpl.setTermOfUse(termOfUse);

		memberImpl.resetOriginalValues();

		return memberImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		memberId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		emailAddress = objectInput.readUTF();

		male = objectInput.readBoolean();

		monthOfBirth = objectInput.readInt();

		dayOfBirth = objectInput.readInt();

		yearOfBirth = objectInput.readInt();
		password = objectInput.readUTF();
		homePhone = objectInput.readUTF();
		mobilePhone = objectInput.readUTF();
		address1 = objectInput.readUTF();
		address2 = objectInput.readUTF();
		city = objectInput.readUTF();
		state = objectInput.readUTF();
		zipCode = objectInput.readUTF();
		securityQuestion = objectInput.readUTF();
		answer = objectInput.readUTF();

		termOfUse = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(memberId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (emailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		objectOutput.writeBoolean(male);

		objectOutput.writeInt(monthOfBirth);

		objectOutput.writeInt(dayOfBirth);

		objectOutput.writeInt(yearOfBirth);

		if (password == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(password);
		}

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

		if (address1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address1);
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

		if (zipCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(zipCode);
		}

		if (securityQuestion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(securityQuestion);
		}

		if (answer == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(answer);
		}

		objectOutput.writeBoolean(termOfUse);
	}

	public long memberId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String firstName;
	public String lastName;
	public String emailAddress;
	public boolean male;
	public int monthOfBirth;
	public int dayOfBirth;
	public int yearOfBirth;
	public String password;
	public String homePhone;
	public String mobilePhone;
	public String address1;
	public String address2;
	public String city;
	public String state;
	public String zipCode;
	public String securityQuestion;
	public String answer;
	public boolean termOfUse;

}