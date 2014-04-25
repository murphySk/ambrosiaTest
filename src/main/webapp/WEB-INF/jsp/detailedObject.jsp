<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="sk.eea.test.ambrosia.services.impl.HttpConnection" %>
<%@ page import="sk.eea.test.ambrosia.server.entity.EuropeanaObjectEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="sk.eea.test.ambrosia.services.impl.EuropeanaObjectParserImpl" %>
<html>
    <body>
        <div id="content">
            <fmt:message key="index.property_message"/><br>
            <c:if test="${empty obj.dcCreator}">
                Creator: unknown<br>
            </c:if>
            <c:if test="${!empty obj.dcCreator}">
                Creator: <c:out value="${obj.dcCreator}"/><br>
            </c:if>
            <c:if test="${empty obj.edmDataProvider}">
                Data Provider: unknown<br>
            </c:if>
            <c:if test="${!empty obj.edmDataProvider}">
                Data Provider: <c:out value="${obj.edmDataProvider}"/><br>
            </c:if>
            <c:if test="${empty obj.edmProvider}">
                Object Provider: unknown<br>
            </c:if>
            <c:if test="${!empty obj.edmProvider}">
                Object Provider: <c:out value="${obj.edmProvider}"/><br>
            </c:if>
            <c:if test="${empty obj.dcLanguage}">
                Language: unknown<br>
            </c:if>
            <c:if test="${!empty obj.dcLanguage}">
                Language: <c:out value="${obj.dcLanguage}"/><br>
            </c:if>
            <c:if test="${empty obj.edmCountry}">
                Country of origin: unknown<br>
            </c:if>
            <c:if test="${!empty obj.edmCountry}">
                Country of origin: <c:out value="${obj.edmCountry}"/><br>
            </c:if>
            <c:if test="${empty obj.edmPreview}">
                edmPreview: unknown<br>
            </c:if>
            <c:if test="${!empty obj.edmPreview}">
                edmPreview: <c:out value="${obj.edmPreview}"/><br>
            </c:if>
            <c:if test="${empty obj.title}">
                title: unknown<br>
            </c:if>
            <c:if test="${!empty obj.title}">
                title: <c:out value="${obj.title}"/><br>
            </c:if>

            Searched term was <%= request.getParameter("id")%>
        </div>
    </body>
</html>