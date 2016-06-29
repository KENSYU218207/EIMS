import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import to.Employee;



public class SearchServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Employee> list = null;
		request.setCharacterEncoding("Windows-31J");
		String keyword = request.getParameter("searchkey");
		// String keyword = "����";
		// ���O�C����ʂœ��͂��ꂽ�Ј��ԍ��i�[
		String userid = request.getParameter("userid");
		// ���O�C����ʂœ��͂��ꂽ�p�X���[�h�i�[
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		// ���N�G�X�g�p�����[�^�Ɍ��������������Ă��Ȃ������ꍇ
		if (keyword == null) {
			// �O�񌟍��������Z�b�V����������o��
			keyword = (String) session.getAttribute("searchkey");
		}


		// �����������Z�b�V�����ɕۑ�
		session.setAttribute("searchkey", keyword);
		session.setAttribute("userid", userid);
		session.setAttribute("password", password);


		list = dao.EmployerDao.selectEmployees(keyword);

		System.out.println("2"+keyword);
/*
		BusinessLogic bl = new BusinessLogic();
		list = bl.selectProducts(type, keyword);
*/
//		list = dao.EmployerDao.selectEmployees(keyword);
		if (list != null) {
			request.setAttribute("searchlist", list);
		}

		// �Ɍ������ʂ�]������
	/*	request.getRequestDispatcher("http://localhost:8080/EIMS/SearchServlet").
			forward(request, response);
*/
		response.setContentType("text/html; charset=Windows-31J");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>���C���y�[�W</title>");

		out.println("<link rel=\"stylesheet\" href=\"exercise.css\" type=\"text/css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>�����y�[�W</h1>");
		// �Ј��ԍ��̕\��
		out.println(userid);
		out.println("<br>");
		// �p�X���[�h�̕\��
		out.println(password);
		out.println("<br>");
		// �p�X���[�h�̕\��
		out.println(keyword);
		out.println("<br>");
		// �e��`�F�b�N
		// password �Ɛl�����`�F�b�N
		//LogonController.sendLogon(userid, password);
		/*
		 * out.println("�p�X���[�h�`�F�b�N�F"+
		 * LogonController.sendLogon(userid,password)); out.println("<br>");
		 * out.println("�l�����`�F�b�N"+ LogonController.se);
		 */
		out.println("<br>");
		out.println("<form action=\"SearchServlet\" method=\"post\">");
		out.println("<input type=\"text\" name=\"searchkey\" size=\"20\" value=\"\">");
		out.println("<input type=\"submit\" value=\"����\">");
		out.println("</form>");

		if (dao.EmployerDao.checkJinji(userid)) {
			out.println("<form action=\"AddServlet\" method=\"post\">");
			out.println("<input type=\"submit\" value=\"�ǉ�\">");
			out.println("</form>");
		}
		out.println("<br>");
		if (dao.EmployerDao.checkJinji(userid)) {
			out.println("<form action=\"EditServlet\" method=\"post\">");
			out.println("<input type=\"submit\" value=\"�ύX\">");
			out.println("</form>");
		}
		out.println("<br>");

		int count = 0;
		if (list != null) {
			count = list.size();
		}

		out.println("�������ʁF" + count + "��");
		out.println("<table width=\"98%\" border=\"0\">");
		out.println("<tr>");
		out.println("<th width=\"10%\">�Ј��ԍ�</th>");
		out.println("<th width=\"10%\">��</th>");
		out.println("<th width=\"10%\">���i�t���K�i�j</th>");
		out.println("<th width=\"10%\">��</th>");
		out.println("<th width=\"10%\">���i�t���K�i�j</th>");
		out.println("<th width=\"10%\">������</th>");

		// out.println("<th width=\"30%\">������</th>");
		// out.println("<th rowspan=\"2\">���i�w��</th>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("</tr>");
		for (int i = 0; i < count; i++) {
			int id = 0;
			String fname = "";
			String fkana = "";
			String lname = "";
			String lkana = "";
			String pass = "";
			int dept = 0;
			int gender = 99;

			Employee data = (Employee) list.get(i);

			if (data != null) {
				id = data.getEmpno();
				fname = data.getFname();
				fkana = data.getFkana();
				lname = data.getLname();
				lkana = data.getLkana();
				dept = data.getEmpno();
				gender = data.getGender();
				pass = data.getPassword();
				System.out.println(pass);
			}
			out.println("<tr class=\"emp\">");
			out.println("<td width=\"10%\">" + id + "</td>");
			out.println("<td width=\"10%\">" + lname + "</td>");
			out.println("<td width=\"10%\">" + lkana + "</td>");
			out.println("<td width=\"10%\">" + fname + "</td>");
			out.println("<td width=\"10%\">" + fkana + "</td>");
			out.println("<td width=\"10%\">" + dept + "</td>");
			out.println("<td rowspan=\"2\" align=\"center\" valign=\"middle\">");
			out.println("<form action=\"DeleteConfirmServlet\" method=\"post\">");
			out.println("<input type=\"hidden\" name=\"emp_id\" value=\"" + id + "\">");
			out.println("<input type=\"hidden\" name=\"emp_lname\" value=\"" + lname+ "\">");
			out.println("<input type=\"hidden\" name=\"emp_lkana\" value=\"" + lkana + "\">");
			out.println("<input type=\"hidden\" name=\"emp_fname\" value=\"" + fname+ "\">");
			out.println("<input type=\"hidden\" name=\"emp_fkana\" value=\"" + fkana + "\">");
			out.println("<input type=\"hidden\" name=\"emp_dept\" value=\"" + dept + "\">");
			out.println("<input type=\"hidden\" name=\"emp_gender\" value=\"" + gender + "\">");
			out.println("<input type=\"hidden\" name=\"emp_passr\" value=\"" + pass + "\">");
			out.println("<input type=\"submit\" name=\"submit\" value=\"�폜\">");
			out.println("</form>");
			out.println("</td>");
			out.println("<td rowspan=\"2\" align=\"center\" valign=\"middle\">");
			out.println("<form action=\"EditServlet\" method=\"post\">");
			out.println("<input type=\"hidden\" name=\"emp_id\" value=\"" + id + "\">");
			out.println("<input type=\"hidden\" name=\"emp_lname\" value=\"" + lname+ "\">");
			out.println("<input type=\"hidden\" name=\"emp_lkana\" value=\"" + lkana + "\">");
			out.println("<input type=\"hidden\" name=\"emp_fname\" value=\"" + fname+ "\">");
			out.println("<input type=\"hidden\" name=\"emp_fkana\" value=\"" + fkana + "\">");
			out.println("<input type=\"hidden\" name=\"emp_dept\" value=\"" + dept + "\">");
			out.println("<input type=\"hidden\" name=\"emp_gender\" value=\"" + gender + "\">");
			out.println("<input type=\"hidden\" name=\"emp_pass\" value=\"" + pass + "\">");
			out.println("<input type=\"submit\" name=\"submit\" value=\"�ύX\">");
			out.println("</form>");
			out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			/*
			 * out.println("<td colspan=\"3\"><span class=\"description\">" +
			 * description + "</span></td>");
			 */
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}