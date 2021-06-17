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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for NewsletterArticle. This utility wraps
 * <code>com.liferay.training.newsletter.service.impl.NewsletterArticleLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Son Truong
 * @see NewsletterArticleLocalService
 * @generated
 */
public class NewsletterArticleLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.training.newsletter.service.impl.NewsletterArticleLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.training.newsletter.model.NewsletterArticle
		addNewsletterArticle(
			long companyId, long groupId, long classNameId, long classPK,
			long resourcePrimKey, String title, String author, int status,
			int order, String content) {

		return getService().addNewsletterArticle(
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
	public static com.liferay.training.newsletter.model.NewsletterArticle
		addNewsletterArticle(
			com.liferay.training.newsletter.model.NewsletterArticle
				newsletterArticle) {

		return getService().addNewsletterArticle(newsletterArticle);
	}

	/**
	 * Creates a new newsletter article with the primary key. Does not add the newsletter article to the database.
	 *
	 * @param newsletterArticleId the primary key for the new newsletter article
	 * @return the new newsletter article
	 */
	public static com.liferay.training.newsletter.model.NewsletterArticle
		createNewsletterArticle(long newsletterArticleId) {

		return getService().createNewsletterArticle(newsletterArticleId);
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
	public static com.liferay.training.newsletter.model.NewsletterArticle
			deleteNewsletterArticle(long newsletterArticleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteNewsletterArticle(newsletterArticleId);
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
	public static com.liferay.training.newsletter.model.NewsletterArticle
		deleteNewsletterArticle(
			com.liferay.training.newsletter.model.NewsletterArticle
				newsletterArticle) {

		return getService().deleteNewsletterArticle(newsletterArticle);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.training.newsletter.model.NewsletterArticle
		fetchNewsletterArticle(long newsletterArticleId) {

		return getService().fetchNewsletterArticle(newsletterArticleId);
	}

	/**
	 * Returns the newsletter article matching the UUID and group.
	 *
	 * @param uuid the newsletter article's UUID
	 * @param groupId the primary key of the group
	 * @return the matching newsletter article, or <code>null</code> if a matching newsletter article could not be found
	 */
	public static com.liferay.training.newsletter.model.NewsletterArticle
		fetchNewsletterArticleByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchNewsletterArticleByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.training.newsletter.model.NewsletterArticle
		findByResourcePrimKey(long resourcePrimKey) {

		return getService().findByResourcePrimKey(resourcePrimKey);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the newsletter article with the primary key.
	 *
	 * @param newsletterArticleId the primary key of the newsletter article
	 * @return the newsletter article
	 * @throws PortalException if a newsletter article with the primary key could not be found
	 */
	public static com.liferay.training.newsletter.model.NewsletterArticle
			getNewsletterArticle(long newsletterArticleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getNewsletterArticle(newsletterArticleId);
	}

	/**
	 * Returns the newsletter article matching the UUID and group.
	 *
	 * @param uuid the newsletter article's UUID
	 * @param groupId the primary key of the group
	 * @return the matching newsletter article
	 * @throws PortalException if a matching newsletter article could not be found
	 */
	public static com.liferay.training.newsletter.model.NewsletterArticle
			getNewsletterArticleByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getNewsletterArticleByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List
		<com.liferay.training.newsletter.model.NewsletterArticle>
			getNewsletterArticles(int start, int end) {

		return getService().getNewsletterArticles(start, end);
	}

	/**
	 * Returns all the newsletter articles matching the UUID and company.
	 *
	 * @param uuid the UUID of the newsletter articles
	 * @param companyId the primary key of the company
	 * @return the matching newsletter articles, or an empty list if no matches were found
	 */
	public static java.util.List
		<com.liferay.training.newsletter.model.NewsletterArticle>
			getNewsletterArticlesByUuidAndCompanyId(
				String uuid, long companyId) {

		return getService().getNewsletterArticlesByUuidAndCompanyId(
			uuid, companyId);
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
	public static java.util.List
		<com.liferay.training.newsletter.model.NewsletterArticle>
			getNewsletterArticlesByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.training.newsletter.model.NewsletterArticle>
						orderByComparator) {

		return getService().getNewsletterArticlesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of newsletter articles.
	 *
	 * @return the number of newsletter articles
	 */
	public static int getNewsletterArticlesCount() {
		return getService().getNewsletterArticlesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List
		<? extends com.liferay.portal.kernel.model.PersistedModel>
				getPersistedModel(long resourcePrimKey)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(resourcePrimKey);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static com.liferay.training.newsletter.model.NewsletterArticle
			updateNewsletterArticle(
				long companyId, long groupId, long newsletterArticleId,
				long classNameId, long classPK, long resourcePrimKey,
				String title, String author, int status, int order,
				String content)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateNewsletterArticle(
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
	public static com.liferay.training.newsletter.model.NewsletterArticle
		updateNewsletterArticle(
			com.liferay.training.newsletter.model.NewsletterArticle
				newsletterArticle) {

		return getService().updateNewsletterArticle(newsletterArticle);
	}

	public static NewsletterArticleLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<NewsletterArticleLocalService, NewsletterArticleLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			NewsletterArticleLocalService.class);

		ServiceTracker
			<NewsletterArticleLocalService, NewsletterArticleLocalService>
				serviceTracker =
					new ServiceTracker
						<NewsletterArticleLocalService,
						 NewsletterArticleLocalService>(
							 bundle.getBundleContext(),
							 NewsletterArticleLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}