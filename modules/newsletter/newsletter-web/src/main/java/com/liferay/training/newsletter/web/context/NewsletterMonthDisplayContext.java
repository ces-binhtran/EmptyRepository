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

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.training.newsletter.web.constants.Constants;
import com.liferay.training.newsletter.web.constants.NewsletterPortletKeys;

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
public class NewsletterMonthDisplayContext {

    public NewsletterMonthDisplayContext(RenderRequest _renderRequest, RenderResponse _renderResponse) {
        this._renderRequest = _renderRequest;
        this._renderResponse = _renderResponse;
        _httpServletRequest = PortalUtil.getHttpServletRequest(_renderRequest);
    }

    public List<DropdownItem> getDropdownItems() throws Exception {
        return new DropdownItemList() {
            {
                for(String month : Constants.months) {
                    add(dropdownItem -> {
                        dropdownItem.setActive(Objects.equals(getTabs2(), month));
                        dropdownItem.setHref(getPortletURL(), "tabs2", month);
                        dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, month));
                    });
                }
            }
        };
    }

    public PortletURL getPortletURL() {

        PortletURL portletURL = _renderResponse.createRenderURL();
        portletURL.setParameter("tabs2", getTabs2());
        portletURL.setParameter("tabs1", ParamUtil.getString(_renderRequest, "tabs1", "2021"));
        return portletURL;
    }

    public String getTabs2() {
        Date date = new Date();
        if (_tabs2 != null) {
            return _tabs2;
        }

        _tabs2 = ParamUtil.getString(_renderRequest, "tabs2", "All");

        return _tabs2;
    }

    private final RenderRequest _renderRequest;
    private final RenderResponse _renderResponse;
    private final HttpServletRequest _httpServletRequest;
    private String _tabs2;
}
