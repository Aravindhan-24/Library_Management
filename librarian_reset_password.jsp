<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
    <center>
        <h1>Reset Password</h1>
        <fieldset>
            <legend>Reset Password</legend>
            <pre>
            <form action="librarian_reset_password" method="post">
                Enter Email:        <input type="email" name="reset_email" size="25" placeholder="Enter Registered Email">
                
                Enter New Password: <input type="password" name="reset_password" size="25" placeholder="Enter new password" >
                
                                    <input type="submit" value="Change password">
                                    </form>
                                    <a href="librarian_login.jsp"><button>Back</button></a>
            </pre>
        </fieldset>
    </center>
</body>
</html>
