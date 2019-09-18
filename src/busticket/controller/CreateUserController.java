package busticket.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import busticket.model.ProfileCustomer;
import busticket.model.ProfileManager;
import busticket.model.User;
import busticket.service.ProfileCustomerService;
import busticket.service.ProfileManagerService;
import busticket.service.UserService;

/**
 * Servlet implementation class CreateUserController
 */
@WebServlet("/CreateUser")
public class CreateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUserController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		int role=Integer.parseInt(request.getParameter("role"));
		String userName= request.getParameter("userName");
		if(UserService.getIdByUserName(userName)!=-1) {
			session.setAttribute("mess", -1);
			response.sendRedirect(request.getContextPath()+"/CreateUser.jsp");
		}else {
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			String managerName=request.getParameter("name");
			String customerName=request.getParameter("name");
			Date dateOfBirth=null;
			try {
				dateOfBirth = new java.sql.Date(sdf.parse(request.getParameter("birthDate")).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String gender=request.getParameter("gender");
			String phoneNumber=request.getParameter("phonenumber");
			boolean showProfile=true;
			boolean isActived=true;
			String country="";
			User user =new  User( userName, email, password, isActived, role);
			UserService.addUser(user);
			int idUser = UserService.getIdByUserName(userName);
			if(role==1||role==2) {
				ProfileManager pm = new ProfileManager(managerName, dateOfBirth, gender, phoneNumber, showProfile, idUser);
				ProfileManagerService.addProfileManager(pm);
			}
			if(role==3) {
				ProfileCustomer pc=new ProfileCustomer(customerName, dateOfBirth, gender, phoneNumber, showProfile, country, idUser);
				ProfileCustomerService.addProfileCustomer(pc);
			}
			session.setAttribute("mess", 1);
			RequestDispatcher dispatcher //
            = this.getServletContext().getRequestDispatcher("/WEB-INF/views/AdminView/CreateUser.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
