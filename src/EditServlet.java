

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		//ログイン画面で入力された社員番号格納

//		String userid = request.getParameter("userid");

//		HttpSession session = request.getSession();
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
		out.println("<title>社員情報編集</title>");

		out.println
		("<link rel=\"stylesheet\" href=\"exercise.css\" type=\"text/css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>変更ページ</h1>");
		//社員番号の表示
		out.println("社員番号："+id);
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
//		out.println("人事部チェック"+dao.EmployerDao.checkJinji(userid));

		out.println("<form action=\"SearchServlet\" method=\"post\">");
		 out.println("氏：<input type=\"text\" name=\"editlname\" size=\"20\" value=\"" + lname + "\"><br>");
		 out.println("名：<input type=\"text\" name=\"editfname\" size=\"20\" value=\"" + fname + "\"><br>");
		 out.println("氏(カナ)：<input type=\"text\" name=\"editlkana\" size=\"20\" value=\"" + lkana + "\"><br>");
		 out.println("名(カナ)：<input type=\"text\" name=\"editfkana\" size=\"20\" value=\"" + fkana + "\"><br>");
		 out.println("パスワード：<input type=\"password\" name=\"editpassword\" size=\"20\" value=\"" + password + "\"><br>");
		 out.println("性別：<input type=\"radio\" name=\"editgender\" value=\"1\">男性    <input type=\"radio\" name=\"addgender\" value=\"2\">女性<br>");
		 out.println("所属先：<select name=\"editdept\"><option value=\"none\">-</option><option value=\"100\">人事部</option><option value=\"200\">経理部</option><option value=\"300\">営業部</option><option value=\"400\">企画部</option><option value=\"500\">開発部</option><option value=\"600\">総務部</option></select><br>");
		 out.println("<input type=\"submit\" value=\"変更する\">");
		 out.println("</form>");

		out.println("<br>");

		out.println("<br>");

		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
