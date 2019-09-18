package busticket.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import busticket.model.ProfileManager;
import busticket.service.ProfileManagerService;

/**
 * Servlet implementation class ChangeProfileSellerController
 */
@WebServlet("/ChangeProfileSeller")
public class ChangeProfileSellerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeProfileSellerController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		HttpSession session= request.getSession();
		ProfileManager pm = (ProfileManager) session.getAttribute("pm");
		String name = request.getParameter("name");
		Date birthDate = null;
		try {
			birthDate = new java.sql.Date(sdf.parse(request.getParameter("birthDate")).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String gender= request.getParameter("gender");
		String phoneNumber= request.getParameter("phoneNumber");
		ProfileManager pmn= new ProfileManager(pm.getId(),name, birthDate, gender, phoneNumber,true, pm.getIdUser());
		ProfileManagerService.updateProfileManager(pmn);
		session.setAttribute("pm",pmn);
		request.setAttribute("mess",1);
		RequestDispatcher dispatcher //
        = this.getServletContext().getRequestDispatcher("/WEB-INF/views/SellerView/ProfileSeller.jsp");
		dispatcher.forward(request, response);
	}

}
