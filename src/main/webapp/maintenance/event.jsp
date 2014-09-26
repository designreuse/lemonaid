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
            <td><h4>Mileage</h4></td>
            <td><h4>ID</h4></td>
        </table>
        <table border="1" style="width:690px">
                <tr>
                    <td><c:out value="${event.date}"/></td>
                    <td><a href="http://localhost:8080/maintenance/listing?vehicleName=${requestScope.event.vehicleName}"><c:out value="${requestScope.event.vehicleName}"/></a></td>
                    <td><a href="http://localhost:8080/maintenance/listing?task=${requestScope.event.task}"><c:out value="${requestScope.event.task}"/></a></td>
                    <td><c:out value="${event.comments}"/></td>
                    <td><a href="http://localhost:8080/maintenance/listing?mileage=${requestScope.event.mileage}"><c:out value="${requestScope.event.mileage}"/></a></td>
                    <td><a href="http://localhost:8080/maintenance/event?id=${requestScope.event.id}"><c:out value="${requestScope.event.id}"/></a></td>
                </tr>
        </table>
        <a href="http://localhost:8080/maintenance/listing">back</a>
    </body>
</html>