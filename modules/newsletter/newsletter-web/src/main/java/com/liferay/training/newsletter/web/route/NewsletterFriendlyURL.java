/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.training.newsletter.web.route;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import com.liferay.training.newsletter.web.constants.NewsletterPortletKeys;
import org.osgi.service.component.annotations.Component;

/**
 * @author Son Truong
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.friendly-url-routes=META-INF/resources/friendly-url-routes/routes.xml",
                "javax.portlet.name=" + NewsletterPortletKeys.NEWSLETTER
        },
        service = FriendlyURLMapper.class
)
public class NewsletterFriendlyURL extends DefaultFriendlyURLMapper {
    @Override
    public String getMapping() {
        return _MAPPING;
    }

    private static final String _MAPPING = "newsletter";
}
