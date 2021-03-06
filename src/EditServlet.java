
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		System.out.println(password);

		if (id == null || lname == null || fname == null || lkana == null || fkana == null || password == null
				|| gender == null || dept == null) {
			id = "";
			lname = "";
			fname = "";
			lkana = "";
			fkana = "";
			password = "";
			gender = "";
			dept = "";
		}

		// ログイン画面で入力された社員番号格納

		// String userid = request.getParameter("userid");

		// HttpSession session = request.getSession();
		// session.setAttribute("userid", userid);

		/*
		 * BusinessLogic bl = new BusinessLogic(); list =
		 * bl.selectProducts(type, keyword);
		 */

		// list = dao.EmployerDao.selectEmployees();

		response.setContentType("text/html; charset=Windows-31J");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>社員情報編集</title>");

		out.println("<link rel=\"stylesheet\" href=\"exercise.css\" type=\"text/css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>変更</h1>");

		// out.println(password);
		// out.println("<br>");

		out.println("社員番号：" + id);
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
		// out.println("人事部チェック"+dao.EmployerDao.checkJinji(userid));

		out.println("<form action=\"EditConfirmServlet\" method=\"post\">");
		out.println("氏：<input type=\"text\" name=\"editlname\" size=\"20\" value=\"" + lname + "\"><br><br>");
		out.println("名：<input type=\"text\" name=\"editfname\" size=\"20\" value=\"" + fname + "\"><br><br>");
		out.println("氏(カナ)：<input type=\"text\" name=\"editlkana\" size=\"20\" value=\"" + lkana + "\"><br><br>");
		out.println("名(カナ)：<input type=\"text\" name=\"editfkana\" size=\"20\" value=\"" + fkana + "\"><br><br>");
		out.println(
				"パスワード：<input type=\"password\" name=\"editpassword\" size=\"20\" value=\"" + password + "\"><br><br>");
		// out.println("性別：<input type=\"radio\" name=\"editgender\"
		// value=\"1\">男性 <input type=\"radio\" name=\"addgender\"
		// value=\"2\">女性<br>");
		if (gender.equals("1")) {
			out.println(
					"性別：<input type=\"radio\" name=\"editgender\" value=\"1\" checked>男性    <input type=\"radio\" name=\"addgender\" value=\"2\">女性<br>");
		} else if (gender.equals("2")) {
			out.println(
					"性別：<input type=\"radio\" name=\"editgender\" value=\"1\">男性    <input type=\"radio\" name=\"addgender\" value=\"2\" checked>女性<br>");
		} else {
			out.println(
					"性別：<input type=\"radio\" name=\"editgender\" value=\"1\">男性    <input type=\"radio\" name=\"addgender\" value=\"2\">女性<br>");
		}
		out.println("<br>");
		// out.println("所属先：<select name=\"editdept\"><option
		// value=\"none\">-</option><option value=\"100\">人事部</option><option
		// value=\"200\">経理部</option><option value=\"300\">営業部</option><option
		// value=\"400\">企画部</option><option value=\"500\">開発部</option><option
		// value=\"600\">総務部</option></select><br>");
		if (dept.equals("100")) {
			out.println(
					"所属コード：<select name=\"editdept\"><option value=\"none\">-</option><option value=\"100\" selected>100：人事部</option><option value=\"200\">200：経理部</option><option value=\"300\">300：営業部</option><option value=\"400\">400：企画部</option><option value=\"500\">500：開発部</option><option value=\"600\">600：総務部</option></select><br>");
		} else if (dept.equals("200")) {
			out.println(
					"所属コード：<select name=\"editdept\"><option value=\"none\">-</option><option value=\"100\">100：人事部</option><option value=\"200\" selected>200：経理部</option><option value=\"300\">300：営業部</option><option value=\"400\">400：企画部</option><option value=\"500\">500：開発部</option><option value=\"600\">600：総務部</option></select><br>");
		} else if (dept.equals("300")) {
			out.println(
					"所属コード：<select name=\"editdept\"><option value=\"none\">-</option><option value=\"100\">100：人事部</option><option value=\"200\">200：経理部</option><option value=\"300\" selected>300：営業部</option><option value=\"400\">400：企画部</option><option value=\"500\">500：開発部</option><option value=\"600\">600：総務部</option></select><br>");
		} else if (dept.equals("400")) {
			out.println(
					"所属コード：<select name=\"editdept\"><option value=\"none\">-</option><option value=\"100\">100：人事部</option><option value=\"200\">200：経理部</option><option value=\"300\">300：営業部</option><option value=\"400\" selected>400：企画部</option><option value=\"500\">500：開発部</option><option value=\"600\">600：総務部</option></select><br>");
		} else if (dept.equals("500")) {
			out.println(
					"所属コード：<select name=\"editdept\"><option value=\"none\">-</option><option value=\"100\">100：人事部</option><option value=\"200\">200：経理部</option><option value=\"300\">300：営業部</option><option value=\"400\">400：企画部</option><option value=\"500\" selected>500：開発部</option><option value=\"600\">600：総務部</option></select><br>");
		} else if (dept.equals("600")) {
			out.println(
					"所属コード：<select name=\"editdept\"><option value=\"none\">-</option><option value=\"100\">100：人事部</option><option value=\"200\">200：経理部</option><option value=\"300\">300：営業部</option><option value=\"400\">400：企画部</option><option value=\"500\">500：開発部</option><option value=\"600\" selected>600：総務部</option></select><br>");
		} else {
			out.println(
					"所属コード：<select name=\"editdept\"><option value=\"none\">-</option><option value=\"100\">100：人事部</option><option value=\"200\">200：経理部</option><option value=\"300\">300：営業部</option><option value=\"400\">400：企画部</option><option value=\"500\">500：開発部</option><option value=\"600\">600：総務部</option></select><br>");
		}
		out.println("<br>");
		out.println("<input type=\"hidden\" name=\"emp_id\" value=\"" + id + "\">");
		out.println("<input class=\"button\" type=\"submit\" value=\"変更する\">");
		out.println("</form>");
		out.println("<form action=\"SearchServlet\" method=\"post\">");
		out.println("<input class=\"button\" type=\"submit\" value=\"キャンセル\">");
		out.println("</form>");

		out.println("<br>");

		out.println("<br>");

		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
