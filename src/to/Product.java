package to;

/*
 * 商品オブジェクト TransferObject
 *
 */

public class Product {
	private String id = null; // 商品番号

	private String name = null; // 商品名

	private int price = 0; // 価格

	private String category = null; // カテゴリ

	private String description = null; // 説明

	/*
	 * Setter
	 */
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * Getter
	 */
	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}

	public String getCategory() {
		return this.category;
	}

	public String getDescription() {
		return this.description;
	}
}