import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//削除の際に必要な制御クラス
public class DeleteConfirmServlet extends HttpServlet {
	// 削除ボタンが押下された時に呼び出される

	// (削除)検索画面での入力情報を社員DAOに引き渡し、社員情報の削除を依頼
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("Windows-31J");

		// 削除ボタンが押されたときに引き渡される値
		String id = request.getParameter("emp_id");
		String lname = request.getParameter("emp_lname");
		String lkana = request.getParameter("emp_lkana");
		String fname = request.getParameter("emp_fname");
		String fkana = request.getParameter("emp_fkana");

		HttpSession session = request.getSession();
		session.setAttribute("emp_id", id);
		session.setAttribute("emp_lname", lname);
		session.setAttribute("emp_lkana", lkana);
		session.setAttribute("emp_fname", fname);
		session.setAttribute("emp_fkana", fkana);

		// HTML部分開始
		response.setContentType("text/html; charset=Windows-31J");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>社員情報削除確認</title>");
		out.println("<link rel=\"stylesheet\" href=\"exercise.css\" type=\"text/css\">");
		out.println("</head>");
		out.println("<body>");

		out.println("<form action=\"DeleteController\" method=\"post\">");
		out.println("<h2>以下の情報を削除します。本当によろしいですか？</h2>");
		out.println(id);
		out.println("<br>");
		out.println(lname);
		out.println("<br>");
		out.println(fname);
		out.println("<br>");
		out.println(lkana);
		out.println("<br>");
		out.println(fkana);
		out.println("<br>");

		out.println("<input type=\"hidden\" name=\"empno\" value=\"" + id + "\" />");
		out.println("<input type=\"hidden\" name=\"lname\" value=\"" + lname + "\" />");
		out.println("<input type=\"hidden\" name=\"fname\" value=\"" + fname + "\" />");
		out.println("<input type=\"hidden\" name=\"lkana\" value=\"" + lkana + "\" />");
		out.println("<input type=\"hidden\" name=\"fkana\" value=\"" + fkana + "\" />");
		out.println("<input type=\"submit\" value=\"削除する\">");
	 	 out.println("<form action=\"SearchServlet\" method=\"post\">");
		 out.println("<input type=\"submit\" value=\"キャンセル\">");
		 out.println("</form>");
		out.println("</form>");

		out.print("<a href=\"SearchServlet\">戻る</a>");

		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
