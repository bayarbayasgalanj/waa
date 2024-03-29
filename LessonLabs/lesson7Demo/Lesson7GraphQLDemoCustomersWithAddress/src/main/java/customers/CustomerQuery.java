package customers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerQuery implements GraphQLQueryResolver {

    @Autowired
    private CustomerService customerService;

    public List<Customer> getCustomers(final int count) {
        return customerService.getAllCustomers(count);
    }

    public Optional<Customer> getCustomer(final int customerNumber) {
        return customerService.getCustomer(customerNumber);
    }

    public List<Customer> getCustomer(final String street, final String city, final String zip) {
        return customerService.getCustomersWithAddress(street, city, zip);
    }

    public Optional<Address> getAddress(final int customerNumber) {
        Optional<Customer> customerOpt = customerService.getCustomer(customerNumber);
        if (customerOpt.isPresent())
            return Optional.of(customerOpt.get().getAddress());
        else
            return Optional.of(null);
    }
}
