
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import DAO.UserDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, java.io.IOException { 
		try { 
			User person = new User();
			//get user input
			person.setName(request.getParameter("name"));
			person.setEmail(request.getParameter("email"));
			person.setUsername(request.getParameter("username"));
			person.setPassword(request.getParameter("password"));
			//register
			person = UserDAO.register(person);
			
			// Retrieve password and retype password from the request
	        String password = request.getParameter("password1");
	        String retypePassword = request.getParameter("password");

	        // Check if the passwords match
	        boolean passwordsMatch = password.equals(retypePassword);
	        
	        if (person.isValid()) { // register success
	        		
	    	   if (passwordsMatch) {
	    	       // Registration logic (save to database, etc.)
	    	       // Forward to a success page or perform other actions
	    	       HttpSession session = request.getSession(true);
				   session.setAttribute("registerSuccess",true);
	    	      }
	        		
	        		else {
	        			
	        			//get user
	        			String usernama = (request.getParameter("username"));
	        			//insert to cart
	        			boolean deleteStatus = UserDAO.removeUser(usernama);
	        			System.out.println(deleteStatus);
	        			
	    				HttpSession session = request.getSession(true);
	    				session.setAttribute("passwordFail",true);	
	    	        }
	        		
				} else {
					
					HttpSession session = request.getSession(true);
					session.setAttribute("registerFail",true);			
				}
	        	
			
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);	
		}
		catch(Throwable theException)
		{
			System.out.println(theException);
		}
	}
}
