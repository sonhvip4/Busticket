package busticket.security;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import busticket.model.User;
import busticket.utils.AppUtils;
@WebFilter("/*")
public class SecurityFilter implements Filter {

    
    public SecurityFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest req = (HttpServletRequest) request;
		 HttpServletResponse resp = (HttpServletResponse) response;
	     
		 String servletPath = req.getServletPath();
		
		 
		 User loginedUser = AppUtils.getLoginedUser(req.getSession());
		
		 if (servletPath.equals("/Login"))
		 {
	            chain.doFilter(request, response);
	            return;
	        }
	        HttpServletRequest wrapRequest = null;
	        		if(req != null)
	        		{
	        			wrapRequest = req;
	        		}
	         
	 
	        if (loginedUser != null) {
	            // User Name
 	            String userName = loginedUser.getUserName();
 	            String roles = null;
 	            if (loginedUser.getRoleObject()!= null) {
 	            	roles = loginedUser.getRoleObject().getRoleName();
 	            }
	            
	            
	            wrapRequest = new UserRoleRequestWrapper(userName, roles, req);
	            
	        }
	 
	       
	        if (SecurityUtils.isSeacurityPage(req)) {
	        	  
	        	 
	            if (loginedUser == null) {
	            	
	                String requestUri = catChuoi(wrapRequest.getContextPath(),req.getRequestURL()+"?"+req.getQueryString());
	                
	                int redirectId = AppUtils.storeRedirectAfterLoginUrl(req.getSession(), requestUri);
	                resp.sendRedirect(wrapRequest.getContextPath() + "/Login?redirectId=" + redirectId);
	                return;
	            }
	          
	            boolean hasPermission = SecurityUtils.hasPermission(wrapRequest);
	            
	            if (!hasPermission) {
	 
	                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Login");
	                dispatcher.forward(request, response);
	                return;
	            }
	        }
	       
	        chain.doFilter(wrapRequest, response);
	       
	    }
	 
	     
	
	private String catChuoi(String chuoicon,String chuoiCha)
		{
			
			int index1 = chuoiCha.indexOf(chuoicon);
	        return chuoiCha.substring(index1+chuoicon.length());
		}
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}

