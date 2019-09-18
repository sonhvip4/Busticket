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
 * Servlet implementation class AdminChangeUserController
 */
@WebServlet("/AdminChangeUser")
public class AdminChangeUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChangeUserController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session= request.getSession();
		String password= request.getParameter("password");
		Date birthDate=null;
		try {
			birthDate = new java.sql.Date(sdf.parse(request.getParameter("date")).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String email=request.getParameter("email");
		String phone= request.getParameter("phone");
		int idrole=Integer.parseInt(request.getParameter("idroleuser"));
		User user= (User)session.getAttribute("edituser");
		User newuser= new User(user.getId(), user.getUserName(), email, password, user.isActived(), user.getIdRoleUser());
		UserService.updateUser(newuser);
		session.setAttribute("edituser", newuser);
	
		if(idrole==1||idrole==2) {
			ProfileManager pm = (ProfileManager) session.getAttribute("userplus");
			ProfileManager pmn= new ProfileManager(pm.getId(),name, birthDate, gender, phone,true, pm.getIdUser());
			ProfileManagerService.updateProfileManager(pmn);
			session.setAttribute("userplus", pmn);
		}
		if(idrole==3) {
			ProfileCustomer pc = (ProfileCustomer) session.getAttribute("userplus");
			ProfileCustomer pcn= new ProfileCustomer(pc.getId(), name, birthDate, gender, phone, true, pc.getCountry(), pc.getIdUser());
			ProfileCustomerService.updateProfileCustomer(pcn);
			session.setAttribute("userplus", pcn);
		}
		RequestDispatcher dispatcher //
        = this.getServletContext().getRequestDispatcher("/WEB-INF/views/AdminView/EditUser.jsp");
		dispatcher.forward(request, response);
	}

}
