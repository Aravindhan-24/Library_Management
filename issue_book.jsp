<%-- 
    Document   : issue_book
    Created on : 11 Feb, 2021, 2:15:25 PM
    Author     : aravi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Issue Book</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
    <center>
        <h1>Issue Book</h1>
        <fieldset>
            <legend>Issue Book</legend>
            <pre>
                        <form action="issue_book" method="post">
                            
                            Book Number:   <input type="number" name="issue_book_number" placeholder="Enter Book Number" size="25" required="">

                            Student Id:    <input type="number" name="issue_student_id" placeholder="Enter Student Id" size="25" required="">

                            Student Name:  <input type="text" name="issue_student_name" placeholder="Enter Student Name" size="25" required="">

                            Contact Number:<input type="number" name="issue_contact_number" placeholder="Enter Contact Number" size="25" required>
                                            
                           <input type="submit" value="Issue Book">
                        </form>
                           <a href="librarian_section.jsp"><button>Back</button></a>
            </pre>
        </fieldset>
    </center>
</body>
</html>
