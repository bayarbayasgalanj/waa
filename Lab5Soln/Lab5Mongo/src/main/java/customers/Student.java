package customers;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Student {
	@Id
	private int studentId;
	private String name;
	private String email;
	private String phone;
	private Address address;

	public Student(int studentId, String name, String email, String phone, Address address) {
		this.studentId = studentId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student{" +
				"studentId=" + studentId +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
				", address=" + address +
				'}';
	}
}