package controller;

import java.io.IOException;
import java.io.PrintWriter;

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

		boolean bool = false;
		if (userid.length() != 0 && password.length() != 0) {
			bool = sendLogon(userid, password);
		}

		response.setContentType("text/html; charset=Windows-31J");

		// ���O�C������
		if (bool == true) {
			session.setAttribute("login", "OK");

			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<script>");
			out.println("function goPost() { frm.submit(); }");
			out.println("</script>");
			out.println("</head>");
			out.println("<body onLoad=\"javascript:goPost();\">");
			out.println("<form method=\"post\" action=\"SearchServlet\" id=\"frm\">");
			out.println("<input type=\"hidden\" name=\"userid\" value=\"postdata\">");
			out.println("<input type=\"hidden\" name=\"password\" value=\"postdata\">");
			out.println("<input type=\"submit\"  value=\"submit\">");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			out.close();

			session.setAttribute("userid", userid);
			session.setAttribute("password", password);
			response.sendRedirect("http://localhost:8080/EIMS/SearchServlet");
		}
		//���O�C�����s
		else {
			session.setAttribute("status", "NO");
			response.sendRedirect("http://localhost:8080/EIMS/LogonServlet");
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
