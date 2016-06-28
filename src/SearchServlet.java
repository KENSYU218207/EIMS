import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bl.BusinessLogic;
import to.Employee;
import to.Product;

public class SearchServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,
							HttpServletResponse response)
							throws ServletException, IOException {

		ArrayList<Employee> list = null;

		request.setCharacterEncoding("Windows-31J");

		String type = request.getParameter("category");
		String keyword = request.getParameter("searchkey");
		//ログイン画面で入力された社員番号格納
		String userid = request.getParameter("userid");
		//ログイン画面で入力されたパスワード格納
		String password = request.getParameter("password");



		HttpSession session = request.getSession();
		if(type==null || keyword == null){
			type=(String)session.getAttribute("category");
			keyword=(String)session.getAttribute("searchkey");
		}
		session.setAttribute("category", type);
		session.setAttribute("searchkey", keyword);
		session.setAttribute("userid", userid);
		session.setAttribute("password", password);
/*
		BusinessLogic bl = new BusinessLogic();
		list = bl.selectProducts(type, keyword);
*/
		list = dao.EmployerDao.selectEmployees();

		response.setContentType("text/html; charset=Windows-31J");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>メインページ</title>");

		out.println
		("<link rel=\"stylesheet\" href=\"exercise.css\" type=\"text/css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>検索ページ</h1>");
		//社員番号の表示
		out.println(userid);
		out.println("<br>");
		//パスワードの表示
		out.println(password);
		out.println("<br>");
		//各種チェック
		out.println("パスワードチェック："+dao.EmployerDao.checkPassword(userid,password));
		out.println("<br>");
		out.println("人事部チェック"+dao.EmployerDao.checkJinji(userid));
		out.println("<br>");
		out.println("<form action=\"SearchServlet\" method=\"post\">");
		out.println
		("<input type=\"text\" name=\"searchkey\" size=\"20\" value=\""
						+ "" + "\">");
		out.println("<input type=\"submit\" value=\"検索\">");
		out.println("</form>");

		out.println("<br>");

		int count = 0;
		if (list != null) {
			count = list.size();
		}

		out.println("検索結果：" + count + "件");
		out.println("<table width=\"98%\" border=\"0\">");
		out.println("<tr>");
		out.println("<th width=\"30%\">商品コード</th>");
		out.println("<th width=\"30%\">商品名</th>");
		out.println("<th width=\"30%\">価格</th>");
		out.println("<th rowspan=\"2\">商品購入</th>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th colspan=\"3\">商品の説明</th>");
		out.println("</tr>");
		for (int i = 0; i < count; i++) {
			String id = "";
			String name = "";
			String price = "";
			String description = "";

			Employee data = (Employee) list.get(i);

			if (data != null) {
				id = data.getId();
			}
			out.println("<tr class=\"product\">");
			out.println("<td width=\"30%\">" + id + "</td>");
			out.println("<td width=\"30%\">" + name + "</td>");
			out.println("<td width=\"30%\">" + price + "</td>");
			out.println
			("<td rowspan=\"2\" align=\"center\" valign=\"middle\">");
			out.println("<form action=\"CartServlet\" method=\"post\">");
			out.println("<input type=\"hidden\" name=\"product_id\" value=\""
					+ id + "\">");
			out.println("<input type=\"submit\" name=\"submit\" value=\"購入\">");
			out.println("</form>");
			out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td colspan=\"3\"><span class=\"description\">"
					+ description + "</span></td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}