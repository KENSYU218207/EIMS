package controller;

import java.util.ArrayList;

import to.Employee;
import dao.EmployerDao;

//検索の際に必要な制御クラス
public class SearchController {
	// (検索)検索画面での入力情報を社員DAOに引き渡し、検索結果の社員リストの取得を依頼


	public static ArrayList<Employee> selectEmployees(String keyword) {
		return dao.EmployerDao.selectEmployees(keyword);
	}

	public static boolean checkJinji(String id) {
		return dao.EmployerDao.checkJinji(id);
	}
}
