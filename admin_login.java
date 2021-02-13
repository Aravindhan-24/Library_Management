
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/admin_login"})
public class admin_login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            String name=request.getParameter("admin_name");
            String pass=request.getParameter("admin_pass");
            if(name.equals("admin")&&pass.equals("admin")){
               RequestDispatcher rd=request.getRequestDispatcher("admin_section.jsp");  
                rd.forward(request, response);
               
            }
            else{
                out.print("<center><h3 style='color:red';>Password/Name Invalid!</h3></center>");
                RequestDispatcher rd=request.getRequestDispatcher("admin_login.jsp");  
                rd.include(request, response);
                
            }
    }


}
