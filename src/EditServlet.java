

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

		String id = request.getParameter("emp_id");
		String lname = request.getParameter("emp_lname");
		String lkana = request.getParameter("emp_lkana");
		String fname = request.getParameter("emp_fname");
		String fkana = request.getParameter("emp_fkana");
		String dept = request.getParameter("emp_dept");
		String gender = request.getParameter("emp_gender");
		String password = request.getParameter("emp_pass");

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
		out.println("�Ј��ԍ��F"+id);
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
//		out.println("�l�����`�F�b�N"+dao.EmployerDao.checkJinji(userid));

		out.println("<form action=\"SearchServlet\" method=\"post\">");
		 out.println("���F<input type=\"text\" name=\"editlname\" size=\"20\" value=\"" + lname + "\"><br>");
		 out.println("���F<input type=\"text\" name=\"editfname\" size=\"20\" value=\"" + fname + "\"><br>");
		 out.println("��(�J�i)�F<input type=\"text\" name=\"editlkana\" size=\"20\" value=\"" + lkana + "\"><br>");
		 out.println("��(�J�i)�F<input type=\"text\" name=\"editfkana\" size=\"20\" value=\"" + fkana + "\"><br>");
		 out.println("�p�X���[�h�F<input type=\"password\" name=\"editpassword\" size=\"20\" value=\"" + password + "\"><br>");
		 out.println("���ʁF<input type=\"radio\" name=\"editgender\" value=\"1\">�j��    <input type=\"radio\" name=\"addgender\" value=\"2\">����<br>");
		 out.println("������F<select name=\"editdept\"><option value=\"none\">-</option><option value=\"100\">�l����</option><option value=\"200\">�o����</option><option value=\"300\">�c�ƕ�</option><option value=\"400\">��敔</option><option value=\"500\">�J����</option><option value=\"600\">������</option></select><br>");
		 out.println("<input type=\"submit\" value=\"�ύX����\">");
		 out.println("</form>");

		out.println("<br>");

		out.println("<br>");

		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
