package dao;

import java.sql.Connection;

public class EmployerDao {
	private Connection con; // �R�l�N�V����

	public EmployerDao(Connection con) {
		this.con = con;
	}

	public static boolean checkPassword(String id){
		if(id.equals("1234"))return true;
		return false;
	}

}
