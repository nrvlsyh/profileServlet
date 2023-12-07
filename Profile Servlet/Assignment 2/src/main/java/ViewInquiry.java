
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import DAO.InqDAO;
import bean.User;
import bean.Inquiry;


/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/ViewInquiry")
public class ViewInquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, java.io.IOException {
		doGet(request,response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, java.io.IOException { 
		List<Inquiry> inqList = new ArrayList<Inquiry>();
		try { 
			HttpSession session = request.getSession();
			
			inqList = InqDAO.getAll();
			session.setAttribute("listInq", inqList);
			RequestDispatcher rd = request.getRequestDispatcher("InquiryList.jsp");
			rd.forward(request, response);	
		}
		catch(Throwable theException)
		{
			System.out.println(theException);
		}
	}
}
