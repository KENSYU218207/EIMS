package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import to.Employee;

public class AddController extends HttpServlet {

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
		if(empno!=null)session.setAttribute("empno", empno);
		if(empno!=lname)session.setAttribute("lname", lname);
		if(empno!=fname)session.setAttribute("fname", fname);
		if(empno!=lkana)session.setAttribute("lkana", lkana);
		if(empno!=fkana)session.setAttribute("fkana", fkana);
		if(empno!=password)session.setAttribute("password", password);
		if(empno!=gender)session.setAttribute("gender", gender);
		if(empno!=deptno)session.setAttribute("deptno", deptno);



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

		Employee addUser = new Employee();
		addUser.setEmpno(Integer.parseInt(empno));
		addUser.setLname(lname);
		addUser.setFname(fname);
		addUser.setLkana(lkana);
		addUser.setFkana(fkana);
		addUser.setPassword(password);
		addUser.setGender(Integer.parseInt(gender));
		addUser.setDeptno(Integer.parseInt(deptno));


		if(dao.EmployerDao.addEmployee(addUser)){
		out.println("<h2>追加しました。</h2>");
		out.println("<form action=\"SearchServlet\" method=\"post\">");
		 out.println("<input type=\"submit\" value=\"検索画面に戻る\">");
		 out.println("</form>");
		}else{
		out.println("<h2>DBへの接続に失敗しました。</h2>");
		out.println("<form action=\"AddConfirmServlet\" method=\"post\">");
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
