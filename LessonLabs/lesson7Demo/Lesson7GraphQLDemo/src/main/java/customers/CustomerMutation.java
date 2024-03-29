package customers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerMutation implements GraphQLMutationResolver {

    @Autowired
    private CustomerService customerService;

    public Customer createCustomer(final int customerNumber, final String name, final String email, final String phone) {
        return customerService.createCustomer(customerNumber, name, email, phone);
    }
}
