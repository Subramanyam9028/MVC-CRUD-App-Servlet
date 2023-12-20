package in.ineuron.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;


public class JDBCConnection {

		
		private JDBCConnection() {
			
		}
		
		static {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static Connection getConnection ()throws SQLException, IOException {
			// TODO Auto-generated method stub

			
			
			String url= "jdbc:mysql://localhost:3306/javacourse";
			String user="root";
			String pass="Eguzk93mjs@80";
			
			
			
			
			Connection connection = DriverManager.getConnection(url, user, pass);
			
			return connection;
		}
	

}
