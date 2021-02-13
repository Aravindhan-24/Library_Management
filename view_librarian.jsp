<%-- 
    Document   : view_librarian
    Created on : 11 Feb, 2021, 6:54:19 PM
    Author     : aravi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Librarian</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <center>
        <h1>Librarians</h1>
        </center>
        <sql:setDataSource var="db" driver="org.apache.derby.jdbc.ClientDriver" 
                           url="jdbc:derby://localhost:1527/library_management"
                           user="root" password="admin"/>
        <sql:query dataSource="${db}" var="rs">
            SELECT * FROM LIBRARIAN
        </sql:query>
            <center>
        <table border=5>
            <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>PASSWORD</th>
            <th>EMAIL</th>
            <th>ADDRESS</th>
            <th>CITY</th>
            <th>CONTACT</th>
            </tr>
            
        <c:forEach var="row" items="${rs.rows}">
            <tr>
                <td>
                    <c:out value="${row.id}"/>
                </td>
                <td>
                    <c:out value="${row.name}"/>
                </td>
                <td>
                    <c:out value="${row.password}"/>
                </td>
                <td>
                    <c:out value="${row.email}"/>
                </td>
                <td>
                    <c:out value="${row.address}"/>
                </td>
                <td>
                    <c:out value="${row.city}"/>
                </td>
                <td>
                    <c:out value="${row.contact}"/>
                </td>
            </tr>    
        </c:forEach>
        </table> 
                <br>
                <br>
                <a href="admin_section.jsp"><button>Back</button></a>
            </center>
            
            
    
    </body>
</html>
