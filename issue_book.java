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

@WebServlet(urlPatterns = {"/issue_book"})
public class issue_book extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int quantity;
        String book_number, student_id, student_name, contact;
        book_number = request.getParameter("issue_book_number");
        student_id = request.getParameter("issue_student_id");
        student_name = request.getParameter("issue_student_name");
        contact = request.getParameter("issue_contact_number");

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/library_management", "root", "admin");
            PreparedStatement ps = con.prepareStatement("select book_quantity from book where book_number=?");
            ps.setString(1, book_number);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                quantity = Integer.parseInt(rs.getString(1));
                if (quantity == 0) {
                    out.print("<center>Book not available to issue<center>");
                    RequestDispatcher rd = request.getRequestDispatcher("issue_book.jsp");
                    rd.include(request, response);
                } else {
                    ps = con.prepareStatement("insert into issue_book values(?, ?, ?, ?)");
                    ps.setString(1, book_number);
                    ps.setString(2, student_id);
                    ps.setString(3, student_name);
                    ps.setString(4, contact);
                    ps.executeUpdate();
                    out.print("<center><h3 style='color:black;'>book issued</h3><center>");
                    RequestDispatcher rd = request.getRequestDispatcher("issue_book.jsp");
                    rd.include(request, response);
                    quantity--;
                    String q=String.valueOf(quantity);
                    ps = con.prepareStatement("update book set book_quantity=? where book_number=?");
                    ps.setString(1,q);
                    ps.setString(2, book_number);
                    ps.executeUpdate();
                }
            }
            else{
            out.print("<center>Invalid book number <center>");
            RequestDispatcher rd = request.getRequestDispatcher("issue_book.jsp");
            rd.include(request, response);
            
            }
        } catch (Exception e) {
            out.print(e);
            RequestDispatcher rd = request.getRequestDispatcher("issue_book.jsp");
            rd.include(request, response);
        }
    }
}
