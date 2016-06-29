import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.LogonController;
import to.Employee;

public class SearchServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Employee> list = null;

		request.setCharacterEncoding("Windows-31J");

		// String type = request.getParameter("category");//
		String keyword = request.getParameter("searchkey");
		// String keyword = "長嶋";
		// ログイン画面で入力された社員番号格納
		String userid = request.getParameter("userid");
		// ログイン画面で入力されたパスワード格納
		String password = request.getParameter("password");
		System.out.println(keyword);

		HttpSession session = request.getSession();
		// リクエストパラメータに検索条件が入っていなかった場合
		if (keyword == null) {
			// 前回検索条件をセッションから取り出し
			keyword = (String) session.getAttribute("searchkey");
		}
		// 検索条件をセッションに保存
		// session.setAttribute("category", type);
		session.setAttribute("searchkey", keyword);
		session.setAttribute("userid", userid);
		session.setAttribute("password", password);


		list = dao.EmployerDao.selectEmployees(keyword);

		System.out.println("2"+keyword);
/*
		BusinessLogic bl = new BusinessLogic();
		list = bl.selectProducts(type, keyword);
*/
//		list = dao.EmployerDao.selectEmployees(keyword);


		response.setContentType("text/html; charset=Windows-31J");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>メインページ</title>");

		out.println("<link rel=\"stylesheet\" href=\"exercise.css\" type=\"text/css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>検索ページ</h1>");
		// 社員番号の表示
		out.println(userid);
		out.println("<br>");
		// パスワードの表示
		out.println(password);
		out.println("<br>");
		// パスワードの表示
		out.println(keyword);
		out.println("<br>");
		// 各種チェック
		// password と人事部チェック
		LogonController.sendLogon(userid, password);
		/*
		 * out.println("パスワードチェック："+
		 * LogonController.sendLogon(userid,password)); out.println("<br>");
		 * out.println("人事部チェック"+ LogonController.se);
		 */
		out.println("<br>");
		out.println("<form action=\"SearchServlet\" method=\"post\">");
		out.println("<input type=\"text\" name=\"searchkey\" size=\"20\" value=\"\">");
		out.println("<input type=\"submit\" value=\"検索\">");
		out.println("</form>");

		if (dao.EmployerDao.checkJinji(userid)) {
			out.println("<form action=\"AddServlet\" method=\"post\">");
			out.println("<input type=\"submit\" value=\"追加\">");
			out.println("</form>");
		}
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

		// out.println("<th width=\"30%\">部署名</th>");
		// out.println("<th rowspan=\"2\">商品購入</th>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("</tr>");
		for (int i = 0; i < count; i++) {
			String id = "";
			String fname = "";
			String fkana = "";
			String lname = "";
			String lkana = "";
			int description = 0;
			Employee data = (Employee) list.get(i);

			if (data != null) {
				id = data.getId();
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