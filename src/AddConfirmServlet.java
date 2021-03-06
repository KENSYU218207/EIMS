import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddConfirmServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ArrayList<Employee> list = null;

		request.setCharacterEncoding("Windows-31J");

		// 追加画面で入力された情報格納
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
		 * BusinessLogic bl = new BusinessLogic(); list =
		 * bl.selectProducts(type, keyword);
		 */
		// list = dao.EmployerDao.selectEmployees();

		response.setContentType("text/html; charset=Windows-31J");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>社員情報追加確認</title>");
		out.println("<link rel=\"stylesheet\" href=\"exercise.css\" type=\"text/css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>追加確認ページ</h1>");
		// 社員番号の表示
		// out.println(userid);
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
		// out.println("人事部チェック"+dao.EmployerDao.checkJinji(userid));

		out.println("<form action=\"AddController\" method=\"post\">");
		out.println("<h2>以下の情報で登録します。よろしいですか？</h2>");
		out.println("社員番号：" + empno);
		out.println("<br><br>");
		out.println("氏：" + lname);
		out.println("<br><br>");
		out.println("名：" + fname);
		out.println("<br><br>");
		out.println("氏(カナ)：" + lkana);
		out.println("<br><br>");
		out.println("名(カナ)：" + fkana);
		out.println("<br><br>");
		out.println("性別：" + gender);
		out.println("<br><br>");
		out.println("所属コード" + deptno);
		out.println("<br><br>");

		out.println("<input type=\"hidden\" name=\"empno\" value=\"" + empno + "\" />");
		out.println("<input type=\"hidden\" name=\"lname\" value=\"" + lname + "\" />");
		out.println("<input type=\"hidden\" name=\"fname\" value=\"" + fname + "\" />");
		out.println("<input type=\"hidden\" name=\"lkana\" value=\"" + lkana + "\" />");
		out.println("<input type=\"hidden\" name=\"fkana\" value=\"" + fkana + "\" />");
		out.println("<input type=\"hidden\" name=\"password\" value=\"" + password + "\" />");
		out.println("<input type=\"hidden\" name=\"gender\" value=\"" + gender + "\" />");
		out.println("<input type=\"hidden\" name=\"deptno\" value=\"" + deptno + "\" />");
		out.println("<input  class=\"button\" type=\"submit\" value=\"追加する\">");
		out.println("</form>");
		out.println("<form action=\"AddServlet\" method=\"post\">");
		out.println("<input type=\"hidden\" name=\"addempno\" value=\"" + empno + "\" />");
		out.println("<input type=\"hidden\" name=\"addlname\" value=\"" + lname + "\" />");
		out.println("<input type=\"hidden\" name=\"addfname\" value=\"" + fname + "\" />");
		out.println("<input type=\"hidden\" name=\"addlkana\" value=\"" + lkana + "\" />");
		out.println("<input type=\"hidden\" name=\"addfkana\" value=\"" + fkana + "\" />");
		out.println("<input type=\"hidden\" name=\"addpassword\" value=\"" + password + "\" />");
		out.println("<input type=\"hidden\" name=\"addgender\" value=\"" + gender + "\" />");
		out.println("<input type=\"hidden\" name=\"adddeptno\" value=\"" + deptno + "\" />");
		out.println("<input  class=\"button\" type=\"submit\" value=\"キャンセル\">");
		out.println("</form>");

		out.println("<br>");

		out.println("<br>");

		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
