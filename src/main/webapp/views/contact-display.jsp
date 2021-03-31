<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">

function confirmDelete(){
	return confirm("Are you sure to delete?");
}

</script>

</head>
<body>

	<h2>All Contacts</h2>
	
	<a href="load-form"> Add new contact</a>

	<table border="1">
		<thead>

			<tr>
				<th>S.No</th>
				<th>Name</th>
				<th>Email</th>
				<th>PhoneNo.</th>
				<th>Action</th>
			</tr>

		</thead>

		<tbody>
	<c:forEach items="${contacts}" var="contact">
	<tr>
       <td>${contact.contactId}</td>
       <td>${contact.contactName}</td>
       <td>${contact.contactEmail}</td>
       <td>${contact.contactNumber}</td>
       <td>
          <a href="editContact?cid=${contact.contactId}">edit</a>
          <a href="deleteContact?cid=${contact.contactId}" onclick="return confirmDelete()">delete</a>
         </td>
       
	</tr>
		</c:forEach>
		</tbody>

	</table>

</body>
</html>