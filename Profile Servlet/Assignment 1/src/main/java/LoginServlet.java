

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {
	
	PrintWriter out=response.getWriter();
	String name=request.getParameter("name");
	String password=request.getParameter("password");
	
	if(name.equals("ameerul") && password.equals("admin123")) {
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		response.sendRedirect("ProfileServlet");
	} else {
		
		//invalid credentials, show an error message and redirect back to the login page
		request.setAttribute("errorMessage", "Wrong username or password. Please try again.");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
}
}