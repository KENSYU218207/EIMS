package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import to.Employee;

public class LogonController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("Windows-31J");

		// ���O�C����ʂœ��͂��ꂽ�Ј��ԍ��i�[
		String userid = request.getParameter("userid");
		// ���O�C����ʂœ��͂��ꂽ�p�X���[�h�i�[
		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		// �Z�b�V�����ɕۑ�
		session.setAttribute("userid", userid);
		session.setAttribute("password", password);

		boolean bool = sendLogon(userid, password);

		// ���O�C������
		if (bool == true) {
			session.setAttribute("login", "OK");
			String target = (String)session.getAttribute("target");
			response.sendRedirect(target);
		}
		//���O�C�����s
		else {
			session.setAttribute("status", "NO");
			response.sendRedirect("C:/workspac/EIMS/src/LogonServlet");
		}

	}

	// ���\�b�h�F���O�I�����˗�����
	public static boolean sendLogon(String userid, String password) {
		// ���O�I����ʂœ��͂��ꂽ[�Ј��ԍ��E�p�X���[�h]���Ј�DAO�Ɉ����n��

		// �Ј��I�u�W�F�N�g�̃C���X�^���X�𐶐�
		Employee emp = new Employee(userid, password);

		// �F�؃G���[�̏ꍇ�A�|�b�v�A�b�v�\��
		if (dao.EmployerDao.checkPassword(userid, password) == false) {
			System.out.println("error password");
			return false;
		}

		// �Ј����l���ł���ꍇ�A�ǉ��폜�ύX���\�ɂ���
		if (dao.EmployerDao.checkJinji(userid)) {
			System.out.println("you are jinji");
		}
		return true;
	}

	// ���\�b�h�F���O�A�E�g���˗�����
	// ���O�I�����Ă����Ԃ̃��[�U���A���O�A�E�g�����ꍇ�ɌĂяo�����
	public void sendLogout() {
		// �Ј��I�u�W�F�N�g�̔j��

		// ��������iSearchController�j�ɁA�������ʂ̎Ј����X�g�̔j�����˗�

	}
}
