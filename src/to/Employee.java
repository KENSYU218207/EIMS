package to;

public class Employee {
	private int empno = 0; // �Ј��ԍ�
	private String lname = null;//�c��
	private String fname = null;//���O
	private String lkana = null;//�c���J�i
	private String fkana = null;//���O�J�i
	private String password = null;//�p�X���[�h
	private int gender=0;//����
	private int deptno=0;//�����R�[�h


	public Employee(){

	}
	public Employee(String id, String password) {
		super();
		this.empno = Integer.parseInt(id);
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
	public void setDeptno(int deptno){
		this.deptno=deptno;
	}

	public int getDeptno(){
		return deptno;
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
