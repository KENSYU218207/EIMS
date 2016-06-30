
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
public class AddServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Employee> list = null;

		request.setCharacterEncoding("Windows-31J");

		// ログイン画面で入力された社員番号格納

		// 追加画面で入力された情報格納
		String empno = request.getParameter("addempno");
		String lname = request.getParameter("addlname");
		String fname = request.getParameter("addfname");
		String lkana = request.getParameter("addlkana");
		String fkana = request.getParameter("addfkana");
		String password = request.getParameter("addpassword");
		String gender = request.getParameter("addgender");
		String deptno = request.getParameter("adddeptno");

		if (empno == null || lname == null || fname == null || lkana == null || fkana == null || password == null
				|| gender == null || deptno == null) {
			empno = "";
			lname = "";
			fname = "";
			lkana = "";
			fkana = "";
			password = "";
			gender = "";
			deptno = "";
		}

		HttpSession session = request.getSession();
		session.setAttribute("addempno", empno);
		session.setAttribute("addlname", lname);
		session.setAttribute("addfname", fname);
		session.setAttribute("addlkana", lkana);
		session.setAttribute("addfkana", fkana);
		session.setAttribute("addpassword", password);
		session.setAttribute("addgender", gender);
		session.setAttribute("adddeptno", deptno);


		response.setContentType("text/html; charset=Windows-31J");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>社員情報追加</title>");

		out.println("<link rel=\"stylesheet\" href=\"exercise.css\" type=\"text/css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>追加ページ</h1>");

		//社員番号の表示
		//		out.println(userid);
		out.println("<br>");

		out.println("<br>");
		out.println("<br>");
		//		out.println("人事部チェック"+dao.EmployerDao.checkJinji(userid));

		out.println("<form action=\"AddCheckController\" method=\"post\">");
		out.println("社員番号：<input type=\"text\" name=\"addempno\" size=\"20\" value=\"" + empno + "\"><br>");

		String empnoCheck = (String) session.getAttribute("empnoCheck");

		if (empnoCheck != null) {
			if (empnoCheck.equals("NO")) {
				out.println("<p>数字を入力してください</p>");
				session.setAttribute("empnoCheck", null);
			}
		}

		out.println("氏：<input type=\"text\" name=\"addlname\" size=\"20\" value=\"" + lname + "\"><br>");

		Object lnameCheck = session.getAttribute("lnameCheck");

		if (lnameCheck != null) {
			if (lnameCheck.equals("NO")) {
				out.println("<p>1～20文字で入力してください</p>");
				session.setAttribute("lnameCheck", null);
			}
		}

		out.println("名：<input type=\"text\" name=\"addfname\" size=\"20\" value=\"" + fname + "\"><br>");

		Object fnameCheck = session.getAttribute("fnameCheck");

		if (fnameCheck != null) {
			if (fnameCheck.equals("NO")) {
				out.println("<p>1～20文字で入力してください</p>");
				session.setAttribute("fnameCheck", null);
			}
		}

		out.println("氏（カナ）：<input type=\"text\" name=\"addlkana\" size=\"20\" value=\"" + lkana + "\"><br>");

		Object lkanaCheck = session.getAttribute("lkanaCheck");

		if (lkanaCheck != null) {
			if (lkanaCheck.equals("NO")) {
				out.println("<p>1～50文字で入力してください</p>");
				session.setAttribute("lkanaCheck", null);
			}
		}

		out.println("名（カナ）：<input type=\"text\" name=\"addfkana\" size=\"20\" value=\"" + fkana + "\"><br>");

		Object fkanaCheck = session.getAttribute("fkanaCheck");

		if (fkanaCheck != null) {
			if (fkanaCheck.equals("NO")) {
				out.println("<p>1～50文字で入力してください</p>");
				session.setAttribute("fkanaCheck", null);
			}
		}

		out.println("パスワード：<input type=\"password\" name=\"addpassword\" size=\"20\" value=\"" + password + "\"><br>");

		Object passwordCheck = session.getAttribute("passwordCheck");

		if (passwordCheck != null) {
			if (passwordCheck.equals("NO")) {
				out.println("<p>1～8文字で入力してください</p>");
				session.setAttribute("passwordCheck", null);
			}
		}

		if (gender.equals("1")) {
			out.println(
					"性別：<input type=\"radio\" name=\"addgender\" value=\"1\" checked>男性    <input type=\"radio\" name=\"addgender\" value=\"2\">女性<br>");
		} else if (gender.equals("2")) {
			out.println(
					"性別：<input type=\"radio\" name=\"addgender\" value=\"1\">男性    <input type=\"radio\" name=\"addgender\" value=\"2\" checked>女性<br>");
		} else {
			out.println(
					"性別：<input type=\"radio\" name=\"addgender\" value=\"1\">男性    <input type=\"radio\" name=\"addgender\" value=\"2\">女性<br>");
		}
		out.println("<br>");

		Object genderCheck = session.getAttribute("genderCheck");

		if (genderCheck != null) {
			if (genderCheck.equals("NO")) {
				out.println("<p>性別を選択してください</p>");
				session.setAttribute("genderCheck", null);
			}
		}

		if (deptno.equals("100")) {
			out.println(
					"所属コード：<select name=\"adddeptno\"><option value=\"none\">-</option><option value=\"100\" selected>100：人事部</option><option value=\"200\">200：経理部</option><option value=\"300\">300：営業部</option><option value=\"400\">400：企画部</option><option value=\"500\">500：開発部</option><option value=\"600\">600：総務部</option></select><br>");
		} else if (deptno.equals("200")) {
			out.println(
					"所属コード：<select name=\"adddeptno\"><option value=\"none\">-</option><option value=\"100\">100：人事部</option><option value=\"200\" selected>200：経理部</option><option value=\"300\">300：営業部</option><option value=\"400\">400：企画部</option><option value=\"500\">500：開発部</option><option value=\"600\">600：総務部</option></select><br>");
		} else if (deptno.equals("300")) {
			out.println(
					"所属コード：<select name=\"adddeptno\"><option value=\"none\">-</option><option value=\"100\">100：人事部</option><option value=\"200\">200：経理部</option><option value=\"300\" selected>300：営業部</option><option value=\"400\">400：企画部</option><option value=\"500\">500：開発部</option><option value=\"600\">600：総務部</option></select><br>");
		} else if (deptno.equals("400")) {
			out.println(
					"所属コード：<select name=\"adddeptno\"><option value=\"none\">-</option><option value=\"100\">100：人事部</option><option value=\"200\">200：経理部</option><option value=\"300\">300：営業部</option><option value=\"400\" selected>400：企画部</option><option value=\"500\">500：開発部</option><option value=\"600\">600：総務部</option></select><br>");
		} else if (deptno.equals("500")) {
			out.println(
					"所属コード：<select name=\"adddeptno\"><option value=\"none\">-</option><option value=\"100\">100：人事部</option><option value=\"200\">200：経理部</option><option value=\"300\">300：営業部</option><option value=\"400\">400：企画部</option><option value=\"500\" selected>500：開発部</option><option value=\"600\">600：総務部</option></select><br>");
		} else if (deptno.equals("600")) {
			out.println(
					"所属コード：<select name=\"adddeptno\"><option value=\"none\">-</option><option value=\"100\">100：人事部</option><option value=\"200\">200：経理部</option><option value=\"300\">300：営業部</option><option value=\"400\">400：企画部</option><option value=\"500\">500：開発部</option><option value=\"600\" selected>600：総務部</option></select><br>");
		} else {
			out.println(
					"所属コード：<select name=\"adddeptno\"><option value=\"none\">-</option><option value=\"100\">100：人事部</option><option value=\"200\">200：経理部</option><option value=\"300\">300：営業部</option><option value=\"400\">400：企画部</option><option value=\"500\">500：開発部</option><option value=\"600\">600：総務部</option></select><br>");
		}

		Object deptnoCheck = session.getAttribute("deptnoCheck");

		if (deptnoCheck != null) {
			if (deptnoCheck.equals("NO")) {
				out.println("<p>所属コードを選択してください</p>");
				session.setAttribute("deptnoCheck", null);
			}
		}

		out.println("<input class=\"button\" type=\"submit\" value=\"追加する\">");
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
