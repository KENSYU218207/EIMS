
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
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Employee> list = null;

		request.setCharacterEncoding("Windows-31J");

		String emptno = request.getParameter("emptno");

		HttpSession session = request.getSession();

		// 検索条件をセッションに保存
		session.setAttribute("emptno", emptno);

		list = dao.EmployerDao.deleteSelectEmployees(emptno);

		if (list != null) {
			request.setAttribute("searchlist", list);
		}

		response.setContentType("text/html; charset=Windows-31J");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>社員情報削除</title>");

		out.println("<link rel=\"stylesheet\" href=\"exercise.css\" type=\"text/css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>削除ページ</h1>");
		// 社員番号の表示
		out.println("empno");
		out.println("<br>");

		int count = 0;
		if (list != null) {
			count = list.size();
		}

		out.println("検索結果：" + count + "件");
		out.println("<table width=\"98%\" border=\"0\">");
		out.println("<tr>");
		out.println("<th width=\"20%\">社員番号</th>");
		out.println("<th width=\"20%\">氏</th>");
		out.println("<th width=\"20%\">氏（フリガナ）</th>");
		out.println("<th width=\"20%\">名</th>");
		out.println("<th width=\"20%\">名（フリガナ）</th>");

		out.println("</tr>");
		out.println("<tr>");
		out.println("</tr>");
		for (int i = 0; i < count; i++) {
			int id = 0;
			String fname = "";
			String fkana = "";
			String lname = "";
			String lkana = "";
			int description = 0;
			Employee data = (Employee) list.get(i);

			if (data != null) {
				id = data.getEmpno();
				fname = data.getFname();
				fkana = data.getFkana();
				lname = data.getLname();
				lkana = data.getLkana();

			}
			out.println("<tr class=\"product\">");
			out.println("<td width=\"20%\">" + id + "</td>");
			out.println("<td width=\"20%\">" + lname + "</td>");
			out.println("<td width=\"20%\">" + lkana + "</td>");
			out.println("<td width=\"20%\">" + fname + "</td>");
			out.println("<td width=\"20%\">" + fkana + "</td>");

			out.println("<td rowspan=\"2\" align=\"center\" valign=\"middle\">");
			out.println("<form action=\"CartServlet\" method=\"post\">");
			out.println("<input type=\"hidden\" name=\"product_id\" value=\"" + id + "\">");
			out.println("<input type=\"submit\" name=\"submit\" value=\"削除\">");
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
