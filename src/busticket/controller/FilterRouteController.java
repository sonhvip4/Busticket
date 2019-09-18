package busticket.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import busticket.model.Session;
import busticket.service.SessionService;

/**
 * Servlet implementation class FilterRouteController
 */
@WebServlet("/FilterRoute")
public class FilterRouteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilterRouteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		String startingPoint= request.getParameter("startingPoint");
		String destination= request.getParameter("destination");
		Date departDate;
		if(request.getParameter("departDate").equals("")) {
			departDate=null;
		}else {
			departDate= Date.valueOf(request.getParameter("departDate"));
		}
		Time timeStarting;
		if(request.getParameter("startingTime")==null) {
			timeStarting=null;
		}else {
			timeStarting = Time.valueOf(request.getParameter("startingTime"));
		}
		ArrayList<Session> listSession= SessionService.getAllSessionNotExpiredWithWhere(startingPoint, destination, departDate, timeStarting);
		if(listSession==null) {
			listSession=new ArrayList<Session>();
		}
		session.setAttribute("listSession", listSession);
		RequestDispatcher dispatcher 
        = this.getServletContext().getRequestDispatcher("/WEB-INF/views/SellerView/ManageRoute1.jsp");
		 	dispatcher.forward(request, response);
	}

}
