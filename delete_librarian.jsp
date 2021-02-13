<%-- 
    Document   : delete_librarian
    Created on : 11 Feb, 2021, 1:20:09 PM
    Author     : aravi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Librarian</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
    <center>
        <h1>Delete Librarian</h1>
        <form action="delete_librarian" method="post">
            Enter Id: <input type="number" name="delete_librarian_id" size="25" placeholder="Enter id" required=""><br><br>
        <input type="submit" value="Delete Librarian">
        </form>
        <br>
        <a href="admin_section.jsp"><button>Back</button></a>
    </center>
        
    </body>
</html>
