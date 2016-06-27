package to;

/*
 * �������J�S�ɓ����ꂽ�w�����i TransferObject
 *
 */

public class CartData {
	private Product product = null; // �w�����i
	private int number = 0; // ��

	/*
	 * Setter
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	/*
	 * Getter
	 */
	public Product getProduct() {
		return this.product;
	}

	public int getNumber() {
		return this.number;
	}

	public String getId() {
		String id = null;
		if (this.product != null) {
			id = this.product.getId();
		}
		return id;
	}

	public String getName() {
		String name = null;
		if (this.product != null) {
			name = this.product.getName();
		}
		return name;
	}

	public int getPrice() {
		int price = 0;
		if (this.product != null) {
			price = this.product.getPrice();
		}
		return price;
	}
}
