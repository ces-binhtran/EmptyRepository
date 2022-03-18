package com.liferay.training.amf.service.audit;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.training.amf.constants.AmfAuditEventTypeConstants;
import com.liferay.training.amf.model.AmfAuditEvent;
import com.liferay.training.amf.service.AmfAuditEventService;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "key=" + PropsKeys.LOGIN_EVENTS_POST }, service = LifecycleAction.class)
public class PostLoginAction implements LifecycleAction {

	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {

		System.out.println("========login event =========");
		HttpServletRequest request = lifecycleEvent.getRequest();
		try {
			User user = PortalUtil.getUser(request);
			long groupId = PortalUtil.getScopeGroupId(request);
			long companyId = PortalUtil.getCompanyId(request);
			System.out.println("groupId=" + groupId + ", companyId=" + companyId);
			long userId = user.getUserId();
			String userName = user.getScreenName();
			String ipAddress = request.getRemoteAddr();
			Date now = new Date();
			AmfAuditEvent amfAuditEvent = _amfAuditEventService.addAmfAuditEvent(userId, userName, groupId, companyId, ipAddress,
					AmfAuditEventTypeConstants.LOGIN, now);
			System.out.println("AmfAuditEvent: userName=" + amfAuditEvent.getUserName() + ", eventId=" + amfAuditEvent.getAmfAuditEventId());

		} catch (PortalException e) {
			e.printStackTrace();
		}
	}

	@Reference
	private AmfAuditEventService _amfAuditEventService;

}
