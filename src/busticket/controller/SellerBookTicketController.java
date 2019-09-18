package busticket.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import busticket.model.Bill;
import busticket.model.Session;
import busticket.model.Ticket;
import busticket.service.BillService;
import busticket.service.SeatService;
import busticket.service.TicketService;

/**
 * Servlet implementation class SellerBookTicketController
 */
@WebServlet("/SellerBookTicket")
public class SellerBookTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerBookTicketController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Integer> lst_ChoosedSeat = new ArrayList<Integer>();
		ArrayList<String> lst_ChoosedSeatName= new ArrayList<String>();
		HttpSession session=request.getSession();
		String s1 = request.getParameter("seat1");
		String s2 = request.getParameter("seat2");
		   String s3 = request.getParameter("seat3");
		   String s4 = request.getParameter("seat4");
		   String s5 = request.getParameter("seat5");
		   int idcus= Integer.parseInt(request.getParameter("radio-cus"));
		   if(s1!="") {
			   int idseat1 = SeatService.getIdSeatByName(s1);
				lst_ChoosedSeat.add(idseat1);
				lst_ChoosedSeatName.add(s1);
		   }
		   if(s2!="") {
			   int idseat2 = SeatService.getIdSeatByName(s2);
				lst_ChoosedSeat.add(idseat2);
				lst_ChoosedSeatName.add(s2);
		   }
		   if(s3!="") {
			   int idseat3 = SeatService.getIdSeatByName(s3);
				lst_ChoosedSeat.add(idseat3);
				lst_ChoosedSeatName.add(s3);
		   }
		   if(s4!="") {
			   int idseat4 = SeatService.getIdSeatByName(s4);
				lst_ChoosedSeat.add(idseat4);
				lst_ChoosedSeatName.add(s4);
		   }
		   if(s5!="") {
			   int idseat5 = SeatService.getIdSeatByName(s5);
				lst_ChoosedSeat.add(idseat5);
				lst_ChoosedSeatName.add(s5);
		   }
		   ArrayList<String> lst_idBill= new ArrayList<String>();
		   for(int i=0;i<lst_ChoosedSeat.size();i++) {
			   final String alphabet = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			    final int N = alphabet.length();
			    Random r = new Random();
			    char[] c =  new char[5];
			    for (int j = 0; j < 5; j++) {
			        c[j]=alphabet.charAt(r.nextInt(N));  
			    }
			    String s= String.copyValueOf(c);
			    lst_idBill.add(s);
		   }
		   Session thisSession = (Session) session.getAttribute("thisSession");
		   
		   for(int i=0;i<lst_ChoosedSeatName.size();i++)
			{
			   if(lst_ChoosedSeatName.get(i)!="")
			   {
					boolean result1 = TicketService.addTicket(new Ticket(null,lst_ChoosedSeat.get(i),thisSession.getId()));
					if(result1) {
						int idNewTicket = TicketService.getIdTicketByIdSeatAndIdSession(lst_ChoosedSeat.get(i), thisSession.getId());
						Timestamp sqlDate = new Timestamp(Calendar.getInstance().getTime().getTime());
						boolean result2 = BillService.addBill(new Bill(lst_idBill.get(i),idNewTicket,idcus, sqlDate));
						if(result2) {
							String idNewBill = BillService.getIdByIdTicket(idNewTicket);
							boolean result3 = TicketService.updateNewTicket(idNewBill, idNewTicket);
							if(result3) {
							}
						}
					}
			   }
			}
		   response.sendRedirect(request.getContextPath() +"/EditRoute");
	}

}
