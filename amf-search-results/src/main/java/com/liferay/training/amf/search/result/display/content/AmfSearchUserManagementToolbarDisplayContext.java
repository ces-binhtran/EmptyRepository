package com.liferay.training.amf.search.result.display.content;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.BaseManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItemList;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.amf.search.result.constants.AmfSearchResultsPortletKeys;
import com.liferay.training.amf.search.result.constants.MVCCommandNames;

import java.util.List;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

public class AmfSearchUserManagementToolbarDisplayContext extends BaseManagementToolbarDisplayContext {

	@SuppressWarnings("deprecation")
	public AmfSearchUserManagementToolbarDisplayContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse, HttpServletRequest httpServletRequest) {
		super(liferayPortletRequest, liferayPortletResponse, httpServletRequest);
		_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);
		_themeDisplay = (ThemeDisplay) liferayPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
	}

	/***
	 * Returns the sort order column.
	 *
	 * @return sort column
	 */
	@SuppressWarnings("deprecation")
	public String getOrderByCol() {
		return ParamUtil.getString(request, "orderByCol", "title");
	}

	/**
	 * Returns the sort type (ascending / descending).
	 *
	 * @return sort type
	 */
	@SuppressWarnings("deprecation")
	public String getOrderByType() {
		return ParamUtil.getString(request, "orderByType", "asc");
	}

	/**
	 * Returns the view type options (card, list, table).
	 *
	 * @return list of view types
	 */
	@SuppressWarnings({ "deprecation", "serial" })
	@Override
	public List<ViewTypeItem> getViewTypeItems() {
		PortletURL portletURL = liferayPortletResponse.createRenderURL();
		portletURL.setParameter("mvcRenderCommandName", MVCCommandNames.SEARCH_USER_RESULT);
		int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);
		if (delta > 0) {
			portletURL.setParameter("delta", String.valueOf(delta));
		}
		String orderByCol = ParamUtil.getString(request, "orderByCol", "title");
		String orderByType = ParamUtil.getString(request, "orderByType", "asc");
		portletURL.setParameter("orderByCol", orderByCol);
		portletURL.setParameter("orderByType", orderByType);
		int cur = ParamUtil.getInteger(request, SearchContainer.DEFAULT_CUR_PARAM);
		if (cur > 0) {
			portletURL.setParameter(SearchContainer.DEFAULT_CUR_PARAM, String.valueOf(cur));
		}
		return new ViewTypeItemList(portletURL, getDisplayStyle()) {
			{
				addTableViewTypeItem();
			}
		};
	}

	/**
	 * Returns the assignment list display style.
	 *
	 * Current selection is stored in portal preferences.
	 *
	 * @return current display style
	 */
	@SuppressWarnings("deprecation")
	public String getDisplayStyle() {
		String displayStyle = ParamUtil.getString(request, "displayStyle");
		if (Validator.isNull(displayStyle)) {
			displayStyle = _portalPreferences.getValue(AmfSearchResultsPortletKeys.AMFSEARCHRESULTS, 
					"amfauditevent-display-style", "descriptive");
		} else {
			_portalPreferences.setValue(AmfSearchResultsPortletKeys.AMFSEARCHRESULTS, 
					"amfauditevent-display-style", displayStyle);
			request.setAttribute(WebKeys.SINGLE_PAGE_APPLICATION_CLEAR_CACHE, Boolean.TRUE);
		}
		return displayStyle;
	}

	private final PortalPreferences _portalPreferences;
	@SuppressWarnings("unused")
	private final ThemeDisplay _themeDisplay;
}
