package to;

public class Employee {
	private String id = null; // 社員番号
	private String lname = null;//苗字
	private String fname = null;//名前
	private String lkana = null;//苗字カナ
	private String fkana = null;//名前カナ
	private int gender;
	private String password;

	public Employee(){

	}
	public Employee(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public void setFname(String fname) {
		this.fname = fname;
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
