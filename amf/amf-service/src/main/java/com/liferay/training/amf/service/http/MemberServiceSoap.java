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
import com.liferay.training.amf.service.MemberServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>MemberServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.training.amf.model.MemberSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.training.amf.model.Member</code>, that is translated to a
 * <code>com.liferay.training.amf.model.MemberSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MemberServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class MemberServiceSoap {

	public static com.liferay.training.amf.model.MemberSoap addMember(
			long groupId, String firstName, String lastName,
			String emailAddress, String username, boolean male,
			int monthOfBirth, int dayOfBirth, int yearOfBirth, String password,
			String confirmPassword, String homePhone, String mobilePhone,
			String address1, String address2, String city, String state,
			String zipCode, String securityQuestion, String answer,
			boolean termOfUse,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.training.amf.model.Member returnValue =
				MemberServiceUtil.addMember(
					groupId, firstName, lastName, emailAddress, username, male,
					monthOfBirth, dayOfBirth, yearOfBirth, password,
					confirmPassword, homePhone, mobilePhone, address1, address2,
					city, state, zipCode, securityQuestion, answer, termOfUse,
					serviceContext);

			return com.liferay.training.amf.model.MemberSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.training.amf.model.MemberSoap[]
			getMembersByKeywords(
				long scopeGroupId, String keywords, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.training.amf.model.Member> comparator)
		throws RemoteException {

		try {
			java.util.List<com.liferay.training.amf.model.Member> returnValue =
				MemberServiceUtil.getMembersByKeywords(
					scopeGroupId, keywords, start, end, comparator);

			return com.liferay.training.amf.model.MemberSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static Object getmembersCountByKeywords(
			long scopeGroupId, String keywords)
		throws RemoteException {

		try {
			Object returnValue = MemberServiceUtil.getmembersCountByKeywords(
				scopeGroupId, keywords);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.training.amf.model.MemberSoap[] getAllMembers()
		throws RemoteException {

		try {
			java.util.List<com.liferay.training.amf.model.Member> returnValue =
				MemberServiceUtil.getAllMembers();

			return com.liferay.training.amf.model.MemberSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(MemberServiceSoap.class);

}