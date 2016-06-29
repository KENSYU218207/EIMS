package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import to.Employee;

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

	public static ArrayList<Employee> selectEmployees(String keyword) {
		ArrayList<Employee> array = null;
		Statement stmt = null;
		ResultSet res = null;

		try {
			boolean bool = checkType(keyword);


			String sql = null;
			if (bool == true) {
				sql = "SELECT * "
						+ "FROM employee LEFT OUTER JOIN department "
						+ "ON employee.deptno = department.deptno "
						+ "WHERE lname = " + "'" + keyword + "'" + " "
						+ "OR fname = " + "'" + keyword + "'" + " "
						+ "OR lkana = " + "'" + keyword + "'" + " "
						+ "OR fkana = " + "'" + keyword + "'" + " "
						+ "OR department.deptname = " + "'" + keyword + "'" + " "
						+ "OR employee.deptno = " + "'" + keyword + "'" + " ";
			}
			else if (bool == false) {
				sql = "SELECT * "
						+ "FROM employee LEFT JOIN department "
						+ "ON employee.deptno = department.deptno "
						+ "WHERE lname = " + "'" + keyword + "'" + " "
						+ "OR fname = " + "'" + keyword + "'" + " "
						+ "OR lkana = " + "'" + keyword + "'" +" "
						+ "OR fkana = " + "'" + keyword + "'" + " "
						+ "OR department.deptname = " + "'" + keyword + "'" + " ";
			}

			stmt = con.createStatement();
			res = stmt.executeQuery(sql);

			while (res.next()) {
				if (array == null) {
					array = new ArrayList<Employee>();
				}

				Employee data = new Employee();
				//DBの中身を取得して社員インスタンスにセットする
				data.setEmpno(res.getInt("empno"));
				data.setFname(res.getString("fname"));
				data.setFkana(res.getString("fkana"));
				data.setLname(res.getString("lname"));
				data.setLkana(res.getString("lkana"));

				array.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return array;
	}

	public static boolean checkType(String type) {

		try {
			int check = Integer.parseInt(type);
			return true;
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
	}

<<<<<<< HEAD
	public static ArrayList<Employee> deleteSelectEmployees(String emptno) {
=======
	public static boolean deleteEmployees(String empno) {
>>>>>>> 6e350a709a95a04bb856e9463f9fe2090e4f0f8c

		ArrayList<Employee> array = null;
		Statement stmt = null;
		ResultSet res = null;

		try {
<<<<<<< HEAD
			String sql = "SELECT * "
					+ "FROM employee LEFT OUTER JOIN department "
					+ "ON employee.deptno = department.deptno "
					+ "WHERE employee.deptno = " + "'" + emptno + "'" + " ";

			stmt = con.createStatement();
			res = stmt.executeQuery(sql);

			while (res.next()) {
				if (array == null) {
					array = new ArrayList<Employee>();
				}

				Employee data = new Employee();
				//DBの中身を取得して社員インスタンスにセットする
				data.setEmpno(res.getInt("empno"));
				data.setFname(res.getString("fname"));
				data.setFkana(res.getString("fkana"));
				data.setLname(res.getString("lname"));
				data.setLkana(res.getString("lkana"));

				array.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return array;
	}

	public static ArrayList<Employee> deleteEmployees(String emptno) {

		ArrayList<Employee> array = null;
		Statement stmt = null;
		ResultSet res = null;

		try {
			String sql = "SELECT * "
					+ "FROM employee LEFT OUTER JOIN department "
					+ "ON employee.deptno = department.deptno "
					+ "WHERE lname = " + "'" + emptno + "'" + " "
					+ "OR fname = " + "'" + emptno + "'" + " "
					+ "OR lkana = " + "'" + emptno + "'" + " "
					+ "OR fkana = " + "'" + emptno + "'" + " "
					+ "OR department.deptname = " + "'" + emptno + "'" + " "
					+ "OR employee.deptno = " + "'" + emptno + "'" + " ";
=======
			//Connectionの設定
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/eimsdb", "eimsuser", "eimspass");

			String sql = "DELETE FROM employee WHERE empno = " + empno + " ";
>>>>>>> 6e350a709a95a04bb856e9463f9fe2090e4f0f8c

			stmt = con.createStatement();
			res = stmt.executeQuery(sql);

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (NullPointerException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean addEmployee(Employee employee){
		int empno=employee.getEmpno();
		String lname=employee.getLname();
		String fname=employee.getFname();
		String lkana=employee.getLkana();
		String fkana=employee.getFkana();
		String password=employee.getPassword();
		int gender=employee.getGender();
		int deptno=employee.getDeptno();
		Statement stmt = null;
		//		ResultSet res = null;
		try {
			//Connectionの設定
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/eimsdb", "eimsuser", "eimspass");
			//			ConnectionManager cm = ConnectionManager.getConnectionManager();
			//			con = cm.getConnection();

			//SQL文の設定（持ってきた社員情報を追加する）
			String sql = "INSERT "
					+"employee "
					+"VALUES "
					+"("
					+empno
					+","
					+"'"+lname+"'"//lname
					+","
					+"'"+fname+"'"//fname
					+","
					+"'"+lkana+"'"//lkana
					+","
					+"'"+fkana+"'"//fkana
					+","
					+"'"+password+"'"//password
					+","
					+gender//gender
					+","
					+deptno//deptno
					+")"
					+" ";
			//System.out.println(sql);
			//SQL文投げる
			stmt = con.createStatement();
			int res = stmt.executeUpdate(sql);
			System.out.println(res);

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			//追加に失敗した場合はfalseを返す
			return false;
		} catch (NullPointerException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return false;
		}

	}

	public static boolean editEmployee(Employee employee){
		int empno=employee.getEmpno();
		String lname=employee.getLname();
		String fname=employee.getFname();
		String lkana=employee.getLkana();
		String fkana=employee.getFkana();
		String password=employee.getPassword();
		int gender=employee.getGender();
		int deptno=employee.getDeptno();
		Statement stmt = null;
		//		ResultSet res = null;
		try {
			//Connectionの設定
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/eimsdb", "eimsuser", "eimspass");
			//			ConnectionManager cm = ConnectionManager.getConnectionManager();
			//			con = cm.getConnection();

			//SQL文の設定（持ってきた社員情報を追加する）
			String sql = "UPDATE "
					+"employee "
					+"SET "
					+"lname="
					+"'"+lname+"'"//lname
					+","
					+"fname="
					+"'"+fname+"'"//fname
					+","
					+"lkana="
					+"'"+lkana+"'"//lkana
					+","
					+"fkana="
					+"'"+fkana+"'"//fkana
					+","
					+"password="
					+"'"+password+"'"//password
					+","
					+"gender="
					+gender//gender
					+","
					+"deptno="
					+deptno//deptno
					+" "
					+"WHERE "
					+"empno="
					+empno
					+" ";
			//System.out.println(sql);
			//SQL文投げる
			stmt = con.createStatement();
			int res = stmt.executeUpdate(sql);
			System.out.println(res);

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			//追加に失敗した場合はfalseを返す
			return false;
		} catch (NullPointerException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return false;
		}

	}
}

