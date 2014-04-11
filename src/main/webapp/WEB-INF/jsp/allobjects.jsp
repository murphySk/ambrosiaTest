<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <%
            EuropeanaObjectParserImpl dummyPars = new EuropeanaObjectParserImpl();
            HttpConnection con = new HttpConnection();
            String term = request.getParameter("term");

            try{
                List<EuropeanaObjectEntity> list = dummyPars.parseObjects(con.sendGet(term));
                for(int i = 0; i < list.size(); i++) {
                    %>
                    <h3> <%=list.get(i).getTitle()%> </h3>
                    <%=list.get(i).getDescription()%>
                    <br>
                <% }
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
        Searched term was <%= request.getParameter("term")%>
    </body>
</html>
martinM