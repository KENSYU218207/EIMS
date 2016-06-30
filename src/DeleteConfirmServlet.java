import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//�폜�̍ۂɕK�v�Ȑ���N���X
public class DeleteConfirmServlet extends HttpServlet {
	// �폜�{�^�����������ꂽ���ɌĂяo�����

	// (�폜)������ʂł̓��͏����Ј�DAO�Ɉ����n���A�Ј����̍폜���˗�
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("Windows-31J");

		// �폜�{�^���������ꂽ�Ƃ��Ɉ����n�����l
		String id = request.getParameter("emp_id");
		String lname = request.getParameter("emp_lname");
		String lkana = request.getParameter("emp_lkana");
		String fname = request.getParameter("emp_fname");
		String fkana = request.getParameter("emp_fkana");

		HttpSession session = request.getSession();
		session.setAttribute("emp_id", id);
		session.setAttribute("emp_lname", lname);
		session.setAttribute("emp_lkana", lkana);
		session.setAttribute("emp_fname", fname);
		session.setAttribute("emp_fkana", fkana);

		// HTML�����J�n
		response.setContentType("text/html; charset=Windows-31J");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>�Ј����폜�m�F</title>");
		out.println("<link rel=\"stylesheet\" href=\"exercise.css\" type=\"text/css\">");
		out.println("</head>");
		out.println("<body>");

		out.println("<form action=\"DeleteController\" method=\"post\">");
		out.println("<h2>�ȉ��̏����폜���܂��B�{���ɂ�낵���ł����H</h2>");
		out.println(id);
		out.println("<br>");
		out.println(lname);
		out.println("<br>");
		out.println(fname);
		out.println("<br>");
		out.println(lkana);
		out.println("<br>");
		out.println(fkana);
		out.println("<br>");

		out.println("<input type=\"hidden\" name=\"empno\" value=\"" + id + "\" />");
		out.println("<input type=\"hidden\" name=\"lname\" value=\"" + lname + "\" />");
		out.println("<input type=\"hidden\" name=\"fname\" value=\"" + fname + "\" />");
		out.println("<input type=\"hidden\" name=\"lkana\" value=\"" + lkana + "\" />");
		out.println("<input type=\"hidden\" name=\"fkana\" value=\"" + fkana + "\" />");
		out.println("<input type=\"submit\" value=\"�폜����\">");
	 	 out.println("<form action=\"SearchServlet\" method=\"post\">");
		 out.println("<input type=\"submit\" value=\"�L�����Z��\">");
		 out.println("</form>");
		out.println("</form>");

		out.print("<a href=\"SearchServlet\">�߂�</a>");

		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
