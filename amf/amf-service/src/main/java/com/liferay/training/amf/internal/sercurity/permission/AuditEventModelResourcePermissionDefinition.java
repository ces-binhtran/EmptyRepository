package com.liferay.training.amf.internal.sercurity.permission;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.StagedModelPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.definition.ModelResourcePermissionDefinition;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermission;
import com.liferay.training.amf.constants.AmfAuditEventConstants;
import com.liferay.training.amf.model.AmfAuditEvent;
import com.liferay.training.amf.service.AmfAuditEventLocalService;

import java.util.function.Consumer;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = ModelResourcePermissionDefinition.class)
public class AuditEventModelResourcePermissionDefinition implements ModelResourcePermissionDefinition<AmfAuditEvent> {

	@Override
	public AmfAuditEvent getModel(long amfAuditEventId) throws PortalException {
		return _amfAuditEventLocalService.getAmfAuditEvent(amfAuditEventId);
	}

	@Override
	public Class<AmfAuditEvent> getModelClass() {
		return AmfAuditEvent.class;
	}

	@Override
	public PortletResourcePermission getPortletResourcePermission() {
		return _portletResourcePermission;
	}

	@Override
	public long getPrimaryKey(AmfAuditEvent amfAuditEvent) {
		return amfAuditEvent.getAmfAuditEventId();
	}

	@Override
	public void registerModelResourcePermissionLogics(ModelResourcePermission<AmfAuditEvent> modelResourcePermission,
			Consumer<ModelResourcePermissionLogic<AmfAuditEvent>> modelResourcePermissionLogicConsumer) {
		modelResourcePermissionLogicConsumer.accept(new StagedModelPermissionLogic<>(_stagingPermission,
				"com_liferay_training_amf_portlet_event_monitor_AmfPortlet", AmfAuditEvent::getAmfAuditEventId));
		
	}

	@Reference
	private AmfAuditEventLocalService _amfAuditEventLocalService;
	@Reference
	private GroupLocalService _groupLocalService;
	@Reference(target = "(resource.name=" + AmfAuditEventConstants.RESOURCE_NAME + ")")
	private PortletResourcePermission _portletResourcePermission;
	@Reference
	private StagingPermission _stagingPermission;
	@Reference
	private WorkflowPermission _workflowPermission;
}
