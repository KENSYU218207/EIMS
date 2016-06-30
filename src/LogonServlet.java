
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
public class LogonServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Employee> list = null;

		request.setCharacterEncoding("Windows-31J");

		//���O�C����ʂœ��͂��ꂽ�Ј��ԍ��i�[
		String userid = request.getParameter("userid");
		//���O�C����ʂœ��͂��ꂽ�p�X���[�h�i�[
		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		session.setAttribute("userid", userid);
		session.setAttribute("password", password);

		/*
		 * BusinessLogic bl = new BusinessLogic();
		 * list = bl.selectProducts(type, keyword);
		 */
		//		list = dao.EmployerDao.selectEmployees();

		response.setContentType("text/html; charset=Windows-31J");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<TITLE>���O�C���y�[�W</TITLE>");
		out.println("<LINK rel=\"stylesheet\"href=\"exercise.css\" type=\"text/css\">");

		out.println("</head>");
		out.println("<body>");
		out.println("<h1>���O�C���y�[�W</h1>");
		out.println("<form action=\"SearchServlet\" method=\"post\">");
		out.println("�Ј��ԍ��F<input type=\"text\" name=\"userid\" size=\"20\"><br>");
		out.println("�p�X���[�h�F<input type=\"password\" name=\"password\" size=\"20\"><br>");
		out.println("<input type=\"submit\" value=\"���O�C��\" onClick=\"disp()\"> ");
		out.println("</form>");
		out.println(" </body>");
		out.println("</html>");
		out.close();
	}

}
