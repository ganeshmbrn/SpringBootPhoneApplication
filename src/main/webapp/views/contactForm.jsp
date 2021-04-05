<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"> 
<title>contactForm.jsp</title>
</head>
<body bgcolor="cyan">
	<div style="text-align:center;color:red;font-size:18px;font-weight:bold;">Contact Management System</div><br/>
   
    <form:form method="post" action="createContactDetails?contactId=${contactForm.contactId}" modelAttribute="contactForm">
          <div style="text-align:center;color:blue;font-weight:bold;">${message}</div>           
           <table align="center">
               <tr>
                   <td>Contact Name</td>
                   <td><form:input path="contactName"/></td>
               </tr>
               
               <tr>
                   <td>Contact Number</td>
                   <td><form:input path="contactNumber"/></td>
               </tr>
               
               <tr>
                   <td>Contact Email</td>
                   <td><form:input path="contactEmail"/></td>
               </tr>
               <tr>
                  <td>&nbsp;</td>
                  <td><form:button>Create Contact</form:button></td>
               </tr>
           </table>
    </form:form>
     <br/>
     <div style="text-align:center;">
        <a href="listOfContacts">List All Contacts</a>
     </div>
</body>
</html>