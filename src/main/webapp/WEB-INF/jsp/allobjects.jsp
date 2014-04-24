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
        <h2>bu</h2>
        <c:forEach var="EuropeanaObjectEntity" items="${list}">
           <a href="/ambrosia/detail/?id=<c:out value="${EuropeanaObjectEntity.getObjectId()}"/>"> <h2><c:out value="${EuropeanaObjectEntity.getTitle()}"/></h2></a>
            <img src="<c:out value="${EuropeanaObjectEntity.getEdmPreview()}"/>">


            <br>
        </c:forEach>
        Searched term was <%= request.getParameter("term")%>
    </body>
</html>