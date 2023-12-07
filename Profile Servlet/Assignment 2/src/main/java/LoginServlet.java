

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import bean.User;

/**
 * Servlet implementation class LoginServlet
 
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
}*/

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		
    		/*String userRole = request.getParameter("user");
    			userRole.equals("User");*/
    			User user = new User();
    			user.setUsername(request.getParameter("username"));
    			user.setPassword(request.getParameter("password"));
    			user=UserDAO.login(user);
			
    			if(user.isValid()) {
    				HttpSession session = request.getSession(true);
    				session.setAttribute("user_Name",user.getName());
    				session.setAttribute("user_ID", user.getId());
    				session.setAttribute("user_Email", user.getEmail());
    				session.setAttribute("user_Username", user.getUsername());
    				session.setAttribute("user_Password", user.getPassword());
    				
    				RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
    				rd.forward(request, response);
    			} 
    			else {
    				HttpSession session = request.getSession(true);
    				session.setAttribute("loginFail",true);
				
    				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
    				rd.forward(request, response);
    			}
    		
    	
		}
		catch(Throwable theException)
			{
			System.out.println(theException);
			}
		
	}

}