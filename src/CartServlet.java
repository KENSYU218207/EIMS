import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import to.CartData;
import to.Product;
import bl.BusinessLogic;

public class CartServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 文字エンコーディングを設定する
		request.setCharacterEncoding("Windows-31J");

		String productId = request.getParameter("product_id");

		// セッションから以前のカートを取り出す
		HttpSession session = request.getSession();
		// セッションからショッピングカートを取得する
		HashMap<String, CartData> cart = (HashMap<String, CartData>) session.getAttribute("cart");

		// 以前のカートが無いときは、新たにカートを作る
		if (cart == null) {
			cart = new HashMap<String, CartData>();
			session.setAttribute("cart", cart);
		}

		// リクエストパラメータから新たにカートに入れる商品を購入する
		BusinessLogic bl = new BusinessLogic();
		Product product = bl.selectProduct(productId);

		if (product != null) {
			// 同じ商品が既にカート内に存在するか
			CartData cartData = (CartData) cart.get(product.getId());
			if (cartData != null) {
				// 存在するので、個数のみ追加
				cartData.setNumber(cartData.getNumber() + 1);
			} else {
				// 存在しないので、商品を個数=１でカートに入れる
				cartData = new CartData();
				cartData.setProduct(product);
				cartData.setNumber(1);
				cart.put(product.getId(), cartData);
			}
		}

	    // 買い物カゴのページへリクエストを転送
	    request.getRequestDispatcher("/cart.jsp").forward(request,response);
	}
}