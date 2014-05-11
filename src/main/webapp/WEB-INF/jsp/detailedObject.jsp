<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="sk.eea.test.ambrosia.services.impl.HttpConnection" %>
<%@ page import="sk.eea.test.ambrosia.server.entity.EuropeanaObjectEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="sk.eea.test.ambrosia.services.impl.EuropeanaObjectParserImpl" %>
<%@ page import="java.util.Arrays" %>
<html>
    <head>
     	<link href="<c:url value="/css/style.css"/>" rel="stylesheet">
     	<link href="<c:url value="/css/style2.css"/>" rel="stylesheet">
     	<link href="<c:url value="/css/jquery-ui-1.10.4.css"/>" rel="stylesheet">
       	<script src="<c:url value="/js/jquery-2.1.1.js"/>"></script>
     	<script src="<c:url value="/js/detailedObject.js"/>"></script>
        <script src="<c:url value="/js/jquery-ui-1.10.4.js"/>"></script>
        <script src="<c:url value="/js/jquery-ui-1.10.4.min.js"/>"></script>
        <script src="<c:url value="/js/scriptJ.js"/>"></script>
        <script src="<c:url value="/js/pokus.js"/>"></script>
    </head>
    <body>

       <div id="tags" >
       <div id="textarea" contenteditable>
           <span class="tag" id="bu">marosko</span>
           <span class="tag" id="bu">martinko</span>
           <span class="tag" id="bu">silvika</span>
                <input type="text" id="autocomplete" value="" placeholder="Add a tag"/>
           </div>
         </div>


        <div id="content">
            <!-- <fmt:message key="index.property_message"/><br> -->
            <c:if test="${empty obj.title}">
                 <h1 id="title" align="left">No title in this record</h1>
            </c:if>
            <c:if test="${!empty obj.title}">
                 <h1 id="title" align="left"><c:out value="${obj.title}"/></h1>
            </c:if>
            <div class="clear"></div>
            <img id="previewImg" src="<c:out value="${obj.edmPreview}"/>">
            <div id="desc">
                <c:if test="${empty obj.dcDescription}">
                                No description in this record.
                </c:if>
                <c:if test="${!empty obj.dcDescription}">
                    <c:forEach items="${obj.dcDescription}" var="desc">
                        <c:out value="${desc}"/>
                    </c:forEach>
                </c:if>
            </div>
            <div class="clear"></div>
            <h2 class = "info" id = "lessTitle">Less information</h2>
            <div class = "info" id = "detailedInfo">
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
                <c:if test="${empty obj.edmLandingPage}">
                </c:if>
                <c:if test="${!empty obj.edmLandingPage}">
                    <a href="<c:out value="${obj.edmLandingPage}"/>">Europeana link</a><br>
                </c:if>
            </div>

            Searched term was <%= request.getParameter("id")%>
            <div id = "skuska">ToTo je skuska</div>
        </div>
    </body>
</html>