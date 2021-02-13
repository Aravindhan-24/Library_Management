<%-- 
    Document   : return_book
    Created on : 11 Feb, 2021, 2:39:33 PM
    Author     : aravi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Return Book</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <center>
            <h1>Return Book</h1>
            <fieldset>
                <legend>Return Book</legend>
                <pre>
                <form action="return_book" method="post">
                    Book Number: <input type="number" name="return_book_number" placeholder="Enter Book Number" size="25">
                    
                    Student Id : <input type="number" name="return_student_id" placeholder="Enter Student Id" size="25">
                    
                                 <input type="submit" value="Return">
                </form>
                                 <a href="librarian_section.jsp"><button>Back</button></a>
                </pre>
            </fieldset>
        </center>
    </body>
</html>
