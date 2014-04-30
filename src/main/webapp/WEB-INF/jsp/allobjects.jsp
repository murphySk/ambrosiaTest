<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="sk.eea.test.ambrosia.services.impl.HttpConnection" %>
<%@ page import="sk.eea.test.ambrosia.server.entity.EuropeanaObjectEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="sk.eea.test.ambrosia.services.impl.EuropeanaObjectParserImpl" %>


<html>
<head>
 	<link href="<c:url value="/css/style.css" />" rel="stylesheet">
</head>
    <body>
        <div id="content">
            <fmt:message key="index.property_message"/>
            <c:forEach var="EuropeanaObjectEntity" items="${list}">
                 <div class="row">
                    <div class="left">
                        <a href="/ambrosia/detail/?id=<c:out value="${EuropeanaObjectEntity.getObjectId()}"/>">
                         <p>
                        <c:out value="${EuropeanaObjectEntity.getTitle()}"/></p>
                        <img src="<c:out value="${EuropeanaObjectEntity.getEdmPreview()}"/>"  width="150"> </a>
                     </div>

                    <div class="middle">
                         <p>
                         <br><br><br>
                         <c:out value="${EuropeanaObjectEntity.getProvider()}"/> <br> <c:out value="${EuropeanaObjectEntity.getLanguage()}"/> </p>
                    </div>

                    <div class="clear">
                    </div>
                </div>
            </c:forEach>
    </body>
</html>