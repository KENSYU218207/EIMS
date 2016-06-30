
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Add
 */
public class LogonServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("Windows-31J");

		// ���O�C����ʂœ��͂��ꂽ�Ј��ԍ��i�[
		String userid = request.getParameter("userid");
		// ���O�C����ʂœ��͂��ꂽ�p�X���[�h�i�[
		String password = request.getParameter("password");

		HttpSession session = request.getSession(true);

		session.setAttribute("userid", userid);
		session.setAttribute("password", password);

		response.setContentType("text/html; charset=Windows-31J");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<TITLE>���O�C���y�[�W</TITLE>");
		out.println("<LINK rel=\"stylesheet\"href=\"exercise.css\" type=\"text/css\">");

		out.println("</head>");
		out.println("<body>");

		out.println("<div class=\"topDown\">");
		out.println("<h1>Login</h1>");

		Object status = session.getAttribute("status");
		if (status != null) {
			out.println("<p>�F�؂Ɏ��s���܂���</p>");
			out.println("<p>�ēx���[�U�[���ƃp�X���[�h����͂��ĉ�����</p>");

			session.setAttribute("status", null);
		}

		out.println("<form action=\"LogonController\" method=\"post\">");

		out.println("�Ј��ԍ��F<input type=\"text\" name=\"userid\" size=\"20\"><br><br>");
		out.println("�p�X���[�h�F<input type=\"password\" name=\"password\" size=\"20\"><br><br>");
		out.println("<input class=\"button\" type=\"submit\" value=\"���O�C��\">");

		out.println("</form>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
