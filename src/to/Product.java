package to;

/*
 * ���i�I�u�W�F�N�g TransferObject
 *
 */

public class Product {
	private String id = null; // ���i�ԍ�

	private String name = null; // ���i��

	private int price = 0; // ���i

	private String category = null; // �J�e�S��

	private String description = null; // ����

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