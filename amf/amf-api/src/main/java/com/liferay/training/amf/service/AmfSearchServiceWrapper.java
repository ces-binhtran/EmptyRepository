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
 * Provides a wrapper for {@link AmfSearchService}.
 *
 * @author Brian Wing Shun Chan
 * @see AmfSearchService
 * @generated
 */
public class AmfSearchServiceWrapper
	implements AmfSearchService, ServiceWrapper<AmfSearchService> {

	public AmfSearchServiceWrapper(AmfSearchService amfSearchService) {
		_amfSearchService = amfSearchService;
	}

	@Override
	public long countUsers(String zipCode) {
		return _amfSearchService.countUsers(zipCode);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _amfSearchService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.User> searchUser(
		String zipCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.portal.kernel.model.User> comparator) {

		return _amfSearchService.searchUser(zipCode, start, end, comparator);
	}

	@Override
	public AmfSearchService getWrappedService() {
		return _amfSearchService;
	}

	@Override
	public void setWrappedService(AmfSearchService amfSearchService) {
		_amfSearchService = amfSearchService;
	}

	private AmfSearchService _amfSearchService;

}