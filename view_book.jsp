<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Book</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <center>
            <h3>Books Available</h3>
            <sql:setDataSource var="db" driver="org.apache.derby.jdbc.ClientDriver" 
                               url="jdbc:derby://localhost:1527/library_management" user="root" password="admin"/>
            <sql:query dataSource="${db}" var="rs">select * from book</sql:query>
            <table border=5>
                <tr>
                    <th>Book Number</th>
                    <th>Book Name</th>
                    <th>Book Author</th>
                    <th>Book Publisher</th>
                    <th>book Quantity</th>
                </tr>
                <tr>
                    <c:forEach var="row" items="${rs.rows}">
                    <td><c:out value="${row.book_number}"/></td>
                    <td><c:out value="${row.book_name}"/></td>
                    <td><c:out value="${row.book_author}"/></td>
                    <td><c:out value="${row.book_publisher}"/></td>
                    <td><c:out value="${row.book_quantity}"/></td>
                </tr>
                </c:forEach>
            </table>
            <br>
            <a href="librarian_section.jsp"><button>Back</button></a>
        </center>
    </body>
</html>
