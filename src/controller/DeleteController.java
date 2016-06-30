package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//削除の際に必要な制御クラス
public class DeleteController extends HttpServlet {
	// 削除ボタンが押下された時に呼び出される

	// (削除)検索画面での入力情報を社員DAOに引き渡し、社員情報の削除を依頼
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("Windows-31J");

		// 削除ボタンが押されたときに引き渡される値
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

		// HTML部分開始
		response.setContentType("text/html; charset=Windows-31J");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>社員情報削除完了画面</title>");
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
			out.println("<h2>削除しました。</h2>");
			out.println("<form action=\"SearchServlet\" method=\"post\">");
			 out.println("<input class=\"button\" type=\"submit\" value=\"検索画面に戻る\">");
			 out.println("</form>");
		} else {
			out.println("<h2>削除できませんでした。</h2>");
			out.println("<form action=\"DeleteConfirmServlet\" method=\"post\">");
			 out.println("<input class=\"button\" type=\"submit\" value=\"確認画面に戻る\">");
			 out.println("</form>");
		}

		// out.println("<h3>ここまではとりあえずok!</h3>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
