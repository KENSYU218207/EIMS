package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;

import to.Employee;
import to.Product;

public class EmployerDao {
	private static Connection con; // �R�l�N�V����

	public EmployerDao(Connection con) {
		this.con = con;
	}

	public static boolean checkPassword(String id,String password){

		Statement stmt = null;
		ResultSet res = null;
		try {
			//Connection�̐ݒ�
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/eimsdb", "eimsuser", "eimspass");
//			ConnectionManager cm = ConnectionManager.getConnectionManager();
//			con = cm.getConnection();

			//SQL���̐ݒ�i�����Ă����Ј��ԍ��Ɉ�v����l���擾�j
			String sql = "SELECT "
					+ "password "
					+ "FROM employee WHERE empno="
					+id+" ";

			//SQL��������
			stmt = con.createStatement();
			res = stmt.executeQuery(sql);

			//�擾�����f�[�^�����ԂɎQ��
			while(res.next()){
				//��v����p�X���[�h�������true��Ԃ�
				if(res.getString("password").equals(password))return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		}

		//�N�ɂ�����������Ȃ����false��Ԃ�
		return false;
	}

	public static boolean checkJinji(String id) {

		Statement stmt = null;
		ResultSet res = null;
		try {
			//Connection�̐ݒ�
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/eimsdb", "eimsuser", "eimspass");
//			ConnectionManager cm = ConnectionManager.getConnectionManager();
//			con = cm.getConnection();

			//SQL���̐ݒ�i�����Ă����Ј��ԍ��Ɉ�v����l���擾�j
			String sql = "SELECT "
					+ "empno, employee.deptno, deptname "
					+ "FROM employee "
					+ "LEFT OUTER JOIN department "
					+ "ON employee.deptno = department.deptno "
					+ "WHERE employee.empno="
					+id+" ";

			//SQL��������
			stmt = con.createStatement();
			res = stmt.executeQuery(sql);

			//�擾�����f�[�^�����ԂɎQ��
			while(res.next()){
				//�l�����̐l�������true��Ԃ�
				if(res.getString("deptname").equals("�l����"))return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		}

		//�N�ɂ�����������Ȃ����false��Ԃ�
		return false;
	}

	public static ArrayList<Employee> selectEmployees() {
		ArrayList<Employee> array = null;
		Statement stmt = null;
		ResultSet res = null;

		try {
			String sql = "SELECT * FROM employee ";

			stmt = con.createStatement();
			res = stmt.executeQuery(sql);

			while (res.next()) {
				if (array == null) {
					array = new ArrayList<Employee>();
				}

				Employee data = new Employee();

				data.setId(res.getString("empno"));

				array.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return array;
	}

}
