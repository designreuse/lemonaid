<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<html>
  <head>
    <title>JSP Hello World</title>
  </head>
  <body>
    <h2>Hello from a JSP!</h2>
    The current date and time is <%= new SimpleDateFormat().format(new Date()) %>
  </body>
</html>
