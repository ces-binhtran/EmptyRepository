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
 * This class is a wrapper for {@link Member}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Member
 * @generated
 */
public class MemberWrapper
	extends BaseModelWrapper<Member> implements Member, ModelWrapper<Member> {

	public MemberWrapper(Member member) {
		super(member);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("memberId", getMemberId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("male", isMale());
		attributes.put("monthOfBirth", getMonthOfBirth());
		attributes.put("dayOfBirth", getDayOfBirth());
		attributes.put("yearOfBirth", getYearOfBirth());
		attributes.put("password", getPassword());
		attributes.put("homePhone", getHomePhone());
		attributes.put("mobilePhone", getMobilePhone());
		attributes.put("address1", getAddress1());
		attributes.put("address2", getAddress2());
		attributes.put("city", getCity());
		attributes.put("state", getState());
		attributes.put("zipCode", getZipCode());
		attributes.put("securityQuestion", getSecurityQuestion());
		attributes.put("answer", getAnswer());
		attributes.put("termOfUse", isTermOfUse());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long memberId = (Long)attributes.get("memberId");

		if (memberId != null) {
			setMemberId(memberId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		Boolean male = (Boolean)attributes.get("male");

		if (male != null) {
			setMale(male);
		}

		Integer monthOfBirth = (Integer)attributes.get("monthOfBirth");

		if (monthOfBirth != null) {
			setMonthOfBirth(monthOfBirth);
		}

		Integer dayOfBirth = (Integer)attributes.get("dayOfBirth");

		if (dayOfBirth != null) {
			setDayOfBirth(dayOfBirth);
		}

		Integer yearOfBirth = (Integer)attributes.get("yearOfBirth");

		if (yearOfBirth != null) {
			setYearOfBirth(yearOfBirth);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		String homePhone = (String)attributes.get("homePhone");

		if (homePhone != null) {
			setHomePhone(homePhone);
		}

		String mobilePhone = (String)attributes.get("mobilePhone");

		if (mobilePhone != null) {
			setMobilePhone(mobilePhone);
		}

		String address1 = (String)attributes.get("address1");

		if (address1 != null) {
			setAddress1(address1);
		}

		String address2 = (String)attributes.get("address2");

		if (address2 != null) {
			setAddress2(address2);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String zipCode = (String)attributes.get("zipCode");

		if (zipCode != null) {
			setZipCode(zipCode);
		}

		String securityQuestion = (String)attributes.get("securityQuestion");

		if (securityQuestion != null) {
			setSecurityQuestion(securityQuestion);
		}

		String answer = (String)attributes.get("answer");

		if (answer != null) {
			setAnswer(answer);
		}

		Boolean termOfUse = (Boolean)attributes.get("termOfUse");

		if (termOfUse != null) {
			setTermOfUse(termOfUse);
		}
	}

	/**
	 * Returns the address1 of this member.
	 *
	 * @return the address1 of this member
	 */
	@Override
	public String getAddress1() {
		return model.getAddress1();
	}

	/**
	 * Returns the address2 of this member.
	 *
	 * @return the address2 of this member
	 */
	@Override
	public String getAddress2() {
		return model.getAddress2();
	}

	/**
	 * Returns the answer of this member.
	 *
	 * @return the answer of this member
	 */
	@Override
	public String getAnswer() {
		return model.getAnswer();
	}

	/**
	 * Returns the city of this member.
	 *
	 * @return the city of this member
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the company ID of this member.
	 *
	 * @return the company ID of this member
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this member.
	 *
	 * @return the create date of this member
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the day of birth of this member.
	 *
	 * @return the day of birth of this member
	 */
	@Override
	public int getDayOfBirth() {
		return model.getDayOfBirth();
	}

	/**
	 * Returns the email address of this member.
	 *
	 * @return the email address of this member
	 */
	@Override
	public String getEmailAddress() {
		return model.getEmailAddress();
	}

	/**
	 * Returns the first name of this member.
	 *
	 * @return the first name of this member
	 */
	@Override
	public String getFirstName() {
		return model.getFirstName();
	}

	/**
	 * Returns the group ID of this member.
	 *
	 * @return the group ID of this member
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the home phone of this member.
	 *
	 * @return the home phone of this member
	 */
	@Override
	public String getHomePhone() {
		return model.getHomePhone();
	}

	/**
	 * Returns the last name of this member.
	 *
	 * @return the last name of this member
	 */
	@Override
	public String getLastName() {
		return model.getLastName();
	}

	/**
	 * Returns the male of this member.
	 *
	 * @return the male of this member
	 */
	@Override
	public boolean getMale() {
		return model.getMale();
	}

	/**
	 * Returns the member ID of this member.
	 *
	 * @return the member ID of this member
	 */
	@Override
	public long getMemberId() {
		return model.getMemberId();
	}

	/**
	 * Returns the mobile phone of this member.
	 *
	 * @return the mobile phone of this member
	 */
	@Override
	public String getMobilePhone() {
		return model.getMobilePhone();
	}

	/**
	 * Returns the modified date of this member.
	 *
	 * @return the modified date of this member
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the month of birth of this member.
	 *
	 * @return the month of birth of this member
	 */
	@Override
	public int getMonthOfBirth() {
		return model.getMonthOfBirth();
	}

	/**
	 * Returns the password of this member.
	 *
	 * @return the password of this member
	 */
	@Override
	public String getPassword() {
		return model.getPassword();
	}

	/**
	 * Returns the primary key of this member.
	 *
	 * @return the primary key of this member
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the security question of this member.
	 *
	 * @return the security question of this member
	 */
	@Override
	public String getSecurityQuestion() {
		return model.getSecurityQuestion();
	}

	/**
	 * Returns the state of this member.
	 *
	 * @return the state of this member
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the term of use of this member.
	 *
	 * @return the term of use of this member
	 */
	@Override
	public boolean getTermOfUse() {
		return model.getTermOfUse();
	}

	/**
	 * Returns the user ID of this member.
	 *
	 * @return the user ID of this member
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this member.
	 *
	 * @return the user name of this member
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this member.
	 *
	 * @return the user uuid of this member
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the year of birth of this member.
	 *
	 * @return the year of birth of this member
	 */
	@Override
	public int getYearOfBirth() {
		return model.getYearOfBirth();
	}

	/**
	 * Returns the zip code of this member.
	 *
	 * @return the zip code of this member
	 */
	@Override
	public String getZipCode() {
		return model.getZipCode();
	}

	/**
	 * Returns <code>true</code> if this member is male.
	 *
	 * @return <code>true</code> if this member is male; <code>false</code> otherwise
	 */
	@Override
	public boolean isMale() {
		return model.isMale();
	}

	/**
	 * Returns <code>true</code> if this member is term of use.
	 *
	 * @return <code>true</code> if this member is term of use; <code>false</code> otherwise
	 */
	@Override
	public boolean isTermOfUse() {
		return model.isTermOfUse();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address1 of this member.
	 *
	 * @param address1 the address1 of this member
	 */
	@Override
	public void setAddress1(String address1) {
		model.setAddress1(address1);
	}

	/**
	 * Sets the address2 of this member.
	 *
	 * @param address2 the address2 of this member
	 */
	@Override
	public void setAddress2(String address2) {
		model.setAddress2(address2);
	}

	/**
	 * Sets the answer of this member.
	 *
	 * @param answer the answer of this member
	 */
	@Override
	public void setAnswer(String answer) {
		model.setAnswer(answer);
	}

	/**
	 * Sets the city of this member.
	 *
	 * @param city the city of this member
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the company ID of this member.
	 *
	 * @param companyId the company ID of this member
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this member.
	 *
	 * @param createDate the create date of this member
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the day of birth of this member.
	 *
	 * @param dayOfBirth the day of birth of this member
	 */
	@Override
	public void setDayOfBirth(int dayOfBirth) {
		model.setDayOfBirth(dayOfBirth);
	}

	/**
	 * Sets the email address of this member.
	 *
	 * @param emailAddress the email address of this member
	 */
	@Override
	public void setEmailAddress(String emailAddress) {
		model.setEmailAddress(emailAddress);
	}

	/**
	 * Sets the first name of this member.
	 *
	 * @param firstName the first name of this member
	 */
	@Override
	public void setFirstName(String firstName) {
		model.setFirstName(firstName);
	}

	/**
	 * Sets the group ID of this member.
	 *
	 * @param groupId the group ID of this member
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the home phone of this member.
	 *
	 * @param homePhone the home phone of this member
	 */
	@Override
	public void setHomePhone(String homePhone) {
		model.setHomePhone(homePhone);
	}

	/**
	 * Sets the last name of this member.
	 *
	 * @param lastName the last name of this member
	 */
	@Override
	public void setLastName(String lastName) {
		model.setLastName(lastName);
	}

	/**
	 * Sets whether this member is male.
	 *
	 * @param male the male of this member
	 */
	@Override
	public void setMale(boolean male) {
		model.setMale(male);
	}

	/**
	 * Sets the member ID of this member.
	 *
	 * @param memberId the member ID of this member
	 */
	@Override
	public void setMemberId(long memberId) {
		model.setMemberId(memberId);
	}

	/**
	 * Sets the mobile phone of this member.
	 *
	 * @param mobilePhone the mobile phone of this member
	 */
	@Override
	public void setMobilePhone(String mobilePhone) {
		model.setMobilePhone(mobilePhone);
	}

	/**
	 * Sets the modified date of this member.
	 *
	 * @param modifiedDate the modified date of this member
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the month of birth of this member.
	 *
	 * @param monthOfBirth the month of birth of this member
	 */
	@Override
	public void setMonthOfBirth(int monthOfBirth) {
		model.setMonthOfBirth(monthOfBirth);
	}

	/**
	 * Sets the password of this member.
	 *
	 * @param password the password of this member
	 */
	@Override
	public void setPassword(String password) {
		model.setPassword(password);
	}

	/**
	 * Sets the primary key of this member.
	 *
	 * @param primaryKey the primary key of this member
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the security question of this member.
	 *
	 * @param securityQuestion the security question of this member
	 */
	@Override
	public void setSecurityQuestion(String securityQuestion) {
		model.setSecurityQuestion(securityQuestion);
	}

	/**
	 * Sets the state of this member.
	 *
	 * @param state the state of this member
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets whether this member is term of use.
	 *
	 * @param termOfUse the term of use of this member
	 */
	@Override
	public void setTermOfUse(boolean termOfUse) {
		model.setTermOfUse(termOfUse);
	}

	/**
	 * Sets the user ID of this member.
	 *
	 * @param userId the user ID of this member
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this member.
	 *
	 * @param userName the user name of this member
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this member.
	 *
	 * @param userUuid the user uuid of this member
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the year of birth of this member.
	 *
	 * @param yearOfBirth the year of birth of this member
	 */
	@Override
	public void setYearOfBirth(int yearOfBirth) {
		model.setYearOfBirth(yearOfBirth);
	}

	/**
	 * Sets the zip code of this member.
	 *
	 * @param zipCode the zip code of this member
	 */
	@Override
	public void setZipCode(String zipCode) {
		model.setZipCode(zipCode);
	}

	@Override
	protected MemberWrapper wrap(Member member) {
		return new MemberWrapper(member);
	}

}