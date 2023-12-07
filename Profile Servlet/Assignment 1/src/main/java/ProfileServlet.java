import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet { protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		//check user logged in
		HttpSession session = request.getSession(false);
		
		if(session != null && session.getAttribute("name") != null)
		{
			//user logged in, show the profile page
			request.getRequestDispatcher("profile.jsp").forward(request, response);
		} else
		{
			//user is not logged in, redirect to the login page
			response.sendRedirect("login.jsp");
		}
}
}
