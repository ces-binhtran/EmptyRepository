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

package com.liferay.training.newsletter.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.training.newsletter.exception.NoSuchNewsletterIssueException;
import com.liferay.training.newsletter.model.NewsletterIssue;
import com.liferay.training.newsletter.model.impl.NewsletterIssueImpl;
import com.liferay.training.newsletter.model.impl.NewsletterIssueModelImpl;
import com.liferay.training.newsletter.service.persistence.NewsletterIssuePersistence;
import com.liferay.training.newsletter.service.persistence.impl.constants.TSPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the newsletter issue service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Son Truong
 * @generated
 */
@Component(service = NewsletterIssuePersistence.class)
public class NewsletterIssuePersistenceImpl
	extends BasePersistenceImpl<NewsletterIssue>
	implements NewsletterIssuePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>NewsletterIssueUtil</code> to access the newsletter issue persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		NewsletterIssueImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByResourcePrimKey;
	private FinderPath _finderPathWithoutPaginationFindByResourcePrimKey;
	private FinderPath _finderPathCountByResourcePrimKey;

	/**
	 * Returns all the newsletter issues where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the matching newsletter issues
	 */
	@Override
	public List<NewsletterIssue> findByResourcePrimKey(long resourcePrimKey) {
		return findByResourcePrimKey(
			resourcePrimKey, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the newsletter issues where resourcePrimKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterIssueModelImpl</code>.
	 * </p>
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param start the lower bound of the range of newsletter issues
	 * @param end the upper bound of the range of newsletter issues (not inclusive)
	 * @return the range of matching newsletter issues
	 */
	@Override
	public List<NewsletterIssue> findByResourcePrimKey(
		long resourcePrimKey, int start, int end) {

		return findByResourcePrimKey(resourcePrimKey, start, end, null);
	}

	/**
	 * Returns an ordered range of all the newsletter issues where resourcePrimKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterIssueModelImpl</code>.
	 * </p>
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param start the lower bound of the range of newsletter issues
	 * @param end the upper bound of the range of newsletter issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching newsletter issues
	 */
	@Override
	public List<NewsletterIssue> findByResourcePrimKey(
		long resourcePrimKey, int start, int end,
		OrderByComparator<NewsletterIssue> orderByComparator) {

		return findByResourcePrimKey(
			resourcePrimKey, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the newsletter issues where resourcePrimKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterIssueModelImpl</code>.
	 * </p>
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param start the lower bound of the range of newsletter issues
	 * @param end the upper bound of the range of newsletter issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching newsletter issues
	 */
	@Override
	public List<NewsletterIssue> findByResourcePrimKey(
		long resourcePrimKey, int start, int end,
		OrderByComparator<NewsletterIssue> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByResourcePrimKey;
				finderArgs = new Object[] {resourcePrimKey};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByResourcePrimKey;
			finderArgs = new Object[] {
				resourcePrimKey, start, end, orderByComparator
			};
		}

		List<NewsletterIssue> list = null;

		if (useFinderCache) {
			list = (List<NewsletterIssue>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (NewsletterIssue newsletterIssue : list) {
					if (resourcePrimKey !=
							newsletterIssue.getResourcePrimKey()) {

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

			sb.append(_SQL_SELECT_NEWSLETTERISSUE_WHERE);

			sb.append(_FINDER_COLUMN_RESOURCEPRIMKEY_RESOURCEPRIMKEY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(NewsletterIssueModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(resourcePrimKey);

				list = (List<NewsletterIssue>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first newsletter issue in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter issue
	 * @throws NoSuchNewsletterIssueException if a matching newsletter issue could not be found
	 */
	@Override
	public NewsletterIssue findByResourcePrimKey_First(
			long resourcePrimKey,
			OrderByComparator<NewsletterIssue> orderByComparator)
		throws NoSuchNewsletterIssueException {

		NewsletterIssue newsletterIssue = fetchByResourcePrimKey_First(
			resourcePrimKey, orderByComparator);

		if (newsletterIssue != null) {
			return newsletterIssue;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("resourcePrimKey=");
		sb.append(resourcePrimKey);

		sb.append("}");

		throw new NoSuchNewsletterIssueException(sb.toString());
	}

	/**
	 * Returns the first newsletter issue in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	@Override
	public NewsletterIssue fetchByResourcePrimKey_First(
		long resourcePrimKey,
		OrderByComparator<NewsletterIssue> orderByComparator) {

		List<NewsletterIssue> list = findByResourcePrimKey(
			resourcePrimKey, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last newsletter issue in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter issue
	 * @throws NoSuchNewsletterIssueException if a matching newsletter issue could not be found
	 */
	@Override
	public NewsletterIssue findByResourcePrimKey_Last(
			long resourcePrimKey,
			OrderByComparator<NewsletterIssue> orderByComparator)
		throws NoSuchNewsletterIssueException {

		NewsletterIssue newsletterIssue = fetchByResourcePrimKey_Last(
			resourcePrimKey, orderByComparator);

		if (newsletterIssue != null) {
			return newsletterIssue;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("resourcePrimKey=");
		sb.append(resourcePrimKey);

		sb.append("}");

		throw new NoSuchNewsletterIssueException(sb.toString());
	}

	/**
	 * Returns the last newsletter issue in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	@Override
	public NewsletterIssue fetchByResourcePrimKey_Last(
		long resourcePrimKey,
		OrderByComparator<NewsletterIssue> orderByComparator) {

		int count = countByResourcePrimKey(resourcePrimKey);

		if (count == 0) {
			return null;
		}

		List<NewsletterIssue> list = findByResourcePrimKey(
			resourcePrimKey, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the newsletter issues before and after the current newsletter issue in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param newsletterIssueId the primary key of the current newsletter issue
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next newsletter issue
	 * @throws NoSuchNewsletterIssueException if a newsletter issue with the primary key could not be found
	 */
	@Override
	public NewsletterIssue[] findByResourcePrimKey_PrevAndNext(
			long newsletterIssueId, long resourcePrimKey,
			OrderByComparator<NewsletterIssue> orderByComparator)
		throws NoSuchNewsletterIssueException {

		NewsletterIssue newsletterIssue = findByPrimaryKey(newsletterIssueId);

		Session session = null;

		try {
			session = openSession();

			NewsletterIssue[] array = new NewsletterIssueImpl[3];

			array[0] = getByResourcePrimKey_PrevAndNext(
				session, newsletterIssue, resourcePrimKey, orderByComparator,
				true);

			array[1] = newsletterIssue;

			array[2] = getByResourcePrimKey_PrevAndNext(
				session, newsletterIssue, resourcePrimKey, orderByComparator,
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

	protected NewsletterIssue getByResourcePrimKey_PrevAndNext(
		Session session, NewsletterIssue newsletterIssue, long resourcePrimKey,
		OrderByComparator<NewsletterIssue> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_NEWSLETTERISSUE_WHERE);

		sb.append(_FINDER_COLUMN_RESOURCEPRIMKEY_RESOURCEPRIMKEY_2);

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
			sb.append(NewsletterIssueModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(resourcePrimKey);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						newsletterIssue)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<NewsletterIssue> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the newsletter issues where resourcePrimKey = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 */
	@Override
	public void removeByResourcePrimKey(long resourcePrimKey) {
		for (NewsletterIssue newsletterIssue :
				findByResourcePrimKey(
					resourcePrimKey, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(newsletterIssue);
		}
	}

	/**
	 * Returns the number of newsletter issues where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the number of matching newsletter issues
	 */
	@Override
	public int countByResourcePrimKey(long resourcePrimKey) {
		FinderPath finderPath = _finderPathCountByResourcePrimKey;

		Object[] finderArgs = new Object[] {resourcePrimKey};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_NEWSLETTERISSUE_WHERE);

			sb.append(_FINDER_COLUMN_RESOURCEPRIMKEY_RESOURCEPRIMKEY_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(resourcePrimKey);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_RESOURCEPRIMKEY_RESOURCEPRIMKEY_2 =
			"newsletterIssue.resourcePrimKey = ?";

	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the newsletter issues where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching newsletter issues
	 */
	@Override
	public List<NewsletterIssue> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the newsletter issues where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterIssueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of newsletter issues
	 * @param end the upper bound of the range of newsletter issues (not inclusive)
	 * @return the range of matching newsletter issues
	 */
	@Override
	public List<NewsletterIssue> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the newsletter issues where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterIssueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of newsletter issues
	 * @param end the upper bound of the range of newsletter issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching newsletter issues
	 */
	@Override
	public List<NewsletterIssue> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<NewsletterIssue> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the newsletter issues where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterIssueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of newsletter issues
	 * @param end the upper bound of the range of newsletter issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching newsletter issues
	 */
	@Override
	public List<NewsletterIssue> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<NewsletterIssue> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<NewsletterIssue> list = null;

		if (useFinderCache) {
			list = (List<NewsletterIssue>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (NewsletterIssue newsletterIssue : list) {
					if (!uuid.equals(newsletterIssue.getUuid())) {
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

			sb.append(_SQL_SELECT_NEWSLETTERISSUE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(NewsletterIssueModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<NewsletterIssue>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first newsletter issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter issue
	 * @throws NoSuchNewsletterIssueException if a matching newsletter issue could not be found
	 */
	@Override
	public NewsletterIssue findByUuid_First(
			String uuid, OrderByComparator<NewsletterIssue> orderByComparator)
		throws NoSuchNewsletterIssueException {

		NewsletterIssue newsletterIssue = fetchByUuid_First(
			uuid, orderByComparator);

		if (newsletterIssue != null) {
			return newsletterIssue;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchNewsletterIssueException(sb.toString());
	}

	/**
	 * Returns the first newsletter issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	@Override
	public NewsletterIssue fetchByUuid_First(
		String uuid, OrderByComparator<NewsletterIssue> orderByComparator) {

		List<NewsletterIssue> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last newsletter issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter issue
	 * @throws NoSuchNewsletterIssueException if a matching newsletter issue could not be found
	 */
	@Override
	public NewsletterIssue findByUuid_Last(
			String uuid, OrderByComparator<NewsletterIssue> orderByComparator)
		throws NoSuchNewsletterIssueException {

		NewsletterIssue newsletterIssue = fetchByUuid_Last(
			uuid, orderByComparator);

		if (newsletterIssue != null) {
			return newsletterIssue;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchNewsletterIssueException(sb.toString());
	}

	/**
	 * Returns the last newsletter issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	@Override
	public NewsletterIssue fetchByUuid_Last(
		String uuid, OrderByComparator<NewsletterIssue> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<NewsletterIssue> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the newsletter issues before and after the current newsletter issue in the ordered set where uuid = &#63;.
	 *
	 * @param newsletterIssueId the primary key of the current newsletter issue
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next newsletter issue
	 * @throws NoSuchNewsletterIssueException if a newsletter issue with the primary key could not be found
	 */
	@Override
	public NewsletterIssue[] findByUuid_PrevAndNext(
			long newsletterIssueId, String uuid,
			OrderByComparator<NewsletterIssue> orderByComparator)
		throws NoSuchNewsletterIssueException {

		uuid = Objects.toString(uuid, "");

		NewsletterIssue newsletterIssue = findByPrimaryKey(newsletterIssueId);

		Session session = null;

		try {
			session = openSession();

			NewsletterIssue[] array = new NewsletterIssueImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, newsletterIssue, uuid, orderByComparator, true);

			array[1] = newsletterIssue;

			array[2] = getByUuid_PrevAndNext(
				session, newsletterIssue, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected NewsletterIssue getByUuid_PrevAndNext(
		Session session, NewsletterIssue newsletterIssue, String uuid,
		OrderByComparator<NewsletterIssue> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_NEWSLETTERISSUE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
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
			sb.append(NewsletterIssueModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						newsletterIssue)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<NewsletterIssue> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the newsletter issues where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (NewsletterIssue newsletterIssue :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(newsletterIssue);
		}
	}

	/**
	 * Returns the number of newsletter issues where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching newsletter issues
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_NEWSLETTERISSUE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"newsletterIssue.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(newsletterIssue.uuid IS NULL OR newsletterIssue.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the newsletter issue where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchNewsletterIssueException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching newsletter issue
	 * @throws NoSuchNewsletterIssueException if a matching newsletter issue could not be found
	 */
	@Override
	public NewsletterIssue findByUUID_G(String uuid, long groupId)
		throws NoSuchNewsletterIssueException {

		NewsletterIssue newsletterIssue = fetchByUUID_G(uuid, groupId);

		if (newsletterIssue == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchNewsletterIssueException(sb.toString());
		}

		return newsletterIssue;
	}

	/**
	 * Returns the newsletter issue where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	@Override
	public NewsletterIssue fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the newsletter issue where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	@Override
	public NewsletterIssue fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof NewsletterIssue) {
			NewsletterIssue newsletterIssue = (NewsletterIssue)result;

			if (!Objects.equals(uuid, newsletterIssue.getUuid()) ||
				(groupId != newsletterIssue.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_NEWSLETTERISSUE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<NewsletterIssue> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					NewsletterIssue newsletterIssue = list.get(0);

					result = newsletterIssue;

					cacheResult(newsletterIssue);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByUUID_G, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (NewsletterIssue)result;
		}
	}

	/**
	 * Removes the newsletter issue where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the newsletter issue that was removed
	 */
	@Override
	public NewsletterIssue removeByUUID_G(String uuid, long groupId)
		throws NoSuchNewsletterIssueException {

		NewsletterIssue newsletterIssue = findByUUID_G(uuid, groupId);

		return remove(newsletterIssue);
	}

	/**
	 * Returns the number of newsletter issues where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching newsletter issues
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_NEWSLETTERISSUE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"newsletterIssue.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(newsletterIssue.uuid IS NULL OR newsletterIssue.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"newsletterIssue.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the newsletter issues where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching newsletter issues
	 */
	@Override
	public List<NewsletterIssue> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the newsletter issues where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterIssueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of newsletter issues
	 * @param end the upper bound of the range of newsletter issues (not inclusive)
	 * @return the range of matching newsletter issues
	 */
	@Override
	public List<NewsletterIssue> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the newsletter issues where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterIssueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of newsletter issues
	 * @param end the upper bound of the range of newsletter issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching newsletter issues
	 */
	@Override
	public List<NewsletterIssue> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<NewsletterIssue> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the newsletter issues where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterIssueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of newsletter issues
	 * @param end the upper bound of the range of newsletter issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching newsletter issues
	 */
	@Override
	public List<NewsletterIssue> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<NewsletterIssue> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<NewsletterIssue> list = null;

		if (useFinderCache) {
			list = (List<NewsletterIssue>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (NewsletterIssue newsletterIssue : list) {
					if (!uuid.equals(newsletterIssue.getUuid()) ||
						(companyId != newsletterIssue.getCompanyId())) {

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

			sb.append(_SQL_SELECT_NEWSLETTERISSUE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(NewsletterIssueModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<NewsletterIssue>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first newsletter issue in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter issue
	 * @throws NoSuchNewsletterIssueException if a matching newsletter issue could not be found
	 */
	@Override
	public NewsletterIssue findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<NewsletterIssue> orderByComparator)
		throws NoSuchNewsletterIssueException {

		NewsletterIssue newsletterIssue = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (newsletterIssue != null) {
			return newsletterIssue;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchNewsletterIssueException(sb.toString());
	}

	/**
	 * Returns the first newsletter issue in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	@Override
	public NewsletterIssue fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<NewsletterIssue> orderByComparator) {

		List<NewsletterIssue> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last newsletter issue in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter issue
	 * @throws NoSuchNewsletterIssueException if a matching newsletter issue could not be found
	 */
	@Override
	public NewsletterIssue findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<NewsletterIssue> orderByComparator)
		throws NoSuchNewsletterIssueException {

		NewsletterIssue newsletterIssue = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (newsletterIssue != null) {
			return newsletterIssue;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchNewsletterIssueException(sb.toString());
	}

	/**
	 * Returns the last newsletter issue in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	@Override
	public NewsletterIssue fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<NewsletterIssue> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<NewsletterIssue> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the newsletter issues before and after the current newsletter issue in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param newsletterIssueId the primary key of the current newsletter issue
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next newsletter issue
	 * @throws NoSuchNewsletterIssueException if a newsletter issue with the primary key could not be found
	 */
	@Override
	public NewsletterIssue[] findByUuid_C_PrevAndNext(
			long newsletterIssueId, String uuid, long companyId,
			OrderByComparator<NewsletterIssue> orderByComparator)
		throws NoSuchNewsletterIssueException {

		uuid = Objects.toString(uuid, "");

		NewsletterIssue newsletterIssue = findByPrimaryKey(newsletterIssueId);

		Session session = null;

		try {
			session = openSession();

			NewsletterIssue[] array = new NewsletterIssueImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, newsletterIssue, uuid, companyId, orderByComparator,
				true);

			array[1] = newsletterIssue;

			array[2] = getByUuid_C_PrevAndNext(
				session, newsletterIssue, uuid, companyId, orderByComparator,
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

	protected NewsletterIssue getByUuid_C_PrevAndNext(
		Session session, NewsletterIssue newsletterIssue, String uuid,
		long companyId, OrderByComparator<NewsletterIssue> orderByComparator,
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

		sb.append(_SQL_SELECT_NEWSLETTERISSUE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			sb.append(NewsletterIssueModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						newsletterIssue)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<NewsletterIssue> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the newsletter issues where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (NewsletterIssue newsletterIssue :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(newsletterIssue);
		}
	}

	/**
	 * Returns the number of newsletter issues where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching newsletter issues
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_NEWSLETTERISSUE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"newsletterIssue.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(newsletterIssue.uuid IS NULL OR newsletterIssue.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"newsletterIssue.companyId = ?";

	private FinderPath _finderPathFetchByresourcePrimKey;
	private FinderPath _finderPathCountByresourcePrimKey;

	/**
	 * Returns the newsletter issue where resourcePrimKey = &#63; or throws a <code>NoSuchNewsletterIssueException</code> if it could not be found.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the matching newsletter issue
	 * @throws NoSuchNewsletterIssueException if a matching newsletter issue could not be found
	 */
	@Override
	public NewsletterIssue findByresourcePrimKey(long resourcePrimKey)
		throws NoSuchNewsletterIssueException {

		NewsletterIssue newsletterIssue = fetchByresourcePrimKey(
			resourcePrimKey);

		if (newsletterIssue == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("resourcePrimKey=");
			sb.append(resourcePrimKey);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchNewsletterIssueException(sb.toString());
		}

		return newsletterIssue;
	}

	/**
	 * Returns the newsletter issue where resourcePrimKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	@Override
	public NewsletterIssue fetchByresourcePrimKey(long resourcePrimKey) {
		return fetchByresourcePrimKey(resourcePrimKey, true);
	}

	/**
	 * Returns the newsletter issue where resourcePrimKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	@Override
	public NewsletterIssue fetchByresourcePrimKey(
		long resourcePrimKey, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {resourcePrimKey};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByresourcePrimKey, finderArgs, this);
		}

		if (result instanceof NewsletterIssue) {
			NewsletterIssue newsletterIssue = (NewsletterIssue)result;

			if (resourcePrimKey != newsletterIssue.getResourcePrimKey()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_NEWSLETTERISSUE_WHERE);

			sb.append(_FINDER_COLUMN_RESOURCEPRIMKEY_RESOURCEPRIMKEY_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(resourcePrimKey);

				List<NewsletterIssue> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByresourcePrimKey, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {resourcePrimKey};
							}

							_log.warn(
								"NewsletterIssuePersistenceImpl.fetchByresourcePrimKey(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					NewsletterIssue newsletterIssue = list.get(0);

					result = newsletterIssue;

					cacheResult(newsletterIssue);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByresourcePrimKey, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (NewsletterIssue)result;
		}
	}

	/**
	 * Removes the newsletter issue where resourcePrimKey = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the newsletter issue that was removed
	 */
	@Override
	public NewsletterIssue removeByresourcePrimKey(long resourcePrimKey)
		throws NoSuchNewsletterIssueException {

		NewsletterIssue newsletterIssue = findByresourcePrimKey(
			resourcePrimKey);

		return remove(newsletterIssue);
	}

	/**
	 * Returns the number of newsletter issues where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the number of matching newsletter issues
	 */
	@Override
	public int countByresourcePrimKey(long resourcePrimKey) {
		FinderPath finderPath = _finderPathCountByresourcePrimKey;

		Object[] finderArgs = new Object[] {resourcePrimKey};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_NEWSLETTERISSUE_WHERE);

			sb.append(_FINDER_COLUMN_RESOURCEPRIMKEY_RESOURCEPRIMKEY_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(resourcePrimKey);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	public NewsletterIssuePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(NewsletterIssue.class);

		setModelImplClass(NewsletterIssueImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the newsletter issue in the entity cache if it is enabled.
	 *
	 * @param newsletterIssue the newsletter issue
	 */
	@Override
	public void cacheResult(NewsletterIssue newsletterIssue) {
		entityCache.putResult(
			entityCacheEnabled, NewsletterIssueImpl.class,
			newsletterIssue.getPrimaryKey(), newsletterIssue);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				newsletterIssue.getUuid(), newsletterIssue.getGroupId()
			},
			newsletterIssue);

		finderCache.putResult(
			_finderPathFetchByresourcePrimKey,
			new Object[] {newsletterIssue.getResourcePrimKey()},
			newsletterIssue);

		newsletterIssue.resetOriginalValues();
	}

	/**
	 * Caches the newsletter issues in the entity cache if it is enabled.
	 *
	 * @param newsletterIssues the newsletter issues
	 */
	@Override
	public void cacheResult(List<NewsletterIssue> newsletterIssues) {
		for (NewsletterIssue newsletterIssue : newsletterIssues) {
			if (entityCache.getResult(
					entityCacheEnabled, NewsletterIssueImpl.class,
					newsletterIssue.getPrimaryKey()) == null) {

				cacheResult(newsletterIssue);
			}
			else {
				newsletterIssue.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all newsletter issues.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(NewsletterIssueImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the newsletter issue.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NewsletterIssue newsletterIssue) {
		entityCache.removeResult(
			entityCacheEnabled, NewsletterIssueImpl.class,
			newsletterIssue.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(NewsletterIssueModelImpl)newsletterIssue, true);
	}

	@Override
	public void clearCache(List<NewsletterIssue> newsletterIssues) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (NewsletterIssue newsletterIssue : newsletterIssues) {
			entityCache.removeResult(
				entityCacheEnabled, NewsletterIssueImpl.class,
				newsletterIssue.getPrimaryKey());

			clearUniqueFindersCache(
				(NewsletterIssueModelImpl)newsletterIssue, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, NewsletterIssueImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		NewsletterIssueModelImpl newsletterIssueModelImpl) {

		Object[] args = new Object[] {
			newsletterIssueModelImpl.getUuid(),
			newsletterIssueModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, newsletterIssueModelImpl, false);

		args = new Object[] {newsletterIssueModelImpl.getResourcePrimKey()};

		finderCache.putResult(
			_finderPathCountByresourcePrimKey, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByresourcePrimKey, args, newsletterIssueModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(
		NewsletterIssueModelImpl newsletterIssueModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				newsletterIssueModelImpl.getUuid(),
				newsletterIssueModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((newsletterIssueModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				newsletterIssueModelImpl.getOriginalUuid(),
				newsletterIssueModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				newsletterIssueModelImpl.getResourcePrimKey()
			};

			finderCache.removeResult(_finderPathCountByresourcePrimKey, args);
			finderCache.removeResult(_finderPathFetchByresourcePrimKey, args);
		}

		if ((newsletterIssueModelImpl.getColumnBitmask() &
			 _finderPathFetchByresourcePrimKey.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				newsletterIssueModelImpl.getOriginalResourcePrimKey()
			};

			finderCache.removeResult(_finderPathCountByresourcePrimKey, args);
			finderCache.removeResult(_finderPathFetchByresourcePrimKey, args);
		}
	}

	/**
	 * Creates a new newsletter issue with the primary key. Does not add the newsletter issue to the database.
	 *
	 * @param newsletterIssueId the primary key for the new newsletter issue
	 * @return the new newsletter issue
	 */
	@Override
	public NewsletterIssue create(long newsletterIssueId) {
		NewsletterIssue newsletterIssue = new NewsletterIssueImpl();

		newsletterIssue.setNew(true);
		newsletterIssue.setPrimaryKey(newsletterIssueId);

		String uuid = PortalUUIDUtil.generate();

		newsletterIssue.setUuid(uuid);

		newsletterIssue.setCompanyId(CompanyThreadLocal.getCompanyId());

		return newsletterIssue;
	}

	/**
	 * Removes the newsletter issue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param newsletterIssueId the primary key of the newsletter issue
	 * @return the newsletter issue that was removed
	 * @throws NoSuchNewsletterIssueException if a newsletter issue with the primary key could not be found
	 */
	@Override
	public NewsletterIssue remove(long newsletterIssueId)
		throws NoSuchNewsletterIssueException {

		return remove((Serializable)newsletterIssueId);
	}

	/**
	 * Removes the newsletter issue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the newsletter issue
	 * @return the newsletter issue that was removed
	 * @throws NoSuchNewsletterIssueException if a newsletter issue with the primary key could not be found
	 */
	@Override
	public NewsletterIssue remove(Serializable primaryKey)
		throws NoSuchNewsletterIssueException {

		Session session = null;

		try {
			session = openSession();

			NewsletterIssue newsletterIssue = (NewsletterIssue)session.get(
				NewsletterIssueImpl.class, primaryKey);

			if (newsletterIssue == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNewsletterIssueException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(newsletterIssue);
		}
		catch (NoSuchNewsletterIssueException noSuchEntityException) {
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
	protected NewsletterIssue removeImpl(NewsletterIssue newsletterIssue) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(newsletterIssue)) {
				newsletterIssue = (NewsletterIssue)session.get(
					NewsletterIssueImpl.class,
					newsletterIssue.getPrimaryKeyObj());
			}

			if (newsletterIssue != null) {
				session.delete(newsletterIssue);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (newsletterIssue != null) {
			clearCache(newsletterIssue);
		}

		return newsletterIssue;
	}

	@Override
	public NewsletterIssue updateImpl(NewsletterIssue newsletterIssue) {
		boolean isNew = newsletterIssue.isNew();

		if (!(newsletterIssue instanceof NewsletterIssueModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(newsletterIssue.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					newsletterIssue);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in newsletterIssue proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom NewsletterIssue implementation " +
					newsletterIssue.getClass());
		}

		NewsletterIssueModelImpl newsletterIssueModelImpl =
			(NewsletterIssueModelImpl)newsletterIssue;

		if (Validator.isNull(newsletterIssue.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			newsletterIssue.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(newsletterIssue);

				newsletterIssue.setNew(false);
			}
			else {
				newsletterIssue = (NewsletterIssue)session.merge(
					newsletterIssue);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				newsletterIssueModelImpl.getResourcePrimKey()
			};

			finderCache.removeResult(_finderPathCountByResourcePrimKey, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByResourcePrimKey, args);

			args = new Object[] {newsletterIssueModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				newsletterIssueModelImpl.getUuid(),
				newsletterIssueModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((newsletterIssueModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByResourcePrimKey.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					newsletterIssueModelImpl.getOriginalResourcePrimKey()
				};

				finderCache.removeResult(
					_finderPathCountByResourcePrimKey, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByResourcePrimKey, args);

				args = new Object[] {
					newsletterIssueModelImpl.getResourcePrimKey()
				};

				finderCache.removeResult(
					_finderPathCountByResourcePrimKey, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByResourcePrimKey, args);
			}

			if ((newsletterIssueModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					newsletterIssueModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {newsletterIssueModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((newsletterIssueModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					newsletterIssueModelImpl.getOriginalUuid(),
					newsletterIssueModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					newsletterIssueModelImpl.getUuid(),
					newsletterIssueModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, NewsletterIssueImpl.class,
			newsletterIssue.getPrimaryKey(), newsletterIssue, false);

		clearUniqueFindersCache(newsletterIssueModelImpl, false);
		cacheUniqueFindersCache(newsletterIssueModelImpl);

		newsletterIssue.resetOriginalValues();

		return newsletterIssue;
	}

	/**
	 * Returns the newsletter issue with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the newsletter issue
	 * @return the newsletter issue
	 * @throws NoSuchNewsletterIssueException if a newsletter issue with the primary key could not be found
	 */
	@Override
	public NewsletterIssue findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNewsletterIssueException {

		NewsletterIssue newsletterIssue = fetchByPrimaryKey(primaryKey);

		if (newsletterIssue == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNewsletterIssueException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return newsletterIssue;
	}

	/**
	 * Returns the newsletter issue with the primary key or throws a <code>NoSuchNewsletterIssueException</code> if it could not be found.
	 *
	 * @param newsletterIssueId the primary key of the newsletter issue
	 * @return the newsletter issue
	 * @throws NoSuchNewsletterIssueException if a newsletter issue with the primary key could not be found
	 */
	@Override
	public NewsletterIssue findByPrimaryKey(long newsletterIssueId)
		throws NoSuchNewsletterIssueException {

		return findByPrimaryKey((Serializable)newsletterIssueId);
	}

	/**
	 * Returns the newsletter issue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param newsletterIssueId the primary key of the newsletter issue
	 * @return the newsletter issue, or <code>null</code> if a newsletter issue with the primary key could not be found
	 */
	@Override
	public NewsletterIssue fetchByPrimaryKey(long newsletterIssueId) {
		return fetchByPrimaryKey((Serializable)newsletterIssueId);
	}

	/**
	 * Returns all the newsletter issues.
	 *
	 * @return the newsletter issues
	 */
	@Override
	public List<NewsletterIssue> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the newsletter issues.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterIssueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of newsletter issues
	 * @param end the upper bound of the range of newsletter issues (not inclusive)
	 * @return the range of newsletter issues
	 */
	@Override
	public List<NewsletterIssue> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the newsletter issues.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterIssueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of newsletter issues
	 * @param end the upper bound of the range of newsletter issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of newsletter issues
	 */
	@Override
	public List<NewsletterIssue> findAll(
		int start, int end,
		OrderByComparator<NewsletterIssue> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the newsletter issues.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterIssueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of newsletter issues
	 * @param end the upper bound of the range of newsletter issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of newsletter issues
	 */
	@Override
	public List<NewsletterIssue> findAll(
		int start, int end,
		OrderByComparator<NewsletterIssue> orderByComparator,
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

		List<NewsletterIssue> list = null;

		if (useFinderCache) {
			list = (List<NewsletterIssue>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_NEWSLETTERISSUE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_NEWSLETTERISSUE;

				sql = sql.concat(NewsletterIssueModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<NewsletterIssue>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the newsletter issues from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (NewsletterIssue newsletterIssue : findAll()) {
			remove(newsletterIssue);
		}
	}

	/**
	 * Returns the number of newsletter issues.
	 *
	 * @return the number of newsletter issues
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_NEWSLETTERISSUE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "newsletterIssueId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_NEWSLETTERISSUE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return NewsletterIssueModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the newsletter issue persistence.
	 */
	@Activate
	public void activate() {
		NewsletterIssueModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		NewsletterIssueModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, NewsletterIssueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, NewsletterIssueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByResourcePrimKey = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, NewsletterIssueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByResourcePrimKey",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByResourcePrimKey = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, NewsletterIssueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByResourcePrimKey",
			new String[] {Long.class.getName()},
			NewsletterIssueModelImpl.RESOURCEPRIMKEY_COLUMN_BITMASK |
			NewsletterIssueModelImpl.ISSUEDATE_COLUMN_BITMASK);

		_finderPathCountByResourcePrimKey = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByResourcePrimKey",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, NewsletterIssueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, NewsletterIssueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			NewsletterIssueModelImpl.UUID_COLUMN_BITMASK |
			NewsletterIssueModelImpl.ISSUEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, NewsletterIssueImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			NewsletterIssueModelImpl.UUID_COLUMN_BITMASK |
			NewsletterIssueModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, NewsletterIssueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, NewsletterIssueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			NewsletterIssueModelImpl.UUID_COLUMN_BITMASK |
			NewsletterIssueModelImpl.COMPANYID_COLUMN_BITMASK |
			NewsletterIssueModelImpl.ISSUEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathFetchByresourcePrimKey = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, NewsletterIssueImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByresourcePrimKey",
			new String[] {Long.class.getName()},
			NewsletterIssueModelImpl.RESOURCEPRIMKEY_COLUMN_BITMASK);

		_finderPathCountByresourcePrimKey = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByresourcePrimKey",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(NewsletterIssueImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = TSPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.liferay.training.newsletter.model.NewsletterIssue"),
			true);
	}

	@Override
	@Reference(
		target = TSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = TSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_NEWSLETTERISSUE =
		"SELECT newsletterIssue FROM NewsletterIssue newsletterIssue";

	private static final String _SQL_SELECT_NEWSLETTERISSUE_WHERE =
		"SELECT newsletterIssue FROM NewsletterIssue newsletterIssue WHERE ";

	private static final String _SQL_COUNT_NEWSLETTERISSUE =
		"SELECT COUNT(newsletterIssue) FROM NewsletterIssue newsletterIssue";

	private static final String _SQL_COUNT_NEWSLETTERISSUE_WHERE =
		"SELECT COUNT(newsletterIssue) FROM NewsletterIssue newsletterIssue WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "newsletterIssue.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No NewsletterIssue exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No NewsletterIssue exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		NewsletterIssuePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

}