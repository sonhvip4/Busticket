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

import busticket.model.Ticket;
import busticket.model.Session;
import busticket.service.SessionService;
import busticket.service.TicketService;

/**
 * Servlet implementation class EditRouteController
 */
@WebServlet("/EditRoute")
public class EditRouteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditRouteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		Session thisSession = (Session) session.getAttribute("thisSession");
		ArrayList<Ticket> listTicket = TicketService.getAllOccupiedTicketBySession(thisSession.getId());
		if(listTicket != null) {
			session.setAttribute("listTicket", listTicket);
		}
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/SellerView/EditRoute1.jsp");
		dispatcher.forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		int idSession;
		if (request.getParameter("getSession")!=null)
			idSession = Integer.parseInt(request.getParameter("getSession"));
		else {
			String val = request.getParameter("delTicket").toString();
			System.out.println(val);
			int tmp = 0;
			String idTicketStr = new String();
			for (int i=0; i< val.length(); i++) {
				if (val.charAt(i) != '-') {
					idTicketStr = idTicketStr + val.charAt(i);
				} else {
					tmp = i;
					break;
				}
			}
			int idTicket = Integer.parseInt(idTicketStr);
			String idSessionStr = new String();
			idSessionStr = val.substring(tmp+1);
			idSession = Integer.parseInt(idSessionStr);
			boolean x = TicketService.delTicket(idTicket);
		}
		
		ArrayList<Ticket> listTicket = TicketService.getAllOccupiedTicketBySession(idSession);
		if(listTicket != null) {
			session.setAttribute("listTicket", listTicket);
		}
		System.out.println("OK");
		Session thisSession = SessionService.getSessionById(idSession);
		if(thisSession != null) {
			session.setAttribute("thisSession",thisSession);
		}
			
		

		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/SellerView/EditRoute1.jsp");
		dispatcher.forward(request, response);
		
		
		
		
//		RequestDispatcher dispatcher = request.getServletContext()
//				.getRequestDispatcher("/WEB-INF/views/SellerView/EditRoute1.jsp");
//		dispatcher.forward(request, response);
	}

}
