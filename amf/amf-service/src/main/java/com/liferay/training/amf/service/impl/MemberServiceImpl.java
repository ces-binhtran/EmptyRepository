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

package com.liferay.training.amf.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.training.amf.model.Member;
import com.liferay.training.amf.service.base.MemberServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the member remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.liferay.training.amf.service.MemberService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MemberServiceBaseImpl
 */
@Component(property = { "json.web.service.context.name=amf",
		"json.web.service.context.path=Member" }, service = AopService.class)
public class MemberServiceImpl extends MemberServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use
	 * <code>com.liferay.training.amf.service.MemberServiceUtil</code> to access the
	 * member remote service.
	 */
	public Member addMember(long groupId, String firstName, String lastName, String emailAddress, String username, 
			boolean male, int monthOfBirth, int dayOfBirth, int yearOfBirth, 
			String password, String confirmPassword, String homePhone, String mobilePhone, String address1, String address2, String city, 
			String state, String zipCode, String securityQuestion, String answer, boolean termOfUse, ServiceContext serviceContext) throws PortalException {
	
		return memberLocalService.addMember(groupId, firstName, lastName, emailAddress, username, 
				male, monthOfBirth, dayOfBirth, yearOfBirth, password, confirmPassword, homePhone, 
				mobilePhone, address1, address2, city, state, zipCode, securityQuestion, answer, 
				termOfUse, serviceContext);
	}

	@Override
	public List<Member> getMembersByKeywords(long scopeGroupId, String keywords, int start, int end,
			OrderByComparator<Member> comparator) {
		return memberLocalService.getMembersByKeywords(scopeGroupId, keywords, start, end, comparator);
	}

	@Override
	public Object getmembersCountByKeywords(long scopeGroupId, String keywords) {
		return memberLocalService.getmembersCountByKeywords(scopeGroupId, keywords);
	}

	@Override
	public List<Member> getAllMembers() {
		return memberLocalService.getAllMembers();
	}
}