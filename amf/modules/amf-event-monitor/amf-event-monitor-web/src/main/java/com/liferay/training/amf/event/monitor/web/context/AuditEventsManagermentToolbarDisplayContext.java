package com.liferay.training.amf.event.monitor.web.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItemList;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * @author Brian Wing Shun Chan
 */
public class AuditEventsManagermentToolbarDisplayContext {

    public AuditEventsManagermentToolbarDisplayContext(RenderRequest renderRequest, RenderResponse renderResponse) {
        _renderRequest = renderRequest;

        _renderResponse = renderResponse;
        _httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
    }

    public List<NavigationItem> getNavigationItems() {
        return new NavigationItemList() {
            {
                add(
                    navigationItem -> {
                        navigationItem.setActive(Objects.equals(getTabs1(), "all"));
                        navigationItem.setHref(
                                getPortletURL(), "tabs1", "all");
                        navigationItem.setLabel(
                             LanguageUtil.get(_httpServletRequest, "all")
                        );
                });

                add(
                    navigationItem -> {
                        navigationItem.setActive(Objects.equals(getTabs1(), "registration"));
                        navigationItem.setHref(
                                getPortletURL(), "tabs1", "registration");
                        navigationItem.setLabel(
                                LanguageUtil.get(_httpServletRequest, "registration")
                        );
                });

                add(
                    navigationItem -> {
                        navigationItem.setActive(Objects.equals(getTabs1(), "login"));
                        navigationItem.setHref(
                                getPortletURL(), "tabs1", "login");
                        navigationItem.setLabel(
                                LanguageUtil.get(_httpServletRequest, "login")
                        );
                });
            }
        };
    }

    public PortletURL getPortletURL() {

        PortletURL portletURL = _renderResponse.createRenderURL();
        portletURL.setParameter("tabs1", getTabs1());
        return portletURL;
    }

    public String getTabs1() {
        if (_tabs1 != null) {
            return _tabs1;
        }

        _tabs1 = ParamUtil.getString(_renderRequest, "tabs1", "all");

        if (!_tabs1.equals("all") && !_tabs1.equals("registration") && !_tabs1.equals("login")) {
            _tabs1 = "all";
        }

        return _tabs1;
    }

    private final RenderRequest _renderRequest;
    private final RenderResponse _renderResponse;
    private final HttpServletRequest _httpServletRequest;
    private String _tabs1;
}