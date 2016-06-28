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
			//Connectionの設定
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/eimsdb", "eimsuser", "eimspass");
//			ConnectionManager cm = ConnectionManager.getConnectionManager();
//			con = cm.getConnection();

			//SQL文の設定（持ってきた社員番号に一致する人を取得）
			String sql = "SELECT "
					+ "password "
					+ "FROM employee WHERE empno="
					+id+" ";

			//SQL文投げる
			stmt = con.createStatement();
			res = stmt.executeQuery(sql);

			//取得したデータを順番に参照
			while(res.next()){
				//一致するパスワードがあればtrueを返す
				if(res.getString("password").equals(password))return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//誰にも引っかからなければfalseを返す
		return false;
	}

	public static boolean checkJinji(String id) {

		Statement stmt = null;
		ResultSet res = null;
		try {
			//Connectionの設定
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/eimsdb", "eimsuser", "eimspass");
//			ConnectionManager cm = ConnectionManager.getConnectionManager();
//			con = cm.getConnection();

			//SQL文の設定（持ってきた社員番号に一致する人を取得）
			String sql = "SELECT "
					+ "empno, employee.deptno, deptname "
					+ "FROM employee "
					+ "LEFT OUTER JOIN department "
					+ "ON employee.deptno = department.deptno "
					+ "WHERE employee.empno="
					+id+" ";

			//SQL文投げる
			stmt = con.createStatement();
			res = stmt.executeQuery(sql);

			//取得したデータを順番に参照
			while(res.next()){
				//人事部の人がいればtrueを返す
				if(res.getString("deptname").equals("人事部"))return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//誰にも引っかからなければfalseを返す
		return false;
	}

}
