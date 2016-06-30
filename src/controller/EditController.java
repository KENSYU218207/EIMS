package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import to.Employee;

//変更の際に必要な制御クラス
public class EditController extends HttpServlet {
	// (変更)入力された内容に誤りがないかを確認する

	// 入力情報にNULL・空文字がある場合、エラーメッセージを検索画面に表示する

	// 入力情報に問題がなければ、社員DAOに入力情報を引き渡す

	//社員DAOの確認メッセージで、部署コードに誤りがある場合、エラーメッセージを検索画面に表示する

	//問題なければ、変更確認画面を表示させる。
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ArrayList<Employee> list = null;

		request.setCharacterEncoding("Windows-31J");

		//追加画面で入力された情報格納
		String empno = request.getParameter("empno");
		String lname = request.getParameter("lname");
		String fname = request.getParameter("fname");
		String lkana = request.getParameter("lkana");
		String fkana = request.getParameter("fkana");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String deptno = request.getParameter("deptno");


		HttpSession session = request.getSession();
		session.setAttribute("empno", empno);
		session.setAttribute("lname", lname);
		session.setAttribute("fname", fname);
		session.setAttribute("lkana", lkana);
		session.setAttribute("fkana", fkana);
		session.setAttribute("password", password);
		session.setAttribute("gender", gender);
		session.setAttribute("deptno", deptno);



/*
		BusinessLogic bl = new BusinessLogic();
		list = bl.selectProducts(type, keyword);
*/
//		list = dao.EmployerDao.selectEmployees();

		response.setContentType("text/html; charset=Windows-31J");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>社員情報追加確認</title>");

		out.println
		("<link rel=\"stylesheet\" href=\"exercise.css\" type=\"text/css\">");
		out.println("</head>");
		out.println("<body>");

//		out.println(empno);
//		out.println("<br>");
//		out.println(lname);
//		out.println("<br>");
//		out.println(fname);
//		out.println("<br>");
//		out.println(lkana);
//		out.println("<br>");
//		out.println(fkana);
//		out.println("<br>");
//		out.println(password);
//		out.println("<br>");
//		out.println(gender);
//		out.println("<br>");
//		out.println(deptno);
//		out.println("<br>");

		Employee editUser = new Employee();
		editUser.setEmpno(Integer.parseInt(empno));
		editUser.setLname(lname);
		editUser.setFname(fname);
		editUser.setFkana(fkana);
		editUser.setLkana(lkana);
		editUser.setPassword(password);
		editUser.setGender(Integer.parseInt(gender));
		editUser.setDeptno(Integer.parseInt(deptno));


		if(dao.EmployerDao.editEmployee(editUser)){
		out.println("<h2>変更しました。</h2>");
		out.println("<form action=\"SearchServlet\" method=\"post\">");
		 out.println("<input type=\"submit\" value=\"検索画面に戻る\">");
		 out.println("</form>");
		}else{
		out.println("<h2>変更できませんでした。</h2>");
		out.println("<form action=\"EditConfirmServlet\" method=\"post\">");
		 out.println("<input type=\"submit\" value=\"確認画面に戻る\">");
		 out.println("</form>");

		}
		out.println("<br>");

		out.println("<br>");

		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
