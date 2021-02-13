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

@WebServlet(urlPatterns = {"/return_book"})
public class return_book extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String book_number, student_id, quantity;
        int q;
        book_number = request.getParameter("return_book_number");
        student_id = request.getParameter("return_student_id");
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/library_management", "root", "admin");
            PreparedStatement ps = con.prepareStatement("select book_number,student_id from issue_book where student_id=? and book_number=?");
            ps.setString(1, student_id);
            ps.setString(2, book_number);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ps = con.prepareStatement("delete from issue_book where student_id=?");
                ps.setString(1, student_id);
                ps.executeUpdate();
                ps = con.prepareStatement("select book_quantity from book where book_number=?");
                ps.setString(1, book_number);
                rs = ps.executeQuery();
                while (rs.next()) {
                    q = Integer.parseInt(rs.getString(1));
                    q++;
                    quantity = String.valueOf(q);
                    ps = con.prepareStatement("update book set book_quantity=? where book_number=?");
                    ps.setString(1, quantity);
                    ps.setString(2, book_number);
                    ps.executeUpdate();
                    out.print("<center><h3 style='color:black;'>Book return Success</h3></center>");
                    RequestDispatcher rd = request.getRequestDispatcher("return_book.jsp");
                    rd.include(request, response);
                } 
            }
        } 
            catch (Exception e) {
            out.print("<center><h3 style='color:red;'>Entry not found in the table</h3></center>");
            RequestDispatcher rd = request.getRequestDispatcher("return_book.jsp");
            rd.include(request, response);
        }
    }
}
