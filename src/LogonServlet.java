
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Add
 */
public class LogonServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("Windows-31J");

		//ログイン画面で入力された社員番号格納
		String userid = request.getParameter("userid");
		//ログイン画面で入力されたパスワード格納
		String password = request.getParameter("password");

		HttpSession session = request.getSession(true);

		session.setAttribute("userid", userid);
		session.setAttribute("password", password);

		/*
		 * BusinessLogic bl = new BusinessLogic();
		 * list = bl.selectProducts(type, keyword);
		 */
		//		list = dao.EmployerDao.selectEmployees();

		response.setContentType("text/html; charset=Windows-31J");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<TITLE>ログインページ</TITLE>");
		out.println("<LINK rel=\"stylesheet\"href=\"exercise.css\" type=\"text/css\">");

<<<<<<< HEAD
=======
/*		out.println("<script type=\"text/javascript\">");
		out.println("<!--");
		out.println("function disp(){");
		// 「OK」時の処理開始 ＋ 確認ダイアログの表示
		out.println("if(window.confirm('ログオンエラー')){");
		out.println("location.href = \"http://localhost:8080/EIMS/LogonServlet\";");
		out.println("}");
		out.println("else{");
		out.println("window.alert('キャンセルされました'); "); // 警告ダイアログを表示
		out.println("}");
		// 「キャンセル」時の処理終了
		out.println("}");
		out.println(" // -->");
		out.println(" </script>");*/

>>>>>>> f29c1487c6555ce242bf5af0c53b585cc015f5b4
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>ログインページ</h1>");

		Object status = session.getAttribute("status");

		if (status != null) {
			out.println("<p>認証に失敗しました</p>");
			out.println("<p>再度ユーザー名とパスワードを入力して下さい</p>");

			session.setAttribute("status", null);
		}

		out.println("<form action=\"LogonController\" method=\"post\">");
		out.println("社員番号：<input type=\"text\" name=\"userid\" size=\"20\"><br>");
		out.println("パスワード：<input type=\"password\" name=\"password\" size=\"20\"><br>");
<<<<<<< HEAD
		out.println("<input type=\"submit\" value=\"ログイン\" onClick=\"disp()\"> ");
=======
		out.println("<input type=\"submit\" value=\"ログイン\"");
>>>>>>> f29c1487c6555ce242bf5af0c53b585cc015f5b4
		out.println("</form>");
		out.println(" </body>");
		out.println("</html>");
		out.close();
	}

}
