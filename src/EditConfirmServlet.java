import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditConfirmServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ArrayList<Employee> list = null;

		request.setCharacterEncoding("Windows-31J");

		//編集画面で入力された情報格納
		String id = request.getParameter("emp_id");
		String lname = request.getParameter("editlname");
		String lkana = request.getParameter("editlkana");
		String fname = request.getParameter("editfname");
		String fkana = request.getParameter("editfkana");
		String dept = request.getParameter("editdept");
		String gender = request.getParameter("editgender");
		String password = request.getParameter("editpassword");


		HttpSession session = request.getSession();
		session.setAttribute("emp_id", id);
		session.setAttribute("editlname", lname);
		session.setAttribute("editfname", fname);
		session.setAttribute("editlkana", lkana);
		session.setAttribute("editfkana", fkana);
		session.setAttribute("editpassword", password);
		session.setAttribute("editgender", gender);
		session.setAttribute("editgender", dept);



/*
		BusinessLogic bl = new BusinessLogic();
		list = bl.selectProducts(type, keyword);
*/
//		list = dao.EmployerDao.selectEmployees();

		response.setContentType("text/html; charset=Windows-31J");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>社員情報変更確認</title>");

		out.println
		("<link rel=\"stylesheet\" href=\"exercise.css\" type=\"text/css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>変更確認ページ</h1>");
		//社員番号の表示
		out.println(id);
		out.println("<br>");
		out.println("<br>");
		out.println("<br>");
//		out.println("人事部チェック"+dao.EmployerDao.checkJinji(userid));

		out.println("<form action=\"EditController\" method=\"post\">");
		out.println("<h2>以下の情報で登録します。よろしいですか？</h2>");
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
		out.println(gender);
		out.println("<br>");
		out.println(dept);
		out.println("<br>");
		out.println(password);
		out.println("<br>");

		out.println("<input type=\"hidden\" name=\"empno\" value=\""+id+"\" />");
		out.println("<input type=\"hidden\" name=\"lname\" value=\""+lname+"\" />");
		out.println("<input type=\"hidden\" name=\"fname\" value=\""+fname+"\" />");
		out.println("<input type=\"hidden\" name=\"lkana\" value=\""+lkana+"\" />");
		out.println("<input type=\"hidden\" name=\"fkana\" value=\""+fkana+"\" />");
		out.println("<input type=\"hidden\" name=\"password\" value=\""+password+"\" />");
		out.println("<input type=\"hidden\" name=\"gender\" value=\""+gender+"\" />");
		out.println("<input type=\"hidden\" name=\"deptno\" value=\""+dept+"\" />");
		 out.println("<input type=\"submit\" value=\"変更する\">");
		 out.println("</form>");
			out.println("<form action=\"EditServlet\" method=\"post\">");
			out.println("<input type=\"hidden\" name=\"emp_id\" value=\""+id+"\" />");
			out.println("<input type=\"hidden\" name=\"emp_lname\" value=\""+lname+"\" />");
			out.println("<input type=\"hidden\" name=\"emp_fname\" value=\""+fname+"\" />");
			out.println("<input type=\"hidden\" name=\"emp_lkana\" value=\""+lkana+"\" />");
			out.println("<input type=\"hidden\" name=\"emp_fkana\" value=\""+fkana+"\" />");
			out.println("<input type=\"hidden\" name=\"emp_pass\" value=\""+password+"\" />");
			out.println("<input type=\"hidden\" name=\"emp_gender\" value=\""+gender+"\" />");
			out.println("<input type=\"hidden\" name=\"emp_dept\" value=\""+dept+"\" />");
			 out.println("<input type=\"submit\" value=\"キャンセル\">");
			 out.println("</form>");

		out.println("<br>");

		out.println("<br>");

		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
