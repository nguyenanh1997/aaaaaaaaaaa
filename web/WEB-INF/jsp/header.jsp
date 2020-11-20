<%-- 
    Document   : dashbroad
    Created on : Nov 18, 2020, 3:26:52 PM
    Author     : CNTT_anhN
--%>

<!DOCTYPE html>
<html>
    <head>
        <style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 5px;
  text-align: left;    
}
</style>
        <%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<%@page isELIgnored="false" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
           
        
                <%
                    Cookie cookie = null;
                    Cookie[] cookies = null;
                    cookies = request.getCookies();
                    for (int i = 0; i < cookies.length; i++) {
                        cookie = cookies[i];
                        if (cookie.getName().compareTo("role_name") == 0)
                        {
                            String value = cookie.getValue();
                            if (value.compareTo("admin") == 0){
                %>
                Welcome Admin
                <tr>        <th><a href="login.htm" >home</a></th>
                            <th><a href="studentManager.htm">Student managment</a></th>
                            <th><a href="teacherManager.htm">Teacher managment</a></th>    
                            <th><a href="adminManager.htm" >admin managment</a></th>
                </tr>
                <%          }
                            if (value.compareTo("teacher") == 0){
                %>
                            Welcome Teacher
                            <tr>
                                <th><a href="#">Class information</a></th>
                                <th><a href="#">User profile</a></th>
                            </tr>
                            
                            <%          }
                            if (value.compareTo("student") == 0){
                                %>
                            Welcome Student
                            <tr>
                                <th><a href="#">User profile</a></th>
                                <th><a href="#">Check score</a></th>
                            </tr>
                        <%          }
                        }
                        if(cookie.getName().compareTo("username") == 0)
                        {
                         %>
                         <h1> Welcome: ${cookie.username.value} </h1>
                         <%
                        }
                    }
                        %>
                            
        </table>