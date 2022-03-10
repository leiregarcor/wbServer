<%--
  Created by IntelliJ IDEA.
  User: leire
  Date: 10/03/2022
  Time: 7:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Welcome</title>
</head>
<body>

<% String username = (String) session.getAttribute("username");
    if (username == null){%>
        <a href="/wbServer/jsp/login_form.jsp">Log in</a>
<%} else { %>
    <h3> ONGI ETORRI,<%= username%>  <h3/>
<%  }%>

</body>
</html>
