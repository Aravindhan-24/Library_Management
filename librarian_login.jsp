    <%-- 
    Document   : Librarian
    Created on : 11 Feb, 2021, 11:49:35 AM
    Author     : aravi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Librarian Login</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <center>
        <fieldset>
       <legend><b>Librarian Login</b>:</legend> 
        <br><br>
        <pre>
        <form action="librarian_login" method="post">
        Enter Name:     <input type="text" name="librarian_name" required>
        
        Enter Password: <input type="password" name="librarian_pass" required>
        
                       <input type="submit" value="Login">
        </form>
                       <a href="librarian_reset_password.jsp"><button>Forgot Password</button></a>  <a href="home.jsp"><button>Back</button></a>
                      
        </pre>
        </tr>
        </table> 
       </fieldset>
        </center>
    </body>
</html>
