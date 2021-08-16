<%@page import="classes.Doctor"%>
<%@ page language="java" contentType="text/html; charset=windows-1255"
         pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=windows-1255">
        <title>Insert title here</title>
    </head>
    <body>
        <%
            Doctor doctor = (Doctor)request.getServletContext().getAttribute("doctor");
        %>
        
        <h1>
            hello
            <%=doctor.getName()%></h1>
        <form action="Action">
            <h2>Add Patient:</h2>
            <input type="text" placeholder="Name" name="addName"/><br/>
            <input type="text" placeholder="Password" name="addPassword"/><br/>
            <input type="submit" name="action" value="addPatient"/>
            <br/><br/>
            <h2>Delete Patient:</h2>
            <input type="number" placeholder="Id" name="deleteId"/><br/>
            <input type="submit" name="action" value="deletePatient"/>
            <br/><br/>
            <input type="submit" name="action" value="showPatients"/>
        </form>
    </body>
</html>