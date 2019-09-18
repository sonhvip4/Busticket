package busticket.controller;

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

import busticket.model.Province;
import busticket.model.Route;
import busticket.model.Session;
import busticket.service.ProvinceService;
import busticket.service.RouteService;
import busticket.service.SessionService;

/**
 * Servlet implementation class FindRouteController
 */
@WebServlet("/FindRoute")
public class FindRouteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindRouteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/CustomerView/ChooseRoute.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String startingPoint = request.getParameter("str");
		String destination = request.getParameter("des");
		String dd = request.getParameter("departDate");
		java.sql.Date departDate = java.sql.Date.valueOf(dd);
		ArrayList<Route> lst_Route = RouteService.FindRoute(startingPoint, destination);
		HttpSession session = request.getSession();
		session.setAttribute("depart_Date", departDate);
		session.setAttribute("lst_Route", lst_Route);
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/CustomerView/ChooseRoute.jsp");
		dispatcher.forward(request, response);
		

	}

}
