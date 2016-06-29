

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Employee> list = null;

		request.setCharacterEncoding("Windows-31J");

		//ログイン画面で入力された社員番号格納

//		String userid = request.getParameter("userid");

		//追加画面で入力された情報格納
		String empno = request.getParameter("addempno");
		String lname = request.getParameter("addlname");
		String fname = request.getParameter("addfname");
		String lkana = request.getParameter("addlkana");
		String fkana = request.getParameter("addfkana");
		String password = request.getParameter("addpassword");
		String gender = request.getParameter("addgender");
		String deptno = request.getParameter("adddeptno");

		if(empno==null||lname==null||fname==null||lkana==null||fkana==null||password==null){
			empno="";
			lname="";
			fname="";
			lkana="";
			fkana="";
			password="";
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
		out.println("<title>社員情報追加</title>");

		out.println
		("<link rel=\"stylesheet\" href=\"exercise.css\" type=\"text/css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>追加ページ</h1>");
		//社員番号の表示
//		out.println(userid);
		out.println("<br>");

		out.println("<br>");
		out.println("<br>");
//		out.println("人事部チェック"+dao.EmployerDao.checkJinji(userid));

		out.println("<form action=\"AddConfirmServlet\" method=\"post\">");
		 out.println("社員番号：<input type=\"text\" name=\"addempno\" size=\"20\" value=\""+empno+"\"><br>");
		 out.println("氏：<input type=\"text\" name=\"addlname\" size=\"20\" value=\""+lname+"\"><br>");
		 out.println("名：<input type=\"text\" name=\"addfname\" size=\"20\" value=\""+fname+"\"><br>");
		 out.println("氏（カナ）：<input type=\"text\" name=\"addlkana\" size=\"20\" value=\""+lkana+"\"><br>");
		 out.println("名（カナ）：<input type=\"text\" name=\"addfkana\" size=\"20\" value=\""+fkana+"\"><br>");
		 out.println("パスワード：<input type=\"password\" name=\"addpassword\" size=\"20\" value=\""+password+"\"><br>");
		 out.println("性別：<input type=\"radio\" name=\"addgender\" value=\"1\">男性    <input type=\"radio\" name=\"addgender\" value=\"2\">女性<br>");
		 out.println("所属コード：<select name=\"adddeptno\"><option value=\"none\">-</option><option value=\"100\">100：人事部</option><option value=\"200\">200：経理部</option><option value=\"300\">300：営業部</option><option value=\"400\">400：企画部</option><option value=\"500\">500：開発部</option><option value=\"600\">600：総務部</option></select><br>");
		 out.println("<input type=\"submit\" value=\"追加する\">");
		 out.println("</form>");
	 	 out.println("<form action=\"SearchServlet\" method=\"post\">");
		 out.println("<input type=\"submit\" value=\"キャンセル\">");
		 out.println("</form>");

		out.println("<br>");

		out.println("<br>");

		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
