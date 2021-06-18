package com.liferay.training.amf.registration.web.portlet;

import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.service.CountryServiceUtil;
import com.liferay.portal.kernel.service.RegionServiceUtil;
import com.liferay.training.amf.registration.web.constants.RegistrationPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.List;

/**
 * @author ces-user
 */
@Component(
	immediate = true,
	property = {
			"com.liferay.portlet.display-category=category.sample",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.friendly-url-mapping=signUp",
			"javax.portlet.display-name=Sign Up",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/view.jsp",
			"javax.portlet.name=" + RegistrationPortletKeys.REGISTRATION,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user",
			"javax.portlet.init-param.add-process-action-success-action=false"
	},
	service = Portlet.class
)
public class RegistrationPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		Country country = countryServiceUtil.fetchCountryByA2("US");
		List<Region> regions = regionServiceUtil.getRegions(country.getCountryId());
		renderRequest.setAttribute("regions", regions);
		super.render(renderRequest, renderResponse);
	}

	private RegionServiceUtil regionServiceUtil;
	private CountryServiceUtil countryServiceUtil;
}