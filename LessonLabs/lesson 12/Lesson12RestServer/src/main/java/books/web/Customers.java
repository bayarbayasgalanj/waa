package books.web;

import java.util.ArrayList;
import java.util.Collection;

public class Customers {
    private Collection<Customer> customers = new ArrayList<Customer>();

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
}
