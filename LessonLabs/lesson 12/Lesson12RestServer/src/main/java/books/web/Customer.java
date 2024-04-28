package books.web;

public class Customer {
    private String customernumber;
    private String name;
    private String phone;
    private String email;

    public Customer() {
    }

    public Customer(String customerNumber, String name, String phone, String email) {
        this.customernumber = customerNumber;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getCustomernumber() {
        return customernumber;
    }

    public void setCustomerNumber(String customernumber) {
        this.customernumber = customernumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
