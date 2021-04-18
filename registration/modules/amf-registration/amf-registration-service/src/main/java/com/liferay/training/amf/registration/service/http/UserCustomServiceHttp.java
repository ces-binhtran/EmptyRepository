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

package com.liferay.training.amf.registration.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.training.amf.registration.service.UserCustomServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>UserCustomServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserCustomServiceSoap
 * @generated
 */
public class UserCustomServiceHttp {

	public static com.liferay.training.amf.registration.model.UserCustom
			addUserCustom(
				HttpPrincipal httpPrincipal, long creatorUserId, long companyId,
				boolean autoPassword, String password1, String password2,
				boolean autoScreenName, String screenName, String emailAddress,
				long facebookId, String openId, java.util.Locale locale,
				String firstName, String middleName, String lastName,
				long prefixId, long suffixId, boolean male, int birthdayMonth,
				int birthdayDay, int birthdayYear, String jobTitle,
				long[] groupIds, long[] organizationIds, long[] roleIds,
				long[] userGroupIds, boolean sendEmail,
				com.liferay.portal.kernel.service.ServiceContext serviceContext,
				String homePhone, String mobilePhone, String address,
				String address2, String city, String state, String zip,
				String securityQuestion, String securityAnswer,
				boolean acceptedTou)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				UserCustomServiceUtil.class, "addUserCustom",
				_addUserCustomParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, creatorUserId, companyId, autoPassword, password1,
				password2, autoScreenName, screenName, emailAddress, facebookId,
				openId, locale, firstName, middleName, lastName, prefixId,
				suffixId, male, birthdayMonth, birthdayDay, birthdayYear,
				jobTitle, groupIds, organizationIds, roleIds, userGroupIds,
				sendEmail, serviceContext, homePhone, mobilePhone, address,
				address2, city, state, zip, securityQuestion, securityAnswer,
				acceptedTou);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.training.amf.registration.model.UserCustom)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		UserCustomServiceHttp.class);

	private static final Class<?>[] _addUserCustomParameterTypes0 =
		new Class[] {
			long.class, long.class, boolean.class, String.class, String.class,
			boolean.class, String.class, String.class, long.class, String.class,
			java.util.Locale.class, String.class, String.class, String.class,
			long.class, long.class, boolean.class, int.class, int.class,
			int.class, String.class, long[].class, long[].class, long[].class,
			long[].class, boolean.class,
			com.liferay.portal.kernel.service.ServiceContext.class,
			String.class, String.class, String.class, String.class,
			String.class, String.class, String.class, String.class,
			String.class, boolean.class
		};

}