package dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import to.Product;

/*
 * 商品＆カテゴリ検索 DataAccessObject
 *
 */
public class ProductsDAO {
	private Connection con; // コネクション

	/*
	 * コンストラクタ
	 */
	public ProductsDAO(Connection con) {
		this.con = con;
	}

	/*
	 * 条件付き検索（カテゴリ＆商品名の一部）
	 */
	public ArrayList<Product> selectProducts(String category, String keyword) {
		ArrayList<Product> array = null;
		Statement stmt = null;
		ResultSet res = null;

		try {
			String sql = "SELECT "
					+ "product_id,product_name,price,category_name,description "
					+ "FROM products,categories ";

			if (!category.equals("すべて")) {
				sql += "WHERE categories.category_name='" + category + "'";
				sql += " AND ";
			} else {
				sql += "WHERE ";
			}
			sql += "categories.category_id=products.category ";
			sql += "AND products.product_name LIKE '%" + keyword + "%'";

			stmt = con.createStatement();
			res = stmt.executeQuery(sql);

			while (res.next()) {
				if (array == null) {
					array = new ArrayList<Product>();
				}

				Product data = new Product();

				data.setId(res.getString("product_id"));
				data.setName(res.getString("product_name"));
				data.setPrice(res.getInt("price"));
				data.setCategory(res.getString("category_name"));
				data.setDescription(res.getString("description"));

				array.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return array;
	}

	/*
	 * 条件付き検索（商品コード）
	 */
	public Product selectProduct(String id) {
		Product data = null;
		Statement stmt = null;
		ResultSet res = null;

		try {
			String sql = "SELECT "
					+ "product_id,product_name,price,category_name,description "
					+ "FROM products,categories "
					+ "WHERE products.product_id='" + id + "' "
					+ "AND products.category = categories.category_id ";

			stmt = con.createStatement();
			res = stmt.executeQuery(sql);

			if (res.next()) {

				data = new Product();

				data.setId(res.getString("product_id"));
				data.setName(res.getString("product_name"));
				data.setPrice(res.getInt("price"));
				data.setCategory(res.getString("category_name"));
				data.setDescription(res.getString("description"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return data;
	}
}