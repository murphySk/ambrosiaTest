<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
    <head>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="<c:url value="/js/pokus.js"/>"></script>
    </head>

    <body>
        <div id="content">
            <fmt:message key="index.property_message"/>
             <h2>Skusanie hladania v europeane</h2>
             <form method="post" action="/ambrosia/allobjects">
                <input type="text" name="term" size="20"><input type="submit" value="search">
             </form>
             <div id="div1"><h2>Let jQuery AJAX Change This Text</h2></div>
             <button>Get External Content</button>
        </div>
    </body>
</html>