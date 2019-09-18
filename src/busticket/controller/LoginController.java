package busticket.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import busticket.model.ProfileCustomer;
import busticket.model.ProfileManager;
import busticket.model.Province;
import busticket.model.User;
import busticket.service.ProfileCustomerService;
import busticket.service.ProfileManagerService;
import busticket.service.ProvinceService;
import busticket.service.UserService;
import busticket.utils.EncryptionHelper;
import busticket.utils.AppUtils;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 RequestDispatcher dispatcher 
         = this.getServletContext().getRequestDispatcher("/WEB-INF/views/LoginView/Login.jsp");
		 	dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String username = request.getParameter("userName");
		String pw= request.getParameter("passWord");
		//String password= EncryptionHelper.MD5(pw);
		User userAccount = UserService.findAccount(username, pw);
		if(userAccount == null)
		{
			String error = "Falure to login account!!";
			request.setAttribute("error", error);
			RequestDispatcher dispatcher //
            = this.getServletContext().getRequestDispatcher("/WEB-INF/views/LoginView/Login.jsp");
			dispatcher.forward(request, response);
	            return;
		}
		else {
			  int redirectId = -1;
		        try {
		            redirectId = Integer.parseInt(request.getParameter("redirectId"));
		        } catch (Exception e) {
		        }
		        String requestUri = AppUtils.getRedirectAfterLoginUrl(request.getSession(), redirectId);
		        if (requestUri != null) {
		        	RequestDispatcher dispatcher //
		            = this.getServletContext()//
		                  .getRequestDispatcher(requestUri);
		        	 dispatcher.forward(request, response);
		        } else {
		        	
					if(userAccount.getIdRoleUser()==1) {
						ProfileManager pm= ProfileManagerService.getProfileManager(userAccount.getId());
						session.setAttribute("pm", pm);
						session.setAttribute("mess", "null");
						RequestDispatcher dispatcher //
			            = this.getServletContext().getRequestDispatcher("/WEB-INF/views/AdminView/Adminpro.jsp");
						dispatcher.forward(request, response);
					}
					if(userAccount.getIdRoleUser()==2) {
						ProfileManager pm= ProfileManagerService.getProfileManager(userAccount.getId());
						session.setAttribute("pm", pm);
						session.setAttribute("seller", userAccount);
						request.setAttribute("mess",-1);
						RequestDispatcher dispatcher //
			            = this.getServletContext().getRequestDispatcher("/WEB-INF/views/SellerView/ProfileSeller.jsp");
						dispatcher.forward(request, response);
					}
					if(userAccount.getIdRoleUser()==3) {
						List<Province> lst_Province = null;
			    		lst_Province = ProvinceService.getAllProvince();
			    		session.setAttribute("user", userAccount);
			    		request.setAttribute("province", lst_Province);
			    		ProfileCustomer pc = ProfileCustomerService.getProfileByIdUser(userAccount.getId());
			    		session.setAttribute("pc", pc);
			    		RequestDispatcher dispatcher //
			            = this.getServletContext().getRequestDispatcher("/WEB-INF/views/CustomerView/HomeCustomer.jsp");
						dispatcher.forward(request, response);
					}
		        }
		}
		

		
	}

}
