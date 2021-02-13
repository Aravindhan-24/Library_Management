import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/librarian_reset_password"})
public class librarian_reset_password extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String email,password;
        email=request.getParameter("reset_email");
        password=request.getParameter("reset_password");
        try{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/library_management","root","admin");
        PreparedStatement ps=con.prepareStatement("select email from librarian where email=?");
        ps.setString(1, email);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            ps=con.prepareStatement("update librarian set password=? where email=?");
            ps.setString(1, password);
            ps.setString(2, email);
            ps.executeUpdate();
            out.print("<center><h3 style='color:black;'>Password reset succesful</h3><center>");
            RequestDispatcher rd=request.getRequestDispatcher("librarian_login.jsp");
            rd.include(request, response);
        }
        }
        catch(Exception e){
        out.print(e);
        out.print("<center><h4 style='color:red;'>Email address not found</h4></center>");
        RequestDispatcher rd=request.getRequestDispatcher("librarian_reset_password.jsp");
        rd.include(request, response);
        }
       
    }


}
