package pl.bialek.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bialek.business.dao.CustomerDAO;
import pl.bialek.domain.Customer;

import java.util.Optional;
@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerDAO customerDAO;

    public void issueInvoice(Customer customer) {
        customerDAO.issueInvoice(customer);
    }

    public Customer findCustomer(String email) {
        Optional<Customer> customer = customerDAO.findByEmail(email);
        if (email.isEmpty()) {
            throw new RuntimeException("Provided customer with email: [%s] doesn't exist".formatted(customer));
        }
        return customer.get();
    }

    public void saveServiceRequest(Customer customer) {
        customerDAO.saveServiceRequest(customer);
    }

    public Customer saveCustomer(Customer customer) {
        return customerDAO.saveCustomer(customer);
    }
}

