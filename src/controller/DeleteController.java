package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//�폜�̍ۂɕK�v�Ȑ���N���X
public class DeleteController extends HttpServlet {
	// �폜�{�^�����������ꂽ���ɌĂяo�����

	// (�폜)������ʂł̓��͏����Ј�DAO�Ɉ����n���A�Ј����̍폜���˗�
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("Windows-31J");

		// �폜�{�^���������ꂽ�Ƃ��Ɉ����n�����l
		String id = request.getParameter("empno");
		String lname = request.getParameter("lname");
		String lkana = request.getParameter("lkana");
		String fname = request.getParameter("fname");
		String fkana = request.getParameter("fkana");

		HttpSession session = request.getSession();
		session.setAttribute("empno", id);
		session.setAttribute("lname", lname);
		session.setAttribute("lkana", lkana);
		session.setAttribute("fname", fname);
		session.setAttribute("fkana", fkana);

		// HTML�����J�n
		response.setContentType("text/html; charset=Windows-31J");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>�Ј����폜�������</title>");
		out.println("<link rel=\"stylesheet\" href=\"exercise.css\" type=\"text/css\">");
		out.println("</head>");
		out.println("<body>");

//		out.println(id);
//		out.println("<br>");
//		out.println(lname);
//		out.println("<br>");
//		out.println(fname);
//		out.println("<br>");
//		out.println(lkana);
//		out.println("<br>");
//		out.println(fkana);
//		out.println("<br>");

		out.println("<br>");
		out.println("<br>");
		if (dao.EmployerDao.deleteEmployee(id)) {
			out.println("<h2>�폜���܂����B</h2>");
			out.println("<form action=\"SearchServlet\" method=\"post\">");
			 out.println("<input class=\"button\" type=\"submit\" value=\"������ʂɖ߂�\">");
			 out.println("</form>");
		} else {
			out.println("<h2>�폜�ł��܂���ł����B</h2>");
			out.println("<form action=\"DeleteConfirmServlet\" method=\"post\">");
			 out.println("<input class=\"button\" type=\"submit\" value=\"�m�F��ʂɖ߂�\">");
			 out.println("</form>");
		}

		// out.println("<h3>�����܂ł͂Ƃ肠����ok!</h3>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
