<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>JSP Placeholder</title>
</head>
<body>
<h2>Hello! This is a Placeholder brought to you by JSP!</h2>
<p>My intention is to present to you a simple Project Euler solution! Here you go:</p>

<p><strong>Find the sum of all the multiples of 3 or 5 below 1000:</strong></p>
<p><c:out value="${requestScope.placeholder}"/></p>

</body>
</html>