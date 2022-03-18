package com.liferay.training.amf.internal.sercurity.permission;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.StagedPortletPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.definition.PortletResourcePermissionDefinition;
import com.liferay.training.amf.constants.AmfAuditEventConstants;

import org.osgi.service.component.annotations.Reference;

public class AuditEventPortletResourcePermissionDefinition implements PortletResourcePermissionDefinition {

	@Override
	public PortletResourcePermissionLogic[] getPortletResourcePermissionLogics() {

		return new PortletResourcePermissionLogic[] { new StagedPortletPermissionLogic(_stagingPermission,
				"com_liferay_training_amf_portlet_event_monitor_AmfPortlet") };
	}

	@Override
	public String getResourceName() {

		return AmfAuditEventConstants.RESOURCE_NAME;
	}

	@Reference
	private StagingPermission _stagingPermission;
}