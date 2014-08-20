<!doctype html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Maintenance Listing</title>
	</head>
	<body>
		<h1>Maintenance Event Listing</h1>
        <table style="width:600px; font-family:verdana; background-color:lightyellow;">
            <td><h4>Date/Time</h4></td>
            <td><h4>Vehicle</h4></td>
            <td><h4>Task</h4></td>
            <td><h4>Comments</h4></td>
            <td><h4>ID</h4></td>
        </table>
		<table border="1" style="width:700px">
			<c:forEach var="event" items="${events}">
				<tr>
					<td><c:out value="${event.date}"></c:out></td>
					<td><c:out value="${event.vehicleName}"></c:out></td>
					<td><c:out value="${event.task}"></c:out></td>
					<td><c:out value="${event.comments}"></c:out></td>
                    <td><c:out value="${event.uuid}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>