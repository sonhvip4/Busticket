package busticket.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import busticket.data.ParamaterStatic;
import busticket.model.Bill;
import busticket.service.BillService;
import busticket.service.ProfileCustomerService;
import busticket.service.TicketService;
import busticket.utils.CalculationHelper;
import busticket.model.User;




/**
 * Servlet implementation class ListTicketCustomer
 */
@WebServlet("/ListTicket")
public class ListTicketCustomer extends HttpServlet {
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListTicketCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessionn=request.getSession();
		User user=(User) sessionn.getAttribute("user");
		int idUser=user.getId();
		int idCustomer = ProfileCustomerService.getIdCustomerByIdUser(idUser);
		
		
			List<Bill> lst_Bill = null;
			lst_Bill= BillService.getAllBillByIdCustomerAndStatus(idCustomer);
			request.setAttribute("list", lst_Bill);
			request.setAttribute("mess", 0);
			RequestDispatcher dispatcher 
	         = this.getServletContext()//
	               .getRequestDispatcher("/WEB-INF/views/CustomerView/ManageTicket.jsp");
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
