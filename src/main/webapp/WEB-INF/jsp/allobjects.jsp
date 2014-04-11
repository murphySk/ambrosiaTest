<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
        <div id="content">
            <fmt:message key="index.property_message"/>
        </div>
        <%
            String term = request.getParameter("term");
            session.setAttribute("theTerm", term);
        %>
        Searched term was <%= request.getParameter("term")%>
    </body>
</html>