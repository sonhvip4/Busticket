package busticket.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import busticket.model.User;



public class AppUtils {

	private static int REDIRECT_ID = 0;

    private static final Map<Integer, String> id_uri_map = new HashMap<Integer, String>();
    private static final Map<String, Integer> uri_id_map = new HashMap<String, Integer>();
	public AppUtils() {
		
	}

    public static void storeLoginedUser(HttpSession session, User loginedUser) {

        session.setAttribute("user", loginedUser);
    }

    public static User getLoginedUser(HttpSession session) {
        User loginedUser = (User) session.getAttribute("user");
        return loginedUser;
    }
    public static int storeRedirectAfterLoginUrl(HttpSession session, String requestUri) {
        Integer id = uri_id_map.get(requestUri);
 
        if (id == null) {
            id = REDIRECT_ID++;
 
            uri_id_map.put(requestUri, id);
            id_uri_map.put(id, requestUri);
            return id;
        }
 
        return id;
    }
    public static String getRedirectAfterLoginUrl(HttpSession session, int redirectId) {
    	String url = id_uri_map.get(redirectId);
        if (url != null) {
            return url;
        }
        return null;
    }
    public static String GetHang(String a) {
    	String b[]=a.split("_");
    	return b[0];
    }
    public static int GetCot(String a) {
    	String b[]=a.split("_");
    	return Integer.parseInt(b[1]);
    }
}
