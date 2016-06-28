import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bl.BusinessLogic;
import to.Product;

public class SearchServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,
							HttpServletResponse response)
							throws ServletException, IOException {

		ArrayList<Product> list = null;

		request.setCharacterEncoding("Windows-31J");

		String type = request.getParameter("category");
		String keyword = request.getParameter("searchkey");
		String userid = request.getParameter("userid");



		HttpSession session = request.getSession();
		if(type==null || keyword == null){
			type=(String)session.getAttribute("category");
			keyword=(String)session.getAttribute("searchkey");
		}
		session.setAttribute("category", type);
		session.setAttribute("searchkey", keyword);
		session.setAttribute("userid", userid);
/*
		BusinessLogic bl = new BusinessLogic();
		list = bl.selectProducts(type, keyword);
*/
		response.setContentType("text/html; charset=Windows-31J");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>���C���y�[�W</title>");

		out.println
		("<link rel=\"stylesheet\" href=\"exercise.css\" type=\"text/css\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>�����y�[�W</h1>");
		out.println(userid);
		out.println(dao.EmployerDao.checkPassword(userid));
		out.println("<form action=\"SearchServlet\" method=\"post\">");
		out.println("<select name=\"category\">");
		if (type.equals("���ׂ�"))
			out.println("<option selected>���ׂ�</option>");
		else
			out.println("<option>���ׂ�</option>");
		if (type.equals("�l�^"))
			out.println("<option selected>�l�^</option>");
		else
			out.println("<option>�l�^</option>");
		if (type.equals("�����^"))
			out.println("<option selected>�����^</option>");
		else
			out.println("<option>�����^</option>");
		out.println("</select>");
		out.println
		("<input type=\"text\" name=\"searchkey\" size=\"20\" value=\""
						+ keyword + "\">");
		out.println("<input type=\"submit\" value=\"����\">");
		out.println("</form>");

		out.println("<br>");
/*
		int count = 0;
		if (list != null) {
			count = list.size();
		}
*//*
		out.println("�������ʁF" + count + "��");
		out.println("<table width=\"98%\" border=\"0\">");
		out.println("<tr>");
		out.println("<th width=\"30%\">���i�R�[�h</th>");
		out.println("<th width=\"30%\">���i��</th>");
		out.println("<th width=\"30%\">���i</th>");
		out.println("<th rowspan=\"2\">���i�w��</th>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th colspan=\"3\">���i�̐���</th>");
		out.println("</tr>");
		for (int i = 0; i < count; i++) {
			String id = "";
			String name = "";
			String price = "";
			String description = "";

			Product data = (Product) list.get(i);

			if (data != null) {
				id = data.getId();
				name = data.getName();
				price = "\\" + data.getPrice();
				description = data.getDescription();
			}
			out.println("<tr class=\"product\">");
			out.println("<td width=\"30%\">" + id + "</td>");
			out.println("<td width=\"30%\">" + name + "</td>");
			out.println("<td width=\"30%\">" + price + "</td>");
			out.println
			("<td rowspan=\"2\" align=\"center\" valign=\"middle\">");
			out.println("<form action=\"CartServlet\" method=\"post\">");
			out.println("<input type=\"hidden\" name=\"product_id\" value=\""
					+ id + "\">");
			out.println("<input type=\"submit\" name=\"submit\" value=\"�w��\">");
			out.println("</form>");
			out.println("</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td colspan=\"3\"><span class=\"description\">"
					+ description + "</span></td>");
			out.println("</tr>");
		}
		out.println("</table>");*/
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}