package com.liferay.training.amf.search.result.util;

import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.AddressLocalService;
import com.liferay.portal.kernel.service.ContactLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(
        immediate = true,
        service = SearchManagerUtil.class
)
public class SearchManagerUtil {

    public List<User> getUsersByZipCodeUseDynamicQuery(String zipCode, int start, int end) {

        return userLocalService.dynamicQuery(createDynamicQuery(zipCode), start, end);
    }

    public DynamicQuery createDynamicQuery(String zipCode) {

        Order order = OrderFactoryUtil.asc("firstName");

        DynamicQuery addressQuery = addressLocalService.dynamicQuery();
        addressQuery
                .add(RestrictionsFactoryUtil.eq("zip", zipCode))
                .setProjection(ProjectionFactoryUtil.property("classPK"));

        DynamicQuery contactQuery = contactLocalService.dynamicQuery();
        contactQuery
                .add(PropertyFactoryUtil.forName("contactId").in(addressQuery))
                .setProjection(ProjectionFactoryUtil.property("classPK"));

        DynamicQuery userQuery = userLocalService.dynamicQuery();
        userQuery
                .add(PropertyFactoryUtil.forName("userId").in(contactQuery));

        return userQuery;
    }

    public long dynamicQueryCount(String zipCode) {
        return userLocalService.dynamicQueryCount(createDynamicQuery(zipCode));
    }

    @Reference
    private AddressLocalService addressLocalService;

    @Reference
    private ContactLocalService contactLocalService;

    @Reference
    private UserLocalService userLocalService;

}
