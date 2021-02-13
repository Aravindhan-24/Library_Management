import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/librarian_login"})
public class librarian_login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        String db_name="null";
        String db_password="null";
        String name=request.getParameter("librarian_name");
        String password=request.getParameter("librarian_pass");
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/library_management","root","admin");
            PreparedStatement ps=con.prepareStatement("Select name,password from librarian where name=? AND password=?");
            ps.setString(1, name);
            ps.setString(2, password);
            
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                 db_name=rs.getString(1);
                 db_password=rs.getString(2);
            }
            
            
            if(db_name.equals(name)&& password.equals(db_password)){
                RequestDispatcher rd=request.getRequestDispatcher("librarian_section.jsp");
                rd.forward(request,response);
            }
            else{
                out.print("<center><h3 style='color:red;'>Invalid password/Name</h3></center>");
                RequestDispatcher rd=request.getRequestDispatcher("librarian_login.jsp");
                rd.include(request, response);
            }
            }
            catch(Exception e){
            out.print(e);
            }
        }
}
