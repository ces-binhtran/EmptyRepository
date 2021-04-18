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
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.training.amf.registration.service.UserCustomServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>UserCustomServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.training.amf.registration.model.UserCustomSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.training.amf.registration.model.UserCustom</code>, that is translated to a
 * <code>com.liferay.training.amf.registration.model.UserCustomSoap</code>. Methods that SOAP
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
 * @see UserCustomServiceHttp
 * @generated
 */
public class UserCustomServiceSoap {

	public static com.liferay.training.amf.registration.model.UserCustomSoap
			addUserCustom(
				long creatorUserId, long companyId, boolean autoPassword,
				String password1, String password2, boolean autoScreenName,
				String screenName, String emailAddress, long facebookId,
				String openId, String locale, String firstName,
				String middleName, String lastName, long prefixId,
				long suffixId, boolean male, int birthdayMonth, int birthdayDay,
				int birthdayYear, String jobTitle, long[] groupIds,
				long[] organizationIds, long[] roleIds, long[] userGroupIds,
				boolean sendEmail,
				com.liferay.portal.kernel.service.ServiceContext serviceContext,
				String homePhone, String mobilePhone, String address,
				String address2, String city, String state, String zip,
				String securityQuestion, String securityAnswer,
				boolean acceptedTou)
		throws RemoteException {

		try {
			com.liferay.training.amf.registration.model.UserCustom returnValue =
				UserCustomServiceUtil.addUserCustom(
					creatorUserId, companyId, autoPassword, password1,
					password2, autoScreenName, screenName, emailAddress,
					facebookId, openId, LocaleUtil.fromLanguageId(locale),
					firstName, middleName, lastName, prefixId, suffixId, male,
					birthdayMonth, birthdayDay, birthdayYear, jobTitle,
					groupIds, organizationIds, roleIds, userGroupIds, sendEmail,
					serviceContext, homePhone, mobilePhone, address, address2,
					city, state, zip, securityQuestion, securityAnswer,
					acceptedTou);

			return com.liferay.training.amf.registration.model.UserCustomSoap.
				toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		UserCustomServiceSoap.class);

}