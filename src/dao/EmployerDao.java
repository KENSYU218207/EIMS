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

	public static int checkPassword(String id){

		Statement stmt = null;
		ResultSet res = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/eimsdb", "eimsuser", "eimspass");
			String sql = "SELECT "
					+ "* "
					+ "FROM employee ";

			stmt = con.createStatement();
			res = stmt.executeQuery(sql);

			return res.getRow();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


		return 0;
	}

}
