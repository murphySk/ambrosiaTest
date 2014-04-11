<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
        <div id="content">
            <fmt:message key="index.property_message"/>
             <h2>Skusanie hladania v europeane</h2>
             <form method="post" action="">
                <input type="text" name="term" size="20"><input type="submit" value="search">
             </form>
        </div>
    </body>
</html>