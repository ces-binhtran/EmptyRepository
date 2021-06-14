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

package com.liferay.training.newsletter.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.training.newsletter.model.NewsletterIssue;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the newsletter issue service. This utility wraps <code>com.liferay.training.newsletter.service.persistence.impl.NewsletterIssuePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Son Truong
 * @see NewsletterIssuePersistence
 * @generated
 */
public class NewsletterIssueUtil {

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
	public static void clearCache(NewsletterIssue newsletterIssue) {
		getPersistence().clearCache(newsletterIssue);
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
	public static Map<Serializable, NewsletterIssue> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<NewsletterIssue> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<NewsletterIssue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<NewsletterIssue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<NewsletterIssue> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static NewsletterIssue update(NewsletterIssue newsletterIssue) {
		return getPersistence().update(newsletterIssue);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static NewsletterIssue update(
		NewsletterIssue newsletterIssue, ServiceContext serviceContext) {

		return getPersistence().update(newsletterIssue, serviceContext);
	}

	/**
	 * Returns all the newsletter issues where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the matching newsletter issues
	 */
	public static List<NewsletterIssue> findByResourcePrimKey(
		long resourcePrimKey) {

		return getPersistence().findByResourcePrimKey(resourcePrimKey);
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
	public static List<NewsletterIssue> findByResourcePrimKey(
		long resourcePrimKey, int start, int end) {

		return getPersistence().findByResourcePrimKey(
			resourcePrimKey, start, end);
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
	public static List<NewsletterIssue> findByResourcePrimKey(
		long resourcePrimKey, int start, int end,
		OrderByComparator<NewsletterIssue> orderByComparator) {

		return getPersistence().findByResourcePrimKey(
			resourcePrimKey, start, end, orderByComparator);
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
	public static List<NewsletterIssue> findByResourcePrimKey(
		long resourcePrimKey, int start, int end,
		OrderByComparator<NewsletterIssue> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByResourcePrimKey(
			resourcePrimKey, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first newsletter issue in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter issue
	 * @throws NoSuchNewsletterIssueException if a matching newsletter issue could not be found
	 */
	public static NewsletterIssue findByResourcePrimKey_First(
			long resourcePrimKey,
			OrderByComparator<NewsletterIssue> orderByComparator)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterIssueException {

		return getPersistence().findByResourcePrimKey_First(
			resourcePrimKey, orderByComparator);
	}

	/**
	 * Returns the first newsletter issue in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	public static NewsletterIssue fetchByResourcePrimKey_First(
		long resourcePrimKey,
		OrderByComparator<NewsletterIssue> orderByComparator) {

		return getPersistence().fetchByResourcePrimKey_First(
			resourcePrimKey, orderByComparator);
	}

	/**
	 * Returns the last newsletter issue in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter issue
	 * @throws NoSuchNewsletterIssueException if a matching newsletter issue could not be found
	 */
	public static NewsletterIssue findByResourcePrimKey_Last(
			long resourcePrimKey,
			OrderByComparator<NewsletterIssue> orderByComparator)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterIssueException {

		return getPersistence().findByResourcePrimKey_Last(
			resourcePrimKey, orderByComparator);
	}

	/**
	 * Returns the last newsletter issue in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	public static NewsletterIssue fetchByResourcePrimKey_Last(
		long resourcePrimKey,
		OrderByComparator<NewsletterIssue> orderByComparator) {

		return getPersistence().fetchByResourcePrimKey_Last(
			resourcePrimKey, orderByComparator);
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
	public static NewsletterIssue[] findByResourcePrimKey_PrevAndNext(
			long newsletterIssueId, long resourcePrimKey,
			OrderByComparator<NewsletterIssue> orderByComparator)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterIssueException {

		return getPersistence().findByResourcePrimKey_PrevAndNext(
			newsletterIssueId, resourcePrimKey, orderByComparator);
	}

	/**
	 * Removes all the newsletter issues where resourcePrimKey = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 */
	public static void removeByResourcePrimKey(long resourcePrimKey) {
		getPersistence().removeByResourcePrimKey(resourcePrimKey);
	}

	/**
	 * Returns the number of newsletter issues where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the number of matching newsletter issues
	 */
	public static int countByResourcePrimKey(long resourcePrimKey) {
		return getPersistence().countByResourcePrimKey(resourcePrimKey);
	}

	/**
	 * Returns all the newsletter issues where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching newsletter issues
	 */
	public static List<NewsletterIssue> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<NewsletterIssue> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<NewsletterIssue> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<NewsletterIssue> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<NewsletterIssue> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<NewsletterIssue> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first newsletter issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter issue
	 * @throws NoSuchNewsletterIssueException if a matching newsletter issue could not be found
	 */
	public static NewsletterIssue findByUuid_First(
			String uuid, OrderByComparator<NewsletterIssue> orderByComparator)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterIssueException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first newsletter issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	public static NewsletterIssue fetchByUuid_First(
		String uuid, OrderByComparator<NewsletterIssue> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last newsletter issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter issue
	 * @throws NoSuchNewsletterIssueException if a matching newsletter issue could not be found
	 */
	public static NewsletterIssue findByUuid_Last(
			String uuid, OrderByComparator<NewsletterIssue> orderByComparator)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterIssueException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last newsletter issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	public static NewsletterIssue fetchByUuid_Last(
		String uuid, OrderByComparator<NewsletterIssue> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static NewsletterIssue[] findByUuid_PrevAndNext(
			long newsletterIssueId, String uuid,
			OrderByComparator<NewsletterIssue> orderByComparator)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterIssueException {

		return getPersistence().findByUuid_PrevAndNext(
			newsletterIssueId, uuid, orderByComparator);
	}

	/**
	 * Removes all the newsletter issues where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of newsletter issues where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching newsletter issues
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the newsletter issue where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchNewsletterIssueException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching newsletter issue
	 * @throws NoSuchNewsletterIssueException if a matching newsletter issue could not be found
	 */
	public static NewsletterIssue findByUUID_G(String uuid, long groupId)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterIssueException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the newsletter issue where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	public static NewsletterIssue fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the newsletter issue where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	public static NewsletterIssue fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the newsletter issue where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the newsletter issue that was removed
	 */
	public static NewsletterIssue removeByUUID_G(String uuid, long groupId)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterIssueException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of newsletter issues where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching newsletter issues
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the newsletter issues where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching newsletter issues
	 */
	public static List<NewsletterIssue> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<NewsletterIssue> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<NewsletterIssue> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<NewsletterIssue> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
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
	public static List<NewsletterIssue> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<NewsletterIssue> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
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
	public static NewsletterIssue findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<NewsletterIssue> orderByComparator)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterIssueException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first newsletter issue in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	public static NewsletterIssue fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<NewsletterIssue> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
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
	public static NewsletterIssue findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<NewsletterIssue> orderByComparator)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterIssueException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last newsletter issue in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	public static NewsletterIssue fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<NewsletterIssue> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
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
	public static NewsletterIssue[] findByUuid_C_PrevAndNext(
			long newsletterIssueId, String uuid, long companyId,
			OrderByComparator<NewsletterIssue> orderByComparator)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterIssueException {

		return getPersistence().findByUuid_C_PrevAndNext(
			newsletterIssueId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the newsletter issues where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of newsletter issues where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching newsletter issues
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the newsletter issue where resourcePrimKey = &#63; or throws a <code>NoSuchNewsletterIssueException</code> if it could not be found.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the matching newsletter issue
	 * @throws NoSuchNewsletterIssueException if a matching newsletter issue could not be found
	 */
	public static NewsletterIssue findByresourcePrimKey(long resourcePrimKey)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterIssueException {

		return getPersistence().findByresourcePrimKey(resourcePrimKey);
	}

	/**
	 * Returns the newsletter issue where resourcePrimKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	public static NewsletterIssue fetchByresourcePrimKey(long resourcePrimKey) {
		return getPersistence().fetchByresourcePrimKey(resourcePrimKey);
	}

	/**
	 * Returns the newsletter issue where resourcePrimKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	public static NewsletterIssue fetchByresourcePrimKey(
		long resourcePrimKey, boolean useFinderCache) {

		return getPersistence().fetchByresourcePrimKey(
			resourcePrimKey, useFinderCache);
	}

	/**
	 * Removes the newsletter issue where resourcePrimKey = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the newsletter issue that was removed
	 */
	public static NewsletterIssue removeByresourcePrimKey(long resourcePrimKey)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterIssueException {

		return getPersistence().removeByresourcePrimKey(resourcePrimKey);
	}

	/**
	 * Returns the number of newsletter issues where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the number of matching newsletter issues
	 */
	public static int countByresourcePrimKey(long resourcePrimKey) {
		return getPersistence().countByresourcePrimKey(resourcePrimKey);
	}

	/**
	 * Caches the newsletter issue in the entity cache if it is enabled.
	 *
	 * @param newsletterIssue the newsletter issue
	 */
	public static void cacheResult(NewsletterIssue newsletterIssue) {
		getPersistence().cacheResult(newsletterIssue);
	}

	/**
	 * Caches the newsletter issues in the entity cache if it is enabled.
	 *
	 * @param newsletterIssues the newsletter issues
	 */
	public static void cacheResult(List<NewsletterIssue> newsletterIssues) {
		getPersistence().cacheResult(newsletterIssues);
	}

	/**
	 * Creates a new newsletter issue with the primary key. Does not add the newsletter issue to the database.
	 *
	 * @param newsletterIssueId the primary key for the new newsletter issue
	 * @return the new newsletter issue
	 */
	public static NewsletterIssue create(long newsletterIssueId) {
		return getPersistence().create(newsletterIssueId);
	}

	/**
	 * Removes the newsletter issue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param newsletterIssueId the primary key of the newsletter issue
	 * @return the newsletter issue that was removed
	 * @throws NoSuchNewsletterIssueException if a newsletter issue with the primary key could not be found
	 */
	public static NewsletterIssue remove(long newsletterIssueId)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterIssueException {

		return getPersistence().remove(newsletterIssueId);
	}

	public static NewsletterIssue updateImpl(NewsletterIssue newsletterIssue) {
		return getPersistence().updateImpl(newsletterIssue);
	}

	/**
	 * Returns the newsletter issue with the primary key or throws a <code>NoSuchNewsletterIssueException</code> if it could not be found.
	 *
	 * @param newsletterIssueId the primary key of the newsletter issue
	 * @return the newsletter issue
	 * @throws NoSuchNewsletterIssueException if a newsletter issue with the primary key could not be found
	 */
	public static NewsletterIssue findByPrimaryKey(long newsletterIssueId)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterIssueException {

		return getPersistence().findByPrimaryKey(newsletterIssueId);
	}

	/**
	 * Returns the newsletter issue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param newsletterIssueId the primary key of the newsletter issue
	 * @return the newsletter issue, or <code>null</code> if a newsletter issue with the primary key could not be found
	 */
	public static NewsletterIssue fetchByPrimaryKey(long newsletterIssueId) {
		return getPersistence().fetchByPrimaryKey(newsletterIssueId);
	}

	/**
	 * Returns all the newsletter issues.
	 *
	 * @return the newsletter issues
	 */
	public static List<NewsletterIssue> findAll() {
		return getPersistence().findAll();
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
	public static List<NewsletterIssue> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<NewsletterIssue> findAll(
		int start, int end,
		OrderByComparator<NewsletterIssue> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<NewsletterIssue> findAll(
		int start, int end,
		OrderByComparator<NewsletterIssue> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the newsletter issues from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of newsletter issues.
	 *
	 * @return the number of newsletter issues
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static NewsletterIssuePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<NewsletterIssuePersistence, NewsletterIssuePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			NewsletterIssuePersistence.class);

		ServiceTracker<NewsletterIssuePersistence, NewsletterIssuePersistence>
			serviceTracker =
				new ServiceTracker
					<NewsletterIssuePersistence, NewsletterIssuePersistence>(
						bundle.getBundleContext(),
						NewsletterIssuePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}