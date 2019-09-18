package busticket.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import busticket.model.ProfileCustomer;
import busticket.model.User;
import busticket.service.ProfileCustomerService;
import busticket.service.UserService;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/Register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("mess", "mess");
		 RequestDispatcher dispatcher 
         = this.getServletContext().getRequestDispatcher("/WEB-INF/views/LoginView/Register.jsp");
		 	dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String cusname = request.getParameter("name");
		String username = request.getParameter("username");
		String pw = request.getParameter("password");
		//String password= EncryptionHelper.MD5(pw);
		String email= request.getParameter("email");
		String bir= request.getParameter("birthday");
	    Date birthday=Date.valueOf(bir);  
	    String gender = request.getParameter("gender");
	    String phonenumber=request.getParameter("phonenumber");
	    String country=request.getParameter("country");
	    if(UserService.getIdByUserName(username)!=-1) {
	    	request.setAttribute("mess", username);
			RequestDispatcher dispatcher //
	        = this.getServletContext().getRequestDispatcher("/WEB-INF/views/LoginView/Register.jsp");
			dispatcher.forward(request, response);
	    }else {
	    	boolean result1 = UserService.addUser(new User(username, email, pw, true , 3));
		    if(result1)
		    {
			    int iduser = UserService.getIdByUserName(username);
			    boolean result2= ProfileCustomerService.addProfileCustomer(new ProfileCustomer(cusname, birthday, gender, phonenumber,
						true, country, iduser));
			    if(result2) {
			    		
						response.sendRedirect(request.getContextPath()+"/Login");
			            return;
			    	}
		    }
	    
	    }

	}
}
