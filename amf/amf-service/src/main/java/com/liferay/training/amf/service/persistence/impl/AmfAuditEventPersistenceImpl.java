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

package com.liferay.training.amf.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.training.amf.exception.NoSuchAuditEventException;
import com.liferay.training.amf.model.AmfAuditEvent;
import com.liferay.training.amf.model.impl.AmfAuditEventImpl;
import com.liferay.training.amf.model.impl.AmfAuditEventModelImpl;
import com.liferay.training.amf.service.persistence.AmfAuditEventPersistence;
import com.liferay.training.amf.service.persistence.impl.constants.AmfPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the amf audit event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AmfAuditEventPersistence.class)
public class AmfAuditEventPersistenceImpl
	extends BasePersistenceImpl<AmfAuditEvent>
	implements AmfAuditEventPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AmfAuditEventUtil</code> to access the amf audit event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AmfAuditEventImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the amf audit events where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching amf audit events
	 */
	@Override
	public List<AmfAuditEvent> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AmfAuditEvent> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<AmfAuditEvent> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<AmfAuditEvent> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<AmfAuditEvent> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<AmfAuditEvent> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<AmfAuditEvent> list = null;

		if (useFinderCache) {
			list = (List<AmfAuditEvent>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AmfAuditEvent amfAuditEvent : list) {
					if (groupId != amfAuditEvent.getGroupId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_AMFAUDITEVENT_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AmfAuditEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<AmfAuditEvent>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first amf audit event in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf audit event
	 * @throws NoSuchAuditEventException if a matching amf audit event could not be found
	 */
	@Override
	public AmfAuditEvent findByGroupId_First(
			long groupId, OrderByComparator<AmfAuditEvent> orderByComparator)
		throws NoSuchAuditEventException {

		AmfAuditEvent amfAuditEvent = fetchByGroupId_First(
			groupId, orderByComparator);

		if (amfAuditEvent != null) {
			return amfAuditEvent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchAuditEventException(sb.toString());
	}

	/**
	 * Returns the first amf audit event in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf audit event, or <code>null</code> if a matching amf audit event could not be found
	 */
	@Override
	public AmfAuditEvent fetchByGroupId_First(
		long groupId, OrderByComparator<AmfAuditEvent> orderByComparator) {

		List<AmfAuditEvent> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amf audit event in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf audit event
	 * @throws NoSuchAuditEventException if a matching amf audit event could not be found
	 */
	@Override
	public AmfAuditEvent findByGroupId_Last(
			long groupId, OrderByComparator<AmfAuditEvent> orderByComparator)
		throws NoSuchAuditEventException {

		AmfAuditEvent amfAuditEvent = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (amfAuditEvent != null) {
			return amfAuditEvent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchAuditEventException(sb.toString());
	}

	/**
	 * Returns the last amf audit event in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf audit event, or <code>null</code> if a matching amf audit event could not be found
	 */
	@Override
	public AmfAuditEvent fetchByGroupId_Last(
		long groupId, OrderByComparator<AmfAuditEvent> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<AmfAuditEvent> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AmfAuditEvent[] findByGroupId_PrevAndNext(
			long amfAuditEventId, long groupId,
			OrderByComparator<AmfAuditEvent> orderByComparator)
		throws NoSuchAuditEventException {

		AmfAuditEvent amfAuditEvent = findByPrimaryKey(amfAuditEventId);

		Session session = null;

		try {
			session = openSession();

			AmfAuditEvent[] array = new AmfAuditEventImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, amfAuditEvent, groupId, orderByComparator, true);

			array[1] = amfAuditEvent;

			array[2] = getByGroupId_PrevAndNext(
				session, amfAuditEvent, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AmfAuditEvent getByGroupId_PrevAndNext(
		Session session, AmfAuditEvent amfAuditEvent, long groupId,
		OrderByComparator<AmfAuditEvent> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AMFAUDITEVENT_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AmfAuditEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						amfAuditEvent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AmfAuditEvent> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the amf audit events that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching amf audit events that the user has permission to view
	 */
	@Override
	public List<AmfAuditEvent> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AmfAuditEvent> filterFindByGroupId(
		long groupId, int start, int end) {

		return filterFindByGroupId(groupId, start, end, null);
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
	@Override
	public List<AmfAuditEvent> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<AmfAuditEvent> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				3 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_AMFAUDITEVENT_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_AMFAUDITEVENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_AMFAUDITEVENT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(AmfAuditEventModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(AmfAuditEventModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), AmfAuditEvent.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(
					_FILTER_ENTITY_ALIAS, AmfAuditEventImpl.class);
			}
			else {
				sqlQuery.addEntity(
					_FILTER_ENTITY_TABLE, AmfAuditEventImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			return (List<AmfAuditEvent>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public AmfAuditEvent[] filterFindByGroupId_PrevAndNext(
			long amfAuditEventId, long groupId,
			OrderByComparator<AmfAuditEvent> orderByComparator)
		throws NoSuchAuditEventException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(
				amfAuditEventId, groupId, orderByComparator);
		}

		AmfAuditEvent amfAuditEvent = findByPrimaryKey(amfAuditEventId);

		Session session = null;

		try {
			session = openSession();

			AmfAuditEvent[] array = new AmfAuditEventImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(
				session, amfAuditEvent, groupId, orderByComparator, true);

			array[1] = amfAuditEvent;

			array[2] = filterGetByGroupId_PrevAndNext(
				session, amfAuditEvent, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AmfAuditEvent filterGetByGroupId_PrevAndNext(
		Session session, AmfAuditEvent amfAuditEvent, long groupId,
		OrderByComparator<AmfAuditEvent> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_AMFAUDITEVENT_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_AMFAUDITEVENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_AMFAUDITEVENT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(AmfAuditEventModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(AmfAuditEventModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), AmfAuditEvent.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, AmfAuditEventImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, AmfAuditEventImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						amfAuditEvent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AmfAuditEvent> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amf audit events where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (AmfAuditEvent amfAuditEvent :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(amfAuditEvent);
		}
	}

	/**
	 * Returns the number of amf audit events where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching amf audit events
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AMFAUDITEVENT_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of amf audit events that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching amf audit events that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler sb = new StringBundler(2);

		sb.append(_FILTER_SQL_COUNT_AMFAUDITEVENT_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), AmfAuditEvent.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"amfAuditEvent.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the amf audit events where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching amf audit events
	 */
	@Override
	public List<AmfAuditEvent> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AmfAuditEvent> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<AmfAuditEvent> findByUserId(
		long userId, int start, int end,
		OrderByComparator<AmfAuditEvent> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<AmfAuditEvent> findByUserId(
		long userId, int start, int end,
		OrderByComparator<AmfAuditEvent> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<AmfAuditEvent> list = null;

		if (useFinderCache) {
			list = (List<AmfAuditEvent>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AmfAuditEvent amfAuditEvent : list) {
					if (userId != amfAuditEvent.getUserId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_AMFAUDITEVENT_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AmfAuditEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<AmfAuditEvent>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first amf audit event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf audit event
	 * @throws NoSuchAuditEventException if a matching amf audit event could not be found
	 */
	@Override
	public AmfAuditEvent findByUserId_First(
			long userId, OrderByComparator<AmfAuditEvent> orderByComparator)
		throws NoSuchAuditEventException {

		AmfAuditEvent amfAuditEvent = fetchByUserId_First(
			userId, orderByComparator);

		if (amfAuditEvent != null) {
			return amfAuditEvent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchAuditEventException(sb.toString());
	}

	/**
	 * Returns the first amf audit event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf audit event, or <code>null</code> if a matching amf audit event could not be found
	 */
	@Override
	public AmfAuditEvent fetchByUserId_First(
		long userId, OrderByComparator<AmfAuditEvent> orderByComparator) {

		List<AmfAuditEvent> list = findByUserId(
			userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amf audit event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf audit event
	 * @throws NoSuchAuditEventException if a matching amf audit event could not be found
	 */
	@Override
	public AmfAuditEvent findByUserId_Last(
			long userId, OrderByComparator<AmfAuditEvent> orderByComparator)
		throws NoSuchAuditEventException {

		AmfAuditEvent amfAuditEvent = fetchByUserId_Last(
			userId, orderByComparator);

		if (amfAuditEvent != null) {
			return amfAuditEvent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchAuditEventException(sb.toString());
	}

	/**
	 * Returns the last amf audit event in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf audit event, or <code>null</code> if a matching amf audit event could not be found
	 */
	@Override
	public AmfAuditEvent fetchByUserId_Last(
		long userId, OrderByComparator<AmfAuditEvent> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<AmfAuditEvent> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AmfAuditEvent[] findByUserId_PrevAndNext(
			long amfAuditEventId, long userId,
			OrderByComparator<AmfAuditEvent> orderByComparator)
		throws NoSuchAuditEventException {

		AmfAuditEvent amfAuditEvent = findByPrimaryKey(amfAuditEventId);

		Session session = null;

		try {
			session = openSession();

			AmfAuditEvent[] array = new AmfAuditEventImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, amfAuditEvent, userId, orderByComparator, true);

			array[1] = amfAuditEvent;

			array[2] = getByUserId_PrevAndNext(
				session, amfAuditEvent, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AmfAuditEvent getByUserId_PrevAndNext(
		Session session, AmfAuditEvent amfAuditEvent, long userId,
		OrderByComparator<AmfAuditEvent> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AMFAUDITEVENT_WHERE);

		sb.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AmfAuditEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						amfAuditEvent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AmfAuditEvent> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amf audit events where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (AmfAuditEvent amfAuditEvent :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(amfAuditEvent);
		}
	}

	/**
	 * Returns the number of amf audit events where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching amf audit events
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AMFAUDITEVENT_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"amfAuditEvent.userId = ?";

	private FinderPath _finderPathWithPaginationFindByType;
	private FinderPath _finderPathWithoutPaginationFindByType;
	private FinderPath _finderPathCountByType;

	/**
	 * Returns all the amf audit events where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the matching amf audit events
	 */
	@Override
	public List<AmfAuditEvent> findByType(String eventType) {
		return findByType(
			eventType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AmfAuditEvent> findByType(
		String eventType, int start, int end) {

		return findByType(eventType, start, end, null);
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
	@Override
	public List<AmfAuditEvent> findByType(
		String eventType, int start, int end,
		OrderByComparator<AmfAuditEvent> orderByComparator) {

		return findByType(eventType, start, end, orderByComparator, true);
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
	@Override
	public List<AmfAuditEvent> findByType(
		String eventType, int start, int end,
		OrderByComparator<AmfAuditEvent> orderByComparator,
		boolean useFinderCache) {

		eventType = Objects.toString(eventType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByType;
				finderArgs = new Object[] {eventType};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByType;
			finderArgs = new Object[] {
				eventType, start, end, orderByComparator
			};
		}

		List<AmfAuditEvent> list = null;

		if (useFinderCache) {
			list = (List<AmfAuditEvent>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AmfAuditEvent amfAuditEvent : list) {
					if (!eventType.equals(amfAuditEvent.getEventType())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_AMFAUDITEVENT_WHERE);

			boolean bindEventType = false;

			if (eventType.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPE_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				sb.append(_FINDER_COLUMN_TYPE_EVENTTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AmfAuditEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEventType) {
					queryPos.add(eventType);
				}

				list = (List<AmfAuditEvent>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first amf audit event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf audit event
	 * @throws NoSuchAuditEventException if a matching amf audit event could not be found
	 */
	@Override
	public AmfAuditEvent findByType_First(
			String eventType,
			OrderByComparator<AmfAuditEvent> orderByComparator)
		throws NoSuchAuditEventException {

		AmfAuditEvent amfAuditEvent = fetchByType_First(
			eventType, orderByComparator);

		if (amfAuditEvent != null) {
			return amfAuditEvent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("eventType=");
		sb.append(eventType);

		sb.append("}");

		throw new NoSuchAuditEventException(sb.toString());
	}

	/**
	 * Returns the first amf audit event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf audit event, or <code>null</code> if a matching amf audit event could not be found
	 */
	@Override
	public AmfAuditEvent fetchByType_First(
		String eventType, OrderByComparator<AmfAuditEvent> orderByComparator) {

		List<AmfAuditEvent> list = findByType(
			eventType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amf audit event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf audit event
	 * @throws NoSuchAuditEventException if a matching amf audit event could not be found
	 */
	@Override
	public AmfAuditEvent findByType_Last(
			String eventType,
			OrderByComparator<AmfAuditEvent> orderByComparator)
		throws NoSuchAuditEventException {

		AmfAuditEvent amfAuditEvent = fetchByType_Last(
			eventType, orderByComparator);

		if (amfAuditEvent != null) {
			return amfAuditEvent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("eventType=");
		sb.append(eventType);

		sb.append("}");

		throw new NoSuchAuditEventException(sb.toString());
	}

	/**
	 * Returns the last amf audit event in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf audit event, or <code>null</code> if a matching amf audit event could not be found
	 */
	@Override
	public AmfAuditEvent fetchByType_Last(
		String eventType, OrderByComparator<AmfAuditEvent> orderByComparator) {

		int count = countByType(eventType);

		if (count == 0) {
			return null;
		}

		List<AmfAuditEvent> list = findByType(
			eventType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AmfAuditEvent[] findByType_PrevAndNext(
			long amfAuditEventId, String eventType,
			OrderByComparator<AmfAuditEvent> orderByComparator)
		throws NoSuchAuditEventException {

		eventType = Objects.toString(eventType, "");

		AmfAuditEvent amfAuditEvent = findByPrimaryKey(amfAuditEventId);

		Session session = null;

		try {
			session = openSession();

			AmfAuditEvent[] array = new AmfAuditEventImpl[3];

			array[0] = getByType_PrevAndNext(
				session, amfAuditEvent, eventType, orderByComparator, true);

			array[1] = amfAuditEvent;

			array[2] = getByType_PrevAndNext(
				session, amfAuditEvent, eventType, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AmfAuditEvent getByType_PrevAndNext(
		Session session, AmfAuditEvent amfAuditEvent, String eventType,
		OrderByComparator<AmfAuditEvent> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AMFAUDITEVENT_WHERE);

		boolean bindEventType = false;

		if (eventType.isEmpty()) {
			sb.append(_FINDER_COLUMN_TYPE_EVENTTYPE_3);
		}
		else {
			bindEventType = true;

			sb.append(_FINDER_COLUMN_TYPE_EVENTTYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AmfAuditEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindEventType) {
			queryPos.add(eventType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						amfAuditEvent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AmfAuditEvent> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amf audit events where eventType = &#63; from the database.
	 *
	 * @param eventType the event type
	 */
	@Override
	public void removeByType(String eventType) {
		for (AmfAuditEvent amfAuditEvent :
				findByType(
					eventType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(amfAuditEvent);
		}
	}

	/**
	 * Returns the number of amf audit events where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the number of matching amf audit events
	 */
	@Override
	public int countByType(String eventType) {
		eventType = Objects.toString(eventType, "");

		FinderPath finderPath = _finderPathCountByType;

		Object[] finderArgs = new Object[] {eventType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AMFAUDITEVENT_WHERE);

			boolean bindEventType = false;

			if (eventType.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPE_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				sb.append(_FINDER_COLUMN_TYPE_EVENTTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEventType) {
					queryPos.add(eventType);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TYPE_EVENTTYPE_2 =
		"amfAuditEvent.eventType = ?";

	private static final String _FINDER_COLUMN_TYPE_EVENTTYPE_3 =
		"(amfAuditEvent.eventType IS NULL OR amfAuditEvent.eventType = '')";

	private FinderPath _finderPathWithPaginationFindByUserId_Type;
	private FinderPath _finderPathWithoutPaginationFindByUserId_Type;
	private FinderPath _finderPathCountByUserId_Type;

	/**
	 * Returns all the amf audit events where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @return the matching amf audit events
	 */
	@Override
	public List<AmfAuditEvent> findByUserId_Type(
		long userId, String eventType) {

		return findByUserId_Type(
			userId, eventType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AmfAuditEvent> findByUserId_Type(
		long userId, String eventType, int start, int end) {

		return findByUserId_Type(userId, eventType, start, end, null);
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
	@Override
	public List<AmfAuditEvent> findByUserId_Type(
		long userId, String eventType, int start, int end,
		OrderByComparator<AmfAuditEvent> orderByComparator) {

		return findByUserId_Type(
			userId, eventType, start, end, orderByComparator, true);
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
	@Override
	public List<AmfAuditEvent> findByUserId_Type(
		long userId, String eventType, int start, int end,
		OrderByComparator<AmfAuditEvent> orderByComparator,
		boolean useFinderCache) {

		eventType = Objects.toString(eventType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserId_Type;
				finderArgs = new Object[] {userId, eventType};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserId_Type;
			finderArgs = new Object[] {
				userId, eventType, start, end, orderByComparator
			};
		}

		List<AmfAuditEvent> list = null;

		if (useFinderCache) {
			list = (List<AmfAuditEvent>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AmfAuditEvent amfAuditEvent : list) {
					if ((userId != amfAuditEvent.getUserId()) ||
						!eventType.equals(amfAuditEvent.getEventType())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_AMFAUDITEVENT_WHERE);

			sb.append(_FINDER_COLUMN_USERID_TYPE_USERID_2);

			boolean bindEventType = false;

			if (eventType.isEmpty()) {
				sb.append(_FINDER_COLUMN_USERID_TYPE_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				sb.append(_FINDER_COLUMN_USERID_TYPE_EVENTTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AmfAuditEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				if (bindEventType) {
					queryPos.add(eventType);
				}

				list = (List<AmfAuditEvent>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public AmfAuditEvent findByUserId_Type_First(
			long userId, String eventType,
			OrderByComparator<AmfAuditEvent> orderByComparator)
		throws NoSuchAuditEventException {

		AmfAuditEvent amfAuditEvent = fetchByUserId_Type_First(
			userId, eventType, orderByComparator);

		if (amfAuditEvent != null) {
			return amfAuditEvent;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", eventType=");
		sb.append(eventType);

		sb.append("}");

		throw new NoSuchAuditEventException(sb.toString());
	}

	/**
	 * Returns the first amf audit event in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf audit event, or <code>null</code> if a matching amf audit event could not be found
	 */
	@Override
	public AmfAuditEvent fetchByUserId_Type_First(
		long userId, String eventType,
		OrderByComparator<AmfAuditEvent> orderByComparator) {

		List<AmfAuditEvent> list = findByUserId_Type(
			userId, eventType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AmfAuditEvent findByUserId_Type_Last(
			long userId, String eventType,
			OrderByComparator<AmfAuditEvent> orderByComparator)
		throws NoSuchAuditEventException {

		AmfAuditEvent amfAuditEvent = fetchByUserId_Type_Last(
			userId, eventType, orderByComparator);

		if (amfAuditEvent != null) {
			return amfAuditEvent;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append(", eventType=");
		sb.append(eventType);

		sb.append("}");

		throw new NoSuchAuditEventException(sb.toString());
	}

	/**
	 * Returns the last amf audit event in the ordered set where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf audit event, or <code>null</code> if a matching amf audit event could not be found
	 */
	@Override
	public AmfAuditEvent fetchByUserId_Type_Last(
		long userId, String eventType,
		OrderByComparator<AmfAuditEvent> orderByComparator) {

		int count = countByUserId_Type(userId, eventType);

		if (count == 0) {
			return null;
		}

		List<AmfAuditEvent> list = findByUserId_Type(
			userId, eventType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AmfAuditEvent[] findByUserId_Type_PrevAndNext(
			long amfAuditEventId, long userId, String eventType,
			OrderByComparator<AmfAuditEvent> orderByComparator)
		throws NoSuchAuditEventException {

		eventType = Objects.toString(eventType, "");

		AmfAuditEvent amfAuditEvent = findByPrimaryKey(amfAuditEventId);

		Session session = null;

		try {
			session = openSession();

			AmfAuditEvent[] array = new AmfAuditEventImpl[3];

			array[0] = getByUserId_Type_PrevAndNext(
				session, amfAuditEvent, userId, eventType, orderByComparator,
				true);

			array[1] = amfAuditEvent;

			array[2] = getByUserId_Type_PrevAndNext(
				session, amfAuditEvent, userId, eventType, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AmfAuditEvent getByUserId_Type_PrevAndNext(
		Session session, AmfAuditEvent amfAuditEvent, long userId,
		String eventType, OrderByComparator<AmfAuditEvent> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_AMFAUDITEVENT_WHERE);

		sb.append(_FINDER_COLUMN_USERID_TYPE_USERID_2);

		boolean bindEventType = false;

		if (eventType.isEmpty()) {
			sb.append(_FINDER_COLUMN_USERID_TYPE_EVENTTYPE_3);
		}
		else {
			bindEventType = true;

			sb.append(_FINDER_COLUMN_USERID_TYPE_EVENTTYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AmfAuditEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (bindEventType) {
			queryPos.add(eventType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						amfAuditEvent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AmfAuditEvent> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amf audit events where userId = &#63; and eventType = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 */
	@Override
	public void removeByUserId_Type(long userId, String eventType) {
		for (AmfAuditEvent amfAuditEvent :
				findByUserId_Type(
					userId, eventType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(amfAuditEvent);
		}
	}

	/**
	 * Returns the number of amf audit events where userId = &#63; and eventType = &#63;.
	 *
	 * @param userId the user ID
	 * @param eventType the event type
	 * @return the number of matching amf audit events
	 */
	@Override
	public int countByUserId_Type(long userId, String eventType) {
		eventType = Objects.toString(eventType, "");

		FinderPath finderPath = _finderPathCountByUserId_Type;

		Object[] finderArgs = new Object[] {userId, eventType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AMFAUDITEVENT_WHERE);

			sb.append(_FINDER_COLUMN_USERID_TYPE_USERID_2);

			boolean bindEventType = false;

			if (eventType.isEmpty()) {
				sb.append(_FINDER_COLUMN_USERID_TYPE_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				sb.append(_FINDER_COLUMN_USERID_TYPE_EVENTTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				if (bindEventType) {
					queryPos.add(eventType);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_TYPE_USERID_2 =
		"amfAuditEvent.userId = ? AND ";

	private static final String _FINDER_COLUMN_USERID_TYPE_EVENTTYPE_2 =
		"amfAuditEvent.eventType = ?";

	private static final String _FINDER_COLUMN_USERID_TYPE_EVENTTYPE_3 =
		"(amfAuditEvent.eventType IS NULL OR amfAuditEvent.eventType = '')";

	public AmfAuditEventPersistenceImpl() {
		setModelClass(AmfAuditEvent.class);

		setModelImplClass(AmfAuditEventImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the amf audit event in the entity cache if it is enabled.
	 *
	 * @param amfAuditEvent the amf audit event
	 */
	@Override
	public void cacheResult(AmfAuditEvent amfAuditEvent) {
		entityCache.putResult(
			AmfAuditEventImpl.class, amfAuditEvent.getPrimaryKey(),
			amfAuditEvent);
	}

	/**
	 * Caches the amf audit events in the entity cache if it is enabled.
	 *
	 * @param amfAuditEvents the amf audit events
	 */
	@Override
	public void cacheResult(List<AmfAuditEvent> amfAuditEvents) {
		for (AmfAuditEvent amfAuditEvent : amfAuditEvents) {
			if (entityCache.getResult(
					AmfAuditEventImpl.class, amfAuditEvent.getPrimaryKey()) ==
						null) {

				cacheResult(amfAuditEvent);
			}
		}
	}

	/**
	 * Clears the cache for all amf audit events.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AmfAuditEventImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the amf audit event.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AmfAuditEvent amfAuditEvent) {
		entityCache.removeResult(AmfAuditEventImpl.class, amfAuditEvent);
	}

	@Override
	public void clearCache(List<AmfAuditEvent> amfAuditEvents) {
		for (AmfAuditEvent amfAuditEvent : amfAuditEvents) {
			entityCache.removeResult(AmfAuditEventImpl.class, amfAuditEvent);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AmfAuditEventImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new amf audit event with the primary key. Does not add the amf audit event to the database.
	 *
	 * @param amfAuditEventId the primary key for the new amf audit event
	 * @return the new amf audit event
	 */
	@Override
	public AmfAuditEvent create(long amfAuditEventId) {
		AmfAuditEvent amfAuditEvent = new AmfAuditEventImpl();

		amfAuditEvent.setNew(true);
		amfAuditEvent.setPrimaryKey(amfAuditEventId);

		amfAuditEvent.setCompanyId(CompanyThreadLocal.getCompanyId());

		return amfAuditEvent;
	}

	/**
	 * Removes the amf audit event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfAuditEventId the primary key of the amf audit event
	 * @return the amf audit event that was removed
	 * @throws NoSuchAuditEventException if a amf audit event with the primary key could not be found
	 */
	@Override
	public AmfAuditEvent remove(long amfAuditEventId)
		throws NoSuchAuditEventException {

		return remove((Serializable)amfAuditEventId);
	}

	/**
	 * Removes the amf audit event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the amf audit event
	 * @return the amf audit event that was removed
	 * @throws NoSuchAuditEventException if a amf audit event with the primary key could not be found
	 */
	@Override
	public AmfAuditEvent remove(Serializable primaryKey)
		throws NoSuchAuditEventException {

		Session session = null;

		try {
			session = openSession();

			AmfAuditEvent amfAuditEvent = (AmfAuditEvent)session.get(
				AmfAuditEventImpl.class, primaryKey);

			if (amfAuditEvent == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAuditEventException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(amfAuditEvent);
		}
		catch (NoSuchAuditEventException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected AmfAuditEvent removeImpl(AmfAuditEvent amfAuditEvent) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(amfAuditEvent)) {
				amfAuditEvent = (AmfAuditEvent)session.get(
					AmfAuditEventImpl.class, amfAuditEvent.getPrimaryKeyObj());
			}

			if (amfAuditEvent != null) {
				session.delete(amfAuditEvent);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (amfAuditEvent != null) {
			clearCache(amfAuditEvent);
		}

		return amfAuditEvent;
	}

	@Override
	public AmfAuditEvent updateImpl(AmfAuditEvent amfAuditEvent) {
		boolean isNew = amfAuditEvent.isNew();

		if (!(amfAuditEvent instanceof AmfAuditEventModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(amfAuditEvent.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					amfAuditEvent);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in amfAuditEvent proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AmfAuditEvent implementation " +
					amfAuditEvent.getClass());
		}

		AmfAuditEventModelImpl amfAuditEventModelImpl =
			(AmfAuditEventModelImpl)amfAuditEvent;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (amfAuditEvent.getCreateDate() == null)) {
			if (serviceContext == null) {
				amfAuditEvent.setCreateDate(now);
			}
			else {
				amfAuditEvent.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!amfAuditEventModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				amfAuditEvent.setModifiedDate(now);
			}
			else {
				amfAuditEvent.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(amfAuditEvent);
			}
			else {
				amfAuditEvent = (AmfAuditEvent)session.merge(amfAuditEvent);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AmfAuditEventImpl.class, amfAuditEventModelImpl, false, true);

		if (isNew) {
			amfAuditEvent.setNew(false);
		}

		amfAuditEvent.resetOriginalValues();

		return amfAuditEvent;
	}

	/**
	 * Returns the amf audit event with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the amf audit event
	 * @return the amf audit event
	 * @throws NoSuchAuditEventException if a amf audit event with the primary key could not be found
	 */
	@Override
	public AmfAuditEvent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAuditEventException {

		AmfAuditEvent amfAuditEvent = fetchByPrimaryKey(primaryKey);

		if (amfAuditEvent == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAuditEventException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return amfAuditEvent;
	}

	/**
	 * Returns the amf audit event with the primary key or throws a <code>NoSuchAuditEventException</code> if it could not be found.
	 *
	 * @param amfAuditEventId the primary key of the amf audit event
	 * @return the amf audit event
	 * @throws NoSuchAuditEventException if a amf audit event with the primary key could not be found
	 */
	@Override
	public AmfAuditEvent findByPrimaryKey(long amfAuditEventId)
		throws NoSuchAuditEventException {

		return findByPrimaryKey((Serializable)amfAuditEventId);
	}

	/**
	 * Returns the amf audit event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amfAuditEventId the primary key of the amf audit event
	 * @return the amf audit event, or <code>null</code> if a amf audit event with the primary key could not be found
	 */
	@Override
	public AmfAuditEvent fetchByPrimaryKey(long amfAuditEventId) {
		return fetchByPrimaryKey((Serializable)amfAuditEventId);
	}

	/**
	 * Returns all the amf audit events.
	 *
	 * @return the amf audit events
	 */
	@Override
	public List<AmfAuditEvent> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AmfAuditEvent> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<AmfAuditEvent> findAll(
		int start, int end,
		OrderByComparator<AmfAuditEvent> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<AmfAuditEvent> findAll(
		int start, int end, OrderByComparator<AmfAuditEvent> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<AmfAuditEvent> list = null;

		if (useFinderCache) {
			list = (List<AmfAuditEvent>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AMFAUDITEVENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AMFAUDITEVENT;

				sql = sql.concat(AmfAuditEventModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AmfAuditEvent>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the amf audit events from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AmfAuditEvent amfAuditEvent : findAll()) {
			remove(amfAuditEvent);
		}
	}

	/**
	 * Returns the number of amf audit events.
	 *
	 * @return the number of amf audit events
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AMFAUDITEVENT);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "amfAuditEventId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AMFAUDITEVENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AmfAuditEventModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the amf audit event persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new AmfAuditEventModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", AmfAuditEvent.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId"}, true);

		_finderPathWithoutPaginationFindByGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			true);

		_finderPathCountByGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			false);

		_finderPathWithPaginationFindByUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userId"}, true);

		_finderPathWithoutPaginationFindByUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByUserId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_finderPathWithPaginationFindByType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByType",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"eventType"}, true);

		_finderPathWithoutPaginationFindByType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] {String.class.getName()}, new String[] {"eventType"},
			true);

		_finderPathCountByType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] {String.class.getName()}, new String[] {"eventType"},
			false);

		_finderPathWithPaginationFindByUserId_Type = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId_Type",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"userId", "eventType"}, true);

		_finderPathWithoutPaginationFindByUserId_Type = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId_Type",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"userId", "eventType"}, true);

		_finderPathCountByUserId_Type = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId_Type",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"userId", "eventType"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(AmfAuditEventImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = AmfPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = AmfPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = AmfPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_AMFAUDITEVENT =
		"SELECT amfAuditEvent FROM AmfAuditEvent amfAuditEvent";

	private static final String _SQL_SELECT_AMFAUDITEVENT_WHERE =
		"SELECT amfAuditEvent FROM AmfAuditEvent amfAuditEvent WHERE ";

	private static final String _SQL_COUNT_AMFAUDITEVENT =
		"SELECT COUNT(amfAuditEvent) FROM AmfAuditEvent amfAuditEvent";

	private static final String _SQL_COUNT_AMFAUDITEVENT_WHERE =
		"SELECT COUNT(amfAuditEvent) FROM AmfAuditEvent amfAuditEvent WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"amfAuditEvent.amfAuditEventId";

	private static final String _FILTER_SQL_SELECT_AMFAUDITEVENT_WHERE =
		"SELECT DISTINCT {amfAuditEvent.*} FROM Amf_AmfAuditEvent amfAuditEvent WHERE ";

	private static final String
		_FILTER_SQL_SELECT_AMFAUDITEVENT_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {Amf_AmfAuditEvent.*} FROM (SELECT DISTINCT amfAuditEvent.amfAuditEventId FROM Amf_AmfAuditEvent amfAuditEvent WHERE ";

	private static final String
		_FILTER_SQL_SELECT_AMFAUDITEVENT_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN Amf_AmfAuditEvent ON TEMP_TABLE.amfAuditEventId = Amf_AmfAuditEvent.amfAuditEventId";

	private static final String _FILTER_SQL_COUNT_AMFAUDITEVENT_WHERE =
		"SELECT COUNT(DISTINCT amfAuditEvent.amfAuditEventId) AS COUNT_VALUE FROM Amf_AmfAuditEvent amfAuditEvent WHERE ";

	private static final String _FILTER_ENTITY_ALIAS = "amfAuditEvent";

	private static final String _FILTER_ENTITY_TABLE = "Amf_AmfAuditEvent";

	private static final String _ORDER_BY_ENTITY_ALIAS = "amfAuditEvent.";

	private static final String _ORDER_BY_ENTITY_TABLE = "Amf_AmfAuditEvent.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AmfAuditEvent exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AmfAuditEvent exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AmfAuditEventPersistenceImpl.class);

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class AmfAuditEventModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			AmfAuditEventModelImpl amfAuditEventModelImpl =
				(AmfAuditEventModelImpl)baseModel;

			long columnBitmask = amfAuditEventModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(amfAuditEventModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						amfAuditEventModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(amfAuditEventModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			AmfAuditEventModelImpl amfAuditEventModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						amfAuditEventModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = amfAuditEventModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}