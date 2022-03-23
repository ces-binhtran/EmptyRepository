package com.liferay.training.amf.search.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.amf.search.constants.AmfSearchPortletKeys;
import com.liferay.training.amf.search.constants.MVCCommandNames;
import com.liferay.training.amf.service.AmfSearchService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + AmfSearchPortletKeys.AMFSEARCH,
		"mvc.command.name=" + MVCCommandNames.SEARCH_USER }, service = MVCActionCommand.class)
public class SearchUserMVCActionCommand extends BaseMVCActionCommand {

	@SuppressWarnings("deprecation")
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String zipCode = ParamUtil.getString(actionRequest,"zipCode");
		actionResponse.setRenderParameter("zipCode", zipCode);
	}

	@Reference
	AmfSearchService _amfSearchService;
}