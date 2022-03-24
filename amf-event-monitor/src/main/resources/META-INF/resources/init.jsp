<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>

<%@ page import="java.util.Date"%>
<%@ page import="javax.portlet.WindowState"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ page import="com.liferay.training.amf.event.monitor.constants.MVCCommandNames"%>
<%@ page import="com.liferay.asset.kernel.model.AssetRenderer"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ page import="com.liferay.training.amf.constants.AmfAuditEventConstants"%>
<%@ page import="com.liferay.training.amf.model.AmfAuditEvent"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />