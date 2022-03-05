<%-- 
    Document   : testjsp
    Created on : May 18, 2021, 2:37:21 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello</title>
    </head>
    <body>
        <%
            String name = request.getParameter("name");
            String cno = request.getParameter("cno");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String country = request.getParameter("country"); 
         
            out.println("Name: "+name+"\n Contact No:"+cno+"\n Address: "+address+"\n City: "+city+"\n State: "+state+"\n Country: "+country);
      %>
    </body>
</html>
