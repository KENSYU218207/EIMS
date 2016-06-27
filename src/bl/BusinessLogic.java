package bl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import to.Product;
import dao.ConnectionManager;
import dao.ProductsDAO;

public class BusinessLogic {
	/*
	 * カテゴリとキーワードによる商品検索
	 */
	public ArrayList<Product> selectProducts(String category, String keyword) {
		Connection con = null;
		ArrayList<Product> array = null;

		try {
			ConnectionManager cm = ConnectionManager.getConnectionManager();
			con = cm.getConnection();

			ProductsDAO dao = new ProductsDAO(con);

			array = dao.selectProducts(category, keyword);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return array;
	}

	/*
	 * 商品コードによる商品検索
	 */
	public Product selectProduct(String id) {
		Connection con = null;
		Product data = null;

		try {
			ConnectionManager cm = ConnectionManager.getConnectionManager();
			con = cm.getConnection();

			ProductsDAO dao = new ProductsDAO(con);

			data = dao.selectProduct(id);
		} catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
}