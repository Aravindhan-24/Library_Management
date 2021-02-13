<%-- 
    Document   : view_issue_book
    Created on : 12 Feb, 2021, 1:33:21 PM
    Author     : aravi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Issue book</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <sql:setDataSource var="db" driver="org.apache.derby.jdbc.ClientDriver" 
                           url="jdbc:derby://localhost:1527/library_management" user="root" password="admin"/>
        <sql:query dataSource="${db}" var="row">select * from issue_book</sql:query>
        <center>
            <h3>Issued book</h3>
            <table border=5>
                <tr>
                <th>Book Number</th>
                <th>Student_id</th>
                <th>Student_name</th>
                <th>Contact</th>
                </tr>
                    <c:forEach var="rs" items="${row.rows}">
                        <tr>
                        <td><c:out value="${rs.book_number}"/></td>
                        <td><c:out value="${rs.student_id}"/></td>
                        <td><c:out value="${rs.student_name}"/></td>
                        <td><c:out value="${rs.contact}"/></td>
                        </tr>
                    </c:forEach>
            </table>
            <br>
            <a href="librarian_section.jsp"><button>Back</button></a>
        </center>
    </body>
</html>
