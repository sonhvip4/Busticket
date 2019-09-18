package busticket.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import busticket.model.Bill;
import busticket.model.Car;
import busticket.model.Route;
import busticket.model.Ticket;
import busticket.model.User;
import busticket.service.BillService;
import busticket.service.ProfileCustomerService;
import busticket.service.SeatService;
import busticket.service.SessionService;
import busticket.service.TicketService;

/**
 * Servlet implementation class AddBillController
 */
@WebServlet("/AddBill")
public class AddBillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBillController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	     
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession sessionn=request.getSession();
		User user=(User) sessionn.getAttribute("user");
		int idUser=user.getId();
		int idCustomer = ProfileCustomerService.getIdCustomerByIdUser(idUser);
		
		Route route = (Route) sessionn.getAttribute("choosedRoute");
		int idRoute = route.getId();
		Car car = (Car) sessionn.getAttribute("choosedCar");
		int idCar = car.getId();
		ArrayList<String> lst_Bill = (ArrayList<String>) sessionn.getAttribute("lst_idBill");
		//
		int idSession = SessionService.getIdSessionByIdRouteAndIdCar(idRoute,idCar);
		
		
		ArrayList<Integer> lst_ChoosedSeat = (ArrayList<Integer>) sessionn.getAttribute("listChoosedSeat");
		ArrayList<String> lst_ChoosedSeatName = (ArrayList<String>) sessionn.getAttribute("lst_chooseSeatName");
		for(int i=0;i<lst_ChoosedSeatName.size();i++)
	{
	   if(lst_ChoosedSeatName.get(i)!="")
	   {
			boolean result1 = TicketService.addTicket(new Ticket(null,lst_ChoosedSeat.get(i),idSession));
			if(result1) {
				int idNewTicket = TicketService.getIdTicketByIdSeatAndIdSession(lst_ChoosedSeat.get(i), idSession);
				Timestamp sqlDate = new Timestamp(Calendar.getInstance().getTime().getTime());
				boolean result2 = BillService.addBill(new Bill(lst_Bill.get(i),idNewTicket,idCustomer, sqlDate));
				if(result2) {
					String idNewBill = BillService.getIdByIdTicket(idNewTicket);
					boolean result3 = TicketService.updateNewTicket(idNewBill, idNewTicket);
					if(result3) {
					}
				}
			}
	   }
	}

        response.sendRedirect(request.getContextPath() +"/ListTicket");
	}

}
