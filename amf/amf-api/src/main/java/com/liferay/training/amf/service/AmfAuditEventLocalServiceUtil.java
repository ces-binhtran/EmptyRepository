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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for AmfAuditEvent. This utility wraps
 * <code>com.liferay.training.amf.service.impl.AmfAuditEventLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AmfAuditEventLocalService
 * @generated
 */
public class AmfAuditEventLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.training.amf.service.impl.AmfAuditEventLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static com.liferay.training.amf.model.AmfAuditEvent addAmfAuditEvent(
		com.liferay.training.amf.model.AmfAuditEvent amfAuditEvent) {

		return getService().addAmfAuditEvent(amfAuditEvent);
	}

	/**
	 * Creates a new amf audit event with the primary key. Does not add the amf audit event to the database.
	 *
	 * @param amfAuditEventId the primary key for the new amf audit event
	 * @return the new amf audit event
	 */
	public static com.liferay.training.amf.model.AmfAuditEvent
		createAmfAuditEvent(long amfAuditEventId) {

		return getService().createAmfAuditEvent(amfAuditEventId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static com.liferay.training.amf.model.AmfAuditEvent
		deleteAmfAuditEvent(
			com.liferay.training.amf.model.AmfAuditEvent amfAuditEvent) {

		return getService().deleteAmfAuditEvent(amfAuditEvent);
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
	public static com.liferay.training.amf.model.AmfAuditEvent
			deleteAmfAuditEvent(long amfAuditEventId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteAmfAuditEvent(amfAuditEventId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.training.amf.model.AmfAuditEvent
		fetchAmfAuditEvent(long amfAuditEventId) {

		return getService().fetchAmfAuditEvent(amfAuditEventId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the amf audit event with the primary key.
	 *
	 * @param amfAuditEventId the primary key of the amf audit event
	 * @return the amf audit event
	 * @throws PortalException if a amf audit event with the primary key could not be found
	 */
	public static com.liferay.training.amf.model.AmfAuditEvent getAmfAuditEvent(
			long amfAuditEventId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAmfAuditEvent(amfAuditEventId);
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
	public static java.util.List<com.liferay.training.amf.model.AmfAuditEvent>
		getAmfAuditEvents(int start, int end) {

		return getService().getAmfAuditEvents(start, end);
	}

	/**
	 * Returns the number of amf audit events.
	 *
	 * @return the number of amf audit events
	 */
	public static int getAmfAuditEventsCount() {
		return getService().getAmfAuditEventsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static com.liferay.training.amf.model.AmfAuditEvent
		updateAmfAuditEvent(
			com.liferay.training.amf.model.AmfAuditEvent amfAuditEvent) {

		return getService().updateAmfAuditEvent(amfAuditEvent);
	}

	public static AmfAuditEventLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AmfAuditEventLocalService, AmfAuditEventLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			AmfAuditEventLocalService.class);

		ServiceTracker<AmfAuditEventLocalService, AmfAuditEventLocalService>
			serviceTracker =
				new ServiceTracker
					<AmfAuditEventLocalService, AmfAuditEventLocalService>(
						bundle.getBundleContext(),
						AmfAuditEventLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}