<!doctype html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Maintenance Event</title>
    </head>
    <body>
        <h1>Maintenance Event</h1>
        <table style="width:600px; font-family:verdana; background-color:lightyellow;">
            <td><h4>Date/Time</h4></td>
            <td><h4>Vehicle</h4></td>
            <td><h4>Task</h4></td>
            <td><h4>Comments</h4></td>
            <td><h4>ID</h4></td>
        </table>
        <table border="1" style="width:700px">
                <tr>
                    <td><c:out value="${requestScope.event.date}"/></td>
                    <td><c:out value="${requestScope.event.vehicleName}"/></td>
                    <td><c:out value="${requestScope.event.task}"/></td>
                    <td><c:out value="${requestScope.event.comments}"/></td>
                    <td><c:out value="${requestScope.event.id}"/></td>
                </tr>
        </table>
    </body>
</html>