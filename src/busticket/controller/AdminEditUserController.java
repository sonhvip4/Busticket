package busticket.controller;

import java.io.IOException;

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
 * Servlet implementation class AdminEditUserController
 */
@WebServlet("/AdminEdit")
public class AdminEditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id"));
		User user=UserService.getUserbyID(id);
		HttpSession session= request.getSession();
		session.setAttribute("edituser", user);
		if(user.getIdRoleUser()==1||user.getIdRoleUser()==2) {
			ProfileManager pm =ProfileManagerService.getProfileManager(id);
			session.setAttribute("userplus", pm);
		}
		if(user.getIdRoleUser()==3){
			ProfileCustomer pc= ProfileCustomerService.getProfileByIdUser(id);
			session.setAttribute("userplus", pc);
		}
		RequestDispatcher dispatcher //
        = this.getServletContext().getRequestDispatcher("/WEB-INF/views/AdminView/EditUser.jsp");
		dispatcher.forward(request, response);
	}

}
