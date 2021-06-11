<%@ page import="com.liferay.training.newsletter.model.NewsletterIssue" %>
<%@ page import="com.liferay.training.newsletter.util.ConvertUtil" %>
<%@ include file="/init.jsp" %>

<%
    NewsletterIssue newsletterIssue = (NewsletterIssue)renderRequest.getAttribute("newsletterIssue");
    String date = (newsletterIssue.getIssueDate().getMonth() + 1) + "/" + newsletterIssue.getIssueDate().getDate() + "/" + newsletterIssue.getIssueDate().getYear();
%>
<div class="container-fluid-1280">
   <div class="article-description">
       <h4>Issue: ${newsletterIssue.issueNumber}, <%= date %></h4>
       <h2>${newsletterIssue.title}</h2>
       <p>${newsletterManagerUtil.getAuthors(articles)}</p>
       <p>${newsletterIssue.description}</p>
   </div>
    <div class="article-issue">
        <c:forEach var="article" items="${articles}">
            <h3>${article.title}</h3>
            <p>${article.content}</p>
        </c:forEach>
    </div>
</div>