<!doctype html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Maintenance Listing</title>
	</head>
	<body>
		<h1>Maintenance Event Listing</h1>
		<table>
			<c:forEach var="event" items="${events}">
				<tr>
					<td><c:out value="${event.date}"></c:out></td>
					<td><c:out value="${event.vehicleName}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>