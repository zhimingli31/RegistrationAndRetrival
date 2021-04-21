package Beans;

public class Student {
	
	private String ssn;
	private String firstName;
	private String mi;
	private String lastName;
	private String birthDate;
	private String street;
	private String phone;
	private String zipcode;
	private String deptId;
	
	
	
	public Student() {

		this.ssn = "";
		this.firstName = "";
		this.mi = "";
		this.lastName = "";
		this.birthDate = "";
		this.street = "";
		this.phone = "";
		this.zipcode = "";
		this.deptId = "";
	}
	public String getSsn() {
		return ssn;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getMi() {
		return mi;
	}
	public String getLastName() {
		return lastName;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public String getStreet() {
		return street;
	}
	public String getPhone() {
		return phone;
	}
	public String getZipcode() {
		return zipcode;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setMi(String mi) {
		this.mi = mi;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	
	
	
}
