package controller;

import java.util.ArrayList;

import to.Employee;
import dao.EmployerDao;

//�����̍ۂɕK�v�Ȑ���N���X
public class SearchController {
	// (����)������ʂł̓��͏����Ј�DAO�Ɉ����n���A�������ʂ̎Ј����X�g�̎擾���˗�


	public static ArrayList<Employee> selectEmployees(String keyword) {
		return dao.EmployerDao.selectEmployees(keyword);
	}

	public static boolean checkJinji(String id) {
		return dao.EmployerDao.checkJinji(id);
	}
}
