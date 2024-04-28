package books.web;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class CustomerController {

	@GetMapping("/customers/{customernumber}")
    public ResponseEntity<?> getCustomer(@PathVariable String customernumber) {
        System.out.println("getCustomer");
        Customer customer = new Customer("123", "Frank Brown", "06123897","fbrown@gmail.com");
        return new ResponseEntity<Customer> (customer, HttpStatus.OK);
    }

    @GetMapping("/customers")
    public ResponseEntity<?> getCustomers() {
        Customers customers  = new Customers();
        customers.addCustomer(new Customer("123", "Frank Brown", "06123897","fbrown@gmail.com"));
        customers.addCustomer(new Customer("115", "James Bond", "06437894","jbond@gmail.com"));

        return new ResponseEntity<Customers> (customers, HttpStatus.OK);
    }
}


