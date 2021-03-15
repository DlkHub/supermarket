package BaseDao;

import java.sql.Connection;
import java.sql.DriverManager;


public class Basedao {
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket?useUnicode=true&characterEncoding=UTF-8","root","123456789");
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
        }
}

