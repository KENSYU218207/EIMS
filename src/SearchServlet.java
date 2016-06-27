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

		// セッションを開始する
		HttpSession session = request.getSession();

		// リクエストパラメータに検索条件が入っていなかった場合
		if (type == null || keyword == null) {
			// 前回検索条件をセッションから取り出し
			type = (String) session.getAttribute("category");
			keyword = (String) session.getAttribute("searchkey");
		}

		// 検索条件をセッションに保存
		session.setAttribute("category", type);
		session.setAttribute("searchkey", keyword);

		BusinessLogic bl = new BusinessLogic();
		list = bl.selectProducts(type, keyword);

		// 検索結果を転送するため、HttpServletRequestに属性として設定
		if (list != null) {
			request.setAttribute("searchlist", list);
		}

		// JSPに検索結果を転送する
		request.getRequestDispatcher("/search.jsp").forward(request, response);
	}
}