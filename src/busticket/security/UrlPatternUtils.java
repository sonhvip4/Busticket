package busticket.security;

import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServletRequest;

public class UrlPatternUtils {
  private static boolean hasUrlPattern(ServletContext context,String urlPattern)
  {
	  Map<String, ? extends ServletRegistration> map = context.getServletRegistrations();
	  for(String servletname:map.keySet())
	  {
		  ServletRegistration sr=map.get(servletname);
		  Collection<String> mappings=sr.getMappings();
		  if(mappings.contains(urlPattern))
			  return true;
	  }
	  return false;
  }
  
  public static String getUrlPattern(HttpServletRequest request)
  {
	  ServletContext context=request.getServletContext();
	  String servletPath=request.getServletPath();
	  String pathInfo=request.getPathInfo();
 	  String urlPattern=null;
	  if (pathInfo != null) {
	         urlPattern = servletPath + "/*";
	         return urlPattern;
	      }
	  urlPattern = servletPath;
	  boolean has = hasUrlPattern(context, urlPattern);
	  if (has) {
	         return urlPattern;
	      }
	  
	  int i = servletPath.lastIndexOf('.');
      if (i != -1) {
         String ext = servletPath.substring(i + 1);
         urlPattern = "*." + ext;
         has = hasUrlPattern(context, urlPattern);
 
         if (has) {
            return urlPattern;
         }
      }
      return "/";
	  
  }
}
