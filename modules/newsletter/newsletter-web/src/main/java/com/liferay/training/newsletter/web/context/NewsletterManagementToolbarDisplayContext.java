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

package com.liferay.training.newsletter.web.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItemList;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Son Truong
 */
public class NewsletterManagementToolbarDisplayContext {

    public NewsletterManagementToolbarDisplayContext(RenderRequest renderRequest, RenderResponse renderResponse) {
        _renderRequest = renderRequest;

        _renderResponse = renderResponse;
        _httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
    }

    public List<NavigationItem> getNavigationItems() {
        Date date = new Date();
        return new NavigationItemList() {
            {
                for(int navigationElement = 0; navigationElement < 4; navigationElement++) {
                    int distance = navigationElement;
                    add(
                            navigationItem -> {
                                navigationItem.setActive(Objects.equals(getTabs1(), Integer.toString(date.getYear() + 1900 - distance)));
                                navigationItem.setHref(getPortletURL(), "tabs1", Integer.toString(date.getYear() + 1900 - distance));
                                navigationItem.setLabel(LanguageUtil.get(_httpServletRequest, Integer.toString(date.getYear() + 1900 - distance)));
                            }
                    );
                }
            }
        };
    }

    public PortletURL getPortletURL() {

        PortletURL portletURL = _renderResponse.createRenderURL();
        portletURL.setParameter("tabs1", getTabs1());
        portletURL.setParameter("tabs2", ParamUtil.getString(_renderRequest, "tabs2", "All"));
        return portletURL;
    }

    public String getTabs1() {
        Date date = new Date();
        if (_tabs1 != null) {
            return _tabs1;
        }

        _tabs1 = ParamUtil.getString(_renderRequest, "tabs1", Integer.toString(date.getYear() + 1900));

        if (!_tabs1.equals(Integer.toString(date.getYear() + 1900)) && !_tabs1.equals(Integer.toString(date.getYear() + 1900 - 1))
                && !_tabs1.equals(Integer.toString(date.getYear() + 1900 - 2)) && !_tabs1.equals(Integer.toString(date.getYear() + 1900 - 3))) {
            _tabs1 = Integer.toString(date.getYear() + 1900);
        }

        return _tabs1;
    }

    private final RenderRequest _renderRequest;
    private final RenderResponse _renderResponse;
    private final HttpServletRequest _httpServletRequest;
    private String _tabs1;
}
