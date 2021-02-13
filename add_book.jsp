<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Book</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <fieldset>
            <legend>Add Book</legend>
            <pre>
                <form action="add_book" method="post">
                    Book Number: <input type="number" name="add_book_number" placeholder="Enter Book Number" size="25" required>
                    
                    Book Name:   <input type="text" name="add_book_name" placeholder="Enter Book Name" size="25" required>
                    
                    Author:      <input type="text" name="add_book_author" placeholder="Enter Author" size="25" required>
                    
                    Publisher:   <input type="text" name="add_book_publisher" placeholder="Enter publisher" size="25" required>
                    
                    Quantity:    <input type="number" name="add_book_quantity" placeholder="Enter publisher" size="25" required>
                    
                                 <input type="submit" value="Add Book">
                </form>
                                 <a href="librarian_section.jsp"><button>Back</button></a>
            </pre>    
        </fieldset>
    </body>
</html>
