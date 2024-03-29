package customers;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    Map<Integer, Customer> customers = new HashMap<>();

    public List<Customer> getAllCustomers(int count) {
        List<Customer> customerList  = customers.values().stream().collect(Collectors.toList());
        return customerList.subList(0,count);
    }

    public Optional<Customer> getCustomer(int customerNumber) {
        return  Optional.of(customers.get(customerNumber));
    }

    public Customer createCustomer(int customerNumber, String name, String email, String phone, String street, String city, String zip) {
        Customer customer = new Customer(customerNumber, name, email, phone);
        Address address = new Address(street, city, zip);
        customer.setAddress(address);
        customers.put(customerNumber, customer);
        return customer;
    }

    public List<Customer> getCustomersWithAddress(String street, String city, String zip) {
        List<Customer> customerList  = customers.values().stream()
                .filter(c-> c.getAddress().getStreet().equals(street))
                .filter(c-> c.getAddress().getCity().equals(city))
                .filter(c-> c.getAddress().getZip().equals(zip))
                .collect(Collectors.toList());
        return customerList;
    }
}
