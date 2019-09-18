package busticket.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import busticket.data.ConnectionConfigure;
public class MySqlConnUtils {

	public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
		String hostName = ConnectionConfigure.hostname;
		String dbName = ConnectionConfigure.dbName;
		String userName = ConnectionConfigure.userName;
		String password = ConnectionConfigure.password;
		
		return getMySQLConnection(hostName, dbName, userName, password);
	}

	public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password)
			throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		return MySqlConnUtils.getMySQLConnection();
	}

	public static void closeQuietly(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
		}
	}

	public static void rollbackQuietly(Connection conn) {
		try {
			conn.rollback();
		} catch (Exception e) {
		}
	}
	
	
	
	public static void main(String[] args) {
		try {
			Connection conn = MySqlConnUtils.getConnection();
			if(conn!=null) {
				System.out.println("Ok ");

			}
			else
			{
				System.out.println("Null ");
			}
		}
		catch(Exception e){
			System.out.println("Failed " +e);
		}
		
	}

}
