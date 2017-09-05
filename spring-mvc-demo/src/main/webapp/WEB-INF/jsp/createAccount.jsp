<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Spring form tag library -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create an Account</title>
<style>
  .error{
    color:red;
    font-size: 15px;
  }
</style>
</head>

<body>
  <h1>Enter Account Details</h1>
  <form:form commandName="aNewAccount" action="createAccount.html">
    <table>
      <tr>
        <td>
          First name: <form:input path="firstName" type="text" name="firstName"/>
          <form:errors path="firstName" cssClass="error"/>            
        </td>
      </tr>
      <tr>
        <td>
          Last name: <form:input path="lastName" type="text" name="lastName"/>
          <form:errors path="lastName" cssClass="error"/>
        </td>
      </tr>
      <tr>
        <td>
          Last name: <form:input path="age" type="number" name="age"/>
          <form:errors path="age" cssClass="error"/>
        </td>
      </tr>
      <tr>
        <td>
          Address: <form:input path="address" type="text" name="address"/>
          <form:errors path="address" cssClass="error"/>
        </td>
      </tr>
      <tr>
        <td>
          Email: <form:input path="email" type="text" name="email"/>
          <form:errors path="email" cssClass="error"/>
        </td>
      </tr>
      <tr><td><input type="submit" value="Create "/></td></tr>
    </table>
  </form:form>
</body>
</html>