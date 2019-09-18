package busticket.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import busticket.service.SeatService;

/**
 * Servlet implementation class ConfirmController
 */
@WebServlet("/Confirm")
public class ConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmController() {
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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Integer> lst_ChoosedSeat = new ArrayList<Integer>();
		ArrayList<String> lst_ChoosedSeatName= new ArrayList<String>();
		   String s1 = request.getParameter("seat1");
		   String s2 = request.getParameter("seat2");
		   String s3 = request.getParameter("seat3");
		   String s4 = request.getParameter("seat4");
		   String s5 = request.getParameter("seat5");
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
		   
		   HttpSession session = request.getSession();
		   session.setAttribute("lst_chooseSeatName", lst_ChoosedSeatName);
		   session.setAttribute("listChoosedSeat",lst_ChoosedSeat);
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
		   session.setAttribute("lst_idBill", lst_idBill);
		   RequestDispatcher dispatcher 
	        = this.getServletContext()//
	              .getRequestDispatcher("/WEB-INF/views/CustomerView/Confirm.jsp");
			 dispatcher.forward(request, response);
	}

}
