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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.training.amf.registration.model.UserCustom;
import com.liferay.training.amf.registration.model.UserCustomModel;
import com.liferay.training.amf.registration.model.UserCustomSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the UserCustom service. Represents a row in the &quot;AmfRegistration_UserCustom&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>UserCustomModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserCustomImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserCustomImpl
 * @generated
 */
@JSON(strict = true)
public class UserCustomModelImpl
	extends BaseModelImpl<UserCustom> implements UserCustomModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user custom model instance should use the <code>UserCustom</code> interface instead.
	 */
	public static final String TABLE_NAME = "AmfRegistration_UserCustom";

	public static final Object[][] TABLE_COLUMNS = {
		{"userCustomId", Types.BIGINT}, {"homePhone", Types.VARCHAR},
		{"mobilePhone", Types.VARCHAR}, {"userId", Types.BIGINT},
		{"address", Types.VARCHAR}, {"address2", Types.VARCHAR},
		{"city", Types.VARCHAR}, {"state_", Types.VARCHAR},
		{"zip", Types.VARCHAR}, {"securityQuestion", Types.VARCHAR},
		{"securityAnswer", Types.VARCHAR}, {"acceptedTou", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("userCustomId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("homePhone", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("mobilePhone", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("address", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("address2", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("city", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("state_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("zip", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("securityQuestion", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("securityAnswer", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("acceptedTou", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table AmfRegistration_UserCustom (userCustomId LONG not null primary key,homePhone VARCHAR(75) null,mobilePhone VARCHAR(75) null,userId LONG,address VARCHAR(75) null,address2 VARCHAR(75) null,city VARCHAR(75) null,state_ VARCHAR(75) null,zip VARCHAR(75) null,securityQuestion VARCHAR(75) null,securityAnswer VARCHAR(75) null,acceptedTou BOOLEAN)";

	public static final String TABLE_SQL_DROP =
		"drop table AmfRegistration_UserCustom";

	public static final String ORDER_BY_JPQL =
		" ORDER BY userCustom.userCustomId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY AmfRegistration_UserCustom.userCustomId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static UserCustom toModel(UserCustomSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		UserCustom model = new UserCustomImpl();

		model.setUserCustomId(soapModel.getUserCustomId());
		model.setHomePhone(soapModel.getHomePhone());
		model.setMobilePhone(soapModel.getMobilePhone());
		model.setUserId(soapModel.getUserId());
		model.setAddress(soapModel.getAddress());
		model.setAddress2(soapModel.getAddress2());
		model.setCity(soapModel.getCity());
		model.setState(soapModel.getState());
		model.setZip(soapModel.getZip());
		model.setSecurityQuestion(soapModel.getSecurityQuestion());
		model.setSecurityAnswer(soapModel.getSecurityAnswer());
		model.setAcceptedTou(soapModel.isAcceptedTou());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<UserCustom> toModels(UserCustomSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<UserCustom> models = new ArrayList<UserCustom>(soapModels.length);

		for (UserCustomSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public UserCustomModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _userCustomId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserCustomId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userCustomId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return UserCustom.class;
	}

	@Override
	public String getModelClassName() {
		return UserCustom.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<UserCustom, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<UserCustom, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UserCustom, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((UserCustom)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<UserCustom, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<UserCustom, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(UserCustom)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<UserCustom, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<UserCustom, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, UserCustom>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			UserCustom.class.getClassLoader(), UserCustom.class,
			ModelWrapper.class);

		try {
			Constructor<UserCustom> constructor =
				(Constructor<UserCustom>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<UserCustom, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<UserCustom, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<UserCustom, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<UserCustom, Object>>();
		Map<String, BiConsumer<UserCustom, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<UserCustom, ?>>();

		attributeGetterFunctions.put(
			"userCustomId", UserCustom::getUserCustomId);
		attributeSetterBiConsumers.put(
			"userCustomId",
			(BiConsumer<UserCustom, Long>)UserCustom::setUserCustomId);
		attributeGetterFunctions.put("homePhone", UserCustom::getHomePhone);
		attributeSetterBiConsumers.put(
			"homePhone",
			(BiConsumer<UserCustom, String>)UserCustom::setHomePhone);
		attributeGetterFunctions.put("mobilePhone", UserCustom::getMobilePhone);
		attributeSetterBiConsumers.put(
			"mobilePhone",
			(BiConsumer<UserCustom, String>)UserCustom::setMobilePhone);
		attributeGetterFunctions.put("userId", UserCustom::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<UserCustom, Long>)UserCustom::setUserId);
		attributeGetterFunctions.put("address", UserCustom::getAddress);
		attributeSetterBiConsumers.put(
			"address", (BiConsumer<UserCustom, String>)UserCustom::setAddress);
		attributeGetterFunctions.put("address2", UserCustom::getAddress2);
		attributeSetterBiConsumers.put(
			"address2",
			(BiConsumer<UserCustom, String>)UserCustom::setAddress2);
		attributeGetterFunctions.put("city", UserCustom::getCity);
		attributeSetterBiConsumers.put(
			"city", (BiConsumer<UserCustom, String>)UserCustom::setCity);
		attributeGetterFunctions.put("state", UserCustom::getState);
		attributeSetterBiConsumers.put(
			"state", (BiConsumer<UserCustom, String>)UserCustom::setState);
		attributeGetterFunctions.put("zip", UserCustom::getZip);
		attributeSetterBiConsumers.put(
			"zip", (BiConsumer<UserCustom, String>)UserCustom::setZip);
		attributeGetterFunctions.put(
			"securityQuestion", UserCustom::getSecurityQuestion);
		attributeSetterBiConsumers.put(
			"securityQuestion",
			(BiConsumer<UserCustom, String>)UserCustom::setSecurityQuestion);
		attributeGetterFunctions.put(
			"securityAnswer", UserCustom::getSecurityAnswer);
		attributeSetterBiConsumers.put(
			"securityAnswer",
			(BiConsumer<UserCustom, String>)UserCustom::setSecurityAnswer);
		attributeGetterFunctions.put("acceptedTou", UserCustom::getAcceptedTou);
		attributeSetterBiConsumers.put(
			"acceptedTou",
			(BiConsumer<UserCustom, Boolean>)UserCustom::setAcceptedTou);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getUserCustomId() {
		return _userCustomId;
	}

	@Override
	public void setUserCustomId(long userCustomId) {
		_userCustomId = userCustomId;
	}

	@JSON
	@Override
	public String getHomePhone() {
		if (_homePhone == null) {
			return "";
		}
		else {
			return _homePhone;
		}
	}

	@Override
	public void setHomePhone(String homePhone) {
		_homePhone = homePhone;
	}

	@JSON
	@Override
	public String getMobilePhone() {
		if (_mobilePhone == null) {
			return "";
		}
		else {
			return _mobilePhone;
		}
	}

	@Override
	public void setMobilePhone(String mobilePhone) {
		_mobilePhone = mobilePhone;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getAddress() {
		if (_address == null) {
			return "";
		}
		else {
			return _address;
		}
	}

	@Override
	public void setAddress(String address) {
		_address = address;
	}

	@JSON
	@Override
	public String getAddress2() {
		if (_address2 == null) {
			return "";
		}
		else {
			return _address2;
		}
	}

	@Override
	public void setAddress2(String address2) {
		_address2 = address2;
	}

	@JSON
	@Override
	public String getCity() {
		if (_city == null) {
			return "";
		}
		else {
			return _city;
		}
	}

	@Override
	public void setCity(String city) {
		_city = city;
	}

	@JSON
	@Override
	public String getState() {
		if (_state == null) {
			return "";
		}
		else {
			return _state;
		}
	}

	@Override
	public void setState(String state) {
		_state = state;
	}

	@JSON
	@Override
	public String getZip() {
		if (_zip == null) {
			return "";
		}
		else {
			return _zip;
		}
	}

	@Override
	public void setZip(String zip) {
		_zip = zip;
	}

	@JSON
	@Override
	public String getSecurityQuestion() {
		if (_securityQuestion == null) {
			return "";
		}
		else {
			return _securityQuestion;
		}
	}

	@Override
	public void setSecurityQuestion(String securityQuestion) {
		_securityQuestion = securityQuestion;
	}

	@JSON
	@Override
	public String getSecurityAnswer() {
		if (_securityAnswer == null) {
			return "";
		}
		else {
			return _securityAnswer;
		}
	}

	@Override
	public void setSecurityAnswer(String securityAnswer) {
		_securityAnswer = securityAnswer;
	}

	@JSON
	@Override
	public boolean getAcceptedTou() {
		return _acceptedTou;
	}

	@JSON
	@Override
	public boolean isAcceptedTou() {
		return _acceptedTou;
	}

	@Override
	public void setAcceptedTou(boolean acceptedTou) {
		_acceptedTou = acceptedTou;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, UserCustom.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public UserCustom toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, UserCustom>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		UserCustomImpl userCustomImpl = new UserCustomImpl();

		userCustomImpl.setUserCustomId(getUserCustomId());
		userCustomImpl.setHomePhone(getHomePhone());
		userCustomImpl.setMobilePhone(getMobilePhone());
		userCustomImpl.setUserId(getUserId());
		userCustomImpl.setAddress(getAddress());
		userCustomImpl.setAddress2(getAddress2());
		userCustomImpl.setCity(getCity());
		userCustomImpl.setState(getState());
		userCustomImpl.setZip(getZip());
		userCustomImpl.setSecurityQuestion(getSecurityQuestion());
		userCustomImpl.setSecurityAnswer(getSecurityAnswer());
		userCustomImpl.setAcceptedTou(isAcceptedTou());

		userCustomImpl.resetOriginalValues();

		return userCustomImpl;
	}

	@Override
	public int compareTo(UserCustom userCustom) {
		long primaryKey = userCustom.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserCustom)) {
			return false;
		}

		UserCustom userCustom = (UserCustom)object;

		long primaryKey = userCustom.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<UserCustom> toCacheModel() {
		UserCustomCacheModel userCustomCacheModel = new UserCustomCacheModel();

		userCustomCacheModel.userCustomId = getUserCustomId();

		userCustomCacheModel.homePhone = getHomePhone();

		String homePhone = userCustomCacheModel.homePhone;

		if ((homePhone != null) && (homePhone.length() == 0)) {
			userCustomCacheModel.homePhone = null;
		}

		userCustomCacheModel.mobilePhone = getMobilePhone();

		String mobilePhone = userCustomCacheModel.mobilePhone;

		if ((mobilePhone != null) && (mobilePhone.length() == 0)) {
			userCustomCacheModel.mobilePhone = null;
		}

		userCustomCacheModel.userId = getUserId();

		userCustomCacheModel.address = getAddress();

		String address = userCustomCacheModel.address;

		if ((address != null) && (address.length() == 0)) {
			userCustomCacheModel.address = null;
		}

		userCustomCacheModel.address2 = getAddress2();

		String address2 = userCustomCacheModel.address2;

		if ((address2 != null) && (address2.length() == 0)) {
			userCustomCacheModel.address2 = null;
		}

		userCustomCacheModel.city = getCity();

		String city = userCustomCacheModel.city;

		if ((city != null) && (city.length() == 0)) {
			userCustomCacheModel.city = null;
		}

		userCustomCacheModel.state = getState();

		String state = userCustomCacheModel.state;

		if ((state != null) && (state.length() == 0)) {
			userCustomCacheModel.state = null;
		}

		userCustomCacheModel.zip = getZip();

		String zip = userCustomCacheModel.zip;

		if ((zip != null) && (zip.length() == 0)) {
			userCustomCacheModel.zip = null;
		}

		userCustomCacheModel.securityQuestion = getSecurityQuestion();

		String securityQuestion = userCustomCacheModel.securityQuestion;

		if ((securityQuestion != null) && (securityQuestion.length() == 0)) {
			userCustomCacheModel.securityQuestion = null;
		}

		userCustomCacheModel.securityAnswer = getSecurityAnswer();

		String securityAnswer = userCustomCacheModel.securityAnswer;

		if ((securityAnswer != null) && (securityAnswer.length() == 0)) {
			userCustomCacheModel.securityAnswer = null;
		}

		userCustomCacheModel.acceptedTou = isAcceptedTou();

		return userCustomCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<UserCustom, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<UserCustom, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UserCustom, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((UserCustom)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<UserCustom, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<UserCustom, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<UserCustom, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((UserCustom)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, UserCustom>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

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
	private UserCustom _escapedModel;

}