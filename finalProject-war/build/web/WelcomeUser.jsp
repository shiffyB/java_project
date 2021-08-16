<%@page import="classes.Patient"%>
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
            Patient patient = (Patient) request.getServletContext().getAttribute("patient");
        %>
        <h1>
            hello
            <%=patient.getName()%></h1>
        <form action="Action">
            <h2>Add Treatment:</h2>
            <input placeholder="Date" name="addDate" type="datetime"/><br/>
            <input placeholer = "Tooth Number" name="addToothNumber" type = "number"/><br/>
            <select name="addTreatmentType">
                <option value="FILLING">FILLING</option>
                <option value="ROOT_CANAL">ROOT_CANAL</option>
            </select><br/>
            <input type="number" placeholder="Price" name="addPrice"/><br/>
            <input type="checkbox" name="addPaid"/><label>Paid</label><br/>
            <input type="submit" name="action" value="addTreatment"/>
            <br/><br/>
            <h2>Set Treatment:</h2>
            <input type="number" placeholder="Id Treatment" name="id"/><br/>
            <input placeholder="Date" name="setDate" type="datetime"/><br/>
            <input placeholer = "Tooth Number" name="setToothNumber" type = "number"/><br/>
            <select name="setTreatmentType">
                <option value="FILLING">FILLING</option>
                <option value="ROOT_CANAL">ROOT_CANAL</option>
            </select><br/>
            <input type="number" placeholder="setPrice" name="setPrice"/><br/>
            <input type="checkbox" name="setPaid"/><label>Paid</label><br/>
            <input type="submit" name="action" value="setTreatment"/>
            <br/><br/>
            <input type="submit" value="treatmentsReport" name="action"/>                    
        </form>

    </body>
</html>