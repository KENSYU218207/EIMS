

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import to.Employee;

/**
 * Servlet implementation class Add
 */
public class AddServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Employee> list = null;

		request.setCharacterEncoding("Windows-31J");

		//���O�C����ʂœ��͂��ꂽ�Ј��ԍ��i�[
		String userid = request.getParameter("userid");

		HttpSession session = request.getSession();
		session.setAttribute("userid", userid);
/*
		BusinessLogic bl = new BusinessLogic();
		list = bl.selectProducts(type, keyword);
*/
//		list = dao.EmployerDao.selectEmployees();

		response.setContentType("text/html; charset=Windows-31J");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>�Ј����ǉ�</title>");

		out.println
		("<link rel=\"stylesheet\" href=\"exercise.css\" type=\"text/css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>�ǉ��y�[�W</h1>");
		//�Ј��ԍ��̕\��
		out.println(userid);
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
		out.println("�l�����`�F�b�N"+dao.EmployerDao.checkJinji(userid));

		out.println("<form action=\"SearchServlet\" method=\"post\">");
		 out.println("�Ј��ԍ��F<input type=\"text\" name=\"addlname\" size=\"20\"><br>");
		 out.println("�Ј��ԍ��F<input type=\"text\" name=\"addfname\" size=\"20\"><br>");
		 out.println("�Ј��ԍ��F<input type=\"text\" name=\"addlkana\" size=\"20\"><br>");
		 out.println("�Ј��ԍ��F<input type=\"text\" name=\"addfkana\" size=\"20\"><br>");
		 out.println("�p�X���[�h�F<input type=\"password\" name=\"addpassword\" size=\"20\"><br>");
		 out.println("���ʁF<input type=\"radio\" name=\"addgender\" value=\"male\">�j��    <input type=\"radio\" name=\"addgender\" value=\"female\">����<br>");
		 out.println("������F���X�g�{�b�N�X�������ɍ��<br>");
		 out.println("<input type=\"submit\" value=\"�ǉ�����\">");
		 out.println("</form>");

		out.println("<br>");

		out.println("<br>");

		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
