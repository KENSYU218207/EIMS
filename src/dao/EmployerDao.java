package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import to.Employee;

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
				//DB�̒��g���擾���ĎЈ��C���X�^���X�ɃZ�b�g����
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
			//Connection�̐ݒ�
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/eimsdb", "eimsuser", "eimspass");
//			ConnectionManager cm = ConnectionManager.getConnectionManager();
//			con = cm.getConnection();

			//SQL���̐ݒ�i�����Ă����Ј�����ǉ�����j
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
System.out.println(sql);
			//SQL��������
			stmt = con.createStatement();
			int res = stmt.executeUpdate(sql);
			System.out.println(res);

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			//�ǉ��Ɏ��s�����ꍇ��false��Ԃ�
			return false;
		} catch (NullPointerException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
			return false;
		}

	}
}
