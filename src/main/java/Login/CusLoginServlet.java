package Login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/CusLoginServlet")
public class CusLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CusLoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get username and password from the login form
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		// Validate user and get the customer ID
		int cusID = LoginDBUtil.ValidateUser(userName, password);
		
		// If cusID is valid (greater than 0), create a session
		if (cusID > 0) {
			// Create session and set CusID attribute
			HttpSession session = request.getSession();
			session.setAttribute("cusID", cusID);
			session.setAttribute("username", userName);  // Optional: store username too
			
			// Forward to a success page or dashboard
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewFAQCustomerServlet");
			dispatcher.forward(request, response);
		} else {
			// If login fails, forward back to the login page with an error message
			request.setAttribute("loginError", "Invalid username or password");
			RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);
		}
	}
}
