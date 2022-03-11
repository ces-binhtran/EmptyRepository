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
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.training.amf.model.Member;
import com.liferay.training.amf.service.base.MemberLocalServiceBaseImpl;
import com.liferay.training.amf.validator.MemberValidator;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the member local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.training.amf.service.MemberLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MemberLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.liferay.training.amf.model.Member", service = AopService.class)
public class MemberLocalServiceImpl extends MemberLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.training.amf.service.MemberLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.training.amf.service.MemberLocalServiceUtil</code>.
	 */
	public Member addMember(long groupId, String firstName, String lastName, String emailAddress, String username,
			boolean male, int monthOfBirth, int dayOfBirth, int yearOfBirth, String password, String confirmPassword,
			String homePhone, String mobilePhone, String address1, String address2, String city, String state,
			String zipCode, String securityQuestion, String answer, boolean termsOfUse, ServiceContext serviceContext)
			throws PortalException {

		_memberValidator.validate(firstName, lastName, emailAddress, username, monthOfBirth, dayOfBirth, yearOfBirth,
				password, confirmPassword, homePhone, mobilePhone, address1, address2, city, state, zipCode,
				securityQuestion, answer, termsOfUse);
		
		long memberId = counterLocalService.increment(Member.class.getName());
		Member member = createMember(memberId);
		member.setFirstName(firstName);
		member.setLastName(lastName);
		member.setEmailAddress(emailAddress);
		member.setMale(male);
		member.setMonthOfBirth(monthOfBirth);
		member.setDayOfBirth(dayOfBirth);
		member.setYearOfBirth(yearOfBirth);
		member.setPassword(password);
		member.setHomePhone(homePhone);
		member.setMobilePhone(mobilePhone);
		member.setAddress1(address1);
		member.setAddress2(address2);
		member.setCity(city);
		member.setState(state);
		member.setZipCode(zipCode);
		member.setSecurityQuestion(securityQuestion);
		member.setAnswer(answer);
		member.setTermOfUse(termsOfUse);

		// persit member to database
		member = super.addMember(member);
		return member;
	}

	@Override
	public List<Member> getMembersByKeywords(long scopeGroupId, String keywords, int start, int end,
			OrderByComparator<Member> comparator) {
		return memberLocalService.dynamicQuery(getKeywordSearchDynamicQuery(scopeGroupId, keywords), start, end, comparator);
	}

	@Override
	public Object getmembersCountByKeywords(long scopeGroupId, String keywords) {
		return memberLocalService.dynamicQueryCount(getKeywordSearchDynamicQuery(scopeGroupId, keywords));
	}
	
	private DynamicQuery getKeywordSearchDynamicQuery(long groupId, String keywords) {
		DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));
		if (Validator.isNotNull(keywords)) {
			Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();
			disjunctionQuery.add(RestrictionsFactoryUtil.like("username", "%" + keywords + "%"));
			dynamicQuery.add(disjunctionQuery);
		}
		return dynamicQuery;
	}

	@Override
	public List<Member> getAllMembers() {
		return memberPersistence.findAll();
	}

	@Reference
	MemberValidator _memberValidator;

}
