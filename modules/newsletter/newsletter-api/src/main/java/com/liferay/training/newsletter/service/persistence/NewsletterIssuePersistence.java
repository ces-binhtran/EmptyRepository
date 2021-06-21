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
import com.liferay.training.newsletter.exception.NoSuchNewsletterIssueException;
import com.liferay.training.newsletter.model.NewsletterIssue;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the newsletter issue service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Son Truong
 * @see NewsletterIssueUtil
 * @generated
 */
@ProviderType
public interface NewsletterIssuePersistence
	extends BasePersistence<NewsletterIssue> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NewsletterIssueUtil} to access the newsletter issue persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the newsletter issues where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the matching newsletter issues
	 */
	public java.util.List<NewsletterIssue> findByResourcePrimKey(
		long resourcePrimKey);

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
	public java.util.List<NewsletterIssue> findByResourcePrimKey(
		long resourcePrimKey, int start, int end);

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
	public java.util.List<NewsletterIssue> findByResourcePrimKey(
		long resourcePrimKey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterIssue>
			orderByComparator);

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
	public java.util.List<NewsletterIssue> findByResourcePrimKey(
		long resourcePrimKey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterIssue>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first newsletter issue in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter issue
	 * @throws NoSuchNewsletterIssueException if a matching newsletter issue could not be found
	 */
	public NewsletterIssue findByResourcePrimKey_First(
			long resourcePrimKey,
			com.liferay.portal.kernel.util.OrderByComparator<NewsletterIssue>
				orderByComparator)
		throws NoSuchNewsletterIssueException;

	/**
	 * Returns the first newsletter issue in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	public NewsletterIssue fetchByResourcePrimKey_First(
		long resourcePrimKey,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterIssue>
			orderByComparator);

	/**
	 * Returns the last newsletter issue in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter issue
	 * @throws NoSuchNewsletterIssueException if a matching newsletter issue could not be found
	 */
	public NewsletterIssue findByResourcePrimKey_Last(
			long resourcePrimKey,
			com.liferay.portal.kernel.util.OrderByComparator<NewsletterIssue>
				orderByComparator)
		throws NoSuchNewsletterIssueException;

	/**
	 * Returns the last newsletter issue in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	public NewsletterIssue fetchByResourcePrimKey_Last(
		long resourcePrimKey,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterIssue>
			orderByComparator);

	/**
	 * Returns the newsletter issues before and after the current newsletter issue in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param newsletterIssueId the primary key of the current newsletter issue
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next newsletter issue
	 * @throws NoSuchNewsletterIssueException if a newsletter issue with the primary key could not be found
	 */
	public NewsletterIssue[] findByResourcePrimKey_PrevAndNext(
			long newsletterIssueId, long resourcePrimKey,
			com.liferay.portal.kernel.util.OrderByComparator<NewsletterIssue>
				orderByComparator)
		throws NoSuchNewsletterIssueException;

	/**
	 * Removes all the newsletter issues where resourcePrimKey = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 */
	public void removeByResourcePrimKey(long resourcePrimKey);

	/**
	 * Returns the number of newsletter issues where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the number of matching newsletter issues
	 */
	public int countByResourcePrimKey(long resourcePrimKey);

	/**
	 * Returns all the newsletter issues where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching newsletter issues
	 */
	public java.util.List<NewsletterIssue> findByUuid(String uuid);

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
	public java.util.List<NewsletterIssue> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<NewsletterIssue> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterIssue>
			orderByComparator);

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
	public java.util.List<NewsletterIssue> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterIssue>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first newsletter issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter issue
	 * @throws NoSuchNewsletterIssueException if a matching newsletter issue could not be found
	 */
	public NewsletterIssue findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<NewsletterIssue>
				orderByComparator)
		throws NoSuchNewsletterIssueException;

	/**
	 * Returns the first newsletter issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	public NewsletterIssue fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterIssue>
			orderByComparator);

	/**
	 * Returns the last newsletter issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter issue
	 * @throws NoSuchNewsletterIssueException if a matching newsletter issue could not be found
	 */
	public NewsletterIssue findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<NewsletterIssue>
				orderByComparator)
		throws NoSuchNewsletterIssueException;

	/**
	 * Returns the last newsletter issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	public NewsletterIssue fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterIssue>
			orderByComparator);

	/**
	 * Returns the newsletter issues before and after the current newsletter issue in the ordered set where uuid = &#63;.
	 *
	 * @param newsletterIssueId the primary key of the current newsletter issue
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next newsletter issue
	 * @throws NoSuchNewsletterIssueException if a newsletter issue with the primary key could not be found
	 */
	public NewsletterIssue[] findByUuid_PrevAndNext(
			long newsletterIssueId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<NewsletterIssue>
				orderByComparator)
		throws NoSuchNewsletterIssueException;

	/**
	 * Removes all the newsletter issues where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of newsletter issues where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching newsletter issues
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the newsletter issue where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchNewsletterIssueException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching newsletter issue
	 * @throws NoSuchNewsletterIssueException if a matching newsletter issue could not be found
	 */
	public NewsletterIssue findByUUID_G(String uuid, long groupId)
		throws NoSuchNewsletterIssueException;

	/**
	 * Returns the newsletter issue where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	public NewsletterIssue fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the newsletter issue where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	public NewsletterIssue fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the newsletter issue where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the newsletter issue that was removed
	 */
	public NewsletterIssue removeByUUID_G(String uuid, long groupId)
		throws NoSuchNewsletterIssueException;

	/**
	 * Returns the number of newsletter issues where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching newsletter issues
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the newsletter issues where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching newsletter issues
	 */
	public java.util.List<NewsletterIssue> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<NewsletterIssue> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<NewsletterIssue> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterIssue>
			orderByComparator);

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
	public java.util.List<NewsletterIssue> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterIssue>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first newsletter issue in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter issue
	 * @throws NoSuchNewsletterIssueException if a matching newsletter issue could not be found
	 */
	public NewsletterIssue findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<NewsletterIssue>
				orderByComparator)
		throws NoSuchNewsletterIssueException;

	/**
	 * Returns the first newsletter issue in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	public NewsletterIssue fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterIssue>
			orderByComparator);

	/**
	 * Returns the last newsletter issue in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter issue
	 * @throws NoSuchNewsletterIssueException if a matching newsletter issue could not be found
	 */
	public NewsletterIssue findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<NewsletterIssue>
				orderByComparator)
		throws NoSuchNewsletterIssueException;

	/**
	 * Returns the last newsletter issue in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	public NewsletterIssue fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterIssue>
			orderByComparator);

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
	public NewsletterIssue[] findByUuid_C_PrevAndNext(
			long newsletterIssueId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<NewsletterIssue>
				orderByComparator)
		throws NoSuchNewsletterIssueException;

	/**
	 * Removes all the newsletter issues where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of newsletter issues where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching newsletter issues
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the newsletter issue where resourcePrimKey = &#63; or throws a <code>NoSuchNewsletterIssueException</code> if it could not be found.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the matching newsletter issue
	 * @throws NoSuchNewsletterIssueException if a matching newsletter issue could not be found
	 */
	public NewsletterIssue findByresourcePrimKey(long resourcePrimKey)
		throws NoSuchNewsletterIssueException;

	/**
	 * Returns the newsletter issue where resourcePrimKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	public NewsletterIssue fetchByresourcePrimKey(long resourcePrimKey);

	/**
	 * Returns the newsletter issue where resourcePrimKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	public NewsletterIssue fetchByresourcePrimKey(
		long resourcePrimKey, boolean useFinderCache);

	/**
	 * Removes the newsletter issue where resourcePrimKey = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the newsletter issue that was removed
	 */
	public NewsletterIssue removeByresourcePrimKey(long resourcePrimKey)
		throws NoSuchNewsletterIssueException;

	/**
	 * Returns the number of newsletter issues where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the number of matching newsletter issues
	 */
	public int countByresourcePrimKey(long resourcePrimKey);

	/**
	 * Caches the newsletter issue in the entity cache if it is enabled.
	 *
	 * @param newsletterIssue the newsletter issue
	 */
	public void cacheResult(NewsletterIssue newsletterIssue);

	/**
	 * Caches the newsletter issues in the entity cache if it is enabled.
	 *
	 * @param newsletterIssues the newsletter issues
	 */
	public void cacheResult(java.util.List<NewsletterIssue> newsletterIssues);

	/**
	 * Creates a new newsletter issue with the primary key. Does not add the newsletter issue to the database.
	 *
	 * @param newsletterIssueId the primary key for the new newsletter issue
	 * @return the new newsletter issue
	 */
	public NewsletterIssue create(long newsletterIssueId);

	/**
	 * Removes the newsletter issue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param newsletterIssueId the primary key of the newsletter issue
	 * @return the newsletter issue that was removed
	 * @throws NoSuchNewsletterIssueException if a newsletter issue with the primary key could not be found
	 */
	public NewsletterIssue remove(long newsletterIssueId)
		throws NoSuchNewsletterIssueException;

	public NewsletterIssue updateImpl(NewsletterIssue newsletterIssue);

	/**
	 * Returns the newsletter issue with the primary key or throws a <code>NoSuchNewsletterIssueException</code> if it could not be found.
	 *
	 * @param newsletterIssueId the primary key of the newsletter issue
	 * @return the newsletter issue
	 * @throws NoSuchNewsletterIssueException if a newsletter issue with the primary key could not be found
	 */
	public NewsletterIssue findByPrimaryKey(long newsletterIssueId)
		throws NoSuchNewsletterIssueException;

	/**
	 * Returns the newsletter issue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param newsletterIssueId the primary key of the newsletter issue
	 * @return the newsletter issue, or <code>null</code> if a newsletter issue with the primary key could not be found
	 */
	public NewsletterIssue fetchByPrimaryKey(long newsletterIssueId);

	/**
	 * Returns all the newsletter issues.
	 *
	 * @return the newsletter issues
	 */
	public java.util.List<NewsletterIssue> findAll();

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
	public java.util.List<NewsletterIssue> findAll(int start, int end);

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
	public java.util.List<NewsletterIssue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterIssue>
			orderByComparator);

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
	public java.util.List<NewsletterIssue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NewsletterIssue>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the newsletter issues from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of newsletter issues.
	 *
	 * @return the number of newsletter issues
	 */
	public int countAll();

}