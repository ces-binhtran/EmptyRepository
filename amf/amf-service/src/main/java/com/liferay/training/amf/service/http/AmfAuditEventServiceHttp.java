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
import com.liferay.training.amf.service.AmfAuditEventServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>AmfAuditEventServiceUtil</code> service
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
 * @see AmfAuditEventServiceSoap
 * @generated
 */
public class AmfAuditEventServiceHttp {

	public static java.util.List<com.liferay.training.amf.model.AmfAuditEvent>
		getAuditEventByTypeAndUser(
			HttpPrincipal httpPrincipal, Long userIdForSearch,
			String[] eventTypeForSearch, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.training.amf.model.AmfAuditEvent> comparator) {

		try {
			MethodKey methodKey = new MethodKey(
				AmfAuditEventServiceUtil.class, "getAuditEventByTypeAndUser",
				_getAuditEventByTypeAndUserParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userIdForSearch, eventTypeForSearch, start, end,
				comparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.training.amf.model.AmfAuditEvent>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.training.amf.model.AmfAuditEvent addAmfAuditEvent(
		HttpPrincipal httpPrincipal, long userId, String userName, long groupId,
		long companyId, String ipAddress, String eventType,
		java.util.Date createdDate) {

		try {
			MethodKey methodKey = new MethodKey(
				AmfAuditEventServiceUtil.class, "addAmfAuditEvent",
				_addAmfAuditEventParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, userName, groupId, companyId, ipAddress,
				eventType, createdDate);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.training.amf.model.AmfAuditEvent)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static long countAuditEventBytypeAndUser(
		HttpPrincipal httpPrincipal, Long userIdForSearch,
		String[] eventTypeForSearch) {

		try {
			MethodKey methodKey = new MethodKey(
				AmfAuditEventServiceUtil.class, "countAuditEventBytypeAndUser",
				_countAuditEventBytypeAndUserParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userIdForSearch, eventTypeForSearch);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Long)returnObj).longValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		AmfAuditEventServiceHttp.class);

	private static final Class<?>[] _getAuditEventByTypeAndUserParameterTypes0 =
		new Class[] {
			Long.class, String[].class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[] _addAmfAuditEventParameterTypes1 =
		new Class[] {
			long.class, String.class, long.class, long.class, String.class,
			String.class, java.util.Date.class
		};
	private static final Class<?>[]
		_countAuditEventBytypeAndUserParameterTypes2 = new Class[] {
			Long.class, String[].class
		};

}