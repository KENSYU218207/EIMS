package to;

public class Employee {
	private String id = null; // �Ј��ԍ�
	private String lname = null;//�c��
	private String fname = null;//���O
	private String lkana = null;//�c���J�i
	private String fkana = null;//���O�J�i


	public void setId(String id) {
		this.id = id;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public void setFname(String fname) {
		this.lname = fname;
	}
	public void setLkana(String lkana) {
		this.lkana = lkana;
	}
	public void setFkana(String fkana) {
		this.fkana = fkana;
	}

	public String getId() {
		return this.id;
	}
	public String getLname() {
		return this.lname;
	}
	public String getFname() {
		return this.fname;
	}
	public String getLkana() {
		return this.lkana;
	}
	public String getFkana() {
		return this.fkana;
	}

}
