package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddCheckController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//		ArrayList<Employee> list = null;

		request.setCharacterEncoding("Windows-31J");

		//’Ç‰Á‰æ–Ê‚Å“ü—Í‚³‚ê‚½î•ñŠi”[
		String empno = request.getParameter("addempno");
		String lname = request.getParameter("addlname");
		String fname = request.getParameter("addfname");
		String lkana = request.getParameter("addlkana");
		String fkana = request.getParameter("addfkana");
		String password = request.getParameter("addpassword");
		String gender = request.getParameter("addgender");
		String deptno = request.getParameter("adddeptno");

		HttpSession session = request.getSession();
		session.setAttribute("addempno", empno);
		session.setAttribute("addlname", lname);
		session.setAttribute("addfname", fname);
		session.setAttribute("addlkana", lkana);
		session.setAttribute("addfkana", fkana);
		session.setAttribute("addpassword", password);
		session.setAttribute("addgender", gender);
		session.setAttribute("adddeptno", deptno);

		boolean allBool = true;

		// empno
		boolean empnoBool = false;
		try {
			Integer.parseInt(empno);
			empnoBool = true;
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
			allBool = false;
		}
		if (empnoBool == false) {
			session.setAttribute("empnoCheck", "NO");
		}

		// lname
		boolean lnameBool = false;
		if (lname.length() == 0 || lname.length() > 20) {
			allBool = false;
		}
		else {
			lnameBool = true;
		}
		if (lnameBool == false) {
			session.setAttribute("lnameCheck", "NO");
		}

		// fname
		boolean fnameBool = false;
		if (fname.length() == 0 || fname.length() > 20) {
			allBool = false;
		}
		else {
			fnameBool = true;
		}
		if (fnameBool == false) {
			session.setAttribute("fnameCheck", "NO");
		}

		// lkana
		boolean lkanaBool = false;
		if (lkana.length() == 0 || lkana.length() > 50) {
			allBool = false;
		}
		else {
			lkanaBool = true;
		}
		if (lkanaBool == false) {
			session.setAttribute("lkanaCheck", "NO");
		}

		// fname
		boolean fkanaBool = false;
		if (fkana.length() == 0 || fkana.length() > 50) {
			allBool = false;
		}
		else {
			fkanaBool = true;
		}
		if (fkanaBool == false) {
			session.setAttribute("fkanaCheck", "NO");
		}

		// password
		boolean passwordBool = false;
		if (password.length() == 0 || password.length() > 8) {
			allBool = false;
		}
		else {
			passwordBool = true;
		}
		if (passwordBool == false) {
			session.setAttribute("passwordCheck", "NO");
		}

		// gender
		boolean genderBool = false;
		if (gender == null) {
			allBool = false;
		}
		if (genderBool == false) {
			session.setAttribute("genderCheck", "NO");
		}

		// deptno
		boolean deptnoBool = false;
		if (deptno == null) {
			allBool = false;
		}
		if (deptnoBool == false) {
			session.setAttribute("deptnoCheck", "NO");
		}

		response.setContentType("text/html; charset=Windows-31J");

		PrintWriter out = response.getWriter();

		if (allBool == false) {
			out.println("<html>");
			out.println("<head>");
			out.println("<script>");
			out.println("function goPost() { frm.submit(); }");
			out.println("</script>");
			out.println("</head>");
			out.println("<body onLoad=\"javascript:goPost();\">");
			out.println("<form method=\"post\" action=\"AddServlet\" id=\"frm\">");

			out.println("<input type=\"hidden\" name=\"addempno\" value=\"" + empno + "\" />");
			out.println("<input type=\"hidden\" name=\"addlname\" value=\"" + lname + "\" />");
			out.println("<input type=\"hidden\" name=\"addfname\" value=\"" + fname + "\" />");
			out.println("<input type=\"hidden\" name=\"addlkana\" value=\"" + lkana + "\" />");
			out.println("<input type=\"hidden\" name=\"addfkana\" value=\"" + fkana + "\" />");
			out.println("<input type=\"hidden\" name=\"addpassword\" value=\"" + password + "\" />");
			out.println("<input type=\"hidden\" name=\"addgender\" value=\"" + gender + "\" />");
			out.println("<input type=\"hidden\" name=\"adddeptno\" value=\"" + deptno + "\" />");

			out.println("<input type=\"submit\"  value=\"submit\">");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			out.close();
		}
		else {
			// addConfirmServlet‚É”ò‚Ô
			out.println("<html>");
			out.println("<head>");
			out.println("<script>");
			out.println("function goPost() { frm.submit(); }");
			out.println("</script>");
			out.println("</head>");
			out.println("<body onLoad=\"javascript:goPost();\">");
			out.println("<form method=\"post\" action=\"AddConfirmServlet\" id=\"frm\">");

			out.println("<input type=\"hidden\" name=\"addempno\" value=\"" + empno + "\" />");
			out.println("<input type=\"hidden\" name=\"addlname\" value=\"" + lname + "\" />");
			out.println("<input type=\"hidden\" name=\"addfname\" value=\"" + fname + "\" />");
			out.println("<input type=\"hidden\" name=\"addlkana\" value=\"" + lkana + "\" />");
			out.println("<input type=\"hidden\" name=\"addfkana\" value=\"" + fkana + "\" />");
			out.println("<input type=\"hidden\" name=\"addpassword\" value=\"" + password + "\" />");
			out.println("<input type=\"hidden\" name=\"addgender\" value=\"" + gender + "\" />");
			out.println("<input type=\"hidden\" name=\"adddeptno\" value=\"" + deptno + "\" />");

			out.println("<input type=\"submit\"  value=\"submit\">");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			out.close();
		}
	}

}
