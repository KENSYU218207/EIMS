package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;

import to.Product;

public class EmployerDao {
	private static Connection con; // コネクション

	public EmployerDao(Connection con) {
		this.con = con;
	}

	public static boolean checkPassword(String id,String password){

		Statement stmt = null;
		ResultSet res = null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			con=DriverManager.getConnection("jdbc:mysql://localhost/eimsdb", "eimsuser", "eimspass");
			ConnectionManager cm = ConnectionManager.getConnectionManager();
			con = cm.getConnection();

			String sql = "SELECT "
					+ "password "
					+ "FROM employee WHERE empno="
					+id+" ";

			stmt = con.createStatement();
			res = stmt.executeQuery(sql);

			while(res.next()){
				if(res.getString("password").equals(password))return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}


		return false;
	}

}
