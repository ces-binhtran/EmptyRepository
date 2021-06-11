package com.liferay.training.newsletter.web.portlet;

import com.liferay.training.newsletter.web.constants.NewsletterPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.training.newsletter.web.utils.NewsletterManagerUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;

/**
 * @author ces-user
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.css-class-wrapper=newsletter-portlet",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Newsletter",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + NewsletterPortletKeys.NEWSLETTER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class NewsletterPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		renderRequest.setAttribute("newsletterManagerUtil", _newsletterManagerUtil);
		super.render(renderRequest, renderResponse);
	}

	@Reference
	private NewsletterManagerUtil _newsletterManagerUtil;
}