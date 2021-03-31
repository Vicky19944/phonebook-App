<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>contact info</h2>

	<form:form action="saveContact?contactId=${contact.contactId }" method="POST" modelAttribute="contact">
	    ${sucMsg }
		<table>

			<tr>
				<td>Name: </td>
				<td> <form:input path="contactName"/>
			</tr>
			
			<tr>
				<td>Email: </td>
				<td> <form:input path="contactEmail"/>
			</tr>
			
			<tr>
				<td>Number: </td>
				<td> <form:input path="contactNumber"/>
			</tr>
			
			<tr>
			<td></td>
			<td> <input type="submit" value="submit"></td>
			</tr>
			
		</table>


	</form:form>
	
	<a href="view-contacts">View All Contacts</a>

</body>
</html>