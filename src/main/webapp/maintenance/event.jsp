<!doctype html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Maintenance Event</title>
    </head>
    <body>
        <h1>Maintenance Event</h1>
        <table style="width:720px; font-family:verdana; background-color:lightyellow;">
            <td><h4>Date/Time</h4></td>
            <td><h4>Vehicle</h4></td>
            <td><h4>Task</h4></td>
            <td><h4>Comments</h4></td>
            <td><h4>ID</h4></td>
        </table>
        <table border="1" style="width:700px">
            <c:forEach var="event" items="${event}">
                <tr>
                    <td><c:out value="${event.date}"/></td>
                    <td><a href="http://localhost:8080/maintenance/event?vehicleName=${event.vehicleName}"><c:out value="${event.vehicleName}"/></a></td>
                    <td><c:out value="${event.task}"/></td>
                    <td><a href="http://localhost:8080/maintenance/event?task=${event.task}"><c:out value="${event.task}"/></a></td>
                    <td><a href="http://localhost:8080/maintenance/event?id=${event.id}"><c:out value="${event.id}"/></a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="http://localhost:8080/maintenance/listing">back</a>
    </body>
</html>