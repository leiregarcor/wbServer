<%--
  Created by IntelliJ IDEA.
  User: leire
  Date: 04/03/2022
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login form</title>
</head>
<body>

<% Object login_error_aux = request.getAttribute("login_error");
    if (login_error_aux != null){
        if ((boolean) login_error_aux){  %>
    <h3> LOGIN ERROR!!! <h3/>
        <%}
    }
        %>


<form method="POST" action="/wbServer/servlet/Login">
    Erabiltzailea: <input type="text" name="username"/> <br/>
    Pasahitza: <input type="text" name="password"/> <br/>
    <input type="submit"/>
</form>

</body>
</html>