package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;
public class JDBCUtil {
	public static Connection getConnection() throws SQLException {
		Connection c = null;
		DriverManager.registerDriver(new Driver());
		String url = "jdbc:mySQL://localhost:3306/account";
		String user = "log2408";
		String password = "2408";
		c = DriverManager.getConnection(url, user, password);
		return c;
	}
	public static void closeConnection(Connection c) throws SQLException {
		if(c != null) {
			c.close();
		}
	}
}
