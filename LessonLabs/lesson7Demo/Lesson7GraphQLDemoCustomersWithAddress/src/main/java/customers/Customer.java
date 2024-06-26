package customers;

public class Customer {
	private int customerNumber;
	private String name;
	private String email;
	private String phone;
	private Address address;

	public Customer(int customerNumber, String name, String email, String phone) {
		this.customerNumber = customerNumber;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}


	public int getCustomerNumber() {
		return customerNumber;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}