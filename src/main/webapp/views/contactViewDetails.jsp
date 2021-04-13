<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ContactViewDetails.jsp</title>
</head>
<script type="text/javascript">
   function deleteConfirmation(){
	   return confirm("Are You Sure Want To Delete record ?")
   }
</script>
<body bgcolor="cyan">

    <div style="text-align:center;">
      <span style="color:red;font-size:18px;font-weight:bold;">Contact Management System</span><br/>
      <a href="loadContactForm">+ Add New Record</a>
    </div><br/>
    
	<c:choose>
		<c:when test="${contactsList.size() > 0 }">
			<div style='text-align:center;color:red;font-weight:bold;'>${deleteMessage}</div>
			<table align="center" border="2">
				<thead>
					<tr style="color: blue;">
						<th>S.No</th>
						<th>Contact Name</th>
						<th>Contact Number</th>
						<th>Contact Email</th>
						<th colspan="2">Operations</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="contact" items="${contactsList}" varStatus="i">
						<tr>
							<td>${i.index +1}</td>
							<td>${contact.contactName}</td>
							<td>${contact.contactNumber}</td>
							<td>${contact.contactEmail}</td>
							<td><a href='editContactDetails?contactId=${contact.contactId}'>Edit</a></td>
							<td><a href='deleteContactDetails?contactId=${contact.contactId}' onclick="deleteConfirmation();">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
	 	   <div style="text-align:center;color:red;font-weight:bold;">No Records available in Database!!!!</div>
		</c:otherwise>
	</c:choose>


</body>
</html>