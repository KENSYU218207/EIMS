

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import to.Employee;

/**
 * Servlet implementation class Add
 */
public class EditServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Employee> list = null;

		request.setCharacterEncoding("Windows-31J");

		//���O�C����ʂœ��͂��ꂽ�Ј��ԍ��i�[

//		String userid = request.getParameter("userid");

//		HttpSession session = request.getSession();
//		session.setAttribute("userid", userid);

/*
		BusinessLogic bl = new BusinessLogic();
		list = bl.selectProducts(type, keyword);
*/

//		list = dao.EmployerDao.selectEmployees();


		response.setContentType("text/html; charset=Windows-31J");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>�Ј����ҏW</title>");

		out.println
		("<link rel=\"stylesheet\" href=\"exercise.css\" type=\"text/css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>�ύX�y�[�W</h1>");
		//�Ј��ԍ��̕\��
//		out.println(userid);
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
//		out.println("�l�����`�F�b�N"+dao.EmployerDao.checkJinji(userid));

		out.println("<form action=\"SearchServlet\" method=\"post\">");
		 out.println("���F<input type=\"text\" name=\"addlname\" size=\"20\"><br>");
		 out.println("���F<input type=\"text\" name=\"addfname\" size=\"20\"><br>");
		 out.println("��(�J�i)�F<input type=\"text\" name=\"addlkana\" size=\"20\"><br>");
		 out.println("��(�J�i)�F<input type=\"text\" name=\"addfkana\" size=\"20\"><br>");
		 out.println("�p�X���[�h�F<input type=\"password\" name=\"addpassword\" size=\"20\"><br>");
		 out.println("���ʁF<input type=\"radio\" name=\"addgender\" value=\"1\">�j��    <input type=\"radio\" name=\"addgender\" value=\"2\">����<br>");
		 out.println("������F<select name=\"adddept\"><option value=\"none\">-</option><option value=\"100\">�l����</option><option value=\"200\">�o����</option><option value=\"300\">�c�ƕ�</option><option value=\"400\">��敔</option><option value=\"500\">�J����</option><option value=\"600\">������</option></select><br>");
		 out.println("<input type=\"submit\" value=\"�ύX����\">");
		 out.println("</form>");

		out.println("<br>");

		out.println("<br>");

		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
