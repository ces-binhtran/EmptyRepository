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

package com.liferay.training.amf.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.training.amf.model.AmfAuditEvent;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the amf audit event service. This utility wraps <code>com.liferay.training.amf.service.persistence.impl.AmfAuditEventPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmfAuditEventPersistence
 * @generated
 */
public class AmfAuditEventUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(AmfAuditEvent amfAuditEvent) {
		getPersistence().clearCache(amfAuditEvent);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, AmfAuditEvent> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AmfAuditEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AmfAuditEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AmfAuditEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AmfAuditEvent> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AmfAuditEvent update(AmfAuditEvent amfAuditEvent) {
		return getPersistence().update(amfAuditEvent);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AmfAuditEvent update(
		AmfAuditEvent amfAuditEvent, ServiceContext serviceContext) {

		return getPersistence().update(amfAuditEvent, serviceContext);
	}

	/**
	 * Returns all the amf audit events where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching amf audit events
	 */
	public static List<AmfAuditEvent> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the amf audit events where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmfAuditEventModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of amf audit events
	 * @param end the upper bound of the range of amf audit events (not inclusive)
	 * @return the range of matching amf audit events
	 */
	public static List<AmfAuditEvent> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the amf audit events where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmfAuditEventModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of amf audit events
	 * @param end the upper bound of the range of amf audit events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf audit events
	 */
	public static List<AmfAuditEvent> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<AmfAuditEvent> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the amf audit events where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmfAuditEventModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of amf audit events
	 * @param end the upper bound of the range of amf audit events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amf audit events
	 */
	public static List<AmfAuditEvent> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<AmfAuditEvent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first amf audit event in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf audit event
	 * @throws NoSuchAuditEventException if a matching amf audit event could not be found
	 */
	public static AmfAuditEvent findByGroupId_First(
			long groupId, OrderByComparator<AmfAuditEvent> orderByComparator)
		throws com.liferay.training.amf.exception.NoSuchAuditEventException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first amf audit event in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf audit event, or <code>null</code> if a matching amf audit event could not be found
	 */
	public static AmfAuditEvent fetchByGroupId_First(
		long groupId, OrderByComparator<AmfAuditEvent> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last amf audit event in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf audit event
	 * @throws NoSuchAuditEventException if a matching amf audit event could not be found
	 */
	public static AmfAuditEvent findByGroupId_Last(
			long groupId, OrderByComparator<AmfAuditEvent> orderByComparator)
		throws com.liferay.training.amf.exception.NoSuchAuditEventException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last amf audit event in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf audit event, or <code>null</code> if a matching amf audit event could not be found
	 */
	public static AmfAuditEvent fetchByGroupId_Last(
		long groupId, OrderByComparator<AmfAuditEvent> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the amf audit events before and after the current amf audit event in the ordered set where groupId = &#63;.
	 *
	 * @param amfAuditEventId the primary key of the current amf audit event
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf audit event
	 * @throws NoSuchAuditEventException if a amf audit event with the primary key could not be found
	 */
	public static AmfAuditEvent[] findByGroupId_PrevAndNext(
			long amfAuditEventId, long groupId,
			OrderByComparator<AmfAuditEvent> orderByComparator)
		throws com.liferay.training.amf.exception.NoSuchAuditEventException {

		return getPersistence().findByGroupId_PrevAndNext(
			amfAuditEventId, groupId, orderByComparator);
	}

	/**
	 * Returns all the amf audit events that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching amf audit events that the user has permission to view
	 */
	public static List<AmfAuditEvent> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	 * Returns a range of all the amf audit events that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmfAuditEventModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of amf audit events
	 * @param end the upper bound of the range of amf audit events (not inclusive)
	 * @return the range of matching amf audit events that the user has permission to view
	 */
	public static List<AmfAuditEvent> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the amf audit events that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmfAuditEventModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of amf audit events
	 * @param end the upper bound of the range of amf audit events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf audit events that the user has permission to view
	 */
	public static List<AmfAuditEvent> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<AmfAuditEvent> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the amf audit events before and after the current amf audit event in the ordered set of amf audit events that the user has permission to view where groupId = &#63;.
	 *
	 * @param amfAuditEventId the primary key of the current amf audit event
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf audit event
	 * @throws NoSuchAuditEventException if a amf audit event with the primary key could not be found
	 */
	public static AmfAuditEvent[] filterFindByGroupId_PrevAndNext(
			long amfAuditEventId, long groupId,
			OrderByComparator<AmfAuditEvent> orderByComparator)
		throws com.liferay.training.amf.exception.NoSuchAuditEventException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			amfAuditEventId, groupId, orderByComparator);
	}

	/**
	 * Removes all the amf audit events where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of amf audit events where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching amf audit events
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of amf audit events that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching amf audit events that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Returns all the amf audit events where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching amf audit events
	 */
	public static List<AmfAuditEvent> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the amf audit events where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmfAuditEventModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of amf audit events
	 * @param end the upper bound of the range of amf audit events (not inclusive)
	 * @return the range of matching amf audit events
	 */
	public static List<AmfAuditEvent> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the amf audit events where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmfAuditEventModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of amf audit events
	 * @param end the upper bound of the range of amf audit events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf audit events
	 */
	public static List<AmfAuditEvent> findByUserId(
		long userId, int start, int end,
		OrderByComparator<AmfAuditEvent> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the amf audit events where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmfAuditEventModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of amf audit events
	 * @param end the upper bound of the range of amf audit events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amf audit events
	 */
	public static List<AmfAuditEvent> findByUserId(
		long userId, int start, int end,
		OrderByComparator<AmfAuditEvent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first amf audit event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf audit event
	 * @throws NoSuchAuditEventException if a matching amf audit event could not be found
	 */
	public static AmfAuditEvent findByUserId_First(
			long userId, OrderByComparator<AmfAuditEvent> orderByComparator)
		throws com.liferay.training.amf.exception.NoSuchAuditEventException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first amf audit event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf audit event, or <code>null</code> if a matching amf audit event could not be found
	 */
	public static AmfAuditEvent fetchByUserId_First(
		long userId, OrderByComparator<AmfAuditEvent> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last amf audit event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf audit event
	 * @throws NoSuchAuditEventException if a matching amf audit event could not be found
	 */
	public static AmfAuditEvent findByUserId_Last(
			long userId, OrderByComparator<AmfAuditEvent> orderByComparator)
		throws com.liferay.training.amf.exception.NoSuchAuditEventException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last amf audit event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf audit event, or <code>null</code> if a matching amf audit event could not be found
	 */
	public static AmfAuditEvent fetchByUserId_Last(
		long userId, OrderByComparator<AmfAuditEvent> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the amf audit events before and after the current amf audit event in the ordered set where userId = &#63;.
	 *
	 * @param amfAuditEventId the primary key of the current amf audit event
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf audit event
	 * @throws NoSuchAuditEventException if a amf audit event with the primary key could not be found
	 */
	public static AmfAuditEvent[] findByUserId_PrevAndNext(
			long amfAuditEventId, long userId,
			OrderByComparator<AmfAuditEvent> orderByComparator)
		throws com.liferay.training.amf.exception.NoSuchAuditEventException {

		return getPersistence().findByUserId_PrevAndNext(
			amfAuditEventId, userId, orderByComparator);
	}

	/**
	 * Removes all the amf audit events where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of amf audit events where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching amf audit events
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns all the amf audit events where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the matching amf audit events
	 */
	public static List<AmfAuditEvent> findByType(String eventType) {
		return getPersistence().findByType(eventType);
	}

	/**
	 * Returns a range of all the amf audit events where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmfAuditEventModelImpl</code>.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of amf audit events
	 * @param end the upper bound of the range of amf audit events (not inclusive)
	 * @return the range of matching amf audit events
	 */
	public static List<AmfAuditEvent> findByType(
		String eventType, int start, int end) {

		return getPersistence().findByType(eventType, start, end);
	}

	/**
	 * Returns an ordered range of all the amf audit events where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmfAuditEventModelImpl</code>.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of amf audit events
	 * @param end the upper bound of the range of amf audit events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf audit events
	 */
	public static List<AmfAuditEvent> findByType(
		String eventType, int start, int end,
		OrderByComparator<AmfAuditEvent> orderByComparator) {

		return getPersistence().findByType(
			eventType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the amf audit events where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmfAuditEventModelImpl</code>.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of amf audit events
	 * @param end the upper bound of the range of amf audit events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amf audit events
	 */
	public static List<AmfAuditEvent> findByType(
		String eventType, int start, int end,
		OrderByComparator<AmfAuditEvent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByType(
			eventType, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first amf audit event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf audit event
	 * @throws NoSuchAuditEventException if a matching amf audit event could not be found
	 */
	public static AmfAuditEvent findByType_First(
			String eventType,
			OrderByComparator<AmfAuditEvent> orderByComparator)
		throws com.liferay.training.amf.exception.NoSuchAuditEventException {

		return getPersistence().findByType_First(eventType, orderByComparator);
	}

	/**
	 * Returns the first amf audit event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf audit event, or <code>null</code> if a matching amf audit event could not be found
	 */
	public static AmfAuditEvent fetchByType_First(
		String eventType, OrderByComparator<AmfAuditEvent> orderByComparator) {

		return getPersistence().fetchByType_First(eventType, orderByComparator);
	}

	/**
	 * Returns the last amf audit event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf audit event
	 * @throws NoSuchAuditEventException if a matching amf audit event could not be found
	 */
	public static AmfAuditEvent findByType_Last(
			String eventType,
			OrderByComparator<AmfAuditEvent> orderByComparator)
		throws com.liferay.training.amf.exception.NoSuchAuditEventException {

		return getPersistence().findByType_Last(eventType, orderByComparator);
	}

	/**
	 * Returns the last amf audit event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf audit event, or <code>null</code> if a matching amf audit event could not be found
	 */
	public static AmfAuditEvent fetchByType_Last(
		String eventType, OrderByComparator<AmfAuditEvent> orderByComparator) {

		return getPersistence().fetchByType_Last(eventType, orderByComparator);
	}

	/**
	 * Returns the amf audit events before and after the current amf audit event in the ordered set where eventType = &#63;.
	 *
	 * @param amfAuditEventId the primary key of the current amf audit event
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf audit event
	 * @throws NoSuchAuditEventException if a amf audit event with the primary key could not be found
	 */
	public static AmfAuditEvent[] findByType_PrevAndNext(
			long amfAuditEventId, String eventType,
			OrderByComparator<AmfAuditEvent> orderByComparator)
		throws com.liferay.training.amf.exception.NoSuchAuditEventException {

		return getPersistence().findByType_PrevAndNext(
			amfAuditEventId, eventType, orderByComparator);
	}

	/**
	 * Removes all the amf audit events where eventType = &#63; from the database.
	 *
	 * @param eventType the event type
	 */
	public static void removeByType(String eventType) {
		getPersistence().removeByType(eventType);
	}

	/**
	 * Returns the number of amf audit events where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the number of matching amf audit events
	 */
	public static int countByType(String eventType) {
		return getPersistence().countByType(eventType);
	}

	/**
	 * Returns all the amf audit events where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @return the matching amf audit events
	 */
	public static List<AmfAuditEvent> findByUserId_Type(
		long userId, String eventType) {

		return getPersistence().findByUserId_Type(userId, eventType);
	}

	/**
	 * Returns a range of all the amf audit events where userId = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmfAuditEventModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param start the lower bound of the range of amf audit events
	 * @param end the upper bound of the range of amf audit events (not inclusive)
	 * @return the range of matching amf audit events
	 */
	public static List<AmfAuditEvent> findByUserId_Type(
		long userId, String eventType, int start, int end) {

		return getPersistence().findByUserId_Type(
			userId, eventType, start, end);
	}

	/**
	 * Returns an ordered range of all the amf audit events where userId = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmfAuditEventModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param start the lower bound of the range of amf audit events
	 * @param end the upper bound of the range of amf audit events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf audit events
	 */
	public static List<AmfAuditEvent> findByUserId_Type(
		long userId, String eventType, int start, int end,
		OrderByComparator<AmfAuditEvent> orderByComparator) {

		return getPersistence().findByUserId_Type(
			userId, eventType, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the amf audit events where userId = &#63; and eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmfAuditEventModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param start the lower bound of the range of amf audit events
	 * @param end the upper bound of the range of amf audit events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amf audit events
	 */
	public static List<AmfAuditEvent> findByUserId_Type(
		long userId, String eventType, int start, int end,
		OrderByComparator<AmfAuditEvent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId_Type(
			userId, eventType, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first amf audit event in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf audit event
	 * @throws NoSuchAuditEventException if a matching amf audit event could not be found
	 */
	public static AmfAuditEvent findByUserId_Type_First(
			long userId, String eventType,
			OrderByComparator<AmfAuditEvent> orderByComparator)
		throws com.liferay.training.amf.exception.NoSuchAuditEventException {

		return getPersistence().findByUserId_Type_First(
			userId, eventType, orderByComparator);
	}

	/**
	 * Returns the first amf audit event in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf audit event, or <code>null</code> if a matching amf audit event could not be found
	 */
	public static AmfAuditEvent fetchByUserId_Type_First(
		long userId, String eventType,
		OrderByComparator<AmfAuditEvent> orderByComparator) {

		return getPersistence().fetchByUserId_Type_First(
			userId, eventType, orderByComparator);
	}

	/**
	 * Returns the last amf audit event in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf audit event
	 * @throws NoSuchAuditEventException if a matching amf audit event could not be found
	 */
	public static AmfAuditEvent findByUserId_Type_Last(
			long userId, String eventType,
			OrderByComparator<AmfAuditEvent> orderByComparator)
		throws com.liferay.training.amf.exception.NoSuchAuditEventException {

		return getPersistence().findByUserId_Type_Last(
			userId, eventType, orderByComparator);
	}

	/**
	 * Returns the last amf audit event in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf audit event, or <code>null</code> if a matching amf audit event could not be found
	 */
	public static AmfAuditEvent fetchByUserId_Type_Last(
		long userId, String eventType,
		OrderByComparator<AmfAuditEvent> orderByComparator) {

		return getPersistence().fetchByUserId_Type_Last(
			userId, eventType, orderByComparator);
	}

	/**
	 * Returns the amf audit events before and after the current amf audit event in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param amfAuditEventId the primary key of the current amf audit event
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf audit event
	 * @throws NoSuchAuditEventException if a amf audit event with the primary key could not be found
	 */
	public static AmfAuditEvent[] findByUserId_Type_PrevAndNext(
			long amfAuditEventId, long userId, String eventType,
			OrderByComparator<AmfAuditEvent> orderByComparator)
		throws com.liferay.training.amf.exception.NoSuchAuditEventException {

		return getPersistence().findByUserId_Type_PrevAndNext(
			amfAuditEventId, userId, eventType, orderByComparator);
	}

	/**
	 * Removes all the amf audit events where userId = &#63; and eventType = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 */
	public static void removeByUserId_Type(long userId, String eventType) {
		getPersistence().removeByUserId_Type(userId, eventType);
	}

	/**
	 * Returns the number of amf audit events where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @return the number of matching amf audit events
	 */
	public static int countByUserId_Type(long userId, String eventType) {
		return getPersistence().countByUserId_Type(userId, eventType);
	}

	/**
	 * Caches the amf audit event in the entity cache if it is enabled.
	 *
	 * @param amfAuditEvent the amf audit event
	 */
	public static void cacheResult(AmfAuditEvent amfAuditEvent) {
		getPersistence().cacheResult(amfAuditEvent);
	}

	/**
	 * Caches the amf audit events in the entity cache if it is enabled.
	 *
	 * @param amfAuditEvents the amf audit events
	 */
	public static void cacheResult(List<AmfAuditEvent> amfAuditEvents) {
		getPersistence().cacheResult(amfAuditEvents);
	}

	/**
	 * Creates a new amf audit event with the primary key. Does not add the amf audit event to the database.
	 *
	 * @param amfAuditEventId the primary key for the new amf audit event
	 * @return the new amf audit event
	 */
	public static AmfAuditEvent create(long amfAuditEventId) {
		return getPersistence().create(amfAuditEventId);
	}

	/**
	 * Removes the amf audit event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfAuditEventId the primary key of the amf audit event
	 * @return the amf audit event that was removed
	 * @throws NoSuchAuditEventException if a amf audit event with the primary key could not be found
	 */
	public static AmfAuditEvent remove(long amfAuditEventId)
		throws com.liferay.training.amf.exception.NoSuchAuditEventException {

		return getPersistence().remove(amfAuditEventId);
	}

	public static AmfAuditEvent updateImpl(AmfAuditEvent amfAuditEvent) {
		return getPersistence().updateImpl(amfAuditEvent);
	}

	/**
	 * Returns the amf audit event with the primary key or throws a <code>NoSuchAuditEventException</code> if it could not be found.
	 *
	 * @param amfAuditEventId the primary key of the amf audit event
	 * @return the amf audit event
	 * @throws NoSuchAuditEventException if a amf audit event with the primary key could not be found
	 */
	public static AmfAuditEvent findByPrimaryKey(long amfAuditEventId)
		throws com.liferay.training.amf.exception.NoSuchAuditEventException {

		return getPersistence().findByPrimaryKey(amfAuditEventId);
	}

	/**
	 * Returns the amf audit event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amfAuditEventId the primary key of the amf audit event
	 * @return the amf audit event, or <code>null</code> if a amf audit event with the primary key could not be found
	 */
	public static AmfAuditEvent fetchByPrimaryKey(long amfAuditEventId) {
		return getPersistence().fetchByPrimaryKey(amfAuditEventId);
	}

	/**
	 * Returns all the amf audit events.
	 *
	 * @return the amf audit events
	 */
	public static List<AmfAuditEvent> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the amf audit events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmfAuditEventModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf audit events
	 * @param end the upper bound of the range of amf audit events (not inclusive)
	 * @return the range of amf audit events
	 */
	public static List<AmfAuditEvent> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the amf audit events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmfAuditEventModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf audit events
	 * @param end the upper bound of the range of amf audit events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of amf audit events
	 */
	public static List<AmfAuditEvent> findAll(
		int start, int end,
		OrderByComparator<AmfAuditEvent> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the amf audit events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmfAuditEventModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf audit events
	 * @param end the upper bound of the range of amf audit events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of amf audit events
	 */
	public static List<AmfAuditEvent> findAll(
		int start, int end, OrderByComparator<AmfAuditEvent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the amf audit events from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of amf audit events.
	 *
	 * @return the number of amf audit events
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AmfAuditEventPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AmfAuditEventPersistence, AmfAuditEventPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AmfAuditEventPersistence.class);

		ServiceTracker<AmfAuditEventPersistence, AmfAuditEventPersistence>
			serviceTracker =
				new ServiceTracker
					<AmfAuditEventPersistence, AmfAuditEventPersistence>(
						bundle.getBundleContext(),
						AmfAuditEventPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}