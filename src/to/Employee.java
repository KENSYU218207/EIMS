package to;

public class Employee {
	private int empno = 0; // 社員番号
	private String lname = null;//苗字
	private String fname = null;//名前
	private String lkana = null;//苗字カナ
	private String fkana = null;//名前カナ
	private String password = null;//パスワード
	private int gender=0;//性別
	private int deptno=0;//所属コード



	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
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

	public int getEmpno() {
		return this.empno;
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
