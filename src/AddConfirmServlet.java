import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import to.Employee;

public class AddConfirmServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ArrayList<Employee> list = null;

		request.setCharacterEncoding("Windows-31J");

		//�ǉ���ʂœ��͂��ꂽ���i�[
		String empno = request.getParameter("addempno");
		String lname = request.getParameter("addlname");
		String fname = request.getParameter("addfname");
		String lkana = request.getParameter("addlkana");
		String fkana = request.getParameter("addfkana");
		String password = request.getParameter("addpassword");
		String gender = request.getParameter("addgender");
		String deptno = request.getParameter("adddeptno");


		HttpSession session = request.getSession();
		session.setAttribute("addempno", empno);
		session.setAttribute("addlname", lname);
		session.setAttribute("addfname", fname);
		session.setAttribute("addlkana", lkana);
		session.setAttribute("addfkana", fkana);
		session.setAttribute("addpassword", password);
		session.setAttribute("addgender", gender);
		session.setAttribute("adddeptno", deptno);



/*
		BusinessLogic bl = new BusinessLogic();
		list = bl.selectProducts(type, keyword);
*/
//		list = dao.EmployerDao.selectEmployees();

		response.setContentType("text/html; charset=Windows-31J");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>�Ј����ǉ��m�F</title>");

		out.println
		("<link rel=\"stylesheet\" href=\"exercise.css\" type=\"text/css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>�ǉ��m�F�y�[�W</h1>");
		//�Ј��ԍ��̕\��
//		out.println(userid);
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
//		out.println("�l�����`�F�b�N"+dao.EmployerDao.checkJinji(userid));

//		out.println("<form action=\"SearchServlet\" method=\"post\">");
		out.println("<h2>�ȉ��̏��œo�^���܂��B��낵���ł����H</h2>");
		out.println(empno);
		out.println("<br>");
		out.println(lname);
		out.println("<br>");
		out.println(fname);
		out.println("<br>");
		out.println(lkana);
		out.println("<br>");
		out.println(fkana);
		out.println("<br>");
		out.println(gender);
		out.println("<br>");
		out.println(deptno);
		out.println("<br>");

		out.println("<input type=\"hidden\" name=\"empno\" value=\""+empno+"\" />");
		out.println("<input type=\"hidden\" name=\"lname\" value=\""+lname+"\" />");
		out.println("<input type=\"hidden\" name=\"fname\" value=\""+fname+"\" />");
		out.println("<input type=\"hidden\" name=\"lkana\" value=\""+lkana+"\" />");
		out.println("<input type=\"hidden\" name=\"fkana\" value=\""+fkana+"\" />");
		out.println("<input type=\"hidden\" name=\"password\" value=\""+password+"\" />");
		out.println("<input type=\"hidden\" name=\"gender\" value=\""+gender+"\" />");
		out.println("<input type=\"hidden\" name=\"deptno\" value=\""+deptno+"\" />");
		 out.println("<input type=\"submit\" value=\"�ǉ�����\">");
		 out.println("</form>");

		out.println("<br>");

		out.println("<br>");

		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
