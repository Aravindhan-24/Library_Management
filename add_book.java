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

@WebServlet(urlPatterns = {"/add_book"})
public class add_book extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String book_name, book_number, book_author, book_publisher, book_quantity;
        book_number = request.getParameter("add_book_number");
        book_name = request.getParameter("add_book_name");
        book_author = request.getParameter("add_book_author");
        book_publisher = request.getParameter("add_book_publisher");
        book_quantity = request.getParameter("add_book_quantity");
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/library_management", "root", "admin");
            PreparedStatement ps = con.prepareStatement("insert into book values(?, ?, ?, ?, ?)");
            ps.setString(1, book_number);
            ps.setString(2, book_name);
            ps.setString(3, book_author);
            ps.setString(4, book_publisher);
            ps.setString(5, book_quantity);
            ps.executeUpdate();
            out.print("<center><h3 style='color:black'>Book inserted Successfully</h3></center>");
            RequestDispatcher rd = request.getRequestDispatcher("add_book.jsp");
            rd.include(request, response);
        }
        catch (Exception e) {
            out.print("<center><h3 style='color:red'>The book already exists</h3></center>");
            RequestDispatcher rd = request.getRequestDispatcher("add_book.jsp");
            rd.include(request, response);
        }
    }
}
