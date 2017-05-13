<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        <h1>Create New Employee</h1>  
       <form:form method="post" action="SpringMvc/createEmployee" commandName="employee">    
        <table >    
         <tr>    
          <td>Emp First Name : </td>   
          <td><form:input path="firstName"  /></td>  
         </tr>
         <tr>    
          <td>Emp Last Name : </td>   
          <td><form:input path="LastName"  /></td>  
         </tr> 
         <tr>    
          <td>Gender : </td>   
          <td><form:input path="gender"  /></td>  
         </tr>   
         <tr>    
          <td>Salary :</td>    
          <td><form:input path="salary" /></td>  
         </tr>   
            
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
</form:form>



</body>
</html>