package busticket.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import busticket.service.SessionService;

/**
 * Servlet implementation class AdminUpdateRouteController
 */
@WebServlet("/UpdateRoute")
public class AdminUpdateRouteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminUpdateRouteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		if(SessionService.UpdateRouteDaily()==true) {
			session.setAttribute("mess", "success");
		}else {
			session.setAttribute("mess", "fail");
		}
		RequestDispatcher dispatcher //
        = this.getServletContext().getRequestDispatcher("/WEB-INF/views/AdminView/Adminpro.jsp");
		dispatcher.forward(request, response);
	}



}
