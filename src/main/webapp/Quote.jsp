<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <title>Quote</title>
  </head>
  <body>
    <h1>Quote</h1>
    <p>The quote is <c:out value="${requestScope.quote}"/>
  </body>
</html>