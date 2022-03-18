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

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.training.amf.exception.NoSuchAuditEventException;
import com.liferay.training.amf.model.AmfAuditEvent;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the amf audit event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmfAuditEventUtil
 * @generated
 */
@ProviderType
public interface AmfAuditEventPersistence
	extends BasePersistence<AmfAuditEvent> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AmfAuditEventUtil} to access the amf audit event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the amf audit events where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching amf audit events
	 */
	public java.util.List<AmfAuditEvent> findByGroupId(long groupId);

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
	public java.util.List<AmfAuditEvent> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<AmfAuditEvent> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
			orderByComparator);

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
	public java.util.List<AmfAuditEvent> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first amf audit event in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf audit event
	 * @throws NoSuchAuditEventException if a matching amf audit event could not be found
	 */
	public AmfAuditEvent findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
				orderByComparator)
		throws NoSuchAuditEventException;

	/**
	 * Returns the first amf audit event in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf audit event, or <code>null</code> if a matching amf audit event could not be found
	 */
	public AmfAuditEvent fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
			orderByComparator);

	/**
	 * Returns the last amf audit event in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf audit event
	 * @throws NoSuchAuditEventException if a matching amf audit event could not be found
	 */
	public AmfAuditEvent findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
				orderByComparator)
		throws NoSuchAuditEventException;

	/**
	 * Returns the last amf audit event in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf audit event, or <code>null</code> if a matching amf audit event could not be found
	 */
	public AmfAuditEvent fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
			orderByComparator);

	/**
	 * Returns the amf audit events before and after the current amf audit event in the ordered set where groupId = &#63;.
	 *
	 * @param amfAuditEventId the primary key of the current amf audit event
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf audit event
	 * @throws NoSuchAuditEventException if a amf audit event with the primary key could not be found
	 */
	public AmfAuditEvent[] findByGroupId_PrevAndNext(
			long amfAuditEventId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
				orderByComparator)
		throws NoSuchAuditEventException;

	/**
	 * Returns all the amf audit events that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching amf audit events that the user has permission to view
	 */
	public java.util.List<AmfAuditEvent> filterFindByGroupId(long groupId);

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
	public java.util.List<AmfAuditEvent> filterFindByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<AmfAuditEvent> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
			orderByComparator);

	/**
	 * Returns the amf audit events before and after the current amf audit event in the ordered set of amf audit events that the user has permission to view where groupId = &#63;.
	 *
	 * @param amfAuditEventId the primary key of the current amf audit event
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf audit event
	 * @throws NoSuchAuditEventException if a amf audit event with the primary key could not be found
	 */
	public AmfAuditEvent[] filterFindByGroupId_PrevAndNext(
			long amfAuditEventId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
				orderByComparator)
		throws NoSuchAuditEventException;

	/**
	 * Removes all the amf audit events where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of amf audit events where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching amf audit events
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of amf audit events that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching amf audit events that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the amf audit events where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching amf audit events
	 */
	public java.util.List<AmfAuditEvent> findByUserId(long userId);

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
	public java.util.List<AmfAuditEvent> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<AmfAuditEvent> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
			orderByComparator);

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
	public java.util.List<AmfAuditEvent> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first amf audit event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf audit event
	 * @throws NoSuchAuditEventException if a matching amf audit event could not be found
	 */
	public AmfAuditEvent findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
				orderByComparator)
		throws NoSuchAuditEventException;

	/**
	 * Returns the first amf audit event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf audit event, or <code>null</code> if a matching amf audit event could not be found
	 */
	public AmfAuditEvent fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
			orderByComparator);

	/**
	 * Returns the last amf audit event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf audit event
	 * @throws NoSuchAuditEventException if a matching amf audit event could not be found
	 */
	public AmfAuditEvent findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
				orderByComparator)
		throws NoSuchAuditEventException;

	/**
	 * Returns the last amf audit event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf audit event, or <code>null</code> if a matching amf audit event could not be found
	 */
	public AmfAuditEvent fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
			orderByComparator);

	/**
	 * Returns the amf audit events before and after the current amf audit event in the ordered set where userId = &#63;.
	 *
	 * @param amfAuditEventId the primary key of the current amf audit event
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf audit event
	 * @throws NoSuchAuditEventException if a amf audit event with the primary key could not be found
	 */
	public AmfAuditEvent[] findByUserId_PrevAndNext(
			long amfAuditEventId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
				orderByComparator)
		throws NoSuchAuditEventException;

	/**
	 * Removes all the amf audit events where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of amf audit events where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching amf audit events
	 */
	public int countByUserId(long userId);

	/**
	 * Returns all the amf audit events where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the matching amf audit events
	 */
	public java.util.List<AmfAuditEvent> findByType(String eventType);

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
	public java.util.List<AmfAuditEvent> findByType(
		String eventType, int start, int end);

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
	public java.util.List<AmfAuditEvent> findByType(
		String eventType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
			orderByComparator);

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
	public java.util.List<AmfAuditEvent> findByType(
		String eventType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first amf audit event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf audit event
	 * @throws NoSuchAuditEventException if a matching amf audit event could not be found
	 */
	public AmfAuditEvent findByType_First(
			String eventType,
			com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
				orderByComparator)
		throws NoSuchAuditEventException;

	/**
	 * Returns the first amf audit event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf audit event, or <code>null</code> if a matching amf audit event could not be found
	 */
	public AmfAuditEvent fetchByType_First(
		String eventType,
		com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
			orderByComparator);

	/**
	 * Returns the last amf audit event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf audit event
	 * @throws NoSuchAuditEventException if a matching amf audit event could not be found
	 */
	public AmfAuditEvent findByType_Last(
			String eventType,
			com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
				orderByComparator)
		throws NoSuchAuditEventException;

	/**
	 * Returns the last amf audit event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf audit event, or <code>null</code> if a matching amf audit event could not be found
	 */
	public AmfAuditEvent fetchByType_Last(
		String eventType,
		com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
			orderByComparator);

	/**
	 * Returns the amf audit events before and after the current amf audit event in the ordered set where eventType = &#63;.
	 *
	 * @param amfAuditEventId the primary key of the current amf audit event
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf audit event
	 * @throws NoSuchAuditEventException if a amf audit event with the primary key could not be found
	 */
	public AmfAuditEvent[] findByType_PrevAndNext(
			long amfAuditEventId, String eventType,
			com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
				orderByComparator)
		throws NoSuchAuditEventException;

	/**
	 * Removes all the amf audit events where eventType = &#63; from the database.
	 *
	 * @param eventType the event type
	 */
	public void removeByType(String eventType);

	/**
	 * Returns the number of amf audit events where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the number of matching amf audit events
	 */
	public int countByType(String eventType);

	/**
	 * Returns all the amf audit events where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @return the matching amf audit events
	 */
	public java.util.List<AmfAuditEvent> findByUserId_Type(
		long userId, String eventType);

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
	public java.util.List<AmfAuditEvent> findByUserId_Type(
		long userId, String eventType, int start, int end);

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
	public java.util.List<AmfAuditEvent> findByUserId_Type(
		long userId, String eventType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
			orderByComparator);

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
	public java.util.List<AmfAuditEvent> findByUserId_Type(
		long userId, String eventType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first amf audit event in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf audit event
	 * @throws NoSuchAuditEventException if a matching amf audit event could not be found
	 */
	public AmfAuditEvent findByUserId_Type_First(
			long userId, String eventType,
			com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
				orderByComparator)
		throws NoSuchAuditEventException;

	/**
	 * Returns the first amf audit event in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf audit event, or <code>null</code> if a matching amf audit event could not be found
	 */
	public AmfAuditEvent fetchByUserId_Type_First(
		long userId, String eventType,
		com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
			orderByComparator);

	/**
	 * Returns the last amf audit event in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf audit event
	 * @throws NoSuchAuditEventException if a matching amf audit event could not be found
	 */
	public AmfAuditEvent findByUserId_Type_Last(
			long userId, String eventType,
			com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
				orderByComparator)
		throws NoSuchAuditEventException;

	/**
	 * Returns the last amf audit event in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf audit event, or <code>null</code> if a matching amf audit event could not be found
	 */
	public AmfAuditEvent fetchByUserId_Type_Last(
		long userId, String eventType,
		com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
			orderByComparator);

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
	public AmfAuditEvent[] findByUserId_Type_PrevAndNext(
			long amfAuditEventId, long userId, String eventType,
			com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
				orderByComparator)
		throws NoSuchAuditEventException;

	/**
	 * Removes all the amf audit events where userId = &#63; and eventType = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 */
	public void removeByUserId_Type(long userId, String eventType);

	/**
	 * Returns the number of amf audit events where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @return the number of matching amf audit events
	 */
	public int countByUserId_Type(long userId, String eventType);

	/**
	 * Caches the amf audit event in the entity cache if it is enabled.
	 *
	 * @param amfAuditEvent the amf audit event
	 */
	public void cacheResult(AmfAuditEvent amfAuditEvent);

	/**
	 * Caches the amf audit events in the entity cache if it is enabled.
	 *
	 * @param amfAuditEvents the amf audit events
	 */
	public void cacheResult(java.util.List<AmfAuditEvent> amfAuditEvents);

	/**
	 * Creates a new amf audit event with the primary key. Does not add the amf audit event to the database.
	 *
	 * @param amfAuditEventId the primary key for the new amf audit event
	 * @return the new amf audit event
	 */
	public AmfAuditEvent create(long amfAuditEventId);

	/**
	 * Removes the amf audit event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfAuditEventId the primary key of the amf audit event
	 * @return the amf audit event that was removed
	 * @throws NoSuchAuditEventException if a amf audit event with the primary key could not be found
	 */
	public AmfAuditEvent remove(long amfAuditEventId)
		throws NoSuchAuditEventException;

	public AmfAuditEvent updateImpl(AmfAuditEvent amfAuditEvent);

	/**
	 * Returns the amf audit event with the primary key or throws a <code>NoSuchAuditEventException</code> if it could not be found.
	 *
	 * @param amfAuditEventId the primary key of the amf audit event
	 * @return the amf audit event
	 * @throws NoSuchAuditEventException if a amf audit event with the primary key could not be found
	 */
	public AmfAuditEvent findByPrimaryKey(long amfAuditEventId)
		throws NoSuchAuditEventException;

	/**
	 * Returns the amf audit event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amfAuditEventId the primary key of the amf audit event
	 * @return the amf audit event, or <code>null</code> if a amf audit event with the primary key could not be found
	 */
	public AmfAuditEvent fetchByPrimaryKey(long amfAuditEventId);

	/**
	 * Returns all the amf audit events.
	 *
	 * @return the amf audit events
	 */
	public java.util.List<AmfAuditEvent> findAll();

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
	public java.util.List<AmfAuditEvent> findAll(int start, int end);

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
	public java.util.List<AmfAuditEvent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
			orderByComparator);

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
	public java.util.List<AmfAuditEvent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AmfAuditEvent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the amf audit events from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of amf audit events.
	 *
	 * @return the number of amf audit events
	 */
	public int countAll();

}