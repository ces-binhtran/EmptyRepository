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

package com.liferay.training.amf.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.training.amf.service.AmfRegistrationServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>AmfRegistrationServiceUtil</code> service
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
 * @see AmfRegistrationServiceSoap
 * @generated
 */
public class AmfRegistrationServiceHttp {

	public static com.liferay.portal.kernel.model.User addMember(
			HttpPrincipal httpPrincipal, long scopeGroupId, long companyId,
			String firstName, String lastName, String emailAddress,
			java.util.Locale locale, String username, boolean male,
			int monthOfBirth, int dayOfBirth, int yearOfBirth, String password,
			String confirmPassword, String homePhone, String mobilePhone,
			String address1, String address2, String city, String state,
			String zipCode, String securityQuestion, String answer,
			boolean termOfUse,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				AmfRegistrationServiceUtil.class, "addMember",
				_addMemberParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, scopeGroupId, companyId, firstName, lastName,
				emailAddress, locale, username, male, monthOfBirth, dayOfBirth,
				yearOfBirth, password, confirmPassword, homePhone, mobilePhone,
				address1, address2, city, state, zipCode, securityQuestion,
				answer, termOfUse, serviceContext);

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

			return (com.liferay.portal.kernel.model.User)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		AmfRegistrationServiceHttp.class);

	private static final Class<?>[] _addMemberParameterTypes0 = new Class[] {
		long.class, long.class, String.class, String.class, String.class,
		java.util.Locale.class, String.class, boolean.class, int.class,
		int.class, int.class, String.class, String.class, String.class,
		String.class, String.class, String.class, String.class, String.class,
		String.class, String.class, String.class, boolean.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};

}