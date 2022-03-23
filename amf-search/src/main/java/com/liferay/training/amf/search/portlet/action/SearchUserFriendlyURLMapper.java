//package com.liferay.training.amf.search.portlet.action;
//
//import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
//import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
//import com.liferay.training.amf.search.constants.AmfSearchPortletKeys;
//
//import org.osgi.service.component.annotations.Component;
//
//@Component(property = { "com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
//		"javax.portlet.name=" + AmfSearchPortletKeys.AMFSEARCH }, service = FriendlyURLMapper.class)
//public class SearchUserFriendlyURLMapper extends DefaultFriendlyURLMapper {
//
//	@Override
//	public String getMapping() {
//		return _MAPPING;
//	}
//
//	private static final String _MAPPING = "tec-search-user";
//}
