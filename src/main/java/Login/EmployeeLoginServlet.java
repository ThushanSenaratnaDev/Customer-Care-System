package Login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/EmployeeLoginServlet")
public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EmployeeLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		// Get username and password from the login form
				String userName = request.getParameter("username");
				String password = request.getParameter("password");
				
				// Validate user and get the customer ID
				int EID = LoginDBUtil.ValidateEmployee(userName, password);
				
				// If cusID is valid (greater than 0), create a session
				if (EID > 0) {
					// Create session and set CusID attribute
					HttpSession session = request.getSession();
					session.setAttribute("EID", EID);
					
					
					// Forward to a success page or dashboard
					RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeHome.jsp");
					dispatcher.forward(request, response);
				} else {
					// If login fails, forward back to the login page with an error message
					request.setAttribute("loginError", "Invalid username or password");
					RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeLogin.jsp");
					dispatcher.forward(request, response);
				}
	}

}
