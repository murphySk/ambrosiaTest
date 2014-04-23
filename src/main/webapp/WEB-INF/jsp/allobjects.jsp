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
            <fmt:message key="index.property_message"/>
        </div>
        <c:forEach var="EuropeanaObjectEntity" items="${list}">
            <h2><c:out value="${EuropeanaObjectEntity.getTitle()}"/></h2>
            <c:out value="${EuropeanaObjectEntity.getDescription()}"/>
            <br>
        </c:forEach>
        Searched term was <%= request.getParameter("term")%>
    </body>
</html>