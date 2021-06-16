<%@ page import="com.liferay.training.newsletter.model.NewsletterIssue" %>
<%@ page import="com.liferay.training.newsletter.util.ConvertUtil" %>
<%@ page import="com.liferay.training.newsletter.model.NewsletterArticle" %>
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
    <c:choose>
        <c:when test="<%= ((List<NewsletterArticle>) request.getAttribute("articles")).size() != 0 %>">
            <div class="article-issue">
                <c:forEach var="article" items="${articles}">
                    <h3>${article.title}</h3>
                    <p>${article.content}</p>
                </c:forEach>
            </div>
        </c:when>
        <c:otherwise>
            <clay:alert message="This issue don't have any article" title="Alert" />
        </c:otherwise>
    </c:choose>

</div>