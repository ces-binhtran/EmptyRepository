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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NewsletterIssueLocalService}.
 *
 * @author Son Truong
 * @see NewsletterIssueLocalService
 * @generated
 */
public class NewsletterIssueLocalServiceWrapper
	implements NewsletterIssueLocalService,
			   ServiceWrapper<NewsletterIssueLocalService> {

	public NewsletterIssueLocalServiceWrapper(
		NewsletterIssueLocalService newsletterIssueLocalService) {

		_newsletterIssueLocalService = newsletterIssueLocalService;
	}

	@Override
	public com.liferay.training.newsletter.model.NewsletterIssue
		addNewsletterIssue(
			long companyId, long groupId, int issueNumber, String title,
			String description, java.util.Date issueDate, int status,
			long resourcePrimKey) {

		return _newsletterIssueLocalService.addNewsletterIssue(
			companyId, groupId, issueNumber, title, description, issueDate,
			status, resourcePrimKey);
	}

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
	@Override
	public com.liferay.training.newsletter.model.NewsletterIssue
		addNewsletterIssue(
			com.liferay.training.newsletter.model.NewsletterIssue
				newsletterIssue) {

		return _newsletterIssueLocalService.addNewsletterIssue(newsletterIssue);
	}

	/**
	 * Creates a new newsletter issue with the primary key. Does not add the newsletter issue to the database.
	 *
	 * @param newsletterIssueId the primary key for the new newsletter issue
	 * @return the new newsletter issue
	 */
	@Override
	public com.liferay.training.newsletter.model.NewsletterIssue
		createNewsletterIssue(long newsletterIssueId) {

		return _newsletterIssueLocalService.createNewsletterIssue(
			newsletterIssueId);
	}

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
	@Override
	public com.liferay.training.newsletter.model.NewsletterIssue
			deleteNewsletterIssue(long newsletterIssueId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _newsletterIssueLocalService.deleteNewsletterIssue(
			newsletterIssueId);
	}

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
	@Override
	public com.liferay.training.newsletter.model.NewsletterIssue
		deleteNewsletterIssue(
			com.liferay.training.newsletter.model.NewsletterIssue
				newsletterIssue) {

		return _newsletterIssueLocalService.deleteNewsletterIssue(
			newsletterIssue);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _newsletterIssueLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _newsletterIssueLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _newsletterIssueLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _newsletterIssueLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _newsletterIssueLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _newsletterIssueLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _newsletterIssueLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.training.newsletter.model.NewsletterIssue
		fetchNewsletterIssue(long newsletterIssueId) {

		return _newsletterIssueLocalService.fetchNewsletterIssue(
			newsletterIssueId);
	}

	/**
	 * Returns the newsletter issue matching the UUID and group.
	 *
	 * @param uuid the newsletter issue's UUID
	 * @param groupId the primary key of the group
	 * @return the matching newsletter issue, or <code>null</code> if a matching newsletter issue could not be found
	 */
	@Override
	public com.liferay.training.newsletter.model.NewsletterIssue
		fetchNewsletterIssueByUuidAndGroupId(String uuid, long groupId) {

		return _newsletterIssueLocalService.
			fetchNewsletterIssueByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.training.newsletter.model.NewsletterIssue
		findByResourcePrimKey(long resourcePrimKey) {

		return _newsletterIssueLocalService.findByResourcePrimKey(
			resourcePrimKey);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _newsletterIssueLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _newsletterIssueLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the newsletter issue with the primary key.
	 *
	 * @param newsletterIssueId the primary key of the newsletter issue
	 * @return the newsletter issue
	 * @throws PortalException if a newsletter issue with the primary key could not be found
	 */
	@Override
	public com.liferay.training.newsletter.model.NewsletterIssue
			getNewsletterIssue(long newsletterIssueId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _newsletterIssueLocalService.getNewsletterIssue(
			newsletterIssueId);
	}

	/**
	 * Returns the newsletter issue matching the UUID and group.
	 *
	 * @param uuid the newsletter issue's UUID
	 * @param groupId the primary key of the group
	 * @return the matching newsletter issue
	 * @throws PortalException if a matching newsletter issue could not be found
	 */
	@Override
	public com.liferay.training.newsletter.model.NewsletterIssue
			getNewsletterIssueByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _newsletterIssueLocalService.getNewsletterIssueByUuidAndGroupId(
			uuid, groupId);
	}

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
	@Override
	public java.util.List<com.liferay.training.newsletter.model.NewsletterIssue>
		getNewsletterIssues(int start, int end) {

		return _newsletterIssueLocalService.getNewsletterIssues(start, end);
	}

	/**
	 * Returns all the newsletter issues matching the UUID and company.
	 *
	 * @param uuid the UUID of the newsletter issues
	 * @param companyId the primary key of the company
	 * @return the matching newsletter issues, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.liferay.training.newsletter.model.NewsletterIssue>
		getNewsletterIssuesByUuidAndCompanyId(String uuid, long companyId) {

		return _newsletterIssueLocalService.
			getNewsletterIssuesByUuidAndCompanyId(uuid, companyId);
	}

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
	@Override
	public java.util.List<com.liferay.training.newsletter.model.NewsletterIssue>
		getNewsletterIssuesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.training.newsletter.model.NewsletterIssue>
					orderByComparator) {

		return _newsletterIssueLocalService.
			getNewsletterIssuesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of newsletter issues.
	 *
	 * @return the number of newsletter issues
	 */
	@Override
	public int getNewsletterIssuesCount() {
		return _newsletterIssueLocalService.getNewsletterIssuesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _newsletterIssueLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List
		<? extends com.liferay.portal.kernel.model.PersistedModel>
				getPersistedModel(long resourcePrimKey)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _newsletterIssueLocalService.getPersistedModel(resourcePrimKey);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _newsletterIssueLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.liferay.training.newsletter.model.NewsletterIssue
			updateNewsletterIssue(
				long companyId, long groupId, long newsletterIssueId,
				int issueNumber, String title, String description,
				java.util.Date issueDate, int status, long resourcePrimKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _newsletterIssueLocalService.updateNewsletterIssue(
			companyId, groupId, newsletterIssueId, issueNumber, title,
			description, issueDate, status, resourcePrimKey);
	}

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
	@Override
	public com.liferay.training.newsletter.model.NewsletterIssue
		updateNewsletterIssue(
			com.liferay.training.newsletter.model.NewsletterIssue
				newsletterIssue) {

		return _newsletterIssueLocalService.updateNewsletterIssue(
			newsletterIssue);
	}

	@Override
	public NewsletterIssueLocalService getWrappedService() {
		return _newsletterIssueLocalService;
	}

	@Override
	public void setWrappedService(
		NewsletterIssueLocalService newsletterIssueLocalService) {

		_newsletterIssueLocalService = newsletterIssueLocalService;
	}

	private NewsletterIssueLocalService _newsletterIssueLocalService;

}