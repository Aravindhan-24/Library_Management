<%-- 
    Document   : add_librarian
    Created on : 11 Feb, 2021, 12:55:23 PM
    Author     : aravi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Librarian</title>
        <link rel="styleSheet" href="style.css">
        
    </head>
    <body>

        <fieldset>
            <legend><b>Add Librarian</b></legend>
            <pre>
            <form action="add_librarian" method="post">
            ID:         <input type="text" name="add_librarian_id" size="25" placeholder="Enter Id" required>

            Name:       <input type="text" name="add_librarian_name" size="25" placeholder="Enter Name" required>

            Password:   <input type="password" name="add_librarian_password" size="25" placeholder="Enter Number" required>

            email:      <input type="email" name="add_librarian_email" size="25" placeholder="Enter email" required>

            Address:    <input type="text" name="add_librarian_address" size="25" placeholder="Enter Address" required>

            city:       <input type="text" name="add_librarian_city" size="25" placeholder="Enter city" required>

            contact:    <input type="text" name="add_librarian_contact" size="25" placeholder="Enter contact" required>

                        <input type="submit" value="Add">
            </form> 
                        <a href="admin_section.jsp"><button>Back</button></a>
            
            </pre>
        </fieldset>
    </body>
</html>
