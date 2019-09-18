package busticket.controller;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import busticket.model.Province;
import busticket.model.Session;
import busticket.service.ProvinceService;
import busticket.service.RouteService;
import busticket.service.SessionService;

/**
 * Servlet implementation class ManageRouteController
 */
@WebServlet("/ManageRoute")
public class ManageRouteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageRouteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		
		ArrayList<Session> listSession = SessionService.getAllSessionNotExpired();
		session.setAttribute("listSession", listSession);
		
		ArrayList<Province> listStartingPoint = ProvinceService.getAllStartingPoint();
		session.setAttribute("listStartingPoint",listStartingPoint);
		
		ArrayList<Province> listDestination = ProvinceService.getAllDestination();
		session.setAttribute("listDestination",listDestination);
		
		ArrayList<String> listStartingTime = RouteService.getAllStartingTime();
		session.setAttribute("listStartingTime", listStartingTime);
		
		RequestDispatcher dispatcher 
        = this.getServletContext().getRequestDispatcher("/WEB-INF/views/SellerView/ManageRoute1.jsp");
		 	dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
