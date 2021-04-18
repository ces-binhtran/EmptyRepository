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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserCustom}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserCustom
 * @generated
 */
public class UserCustomWrapper
	extends BaseModelWrapper<UserCustom>
	implements ModelWrapper<UserCustom>, UserCustom {

	public UserCustomWrapper(UserCustom userCustom) {
		super(userCustom);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userCustomId", getUserCustomId());
		attributes.put("homePhone", getHomePhone());
		attributes.put("mobilePhone", getMobilePhone());
		attributes.put("userId", getUserId());
		attributes.put("address", getAddress());
		attributes.put("address2", getAddress2());
		attributes.put("city", getCity());
		attributes.put("state", getState());
		attributes.put("zip", getZip());
		attributes.put("securityQuestion", getSecurityQuestion());
		attributes.put("securityAnswer", getSecurityAnswer());
		attributes.put("acceptedTou", isAcceptedTou());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userCustomId = (Long)attributes.get("userCustomId");

		if (userCustomId != null) {
			setUserCustomId(userCustomId);
		}

		String homePhone = (String)attributes.get("homePhone");

		if (homePhone != null) {
			setHomePhone(homePhone);
		}

		String mobilePhone = (String)attributes.get("mobilePhone");

		if (mobilePhone != null) {
			setMobilePhone(mobilePhone);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
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

		String zip = (String)attributes.get("zip");

		if (zip != null) {
			setZip(zip);
		}

		String securityQuestion = (String)attributes.get("securityQuestion");

		if (securityQuestion != null) {
			setSecurityQuestion(securityQuestion);
		}

		String securityAnswer = (String)attributes.get("securityAnswer");

		if (securityAnswer != null) {
			setSecurityAnswer(securityAnswer);
		}

		Boolean acceptedTou = (Boolean)attributes.get("acceptedTou");

		if (acceptedTou != null) {
			setAcceptedTou(acceptedTou);
		}
	}

	/**
	 * Returns the accepted tou of this user custom.
	 *
	 * @return the accepted tou of this user custom
	 */
	@Override
	public boolean getAcceptedTou() {
		return model.getAcceptedTou();
	}

	/**
	 * Returns the address of this user custom.
	 *
	 * @return the address of this user custom
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the address2 of this user custom.
	 *
	 * @return the address2 of this user custom
	 */
	@Override
	public String getAddress2() {
		return model.getAddress2();
	}

	/**
	 * Returns the city of this user custom.
	 *
	 * @return the city of this user custom
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the home phone of this user custom.
	 *
	 * @return the home phone of this user custom
	 */
	@Override
	public String getHomePhone() {
		return model.getHomePhone();
	}

	/**
	 * Returns the mobile phone of this user custom.
	 *
	 * @return the mobile phone of this user custom
	 */
	@Override
	public String getMobilePhone() {
		return model.getMobilePhone();
	}

	/**
	 * Returns the primary key of this user custom.
	 *
	 * @return the primary key of this user custom
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the security answer of this user custom.
	 *
	 * @return the security answer of this user custom
	 */
	@Override
	public String getSecurityAnswer() {
		return model.getSecurityAnswer();
	}

	/**
	 * Returns the security question of this user custom.
	 *
	 * @return the security question of this user custom
	 */
	@Override
	public String getSecurityQuestion() {
		return model.getSecurityQuestion();
	}

	/**
	 * Returns the state of this user custom.
	 *
	 * @return the state of this user custom
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the user custom ID of this user custom.
	 *
	 * @return the user custom ID of this user custom
	 */
	@Override
	public long getUserCustomId() {
		return model.getUserCustomId();
	}

	/**
	 * Returns the user ID of this user custom.
	 *
	 * @return the user ID of this user custom
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this user custom.
	 *
	 * @return the user uuid of this user custom
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the zip of this user custom.
	 *
	 * @return the zip of this user custom
	 */
	@Override
	public String getZip() {
		return model.getZip();
	}

	/**
	 * Returns <code>true</code> if this user custom is accepted tou.
	 *
	 * @return <code>true</code> if this user custom is accepted tou; <code>false</code> otherwise
	 */
	@Override
	public boolean isAcceptedTou() {
		return model.isAcceptedTou();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this user custom is accepted tou.
	 *
	 * @param acceptedTou the accepted tou of this user custom
	 */
	@Override
	public void setAcceptedTou(boolean acceptedTou) {
		model.setAcceptedTou(acceptedTou);
	}

	/**
	 * Sets the address of this user custom.
	 *
	 * @param address the address of this user custom
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the address2 of this user custom.
	 *
	 * @param address2 the address2 of this user custom
	 */
	@Override
	public void setAddress2(String address2) {
		model.setAddress2(address2);
	}

	/**
	 * Sets the city of this user custom.
	 *
	 * @param city the city of this user custom
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the home phone of this user custom.
	 *
	 * @param homePhone the home phone of this user custom
	 */
	@Override
	public void setHomePhone(String homePhone) {
		model.setHomePhone(homePhone);
	}

	/**
	 * Sets the mobile phone of this user custom.
	 *
	 * @param mobilePhone the mobile phone of this user custom
	 */
	@Override
	public void setMobilePhone(String mobilePhone) {
		model.setMobilePhone(mobilePhone);
	}

	/**
	 * Sets the primary key of this user custom.
	 *
	 * @param primaryKey the primary key of this user custom
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the security answer of this user custom.
	 *
	 * @param securityAnswer the security answer of this user custom
	 */
	@Override
	public void setSecurityAnswer(String securityAnswer) {
		model.setSecurityAnswer(securityAnswer);
	}

	/**
	 * Sets the security question of this user custom.
	 *
	 * @param securityQuestion the security question of this user custom
	 */
	@Override
	public void setSecurityQuestion(String securityQuestion) {
		model.setSecurityQuestion(securityQuestion);
	}

	/**
	 * Sets the state of this user custom.
	 *
	 * @param state the state of this user custom
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the user custom ID of this user custom.
	 *
	 * @param userCustomId the user custom ID of this user custom
	 */
	@Override
	public void setUserCustomId(long userCustomId) {
		model.setUserCustomId(userCustomId);
	}

	/**
	 * Sets the user ID of this user custom.
	 *
	 * @param userId the user ID of this user custom
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this user custom.
	 *
	 * @param userUuid the user uuid of this user custom
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the zip of this user custom.
	 *
	 * @param zip the zip of this user custom
	 */
	@Override
	public void setZip(String zip) {
		model.setZip(zip);
	}

	@Override
	protected UserCustomWrapper wrap(UserCustom userCustom) {
		return new UserCustomWrapper(userCustom);
	}

}