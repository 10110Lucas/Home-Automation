package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
	
	public static Connection connection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/arduino_Java","root","");
			
		}catch (ClassNotFoundException | SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public static void desconecta(Connection conn){
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException e){
				Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		desconecta(conn);
	}
	
	public static void desconecta(Connection conn, PreparedStatement pst) {
		if(pst != null) {
			try {
				pst.close();
			}catch(SQLException e) {
				Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		desconecta(conn);
	}
	
	public static void desconecta(Connection conn, PreparedStatement pst, ResultSet rs){
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException e){
				Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		desconecta(conn, pst);
	}
}
