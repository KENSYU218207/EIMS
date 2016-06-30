package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import to.Employee;

//�ύX�̍ۂɕK�v�Ȑ���N���X
public class EditController extends HttpServlet {
	// (�ύX)���͂��ꂽ���e�Ɍ�肪�Ȃ������m�F����

	// ���͏���NULL�E�󕶎�������ꍇ�A�G���[���b�Z�[�W��������ʂɕ\������

	// ���͏��ɖ�肪�Ȃ���΁A�Ј�DAO�ɓ��͏��������n��

	//�Ј�DAO�̊m�F���b�Z�[�W�ŁA�����R�[�h�Ɍ�肪����ꍇ�A�G���[���b�Z�[�W��������ʂɕ\������

	//���Ȃ���΁A�ύX�m�F��ʂ�\��������B
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ArrayList<Employee> list = null;

		request.setCharacterEncoding("Windows-31J");

		//�ǉ���ʂœ��͂��ꂽ���i�[
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
		out.println("<title>�Ј����ǉ��m�F</title>");

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
		out.println("<h2>�ύX���܂����B</h2>");
		out.println("<form action=\"SearchServlet\" method=\"post\">");
		 out.println("<input type=\"submit\" value=\"������ʂɖ߂�\">");
		 out.println("</form>");
		}else{
		out.println("<h2>�ύX�ł��܂���ł����B</h2>");
		out.println("<form action=\"EditConfirmServlet\" method=\"post\">");
		 out.println("<input type=\"submit\" value=\"�m�F��ʂɖ߂�\">");
		 out.println("</form>");

		}
		out.println("<br>");

		out.println("<br>");

		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
