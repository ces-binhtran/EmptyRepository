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

package com.liferay.training.amf.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AmfSearchLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AmfSearchLocalService
 * @generated
 */
public class AmfSearchLocalServiceWrapper
	implements AmfSearchLocalService, ServiceWrapper<AmfSearchLocalService> {

	public AmfSearchLocalServiceWrapper(
		AmfSearchLocalService amfSearchLocalService) {

		_amfSearchLocalService = amfSearchLocalService;
	}

	@Override
	public long countUsers(String zipCode) {
		return _amfSearchLocalService.countUsers(zipCode);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _amfSearchLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * search User by zip code
	 * String zipCode
	 *
	 * @return User list
	 */
	@Override
	public java.util.List<com.liferay.portal.kernel.model.User> searchUser(
		String zipCode) {

		return _amfSearchLocalService.searchUser(zipCode);
	}

	@Override
	public AmfSearchLocalService getWrappedService() {
		return _amfSearchLocalService;
	}

	@Override
	public void setWrappedService(AmfSearchLocalService amfSearchLocalService) {
		_amfSearchLocalService = amfSearchLocalService;
	}

	private AmfSearchLocalService _amfSearchLocalService;

}