package busticket.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import busticket.dto.SeatDetail;
import busticket.model.Car;
import busticket.model.Route;
import busticket.model.Seat;
import busticket.model.User;
import busticket.service.CarService;
import busticket.service.ProfileCustomerService;
import busticket.service.RouteService;
import busticket.service.SeatService;
import busticket.service.SessionService;

/**
 * Servlet implementation class AddRouteController
 */
@WebServlet("/AddRoute")
public class AddRouteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRouteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/CustomerView/ChooseSeat.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String startingPoint = request.getParameter("startingPoint");
		String destination = request.getParameter("destination");
		String timeStart = request.getParameter("timeStarting");
		java.sql.Time timeStarting = java.sql.Time.valueOf(timeStart);
		String timeExpect = request.getParameter("timeExpecting");
		java.sql.Time timeExpecting = java.sql.Time.valueOf(timeExpect);

		int idroute = RouteService.getRouteIdFromChoosed(new Route(startingPoint,destination,timeStarting,timeExpecting));
		int idcar = RouteService.getCarIdByRouteId(idroute);
		Car car = CarService.getCarById(idcar);
		Route route = RouteService.FindRouteObject(new Route(startingPoint,destination,timeStarting,timeExpecting));
		HttpSession session = request.getSession();
		session.setAttribute("choosedRoute", route);
		Date departDate=(Date) session.getAttribute("depart_Date");
		ArrayList<SeatDetail> lst_idSeat = null;
		lst_idSeat = SeatService.getIdSeatBooked(departDate,idroute);
		session.setAttribute("lst_idSeat", lst_idSeat);
		session.setAttribute("choosedCar", car);
		
		User user=(User) session.getAttribute("user");
		int idUser=user.getId();
		int idCustomer = ProfileCustomerService.getIdCustomerByIdUser(idUser);
		
		int countBill = SessionService.getCountBill(idroute, idCustomer);
		session.setAttribute("count_Bill", countBill);
		if(countBill<5) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/CustomerView/ChooseSeat.jsp");
			dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath()+"/FindRoute");
		}

	}

}
