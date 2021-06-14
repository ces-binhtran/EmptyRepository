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
 * Provides a wrapper for {@link NewsletterArticleLocalService}.
 *
 * @author Son Truong
 * @see NewsletterArticleLocalService
 * @generated
 */
public class NewsletterArticleLocalServiceWrapper
	implements NewsletterArticleLocalService,
			   ServiceWrapper<NewsletterArticleLocalService> {

	public NewsletterArticleLocalServiceWrapper(
		NewsletterArticleLocalService newsletterArticleLocalService) {

		_newsletterArticleLocalService = newsletterArticleLocalService;
	}

	@Override
	public com.liferay.training.newsletter.model.NewsletterArticle
		addNewsletterArticle(
			long companyId, long groupId, long classNameId, long classPK,
			long resourcePrimKey, String title, String author, int status,
			int order, String content) {

		return _newsletterArticleLocalService.addNewsletterArticle(
			companyId, groupId, classNameId, classPK, resourcePrimKey, title,
			author, status, order, content);
	}

	/**
	 * Adds the newsletter article to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NewsletterArticleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param newsletterArticle the newsletter article
	 * @return the newsletter article that was added
	 */
	@Override
	public com.liferay.training.newsletter.model.NewsletterArticle
		addNewsletterArticle(
			com.liferay.training.newsletter.model.NewsletterArticle
				newsletterArticle) {

		return _newsletterArticleLocalService.addNewsletterArticle(
			newsletterArticle);
	}

	/**
	 * Creates a new newsletter article with the primary key. Does not add the newsletter article to the database.
	 *
	 * @param newsletterArticleId the primary key for the new newsletter article
	 * @return the new newsletter article
	 */
	@Override
	public com.liferay.training.newsletter.model.NewsletterArticle
		createNewsletterArticle(long newsletterArticleId) {

		return _newsletterArticleLocalService.createNewsletterArticle(
			newsletterArticleId);
	}

	/**
	 * Deletes the newsletter article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NewsletterArticleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param newsletterArticleId the primary key of the newsletter article
	 * @return the newsletter article that was removed
	 * @throws PortalException if a newsletter article with the primary key could not be found
	 */
	@Override
	public com.liferay.training.newsletter.model.NewsletterArticle
			deleteNewsletterArticle(long newsletterArticleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _newsletterArticleLocalService.deleteNewsletterArticle(
			newsletterArticleId);
	}

	/**
	 * Deletes the newsletter article from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NewsletterArticleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param newsletterArticle the newsletter article
	 * @return the newsletter article that was removed
	 */
	@Override
	public com.liferay.training.newsletter.model.NewsletterArticle
		deleteNewsletterArticle(
			com.liferay.training.newsletter.model.NewsletterArticle
				newsletterArticle) {

		return _newsletterArticleLocalService.deleteNewsletterArticle(
			newsletterArticle);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _newsletterArticleLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _newsletterArticleLocalService.dynamicQuery();
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

		return _newsletterArticleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.newsletter.model.impl.NewsletterArticleModelImpl</code>.
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

		return _newsletterArticleLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.newsletter.model.impl.NewsletterArticleModelImpl</code>.
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

		return _newsletterArticleLocalService.dynamicQuery(
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

		return _newsletterArticleLocalService.dynamicQueryCount(dynamicQuery);
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

		return _newsletterArticleLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.training.newsletter.model.NewsletterArticle
		fetchNewsletterArticle(long newsletterArticleId) {

		return _newsletterArticleLocalService.fetchNewsletterArticle(
			newsletterArticleId);
	}

	/**
	 * Returns the newsletter article matching the UUID and group.
	 *
	 * @param uuid the newsletter article's UUID
	 * @param groupId the primary key of the group
	 * @return the matching newsletter article, or <code>null</code> if a matching newsletter article could not be found
	 */
	@Override
	public com.liferay.training.newsletter.model.NewsletterArticle
		fetchNewsletterArticleByUuidAndGroupId(String uuid, long groupId) {

		return _newsletterArticleLocalService.
			fetchNewsletterArticleByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.training.newsletter.model.NewsletterArticle
		findByResourcePrimKey(long resourcePrimKey) {

		return _newsletterArticleLocalService.findByResourcePrimKey(
			resourcePrimKey);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _newsletterArticleLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _newsletterArticleLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the newsletter article with the primary key.
	 *
	 * @param newsletterArticleId the primary key of the newsletter article
	 * @return the newsletter article
	 * @throws PortalException if a newsletter article with the primary key could not be found
	 */
	@Override
	public com.liferay.training.newsletter.model.NewsletterArticle
			getNewsletterArticle(long newsletterArticleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _newsletterArticleLocalService.getNewsletterArticle(
			newsletterArticleId);
	}

	/**
	 * Returns the newsletter article matching the UUID and group.
	 *
	 * @param uuid the newsletter article's UUID
	 * @param groupId the primary key of the group
	 * @return the matching newsletter article
	 * @throws PortalException if a matching newsletter article could not be found
	 */
	@Override
	public com.liferay.training.newsletter.model.NewsletterArticle
			getNewsletterArticleByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _newsletterArticleLocalService.
			getNewsletterArticleByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the newsletter articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.newsletter.model.impl.NewsletterArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of newsletter articles
	 * @param end the upper bound of the range of newsletter articles (not inclusive)
	 * @return the range of newsletter articles
	 */
	@Override
	public java.util.List
		<com.liferay.training.newsletter.model.NewsletterArticle>
			getNewsletterArticles(int start, int end) {

		return _newsletterArticleLocalService.getNewsletterArticles(start, end);
	}

	/**
	 * Returns all the newsletter articles matching the UUID and company.
	 *
	 * @param uuid the UUID of the newsletter articles
	 * @param companyId the primary key of the company
	 * @return the matching newsletter articles, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.liferay.training.newsletter.model.NewsletterArticle>
			getNewsletterArticlesByUuidAndCompanyId(
				String uuid, long companyId) {

		return _newsletterArticleLocalService.
			getNewsletterArticlesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of newsletter articles matching the UUID and company.
	 *
	 * @param uuid the UUID of the newsletter articles
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of newsletter articles
	 * @param end the upper bound of the range of newsletter articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching newsletter articles, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.liferay.training.newsletter.model.NewsletterArticle>
			getNewsletterArticlesByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.training.newsletter.model.NewsletterArticle>
						orderByComparator) {

		return _newsletterArticleLocalService.
			getNewsletterArticlesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of newsletter articles.
	 *
	 * @return the number of newsletter articles
	 */
	@Override
	public int getNewsletterArticlesCount() {
		return _newsletterArticleLocalService.getNewsletterArticlesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _newsletterArticleLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List
		<? extends com.liferay.portal.kernel.model.PersistedModel>
				getPersistedModel(long resourcePrimKey)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _newsletterArticleLocalService.getPersistedModel(
			resourcePrimKey);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _newsletterArticleLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.liferay.training.newsletter.model.NewsletterArticle
			updateNewsletterArticle(
				long companyId, long groupId, long newsletterArticleId,
				long classNameId, long classPK, long resourcePrimKey,
				String title, String author, int status, int order,
				String content)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _newsletterArticleLocalService.updateNewsletterArticle(
			companyId, groupId, newsletterArticleId, classNameId, classPK,
			resourcePrimKey, title, author, status, order, content);
	}

	/**
	 * Updates the newsletter article in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NewsletterArticleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param newsletterArticle the newsletter article
	 * @return the newsletter article that was updated
	 */
	@Override
	public com.liferay.training.newsletter.model.NewsletterArticle
		updateNewsletterArticle(
			com.liferay.training.newsletter.model.NewsletterArticle
				newsletterArticle) {

		return _newsletterArticleLocalService.updateNewsletterArticle(
			newsletterArticle);
	}

	@Override
	public NewsletterArticleLocalService getWrappedService() {
		return _newsletterArticleLocalService;
	}

	@Override
	public void setWrappedService(
		NewsletterArticleLocalService newsletterArticleLocalService) {

		_newsletterArticleLocalService = newsletterArticleLocalService;
	}

	private NewsletterArticleLocalService _newsletterArticleLocalService;

}