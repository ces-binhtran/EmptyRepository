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

package com.liferay.training.newsletter.service;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.PersistedResourcedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.training.newsletter.model.NewsletterIssue;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for NewsletterIssue. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Son Truong
 * @see NewsletterIssueLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface NewsletterIssueLocalService
	extends BaseLocalService, PersistedModelLocalService,
			PersistedResourcedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.liferay.training.newsletter.service.impl.NewsletterIssueLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the newsletter issue local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link NewsletterIssueLocalServiceUtil} if injection and service tracking are not available.
	 */
	@Indexable(type = IndexableType.REINDEX)
	public NewsletterIssue addNewsletterIssue(
		long companyId, long groupId, int issueNumber, String title,
		String description, Date issueDate, int status, long resourcePrimKey);

	/**
	 * Adds the newsletter issue to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NewsletterIssueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param newsletterIssue the newsletter issue
	 * @return the newsletter issue that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public NewsletterIssue addNewsletterIssue(NewsletterIssue newsletterIssue);

	/**
	 * Creates a new newsletter issue with the primary key. Does not add the newsletter issue to the database.
	 *
	 * @param newsletterIssueId the primary key for the new newsletter issue
	 * @return the new newsletter issue
	 */
	@Transactional(enabled = false)
	public NewsletterIssue createNewsletterIssue(long newsletterIssueId);

	/**
	 * Deletes the newsletter issue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NewsletterIssueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param newsletterIssueId the primary key of the newsletter issue
	 * @return the newsletter issue that was removed
	 * @throws PortalException if a newsletter issue with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public NewsletterIssue deleteNewsletterIssue(long newsletterIssueId)
		throws PortalException;

	/**
	 * Deletes the newsletter issue from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NewsletterIssueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param newsletterIssue the newsletter issue
	 * @return the newsletter issue that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public NewsletterIssue deleteNewsletterIssue(
		NewsletterIssue newsletterIssue);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.newsletter.model.impl.NewsletterIssueModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.newsletter.model.impl.NewsletterIssueModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public NewsletterIssue fetchNewsletterIssue(long newsletterIssueId);

	/**
	 * Returns the newsletter issue matching the UUID and group.
	 *
	 * @param uuid the newsletter issue's UUID
	 * @param groupId the primary key of the group
	 * @return the matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public NewsletterIssue fetchNewsletterIssueByUuidAndGroupId(
		String uuid, long groupId);

	public NewsletterIssue findByResourcePrimKey(long resourcePrimKey);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the newsletter issue with the primary key.
	 *
	 * @param newsletterIssueId the primary key of the newsletter issue
	 * @return the newsletter issue
	 * @throws PortalException if a newsletter issue with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public NewsletterIssue getNewsletterIssue(long newsletterIssueId)
		throws PortalException;

	/**
	 * Returns the newsletter issue matching the UUID and group.
	 *
	 * @param uuid the newsletter issue's UUID
	 * @param groupId the primary key of the group
	 * @return the matching newsletter issue
	 * @throws PortalException if a matching newsletter issue could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public NewsletterIssue getNewsletterIssueByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the newsletter issues.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.newsletter.model.impl.NewsletterIssueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of newsletter issues
	 * @param end the upper bound of the range of newsletter issues (not inclusive)
	 * @return the range of newsletter issues
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<NewsletterIssue> getNewsletterIssues(int start, int end);

	/**
	 * Returns all the newsletter issues matching the UUID and company.
	 *
	 * @param uuid the UUID of the newsletter issues
	 * @param companyId the primary key of the company
	 * @return the matching newsletter issues, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<NewsletterIssue> getNewsletterIssuesByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of newsletter issues matching the UUID and company.
	 *
	 * @param uuid the UUID of the newsletter issues
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of newsletter issues
	 * @param end the upper bound of the range of newsletter issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching newsletter issues, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<NewsletterIssue> getNewsletterIssuesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<NewsletterIssue> orderByComparator);

	/**
	 * Returns the number of newsletter issues.
	 *
	 * @return the number of newsletter issues
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getNewsletterIssuesCount();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<? extends PersistedModel> getPersistedModel(
			long resourcePrimKey)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Indexable(type = IndexableType.REINDEX)
	public NewsletterIssue updateNewsletterIssue(
			long companyId, long groupId, long newsletterIssueId,
			int issueNumber, String title, String description, Date issueDate,
			int status, long resourcePrimKey)
		throws PortalException;

	/**
	 * Updates the newsletter issue in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NewsletterIssueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param newsletterIssue the newsletter issue
	 * @return the newsletter issue that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public NewsletterIssue updateNewsletterIssue(
		NewsletterIssue newsletterIssue);

}