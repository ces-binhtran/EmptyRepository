package com.liferay.training.amf.search.result.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import com.liferay.training.amf.search.result.constants.SearchResultsPortletKeys;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;

/**
 * @author ces-user
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=SearchResult",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + SearchResultsPortletKeys.SEARCHRESULTS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
			"javax.portlet.supported-public-render-parameter=searchValue",
			"com.liferay.portlet.private-session-attributes=false",
			"com.liferay.portlet.requires-namespaced-parameters=false"
	},
	service = Portlet.class
)
public class SearchResultPortlet extends MVCPortlet {
}