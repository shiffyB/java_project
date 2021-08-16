<%@page import="classes.Treatment"%>
<%@page import="classes.Patient"%>
<%@ page  language="java" contentType="text/html; charset=windows-1255"
         pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
<!--        <meta http-equiv="Content-Type"
              content="text/html; charset=windows-1255">
        <title>Insert title here</title>-->
    </head>
    <body>
        <%Patient patient = (Patient) request.getServletContext().getAttribute("patient");%>
        <table>
            <thead>
                <tr>
                    <th>Date</th>
                    <th>Tooth Number</th>
                    <th>Treatment Type</th>
                    <th>Price</th>
                    <th>Is Paid</th>
                </tr>
            </thead>
            <tbody>
                <%for (Treatment t : patient.getTreatments()) { %>
                <tr>
                    <th>
                        <%= t.getDate()%>
                    </th>
                    <th>
                        <%= t.getToothNumber()%>
                    </th>
                    <th>
                        <%= t.getTreatmentType()%>
                    </th>
                    <th>
                        <%= t.getPrice()%>
                    </th>
                    <th>
                        <%= t.isPaid()%>
                    </th>
                </tr>
                <%} %>
            </tbody>
        </table>
    </body>
</html>