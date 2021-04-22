package com.liferay.training.amf.registration.web.route;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import com.liferay.training.amf.registration.web.constants.RegistrationPortletKeys;
import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.friendly-url-routes=META-INF/resources/friendly-url-routes/routes.xml",
                "javax.portlet.name=" + RegistrationPortletKeys.REGISTRATION
        },
        service = FriendlyURLMapper.class
)
public class RegistrationFriendlyURLMapper extends DefaultFriendlyURLMapper {

        @Override
        public String getMapping() {
                return super.getMapping();
        }

        private static final String _MAPPING = "signUp";
}
