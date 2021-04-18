package com.liferay.training.amf.registration.web.portlet;

import com.liferay.training.amf.registration.web.constants.RegistrationPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author ces-user
 */
@Component(
	immediate = true,
	property = {
			"com.liferay.portlet.display-category=category.sample",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/view.jsp",
			"javax.portlet.name=" + RegistrationPortletKeys.REGISTRATION,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user",
			"javax.portlet.display-name=Sign Up",
			"javax.portlet.init-param.add-process-action-success-action=false"
	},
	service = Portlet.class
)
public class RegistrationPortlet extends MVCPortlet {
}