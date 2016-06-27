import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bl.BusinessLogic;
import to.Product;

public class SearchServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Product> list = null;

		request.setCharacterEncoding("Windows-31J");

		String type = request.getParameter("category");
		String keyword = request.getParameter("searchkey");

		// �Z�b�V�������J�n����
		HttpSession session = request.getSession();

		// ���N�G�X�g�p�����[�^�Ɍ��������������Ă��Ȃ������ꍇ
		if (type == null || keyword == null) {
			// �O�񌟍��������Z�b�V����������o��
			type = (String) session.getAttribute("category");
			keyword = (String) session.getAttribute("searchkey");
		}

		// �����������Z�b�V�����ɕۑ�
		session.setAttribute("category", type);
		session.setAttribute("searchkey", keyword);

		BusinessLogic bl = new BusinessLogic();
		list = bl.selectProducts(type, keyword);

		// �������ʂ�]�����邽�߁AHttpServletRequest�ɑ����Ƃ��Đݒ�
		if (list != null) {
			request.setAttribute("searchlist", list);
		}

		// JSP�Ɍ������ʂ�]������
		request.getRequestDispatcher("/search.jsp").forward(request, response);
	}
}