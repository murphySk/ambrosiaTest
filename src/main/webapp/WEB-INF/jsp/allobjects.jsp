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
           <a href="/ambrosia/detail/?id=<c:out value="${EuropeanaObjectEntity.getObjectId()}"/>"><p style="font-family:arial;color:black;font-size:20px;"><c:out value="${EuropeanaObjectEntity.getTitle()}"/></p><img src="<c:out value="${EuropeanaObjectEntity.getEdmPreview()}"/>"  width="150"> </a>
            <br>
        </c:forEach>
        Searched term was <%= request.getParameter("term")%>
    </body>
</html>