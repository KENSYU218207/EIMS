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

		// セッションを取得する
	    HttpSession session = request.getSession();

	    // セッションにある情報を全て削除
	    session.removeAttribute("cart");
	    session.removeAttribute("category");
	    session.removeAttribute("searchkey");

	    // 結果画面の表示
	    response.sendRedirect("index.html");
	    return;
	}   	  	    
}