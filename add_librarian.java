import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/add_librarian"})
public class add_librarian extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        
        String number, name, password, email, address, city, contact;
        number=request.getParameter("add_librarian_id");
        name=request.getParameter("add_librarian_name");
        password=request.getParameter("add_librarian_password");
        email=request.getParameter("add_librarian_email");
        address=request.getParameter("add_librarian_address");
        city=request.getParameter("add_librarian_city");
        contact=request.getParameter("add_librarian_contact");
        
        try{
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/library_management","root","admin");
        PreparedStatement ps=con.prepareStatement("insert into librarian values(?, ?, ?, ?, ?, ?, ?)");
        ps.setString(1,number);
        ps.setString(2, name);
        ps.setString(3, password);
        ps.setString(4, email);
        ps.setString(5, address);
        ps.setString(6, city);
        ps.setString(7, contact);
        ps.executeUpdate();
        out.print("<center><h3 style='color:black;'>Librarian added into the database</center>");
        RequestDispatcher rd=request.getRequestDispatcher("add_librarian.jsp");
        rd.include(request,response);
        }
        catch(Exception e){
        out.print("<center><h3 style='color:red;'>Librarian Id already exists</center>");
        RequestDispatcher rd=request.getRequestDispatcher("add_librarian.jsp");
        rd.include(request,response);
            
        }
        
    }

}
