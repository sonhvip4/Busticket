package busticket.security;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import busticket.model.User;




public class SecurityUtils {
	public static boolean isSeacurityPage(HttpServletRequest request)
	{
		String urlPattern=UrlPatternUtils.getUrlPattern(request);
		Set<String> roles=SecurityConfig.getAllRoles();
		for(String role:roles)
		{
			List<String> urlPatterns=SecurityConfig.getAllUrlPatternForRole(role);
			if(urlPattern!=null&&urlPatterns.contains(urlPattern))
			{
				return true;
			}
			
		}
		return false;
	}
	public static boolean hasPermission(HttpServletRequest request)
	{
		
		String urlPattern= null;
		if(request != null) {
			urlPattern= UrlPatternUtils.getUrlPattern(request);
		}
				
		
		User user= (User)request.getSession().getAttribute("user");
		String roles = null;
		if(user.getRoleObject() != null) {
			roles = user.getRoleObject().getRoleName();
			}
			List<String> urlPatterns= null;
			urlPatterns = SecurityConfig.getAllUrlPatternForRole(roles);
			if(urlPatterns.contains(urlPattern))
			{
				return true;
			}
		
		
			
	
		return false;
		
	}
}
