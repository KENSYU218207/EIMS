import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ClearServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, 
							HttpServletResponse response) 
							throws ServletException, IOException {

		// �Z�b�V�������擾����
	    HttpSession session = request.getSession();

	    // �Z�b�V�����ɂ������S�č폜
	    session.removeAttribute("cart");
	    session.removeAttribute("category");
	    session.removeAttribute("searchkey");

	    // ���ʉ�ʂ̕\��
	    response.sendRedirect("index.html");
	    return;
	}   	  	    
}