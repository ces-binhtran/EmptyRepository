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

package com.liferay.training.amf.service.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.AddressLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.training.amf.service.base.AmfSearchLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the amf search local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.training.amf.service.AmfSearchLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmfSearchLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.training.amf.model.AmfSearch",
	service = AopService.class
)
public class AmfSearchLocalServiceImpl extends AmfSearchLocalServiceBaseImpl {

	/**
	 * search User by zip code
	 * String zipCode
	 * @return User list
	 */
	@Override
	public List<User> searchUser(String zipCode) {
		if (zipCode == null || zipCode.equals(StringPool.BLANK)) {
			return new ArrayList<User>();
		}
		List<Address> addresses = searchPrimaryAddress(zipCode);
		if (addresses.isEmpty()) {
			return new ArrayList<User>();
		}
		Set<Long> userIds = userIdsFrom(addresses);
		return _userLocalService.dynamicQuery(getUserSearchDynamicQuery(userIds));
	}

	private DynamicQuery getUserSearchDynamicQuery(Set<Long> userIds) {
		DynamicQuery dynamicQuery = _userLocalService.dynamicQuery();
		Disjunction disjuntionQuery = RestrictionsFactoryUtil.disjunction();
		disjuntionQuery.add(RestrictionsFactoryUtil.in("userId", userIds));
		dynamicQuery.add(disjuntionQuery);
		return dynamicQuery;
	}

	@Override
	public long countUsers(String zipCode) {
		if (zipCode == null || zipCode.equals(StringPool.BLANK)) {
			return 0;
		}
		List<Address> addresses = searchPrimaryAddress(zipCode);
		if (addresses.isEmpty()) {
			return 0;
		}
		Set<Long> userIds = userIdsFrom(addresses);
		return userIds.size();
	}
	
	private Set<Long> userIdsFrom(List<Address> addresses) {
		return addresses.stream().map(Address::getUserId).collect(Collectors.toSet());
	}
	
	private List<Address> searchPrimaryAddress(String zipCode) {
		return AddressLocalServiceUtil.dynamicQuery(getPrimaryAddressDynamicQuery(zipCode));
	}
	
	private DynamicQuery getPrimaryAddressDynamicQuery(String zipCode) {
		DynamicQuery dynamicQuery = AddressLocalServiceUtil.dynamicQuery();
		Disjunction disjuntionQueryZip = RestrictionsFactoryUtil.disjunction();
		disjuntionQueryZip.add(RestrictionsFactoryUtil.eq("zip", zipCode));
		Disjunction disjuntionQueryPrimary = RestrictionsFactoryUtil.disjunction();
		disjuntionQueryPrimary.add(RestrictionsFactoryUtil.eq("primary", Boolean.TRUE));
		dynamicQuery.add(disjuntionQueryZip);
		dynamicQuery.add(disjuntionQueryPrimary);
		return dynamicQuery;
	}
	
	@Reference
	UserLocalService _userLocalService;

}