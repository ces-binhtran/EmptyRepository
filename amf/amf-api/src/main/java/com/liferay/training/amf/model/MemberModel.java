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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Member service. Represents a row in the &quot;Amf_Member&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.training.amf.model.impl.MemberModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.training.amf.model.impl.MemberImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Member
 * @generated
 */
@ProviderType
public interface MemberModel
	extends BaseModel<Member>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a member model instance should use the {@link Member} interface instead.
	 */

	/**
	 * Returns the primary key of this member.
	 *
	 * @return the primary key of this member
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this member.
	 *
	 * @param primaryKey the primary key of this member
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the member ID of this member.
	 *
	 * @return the member ID of this member
	 */
	public long getMemberId();

	/**
	 * Sets the member ID of this member.
	 *
	 * @param memberId the member ID of this member
	 */
	public void setMemberId(long memberId);

	/**
	 * Returns the group ID of this member.
	 *
	 * @return the group ID of this member
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this member.
	 *
	 * @param groupId the group ID of this member
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this member.
	 *
	 * @return the company ID of this member
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this member.
	 *
	 * @param companyId the company ID of this member
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this member.
	 *
	 * @return the user ID of this member
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this member.
	 *
	 * @param userId the user ID of this member
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this member.
	 *
	 * @return the user uuid of this member
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this member.
	 *
	 * @param userUuid the user uuid of this member
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this member.
	 *
	 * @return the user name of this member
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this member.
	 *
	 * @param userName the user name of this member
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this member.
	 *
	 * @return the create date of this member
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this member.
	 *
	 * @param createDate the create date of this member
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this member.
	 *
	 * @return the modified date of this member
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this member.
	 *
	 * @param modifiedDate the modified date of this member
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the first name of this member.
	 *
	 * @return the first name of this member
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this member.
	 *
	 * @param firstName the first name of this member
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the last name of this member.
	 *
	 * @return the last name of this member
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this member.
	 *
	 * @param lastName the last name of this member
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the email address of this member.
	 *
	 * @return the email address of this member
	 */
	@AutoEscape
	public String getEmailAddress();

	/**
	 * Sets the email address of this member.
	 *
	 * @param emailAddress the email address of this member
	 */
	public void setEmailAddress(String emailAddress);

	/**
	 * Returns the male of this member.
	 *
	 * @return the male of this member
	 */
	public boolean getMale();

	/**
	 * Returns <code>true</code> if this member is male.
	 *
	 * @return <code>true</code> if this member is male; <code>false</code> otherwise
	 */
	public boolean isMale();

	/**
	 * Sets whether this member is male.
	 *
	 * @param male the male of this member
	 */
	public void setMale(boolean male);

	/**
	 * Returns the month of birth of this member.
	 *
	 * @return the month of birth of this member
	 */
	public int getMonthOfBirth();

	/**
	 * Sets the month of birth of this member.
	 *
	 * @param monthOfBirth the month of birth of this member
	 */
	public void setMonthOfBirth(int monthOfBirth);

	/**
	 * Returns the day of birth of this member.
	 *
	 * @return the day of birth of this member
	 */
	public int getDayOfBirth();

	/**
	 * Sets the day of birth of this member.
	 *
	 * @param dayOfBirth the day of birth of this member
	 */
	public void setDayOfBirth(int dayOfBirth);

	/**
	 * Returns the year of birth of this member.
	 *
	 * @return the year of birth of this member
	 */
	public int getYearOfBirth();

	/**
	 * Sets the year of birth of this member.
	 *
	 * @param yearOfBirth the year of birth of this member
	 */
	public void setYearOfBirth(int yearOfBirth);

	/**
	 * Returns the password of this member.
	 *
	 * @return the password of this member
	 */
	@AutoEscape
	public String getPassword();

	/**
	 * Sets the password of this member.
	 *
	 * @param password the password of this member
	 */
	public void setPassword(String password);

	/**
	 * Returns the home phone of this member.
	 *
	 * @return the home phone of this member
	 */
	@AutoEscape
	public String getHomePhone();

	/**
	 * Sets the home phone of this member.
	 *
	 * @param homePhone the home phone of this member
	 */
	public void setHomePhone(String homePhone);

	/**
	 * Returns the mobile phone of this member.
	 *
	 * @return the mobile phone of this member
	 */
	@AutoEscape
	public String getMobilePhone();

	/**
	 * Sets the mobile phone of this member.
	 *
	 * @param mobilePhone the mobile phone of this member
	 */
	public void setMobilePhone(String mobilePhone);

	/**
	 * Returns the address1 of this member.
	 *
	 * @return the address1 of this member
	 */
	@AutoEscape
	public String getAddress1();

	/**
	 * Sets the address1 of this member.
	 *
	 * @param address1 the address1 of this member
	 */
	public void setAddress1(String address1);

	/**
	 * Returns the address2 of this member.
	 *
	 * @return the address2 of this member
	 */
	@AutoEscape
	public String getAddress2();

	/**
	 * Sets the address2 of this member.
	 *
	 * @param address2 the address2 of this member
	 */
	public void setAddress2(String address2);

	/**
	 * Returns the city of this member.
	 *
	 * @return the city of this member
	 */
	@AutoEscape
	public String getCity();

	/**
	 * Sets the city of this member.
	 *
	 * @param city the city of this member
	 */
	public void setCity(String city);

	/**
	 * Returns the state of this member.
	 *
	 * @return the state of this member
	 */
	@AutoEscape
	public String getState();

	/**
	 * Sets the state of this member.
	 *
	 * @param state the state of this member
	 */
	public void setState(String state);

	/**
	 * Returns the zip code of this member.
	 *
	 * @return the zip code of this member
	 */
	@AutoEscape
	public String getZipCode();

	/**
	 * Sets the zip code of this member.
	 *
	 * @param zipCode the zip code of this member
	 */
	public void setZipCode(String zipCode);

	/**
	 * Returns the security question of this member.
	 *
	 * @return the security question of this member
	 */
	@AutoEscape
	public String getSecurityQuestion();

	/**
	 * Sets the security question of this member.
	 *
	 * @param securityQuestion the security question of this member
	 */
	public void setSecurityQuestion(String securityQuestion);

	/**
	 * Returns the answer of this member.
	 *
	 * @return the answer of this member
	 */
	@AutoEscape
	public String getAnswer();

	/**
	 * Sets the answer of this member.
	 *
	 * @param answer the answer of this member
	 */
	public void setAnswer(String answer);

	/**
	 * Returns the term of use of this member.
	 *
	 * @return the term of use of this member
	 */
	public boolean getTermOfUse();

	/**
	 * Returns <code>true</code> if this member is term of use.
	 *
	 * @return <code>true</code> if this member is term of use; <code>false</code> otherwise
	 */
	public boolean isTermOfUse();

	/**
	 * Sets whether this member is term of use.
	 *
	 * @param termOfUse the term of use of this member
	 */
	public void setTermOfUse(boolean termOfUse);

}