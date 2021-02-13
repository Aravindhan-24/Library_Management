
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

@WebServlet(urlPatterns = {"/delete_librarian"})
public class delete_librarian extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out=response.getWriter();
            String id=request.getParameter("delete_librarian_id");
            try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/library_management","root","admin");
            PreparedStatement ps=con.prepareStatement("select * from librarian where id=?");
            ps.setString(1,id);
            ResultSet rs=ps.executeQuery();
            if(!rs.next()){
                out.print("<center><h3 style='color:red;'>Couldn't perform remove Librarian, Id not found</h3></center>");
                RequestDispatcher rd=request.getRequestDispatcher("delete_librarian.jsp");
                rd.include(request, response);
            }
            else{
            ps=con.prepareStatement("delete from librarian where id=?");
            ps.setString(1, id);
            ps.executeUpdate();
            out.print("<center><h3 style='color:black;'>Librarian removed successfully</h3></center>");
            RequestDispatcher rd=request.getRequestDispatcher("delete_librarian.jsp");
            rd.include(request,response);
            }
        }
            catch(Exception e){
                out.print(e);
            }
    }



}
