package com.liferay.training.amf.registration.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import com.liferay.training.amf.registration.constants.AmfPortletKeys;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author ces-user
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.training",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Amf",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/registration.jsp",
		"javax.portlet.name=" + AmfPortletKeys.AMF,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AmfPortlet extends MVCPortlet {
}