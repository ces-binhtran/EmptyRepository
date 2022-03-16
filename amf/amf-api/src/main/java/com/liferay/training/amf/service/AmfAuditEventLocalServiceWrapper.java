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
 * Provides a wrapper for {@link AmfAuditEventLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AmfAuditEventLocalService
 * @generated
 */
public class AmfAuditEventLocalServiceWrapper
	implements AmfAuditEventLocalService,
			   ServiceWrapper<AmfAuditEventLocalService> {

	public AmfAuditEventLocalServiceWrapper(
		AmfAuditEventLocalService amfAuditEventLocalService) {

		_amfAuditEventLocalService = amfAuditEventLocalService;
	}

	/**
	 * Adds the amf audit event to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AmfAuditEventLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfAuditEvent the amf audit event
	 * @return the amf audit event that was added
	 */
	@Override
	public com.liferay.training.amf.model.AmfAuditEvent addAmfAuditEvent(
		com.liferay.training.amf.model.AmfAuditEvent amfAuditEvent) {

		return _amfAuditEventLocalService.addAmfAuditEvent(amfAuditEvent);
	}

	/**
	 * Creates a new amf audit event with the primary key. Does not add the amf audit event to the database.
	 *
	 * @param amfAuditEventId the primary key for the new amf audit event
	 * @return the new amf audit event
	 */
	@Override
	public com.liferay.training.amf.model.AmfAuditEvent createAmfAuditEvent(
		long amfAuditEventId) {

		return _amfAuditEventLocalService.createAmfAuditEvent(amfAuditEventId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfAuditEventLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the amf audit event from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AmfAuditEventLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfAuditEvent the amf audit event
	 * @return the amf audit event that was removed
	 */
	@Override
	public com.liferay.training.amf.model.AmfAuditEvent deleteAmfAuditEvent(
		com.liferay.training.amf.model.AmfAuditEvent amfAuditEvent) {

		return _amfAuditEventLocalService.deleteAmfAuditEvent(amfAuditEvent);
	}

	/**
	 * Deletes the amf audit event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AmfAuditEventLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfAuditEventId the primary key of the amf audit event
	 * @return the amf audit event that was removed
	 * @throws PortalException if a amf audit event with the primary key could not be found
	 */
	@Override
	public com.liferay.training.amf.model.AmfAuditEvent deleteAmfAuditEvent(
			long amfAuditEventId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfAuditEventLocalService.deleteAmfAuditEvent(amfAuditEventId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfAuditEventLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _amfAuditEventLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _amfAuditEventLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.amf.model.impl.AmfAuditEventModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _amfAuditEventLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.amf.model.impl.AmfAuditEventModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _amfAuditEventLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _amfAuditEventLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _amfAuditEventLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.training.amf.model.AmfAuditEvent fetchAmfAuditEvent(
		long amfAuditEventId) {

		return _amfAuditEventLocalService.fetchAmfAuditEvent(amfAuditEventId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _amfAuditEventLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the amf audit event with the primary key.
	 *
	 * @param amfAuditEventId the primary key of the amf audit event
	 * @return the amf audit event
	 * @throws PortalException if a amf audit event with the primary key could not be found
	 */
	@Override
	public com.liferay.training.amf.model.AmfAuditEvent getAmfAuditEvent(
			long amfAuditEventId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfAuditEventLocalService.getAmfAuditEvent(amfAuditEventId);
	}

	/**
	 * Returns a range of all the amf audit events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.amf.model.impl.AmfAuditEventModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf audit events
	 * @param end the upper bound of the range of amf audit events (not inclusive)
	 * @return the range of amf audit events
	 */
	@Override
	public java.util.List<com.liferay.training.amf.model.AmfAuditEvent>
		getAmfAuditEvents(int start, int end) {

		return _amfAuditEventLocalService.getAmfAuditEvents(start, end);
	}

	/**
	 * Returns the number of amf audit events.
	 *
	 * @return the number of amf audit events
	 */
	@Override
	public int getAmfAuditEventsCount() {
		return _amfAuditEventLocalService.getAmfAuditEventsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _amfAuditEventLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _amfAuditEventLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfAuditEventLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the amf audit event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AmfAuditEventLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfAuditEvent the amf audit event
	 * @return the amf audit event that was updated
	 */
	@Override
	public com.liferay.training.amf.model.AmfAuditEvent updateAmfAuditEvent(
		com.liferay.training.amf.model.AmfAuditEvent amfAuditEvent) {

		return _amfAuditEventLocalService.updateAmfAuditEvent(amfAuditEvent);
	}

	@Override
	public AmfAuditEventLocalService getWrappedService() {
		return _amfAuditEventLocalService;
	}

	@Override
	public void setWrappedService(
		AmfAuditEventLocalService amfAuditEventLocalService) {

		_amfAuditEventLocalService = amfAuditEventLocalService;
	}

	private AmfAuditEventLocalService _amfAuditEventLocalService;

}