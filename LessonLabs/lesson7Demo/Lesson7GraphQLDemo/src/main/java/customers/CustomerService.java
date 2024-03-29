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

    public Customer createCustomer(int customerNumber, String name, String email, String phone) {
        Customer customer = new Customer(customerNumber, name, email, phone);
        customers.put(customerNumber, customer);
        return customer;
    }
}
