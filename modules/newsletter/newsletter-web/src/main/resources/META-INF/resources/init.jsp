<%@ page import="com.liferay.training.newsletter.web.context.NewsletterManagementToolbarDisplayContext" %>
<%@ page import="com.liferay.training.newsletter.web.context.NewsletterMonthDisplayContext" %>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>
<%@ page import="com.liferay.training.newsletter.web.constants.NewsletterPortletKeys" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="liferay-frontend" uri="http://liferay.com/tld/frontend" %>
<%@ page import="com.liferay.portal.kernel.search.SearchContext" %>
<%@ page import="com.liferay.portal.kernel.search.SearchContextFactory" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.training.newsletter.service.NewsletterIssueLocalService" %>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
    NewsletterManagementToolbarDisplayContext newsletterManagementToolbarDisplayContext = new NewsletterManagementToolbarDisplayContext(renderRequest,
            renderResponse, (NewsletterIssueLocalService) renderRequest.getAttribute("newsletterIssueLocalService"));
    NewsletterMonthDisplayContext newsletterMonthDisplayContext = new NewsletterMonthDisplayContext(renderRequest, renderResponse);
    request.setAttribute("year", newsletterManagementToolbarDisplayContext.getYears().get(0));
%>