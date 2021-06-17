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
import com.liferay.training.newsletter.model.NewsletterArticle;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the newsletter article service. This utility wraps <code>com.liferay.training.newsletter.service.persistence.impl.NewsletterArticlePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Son Truong
 * @see NewsletterArticlePersistence
 * @generated
 */
public class NewsletterArticleUtil {

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
	public static void clearCache(NewsletterArticle newsletterArticle) {
		getPersistence().clearCache(newsletterArticle);
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
	public static Map<Serializable, NewsletterArticle> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<NewsletterArticle> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<NewsletterArticle> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<NewsletterArticle> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<NewsletterArticle> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static NewsletterArticle update(
		NewsletterArticle newsletterArticle) {

		return getPersistence().update(newsletterArticle);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static NewsletterArticle update(
		NewsletterArticle newsletterArticle, ServiceContext serviceContext) {

		return getPersistence().update(newsletterArticle, serviceContext);
	}

	/**
	 * Returns all the newsletter articles where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the matching newsletter articles
	 */
	public static List<NewsletterArticle> findByResourcePrimKey(
		long resourcePrimKey) {

		return getPersistence().findByResourcePrimKey(resourcePrimKey);
	}

	/**
	 * Returns a range of all the newsletter articles where resourcePrimKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterArticleModelImpl</code>.
	 * </p>
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param start the lower bound of the range of newsletter articles
	 * @param end the upper bound of the range of newsletter articles (not inclusive)
	 * @return the range of matching newsletter articles
	 */
	public static List<NewsletterArticle> findByResourcePrimKey(
		long resourcePrimKey, int start, int end) {

		return getPersistence().findByResourcePrimKey(
			resourcePrimKey, start, end);
	}

	/**
	 * Returns an ordered range of all the newsletter articles where resourcePrimKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterArticleModelImpl</code>.
	 * </p>
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param start the lower bound of the range of newsletter articles
	 * @param end the upper bound of the range of newsletter articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching newsletter articles
	 */
	public static List<NewsletterArticle> findByResourcePrimKey(
		long resourcePrimKey, int start, int end,
		OrderByComparator<NewsletterArticle> orderByComparator) {

		return getPersistence().findByResourcePrimKey(
			resourcePrimKey, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the newsletter articles where resourcePrimKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterArticleModelImpl</code>.
	 * </p>
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param start the lower bound of the range of newsletter articles
	 * @param end the upper bound of the range of newsletter articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching newsletter articles
	 */
	public static List<NewsletterArticle> findByResourcePrimKey(
		long resourcePrimKey, int start, int end,
		OrderByComparator<NewsletterArticle> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByResourcePrimKey(
			resourcePrimKey, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first newsletter article in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter article
	 * @throws NoSuchNewsletterArticleException if a matching newsletter article could not be found
	 */
	public static NewsletterArticle findByResourcePrimKey_First(
			long resourcePrimKey,
			OrderByComparator<NewsletterArticle> orderByComparator)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterArticleException {

		return getPersistence().findByResourcePrimKey_First(
			resourcePrimKey, orderByComparator);
	}

	/**
	 * Returns the first newsletter article in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter article, or <code>null</code> if a matching newsletter article could not be found
	 */
	public static NewsletterArticle fetchByResourcePrimKey_First(
		long resourcePrimKey,
		OrderByComparator<NewsletterArticle> orderByComparator) {

		return getPersistence().fetchByResourcePrimKey_First(
			resourcePrimKey, orderByComparator);
	}

	/**
	 * Returns the last newsletter article in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter article
	 * @throws NoSuchNewsletterArticleException if a matching newsletter article could not be found
	 */
	public static NewsletterArticle findByResourcePrimKey_Last(
			long resourcePrimKey,
			OrderByComparator<NewsletterArticle> orderByComparator)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterArticleException {

		return getPersistence().findByResourcePrimKey_Last(
			resourcePrimKey, orderByComparator);
	}

	/**
	 * Returns the last newsletter article in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter article, or <code>null</code> if a matching newsletter article could not be found
	 */
	public static NewsletterArticle fetchByResourcePrimKey_Last(
		long resourcePrimKey,
		OrderByComparator<NewsletterArticle> orderByComparator) {

		return getPersistence().fetchByResourcePrimKey_Last(
			resourcePrimKey, orderByComparator);
	}

	/**
	 * Returns the newsletter articles before and after the current newsletter article in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param newsletterArticleId the primary key of the current newsletter article
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next newsletter article
	 * @throws NoSuchNewsletterArticleException if a newsletter article with the primary key could not be found
	 */
	public static NewsletterArticle[] findByResourcePrimKey_PrevAndNext(
			long newsletterArticleId, long resourcePrimKey,
			OrderByComparator<NewsletterArticle> orderByComparator)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterArticleException {

		return getPersistence().findByResourcePrimKey_PrevAndNext(
			newsletterArticleId, resourcePrimKey, orderByComparator);
	}

	/**
	 * Removes all the newsletter articles where resourcePrimKey = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 */
	public static void removeByResourcePrimKey(long resourcePrimKey) {
		getPersistence().removeByResourcePrimKey(resourcePrimKey);
	}

	/**
	 * Returns the number of newsletter articles where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the number of matching newsletter articles
	 */
	public static int countByResourcePrimKey(long resourcePrimKey) {
		return getPersistence().countByResourcePrimKey(resourcePrimKey);
	}

	/**
	 * Returns all the newsletter articles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching newsletter articles
	 */
	public static List<NewsletterArticle> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the newsletter articles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterArticleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of newsletter articles
	 * @param end the upper bound of the range of newsletter articles (not inclusive)
	 * @return the range of matching newsletter articles
	 */
	public static List<NewsletterArticle> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the newsletter articles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterArticleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of newsletter articles
	 * @param end the upper bound of the range of newsletter articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching newsletter articles
	 */
	public static List<NewsletterArticle> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<NewsletterArticle> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the newsletter articles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterArticleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of newsletter articles
	 * @param end the upper bound of the range of newsletter articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching newsletter articles
	 */
	public static List<NewsletterArticle> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<NewsletterArticle> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first newsletter article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter article
	 * @throws NoSuchNewsletterArticleException if a matching newsletter article could not be found
	 */
	public static NewsletterArticle findByUuid_First(
			String uuid, OrderByComparator<NewsletterArticle> orderByComparator)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterArticleException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first newsletter article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter article, or <code>null</code> if a matching newsletter article could not be found
	 */
	public static NewsletterArticle fetchByUuid_First(
		String uuid, OrderByComparator<NewsletterArticle> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last newsletter article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter article
	 * @throws NoSuchNewsletterArticleException if a matching newsletter article could not be found
	 */
	public static NewsletterArticle findByUuid_Last(
			String uuid, OrderByComparator<NewsletterArticle> orderByComparator)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterArticleException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last newsletter article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter article, or <code>null</code> if a matching newsletter article could not be found
	 */
	public static NewsletterArticle fetchByUuid_Last(
		String uuid, OrderByComparator<NewsletterArticle> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the newsletter articles before and after the current newsletter article in the ordered set where uuid = &#63;.
	 *
	 * @param newsletterArticleId the primary key of the current newsletter article
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next newsletter article
	 * @throws NoSuchNewsletterArticleException if a newsletter article with the primary key could not be found
	 */
	public static NewsletterArticle[] findByUuid_PrevAndNext(
			long newsletterArticleId, String uuid,
			OrderByComparator<NewsletterArticle> orderByComparator)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterArticleException {

		return getPersistence().findByUuid_PrevAndNext(
			newsletterArticleId, uuid, orderByComparator);
	}

	/**
	 * Removes all the newsletter articles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of newsletter articles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching newsletter articles
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the newsletter article where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchNewsletterArticleException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching newsletter article
	 * @throws NoSuchNewsletterArticleException if a matching newsletter article could not be found
	 */
	public static NewsletterArticle findByUUID_G(String uuid, long groupId)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterArticleException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the newsletter article where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching newsletter article, or <code>null</code> if a matching newsletter article could not be found
	 */
	public static NewsletterArticle fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the newsletter article where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching newsletter article, or <code>null</code> if a matching newsletter article could not be found
	 */
	public static NewsletterArticle fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the newsletter article where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the newsletter article that was removed
	 */
	public static NewsletterArticle removeByUUID_G(String uuid, long groupId)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterArticleException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of newsletter articles where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching newsletter articles
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the newsletter articles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching newsletter articles
	 */
	public static List<NewsletterArticle> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the newsletter articles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterArticleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of newsletter articles
	 * @param end the upper bound of the range of newsletter articles (not inclusive)
	 * @return the range of matching newsletter articles
	 */
	public static List<NewsletterArticle> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the newsletter articles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterArticleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of newsletter articles
	 * @param end the upper bound of the range of newsletter articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching newsletter articles
	 */
	public static List<NewsletterArticle> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<NewsletterArticle> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the newsletter articles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterArticleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of newsletter articles
	 * @param end the upper bound of the range of newsletter articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching newsletter articles
	 */
	public static List<NewsletterArticle> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<NewsletterArticle> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first newsletter article in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter article
	 * @throws NoSuchNewsletterArticleException if a matching newsletter article could not be found
	 */
	public static NewsletterArticle findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<NewsletterArticle> orderByComparator)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterArticleException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first newsletter article in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter article, or <code>null</code> if a matching newsletter article could not be found
	 */
	public static NewsletterArticle fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<NewsletterArticle> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last newsletter article in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter article
	 * @throws NoSuchNewsletterArticleException if a matching newsletter article could not be found
	 */
	public static NewsletterArticle findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<NewsletterArticle> orderByComparator)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterArticleException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last newsletter article in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter article, or <code>null</code> if a matching newsletter article could not be found
	 */
	public static NewsletterArticle fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<NewsletterArticle> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the newsletter articles before and after the current newsletter article in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param newsletterArticleId the primary key of the current newsletter article
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next newsletter article
	 * @throws NoSuchNewsletterArticleException if a newsletter article with the primary key could not be found
	 */
	public static NewsletterArticle[] findByUuid_C_PrevAndNext(
			long newsletterArticleId, String uuid, long companyId,
			OrderByComparator<NewsletterArticle> orderByComparator)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterArticleException {

		return getPersistence().findByUuid_C_PrevAndNext(
			newsletterArticleId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the newsletter articles where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of newsletter articles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching newsletter articles
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the newsletter article where resourcePrimKey = &#63; or throws a <code>NoSuchNewsletterArticleException</code> if it could not be found.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the matching newsletter article
	 * @throws NoSuchNewsletterArticleException if a matching newsletter article could not be found
	 */
	public static NewsletterArticle findByresourcePrimKey(long resourcePrimKey)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterArticleException {

		return getPersistence().findByresourcePrimKey(resourcePrimKey);
	}

	/**
	 * Returns the newsletter article where resourcePrimKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the matching newsletter article, or <code>null</code> if a matching newsletter article could not be found
	 */
	public static NewsletterArticle fetchByresourcePrimKey(
		long resourcePrimKey) {

		return getPersistence().fetchByresourcePrimKey(resourcePrimKey);
	}

	/**
	 * Returns the newsletter article where resourcePrimKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching newsletter article, or <code>null</code> if a matching newsletter article could not be found
	 */
	public static NewsletterArticle fetchByresourcePrimKey(
		long resourcePrimKey, boolean useFinderCache) {

		return getPersistence().fetchByresourcePrimKey(
			resourcePrimKey, useFinderCache);
	}

	/**
	 * Removes the newsletter article where resourcePrimKey = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the newsletter article that was removed
	 */
	public static NewsletterArticle removeByresourcePrimKey(
			long resourcePrimKey)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterArticleException {

		return getPersistence().removeByresourcePrimKey(resourcePrimKey);
	}

	/**
	 * Returns the number of newsletter articles where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the number of matching newsletter articles
	 */
	public static int countByresourcePrimKey(long resourcePrimKey) {
		return getPersistence().countByresourcePrimKey(resourcePrimKey);
	}

	/**
	 * Caches the newsletter article in the entity cache if it is enabled.
	 *
	 * @param newsletterArticle the newsletter article
	 */
	public static void cacheResult(NewsletterArticle newsletterArticle) {
		getPersistence().cacheResult(newsletterArticle);
	}

	/**
	 * Caches the newsletter articles in the entity cache if it is enabled.
	 *
	 * @param newsletterArticles the newsletter articles
	 */
	public static void cacheResult(List<NewsletterArticle> newsletterArticles) {
		getPersistence().cacheResult(newsletterArticles);
	}

	/**
	 * Creates a new newsletter article with the primary key. Does not add the newsletter article to the database.
	 *
	 * @param newsletterArticleId the primary key for the new newsletter article
	 * @return the new newsletter article
	 */
	public static NewsletterArticle create(long newsletterArticleId) {
		return getPersistence().create(newsletterArticleId);
	}

	/**
	 * Removes the newsletter article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param newsletterArticleId the primary key of the newsletter article
	 * @return the newsletter article that was removed
	 * @throws NoSuchNewsletterArticleException if a newsletter article with the primary key could not be found
	 */
	public static NewsletterArticle remove(long newsletterArticleId)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterArticleException {

		return getPersistence().remove(newsletterArticleId);
	}

	public static NewsletterArticle updateImpl(
		NewsletterArticle newsletterArticle) {

		return getPersistence().updateImpl(newsletterArticle);
	}

	/**
	 * Returns the newsletter article with the primary key or throws a <code>NoSuchNewsletterArticleException</code> if it could not be found.
	 *
	 * @param newsletterArticleId the primary key of the newsletter article
	 * @return the newsletter article
	 * @throws NoSuchNewsletterArticleException if a newsletter article with the primary key could not be found
	 */
	public static NewsletterArticle findByPrimaryKey(long newsletterArticleId)
		throws com.liferay.training.newsletter.exception.
			NoSuchNewsletterArticleException {

		return getPersistence().findByPrimaryKey(newsletterArticleId);
	}

	/**
	 * Returns the newsletter article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param newsletterArticleId the primary key of the newsletter article
	 * @return the newsletter article, or <code>null</code> if a newsletter article with the primary key could not be found
	 */
	public static NewsletterArticle fetchByPrimaryKey(
		long newsletterArticleId) {

		return getPersistence().fetchByPrimaryKey(newsletterArticleId);
	}

	/**
	 * Returns all the newsletter articles.
	 *
	 * @return the newsletter articles
	 */
	public static List<NewsletterArticle> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the newsletter articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of newsletter articles
	 * @param end the upper bound of the range of newsletter articles (not inclusive)
	 * @return the range of newsletter articles
	 */
	public static List<NewsletterArticle> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the newsletter articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of newsletter articles
	 * @param end the upper bound of the range of newsletter articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of newsletter articles
	 */
	public static List<NewsletterArticle> findAll(
		int start, int end,
		OrderByComparator<NewsletterArticle> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the newsletter articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of newsletter articles
	 * @param end the upper bound of the range of newsletter articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of newsletter articles
	 */
	public static List<NewsletterArticle> findAll(
		int start, int end,
		OrderByComparator<NewsletterArticle> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the newsletter articles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of newsletter articles.
	 *
	 * @return the number of newsletter articles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static NewsletterArticlePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<NewsletterArticlePersistence, NewsletterArticlePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			NewsletterArticlePersistence.class);

		ServiceTracker
			<NewsletterArticlePersistence, NewsletterArticlePersistence>
				serviceTracker =
					new ServiceTracker
						<NewsletterArticlePersistence,
						 NewsletterArticlePersistence>(
							 bundle.getBundleContext(),
							 NewsletterArticlePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}