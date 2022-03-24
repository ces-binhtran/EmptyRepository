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

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.training.amf.service.base.AmfSearchServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the amf search remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.training.amf.service.AmfSearchService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmfSearchServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=amf",
		"json.web.service.context.path=AmfSearch"
	},
	service = AopService.class
)
public class AmfSearchServiceImpl extends AmfSearchServiceBaseImpl {

	@Override
	public List<User> searchUser(String zipCode, int start, int end, OrderByComparator<User> comparator) {
		return amfSearchLocalService.searchUser(zipCode, start, end, comparator);
	}

	@Override
	public long countUsers(String zipCode) {
		return amfSearchLocalService.countUsers(zipCode);
	}

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.liferay.training.amf.service.AmfSearchServiceUtil</code> to access the amf search remote service.
	 */
}