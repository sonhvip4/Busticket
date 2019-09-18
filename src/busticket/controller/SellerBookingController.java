package busticket.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import busticket.dto.SeatDetail;
import busticket.model.ProfileCustomer;
import busticket.model.Route;
import busticket.model.Session;
import busticket.service.ProfileCustomerService;
import busticket.service.RouteService;
import busticket.service.SeatService;
import busticket.service.SessionService;

/**
 * Servlet implementation class SellerBookingController
 */
@WebServlet("/SellerBooking")
public class SellerBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerBookingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idSession = Integer.parseInt(request.getParameter("getIdBooking"));
		HttpSession session= request.getSession();
		Session thisSession = SessionService.getSessionById(idSession);
		if(thisSession != null) {
			session.setAttribute("thisSession",thisSession);
		}
		ArrayList<ProfileCustomer> listCustomer = ProfileCustomerService.getAllProfileCustomerShowed();
		if(listCustomer != null) {
			session.setAttribute("listCustomer",listCustomer);
		}
		ArrayList<SeatDetail> lst_idSeat = null;
		lst_idSeat = SeatService.getIdSeatBooked(thisSession.getDepartDate(),thisSession.getIdRoute());
		session.setAttribute("lst_idSeat", lst_idSeat);
		Route route = RouteService.FindRouteObject(new Route(thisSession.getRouteObject().getStartingPoint(),thisSession.getRouteObject().getDestination(),thisSession.getRouteObject().getTimeStarting(),thisSession.getRouteObject().getTimeFinishing()));
		session.setAttribute("choosedRoute", route);
		RequestDispatcher dispatcher 
        = this.getServletContext().getRequestDispatcher("/WEB-INF/views/SellerView/SellerBooking.jsp");
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
