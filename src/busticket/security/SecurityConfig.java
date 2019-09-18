package busticket.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SecurityConfig {

	private static final Map<String,List<String>> map=new HashMap<String,List<String>>();
		static {
			init();
		}
		private static void init()
		{
			// Config for admin
			List<String> urlPatternsAD=new ArrayList<String>();
//			urlPatternsAD.add("/HomeCustomer");
//			urlPatternsAD.add("/FindRoute");
//			urlPatternsAD.add("/AddRoute");
//			urlPatternsAD.add("/Confirm");
//			urlPatternsAD.add("/AddBill");
//			urlPatternsAD.add("/ListTicket");
//			urlPatternsAD.add("/DeleteTicket");
//			urlPatternsAD.add("/ProfileCustomer");
//			urlPatternsAD.add("/Logout");
			

			
			// Config for seller
			List<String> urlPatternsSel=new ArrayList<String>();
//			urlPatternsSel.add("/SellerHome");
//			urlPatternsSel.add("/ManageRoute");
//			urlPatternsSel.add("/SellerBookTicket");
//			urlPatternsSel.add("/SellerBooking");
//			urlPatternsSel.add("/EditRoute");
//			urlPatternsSel.add("/FilterRoute");
//			urlPatternsSel.add("/ChangeProfileSeller");
//			urlPatternsSel.add("/Logout");
			
			
			// Config for customer
			List<String> urlPatternsCus=new ArrayList<String>();
//			urlPatternsCus.add("/AdminHome");
//			urlPatternsCus.add("/UserMan");
//			urlPatternsCus.add("/AdminChangeUser");
//			urlPatternsCus.add("/AdminCreateUser");
//			urlPatternsCus.add("/AdminEdit");
//			urlPatternsCus.add("/UpdateRoute");
//			urlPatternsCus.add("/ChangeProfileAd");
//			urlPatternsCus.add("/Logout");


			
			
			map.put("admin", urlPatternsAD);
			map.put("seller",urlPatternsSel);
			map.put("customer",urlPatternsCus);
			
		
		}
		public static Set<String> getAllRoles()
		{
			return map.keySet();
		}
		public static List<String> getAllUrlPatternForRole(String role)
		{
			return map.get(role);
		}
}
