<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Servlet</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
    <h1>Join our email list - JSP</h1>
    <p>To join our email list, enter your name and email address below.</p>
    <p><i>${message}</i></p>
    <form>
        <form>

        </form>
    </form>
    <form action="emailList" method="post">
        <input type="hidden" name="action" value="add">
        <label class="pad_top">Email:</label>
        <input type="email" name="email" value="${user.email}"><br>

        <label class="pad_top">First Name:</label>
        <input type="text" name="firstName" value="${user.firstName}"><br>

        <label class="pad_top">Last Name:</label>
        <input type="text" name="lastName" value="${user.lastName}"><br>

        <input type="submit" value="Join Now" class="margin_left">
    </form>
    <br>

    <form action="addToEmailListServlet" method="post">
        <input type="submit" value="List" class="margin_left">
    </form>

    <p><a href="test.html">Test - HTML </a></p>
    <p><a href="test.jsp">Test - JSP</a></p>

    <h1>Redirect to outer application</h1>
    <p><a href="redirect">Redirect</a></p>

    <h1>Exception</h1>
    <p><a href="nullpointerexception">Null Pointer Exception</a></p>
    <p><a href="servletexception">Servlet Exception</a></p>

    <h1>Enter wrong Age:</h1>
    <p><a href="enterage.jsp">Age</a></p>


</body>
</html>