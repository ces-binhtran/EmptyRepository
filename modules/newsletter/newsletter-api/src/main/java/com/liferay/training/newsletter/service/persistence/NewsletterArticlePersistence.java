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

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.training.newsletter.exception.NoSuchNewsletterArticleException;
import com.liferay.training.newsletter.model.NewsletterArticle;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the newsletter article service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Son Truong
 * @see NewsletterArticleUtil
 * @generated
 */
@ProviderType
public interface NewsletterArticlePersistence
	extends BasePersistence<NewsletterArticle> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NewsletterArticleUtil} to access the newsletter article persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the newsletter articles where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the matching newsletter articles
	 */
	public java.util.List<NewsletterArticle> findByResourcePrimKey(
		long resourcePrimKey);

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
	public java.util.List<NewsletterArticle> findByResourcePrimKey(
		long resourcePrimKey, int start, int end);

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
	public java.util.List<NewsletterArticle> findByResourcePrimKey(
		long resourcePrimKey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterArticle>
			orderByComparator);

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
	public java.util.List<NewsletterArticle> findByResourcePrimKey(
		long resourcePrimKey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterArticle>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first newsletter article in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter article
	 * @throws NoSuchNewsletterArticleException if a matching newsletter article could not be found
	 */
	public NewsletterArticle findByResourcePrimKey_First(
			long resourcePrimKey,
			com.liferay.portal.kernel.util.OrderByComparator<NewsletterArticle>
				orderByComparator)
		throws NoSuchNewsletterArticleException;

	/**
	 * Returns the first newsletter article in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter article, or <code>null</code> if a matching newsletter article could not be found
	 */
	public NewsletterArticle fetchByResourcePrimKey_First(
		long resourcePrimKey,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterArticle>
			orderByComparator);

	/**
	 * Returns the last newsletter article in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter article
	 * @throws NoSuchNewsletterArticleException if a matching newsletter article could not be found
	 */
	public NewsletterArticle findByResourcePrimKey_Last(
			long resourcePrimKey,
			com.liferay.portal.kernel.util.OrderByComparator<NewsletterArticle>
				orderByComparator)
		throws NoSuchNewsletterArticleException;

	/**
	 * Returns the last newsletter article in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter article, or <code>null</code> if a matching newsletter article could not be found
	 */
	public NewsletterArticle fetchByResourcePrimKey_Last(
		long resourcePrimKey,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterArticle>
			orderByComparator);

	/**
	 * Returns the newsletter articles before and after the current newsletter article in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param newsletterArticleId the primary key of the current newsletter article
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next newsletter article
	 * @throws NoSuchNewsletterArticleException if a newsletter article with the primary key could not be found
	 */
	public NewsletterArticle[] findByResourcePrimKey_PrevAndNext(
			long newsletterArticleId, long resourcePrimKey,
			com.liferay.portal.kernel.util.OrderByComparator<NewsletterArticle>
				orderByComparator)
		throws NoSuchNewsletterArticleException;

	/**
	 * Removes all the newsletter articles where resourcePrimKey = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 */
	public void removeByResourcePrimKey(long resourcePrimKey);

	/**
	 * Returns the number of newsletter articles where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the number of matching newsletter articles
	 */
	public int countByResourcePrimKey(long resourcePrimKey);

	/**
	 * Returns all the newsletter articles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching newsletter articles
	 */
	public java.util.List<NewsletterArticle> findByUuid(String uuid);

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
	public java.util.List<NewsletterArticle> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<NewsletterArticle> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterArticle>
			orderByComparator);

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
	public java.util.List<NewsletterArticle> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterArticle>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first newsletter article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter article
	 * @throws NoSuchNewsletterArticleException if a matching newsletter article could not be found
	 */
	public NewsletterArticle findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<NewsletterArticle>
				orderByComparator)
		throws NoSuchNewsletterArticleException;

	/**
	 * Returns the first newsletter article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter article, or <code>null</code> if a matching newsletter article could not be found
	 */
	public NewsletterArticle fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterArticle>
			orderByComparator);

	/**
	 * Returns the last newsletter article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter article
	 * @throws NoSuchNewsletterArticleException if a matching newsletter article could not be found
	 */
	public NewsletterArticle findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<NewsletterArticle>
				orderByComparator)
		throws NoSuchNewsletterArticleException;

	/**
	 * Returns the last newsletter article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter article, or <code>null</code> if a matching newsletter article could not be found
	 */
	public NewsletterArticle fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterArticle>
			orderByComparator);

	/**
	 * Returns the newsletter articles before and after the current newsletter article in the ordered set where uuid = &#63;.
	 *
	 * @param newsletterArticleId the primary key of the current newsletter article
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next newsletter article
	 * @throws NoSuchNewsletterArticleException if a newsletter article with the primary key could not be found
	 */
	public NewsletterArticle[] findByUuid_PrevAndNext(
			long newsletterArticleId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<NewsletterArticle>
				orderByComparator)
		throws NoSuchNewsletterArticleException;

	/**
	 * Removes all the newsletter articles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of newsletter articles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching newsletter articles
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the newsletter article where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchNewsletterArticleException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching newsletter article
	 * @throws NoSuchNewsletterArticleException if a matching newsletter article could not be found
	 */
	public NewsletterArticle findByUUID_G(String uuid, long groupId)
		throws NoSuchNewsletterArticleException;

	/**
	 * Returns the newsletter article where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching newsletter article, or <code>null</code> if a matching newsletter article could not be found
	 */
	public NewsletterArticle fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the newsletter article where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching newsletter article, or <code>null</code> if a matching newsletter article could not be found
	 */
	public NewsletterArticle fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the newsletter article where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the newsletter article that was removed
	 */
	public NewsletterArticle removeByUUID_G(String uuid, long groupId)
		throws NoSuchNewsletterArticleException;

	/**
	 * Returns the number of newsletter articles where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching newsletter articles
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the newsletter articles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching newsletter articles
	 */
	public java.util.List<NewsletterArticle> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<NewsletterArticle> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<NewsletterArticle> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterArticle>
			orderByComparator);

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
	public java.util.List<NewsletterArticle> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterArticle>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first newsletter article in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter article
	 * @throws NoSuchNewsletterArticleException if a matching newsletter article could not be found
	 */
	public NewsletterArticle findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<NewsletterArticle>
				orderByComparator)
		throws NoSuchNewsletterArticleException;

	/**
	 * Returns the first newsletter article in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter article, or <code>null</code> if a matching newsletter article could not be found
	 */
	public NewsletterArticle fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterArticle>
			orderByComparator);

	/**
	 * Returns the last newsletter article in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter article
	 * @throws NoSuchNewsletterArticleException if a matching newsletter article could not be found
	 */
	public NewsletterArticle findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<NewsletterArticle>
				orderByComparator)
		throws NoSuchNewsletterArticleException;

	/**
	 * Returns the last newsletter article in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter article, or <code>null</code> if a matching newsletter article could not be found
	 */
	public NewsletterArticle fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterArticle>
			orderByComparator);

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
	public NewsletterArticle[] findByUuid_C_PrevAndNext(
			long newsletterArticleId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<NewsletterArticle>
				orderByComparator)
		throws NoSuchNewsletterArticleException;

	/**
	 * Removes all the newsletter articles where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of newsletter articles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching newsletter articles
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the newsletter article where resourcePrimKey = &#63; or throws a <code>NoSuchNewsletterArticleException</code> if it could not be found.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the matching newsletter article
	 * @throws NoSuchNewsletterArticleException if a matching newsletter article could not be found
	 */
	public NewsletterArticle findByresourcePrimKey(long resourcePrimKey)
		throws NoSuchNewsletterArticleException;

	/**
	 * Returns the newsletter article where resourcePrimKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the matching newsletter article, or <code>null</code> if a matching newsletter article could not be found
	 */
	public NewsletterArticle fetchByresourcePrimKey(long resourcePrimKey);

	/**
	 * Returns the newsletter article where resourcePrimKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching newsletter article, or <code>null</code> if a matching newsletter article could not be found
	 */
	public NewsletterArticle fetchByresourcePrimKey(
		long resourcePrimKey, boolean useFinderCache);

	/**
	 * Removes the newsletter article where resourcePrimKey = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the newsletter article that was removed
	 */
	public NewsletterArticle removeByresourcePrimKey(long resourcePrimKey)
		throws NoSuchNewsletterArticleException;

	/**
	 * Returns the number of newsletter articles where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the number of matching newsletter articles
	 */
	public int countByresourcePrimKey(long resourcePrimKey);

	/**
	 * Caches the newsletter article in the entity cache if it is enabled.
	 *
	 * @param newsletterArticle the newsletter article
	 */
	public void cacheResult(NewsletterArticle newsletterArticle);

	/**
	 * Caches the newsletter articles in the entity cache if it is enabled.
	 *
	 * @param newsletterArticles the newsletter articles
	 */
	public void cacheResult(
		java.util.List<NewsletterArticle> newsletterArticles);

	/**
	 * Creates a new newsletter article with the primary key. Does not add the newsletter article to the database.
	 *
	 * @param newsletterArticleId the primary key for the new newsletter article
	 * @return the new newsletter article
	 */
	public NewsletterArticle create(long newsletterArticleId);

	/**
	 * Removes the newsletter article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param newsletterArticleId the primary key of the newsletter article
	 * @return the newsletter article that was removed
	 * @throws NoSuchNewsletterArticleException if a newsletter article with the primary key could not be found
	 */
	public NewsletterArticle remove(long newsletterArticleId)
		throws NoSuchNewsletterArticleException;

	public NewsletterArticle updateImpl(NewsletterArticle newsletterArticle);

	/**
	 * Returns the newsletter article with the primary key or throws a <code>NoSuchNewsletterArticleException</code> if it could not be found.
	 *
	 * @param newsletterArticleId the primary key of the newsletter article
	 * @return the newsletter article
	 * @throws NoSuchNewsletterArticleException if a newsletter article with the primary key could not be found
	 */
	public NewsletterArticle findByPrimaryKey(long newsletterArticleId)
		throws NoSuchNewsletterArticleException;

	/**
	 * Returns the newsletter article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param newsletterArticleId the primary key of the newsletter article
	 * @return the newsletter article, or <code>null</code> if a newsletter article with the primary key could not be found
	 */
	public NewsletterArticle fetchByPrimaryKey(long newsletterArticleId);

	/**
	 * Returns all the newsletter articles.
	 *
	 * @return the newsletter articles
	 */
	public java.util.List<NewsletterArticle> findAll();

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
	public java.util.List<NewsletterArticle> findAll(int start, int end);

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
	public java.util.List<NewsletterArticle> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterArticle>
			orderByComparator);

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
	public java.util.List<NewsletterArticle> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterArticle>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the newsletter articles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of newsletter articles.
	 *
	 * @return the number of newsletter articles
	 */
	public int countAll();

}