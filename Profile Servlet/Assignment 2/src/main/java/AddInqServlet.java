
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import DAO.InqDAO;
import DAO.UserDAO;
import bean.Inquiry;
import bean.User;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/addInquiry")
public class AddInqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static InqDAO dao;
	private int detID;
	private String forward;
	private static String LIST = "InquiryList.jsp";
	
	
	public AddInqServlet() {
		super();
		dao = new InqDAO();
	}
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, java.io.IOException { 

		try {
			
			User user = new User();
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			user=UserDAO.login(user);
			
			if (user.isValid()) {
				HttpSession session = request.getSession();
				Inquiry newInq = new Inquiry(); 
				
				//get user input
				newInq.setName(request.getParameter("name"));
				newInq.setEmail(request.getParameter("email"));
				newInq.setMessage(request.getParameter("inquiry"));
				//insert feedback
				boolean inqStatus= InqDAO.addInq(newInq);
				if(inqStatus) {
					session.setAttribute("inqStatus", true);
				}else
					session.setAttribute("inqStatus", false);
				RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
				rd.forward(request, response);	
				
			} else {
				HttpSession session = request.getSession();
				Inquiry newInq = new Inquiry(); 
				
				//get user input
				newInq.setName(request.getParameter("name"));
				newInq.setEmail(request.getParameter("email"));
				newInq.setMessage(request.getParameter("inquiry"));
				//insert feedback
				boolean inqStatus= InqDAO.addInq(newInq);
				if(inqStatus) {
					session.setAttribute("inqStatus", true);
				}else
					session.setAttribute("inqStatus", false);
				RequestDispatcher rd = request.getRequestDispatcher("indexprofile.jsp");
				rd.forward(request, response);
				
			}
		}
		catch(Throwable theException)
		{
			System.out.println(theException);
		}
	}
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("listDetails")) {
			forward = LIST;
			request.setAttribute("inquiries", InqDAO.getAll());
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
	
}
