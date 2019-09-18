package busticket.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import busticket.model.Bill;
import busticket.model.User;
import busticket.service.BillService;
import busticket.service.ProfileCustomerService;
import busticket.service.TicketService;


/**
 * Servlet implementation class DeleteTicketController
 */
@WebServlet("/DeleteTicket")
public class DeleteTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTicketController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		Timestamp dateBooking=BillService.getDateBookingById(id);
		long datebook=dateBooking.getTime();
		long current = System.currentTimeMillis();
		if(current-datebook>(24*60*60*1000)) {
			HttpSession sessionn=request.getSession();
			User user=(User) sessionn.getAttribute("user");
			int idUser=user.getId();
			int idCustomer = ProfileCustomerService.getIdCustomerByIdUser(idUser);

			List<Bill> lst_Bill = null;
			lst_Bill= BillService.getAllBillByIdCustomerAndStatus(idCustomer);
			request.setAttribute("list", lst_Bill);
			request.setAttribute("mess", -1);
			RequestDispatcher dispatcher 
	         = this.getServletContext()//
	               .getRequestDispatcher("/WEB-INF/views/CustomerView/ManageTicket.jsp");
			 dispatcher.forward(request, response);
		}else {
			BillService.CancelBill(id);
			TicketService.updateStatusTicket(id);
			response.sendRedirect(request.getContextPath() +"/ListTicket");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
