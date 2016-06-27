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
		// �����G���R�[�f�B���O��ݒ肷��
		request.setCharacterEncoding("Windows-31J");

		String productId = request.getParameter("product_id");

		// �Z�b�V��������ȑO�̃J�[�g�����o��
		HttpSession session = request.getSession();
		// �Z�b�V��������V���b�s���O�J�[�g���擾����
		HashMap<String, CartData> cart = (HashMap<String, CartData>) session.getAttribute("cart");

		// �ȑO�̃J�[�g�������Ƃ��́A�V���ɃJ�[�g�����
		if (cart == null) {
			cart = new HashMap<String, CartData>();
			session.setAttribute("cart", cart);
		}

		// ���N�G�X�g�p�����[�^����V���ɃJ�[�g�ɓ���鏤�i���w������
		BusinessLogic bl = new BusinessLogic();
		Product product = bl.selectProduct(productId);

		if (product != null) {
			// �������i�����ɃJ�[�g���ɑ��݂��邩
			CartData cartData = (CartData) cart.get(product.getId());
			if (cartData != null) {
				// ���݂���̂ŁA���̂ݒǉ�
				cartData.setNumber(cartData.getNumber() + 1);
			} else {
				// ���݂��Ȃ��̂ŁA���i����=�P�ŃJ�[�g�ɓ����
				cartData = new CartData();
				cartData.setProduct(product);
				cartData.setNumber(1);
				cart.put(product.getId(), cartData);
			}
		}

	    // �������J�S�̃y�[�W�փ��N�G�X�g��]��
	    request.getRequestDispatcher("/cart.jsp").forward(request,response);
	}
}