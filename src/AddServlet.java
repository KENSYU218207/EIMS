

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
		String userid = request.getParameter("userid");

		HttpSession session = request.getSession();
		session.setAttribute("userid", userid);
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
		out.println(userid);
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
		out.println("人事部チェック"+dao.EmployerDao.checkJinji(userid));

		out.println("<form action=\"SearchServlet\" method=\"post\">");
		 out.println("社員番号：<input type=\"text\" name=\"addlname\" size=\"20\"><br>");
		 out.println("社員番号：<input type=\"text\" name=\"addfname\" size=\"20\"><br>");
		 out.println("社員番号：<input type=\"text\" name=\"addlkana\" size=\"20\"><br>");
		 out.println("社員番号：<input type=\"text\" name=\"addfkana\" size=\"20\"><br>");
		 out.println("パスワード：<input type=\"password\" name=\"addpassword\" size=\"20\"><br>");
		 out.println("性別：<input type=\"radio\" name=\"addgender\" value=\"male\">男性    <input type=\"radio\" name=\"addgender\" value=\"female\">女性<br>");
		 out.println("所属先：リストボックスをここに作る<br>");
		 out.println("<input type=\"submit\" value=\"追加する\">");
		 out.println("</form>");

		out.println("<br>");

		out.println("<br>");

		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
