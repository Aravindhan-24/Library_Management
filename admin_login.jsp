<%-- 
    Document   : Admin
    Created on : 11 Feb, 2021, 11:49:09 AM
    Author     : aravi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
       
    <center>
       <fieldset>
       <legend><b>Admin Login</b>:</legend> 
        
       <br><br><br>
       
       <pre>
        <form action="admin_login" method="post">
    Enter Name:    <input type="text" name="admin_name" size="25" > 
        
    Enter Password:  <input type="password" name="admin_pass" size="25">    
        
                       <input type="submit" value="login">
        </form>
                       <a href="home.jsp"><button>Back</button></a>
        </pre>
       </fieldset>
    </center>
    </body>
</html>
