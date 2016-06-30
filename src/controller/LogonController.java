package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import to.Employee;

public class LogonController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("Windows-31J");

		// ログイン画面で入力された社員番号格納
		String userid = request.getParameter("userid");
		// ログイン画面で入力されたパスワード格納
		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		// セッションに保存
		session.setAttribute("userid", userid);
		session.setAttribute("password", password);

		boolean bool = false;
		if (userid.length() != 0 && password.length() != 0) {
			bool = sendLogon(userid, password);
		}

		response.setContentType("text/html; charset=Windows-31J");

		// ログイン成功
		if (bool == true) {
			session.setAttribute("login", "OK");

			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<script>");
			out.println("function goPost() { frm.submit(); }");
			out.println("</script>");
			out.println("</head>");
			out.println("<body onLoad=\"javascript:goPost();\">");
			out.println("<form method=\"post\" action=\"SearchServlet\" id=\"frm\">");
			out.println("<input type=\"hidden\" name=\"userid\" value=\"postdata\">");
			out.println("<input type=\"hidden\" name=\"password\" value=\"postdata\">");
			out.println("<input type=\"submit\"  value=\"submit\">");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			out.close();

			session.setAttribute("userid", userid);
			session.setAttribute("password", password);
			response.sendRedirect("http://localhost:8080/EIMS/SearchServlet");
		}
		//ログイン失敗
		else {
			session.setAttribute("status", "NO");
			response.sendRedirect("http://localhost:8080/EIMS/LogonServlet");
		}

	}

	// メソッド：ログオンを依頼する
	public static boolean sendLogon(String userid, String password) {
		// ログオン画面で入力された[社員番号・パスワード]を社員DAOに引き渡す

		// 社員オブジェクトのインスタンスを生成
		Employee emp = new Employee(userid, password);

		// 認証エラーの場合、ポップアップ表示
		if (dao.EmployerDao.checkPassword(userid, password) == false) {
			System.out.println("error password");

			return false;
		}

		// 社員が人事である場合、追加削除変更を可能にする
		if (dao.EmployerDao.checkJinji(userid)) {
			System.out.println("you are jinji");
		}
		return true;
	}

	// メソッド：ログアウトを依頼する
	// ログオンしている状態のユーザが、ログアウトした場合に呼び出される
	public void sendLogout() {
		// 社員オブジェクトの破棄

		// 検索制御（SearchController）に、検索結果の社員リストの破棄を依頼

	}
}
