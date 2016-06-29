package controller;

import java.io.IOException;

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

		boolean bool = sendLogon(userid, password);

		// ログイン成功
		if (bool == true) {
			session.setAttribute("login", "OK");
			String target = (String)session.getAttribute("target");
			response.sendRedirect(target);
		}
		//ログイン失敗
		else {
			session.setAttribute("status", "NO");
			response.sendRedirect("C:/workspac/EIMS/src/LogonServlet");
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
