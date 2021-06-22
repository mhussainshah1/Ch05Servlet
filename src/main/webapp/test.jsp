<%--
  Created by IntelliJ IDEA.
  User: Owner
  Date: 6/19/2021
  Time: 6:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Check boxes and Radio Buttons-JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>

<form action="test" method="get">
    <%--    we do not need to mention path from root in JSP     --%>
    <p><input type="checkbox" name="addEmail" checked>Yes, add me to your mailing list.</p>

    <p>Contact me by:<br>
        <input type="radio" name="contactVia" value="Email">Email
        <input type="radio" name="contactVia" value="Postal Mail">Postal Mail
        <input type="radio" name="contactVia" value="Both" checked>Both</p>

    <p>I'm intersted in these types of music:<br>
        <input type="checkbox" name="rock">Rock<br>
        <input type="checkbox" name="country">Country<br>
        <input type="checkbox" name="bluegrass">Bluegrass</p>

    <br>
    <p><label for="country checkbox">Select a country:</label></p>
    <select id="country checkbox" name="country">
        <option value="USA" selected>United States</option>
        <option value="CAN">Canada</option>
        <option value="MEX">Mexico</option>
    </select>

    <br>
    <p><label for="country list">Country:</label></p>
    <select id="country list" name="country" size="3" multiple>
        <option value="USA" selected>United States</option>
        <option value="CAN">Canada</option>
        <option value="MEX">Mexico</option>
    </select>
    <br>
    <input type="submit" value="Join Now" class="margin_left">
</form>
</body>
</html>
