

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
public class LogonServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
//		list = dao.EmployerDao.selectEmployees();


		response.setContentType("text/html; charset=Windows-31J");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<TITLE>ログインページ</TITLE>");
		    out.println("<LINK rel=\"stylesheet\"href=\"exercise.css\" type=\"text/css\">");

		    out.println("<script type=\"text/javascript\">");
		    out.println("<!--");
		    out.println("function disp(){");
		    	// 「OK」時の処理開始 ＋ 確認ダイアログの表示
		    out.println("if(window.confirm('ログオンエラー')){");
		    out.println("location.href = \"http://localhost:8080/EIMS/LogonServlet\";");
		    out.println("}");
		    out.println("else{");
		    out.println("window.alert('キャンセルされました'); ");		// 警告ダイアログを表示
		    out.println("}");
		    	// 「キャンセル」時の処理終了
		    out.println("}");
		    out.println(" // -->");
		    out.println(" </script>");

		 out.println("</head>");
		 out.println("<body>");
		 out.println("<h1>ログインページ</h1>");
		 out.println("<form action=\"SearchServlet\" method=\"post\">");
		 out.println("社員番号：<input type=\"text\" name=\"userid\" size=\"20\"><br>");
		 out.println("パスワード：<input type=\"password\" name=\"password\" size=\"20\"><br>");
		 out.println("<input type=\"submit\" value=\"ログイン\" onClick=\"disp()\"> ");
		 out.println("</form>");
		 out.println("<form action=\"AddServlet\" method=\"post\">");
		 out.println("  社員番号：<input type=\"text\" name=\"userid\" size=\"20\"><br>");
		 out.println("パスワード：<input type=\"password\" name=\"password\" size=\"20\"><br>");
		 out.println("<input type=\"submit\" value=\"追加\">");
		 out.println("</form>");
		 out.println(" </body>");
		 out.println("</html>");
		out.close();
	}

}
