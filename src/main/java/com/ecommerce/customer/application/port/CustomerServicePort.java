package com.ecommerce.customer.application.port;

import com.ecommerce.customer.domain.entity.Customer;
import java.util.Optional;
import java.util.UUID;

public interface CustomerServicePort {

    Customer createCustomer(String name, String email);

    Optional<Customer> getCustomerById(UUID id);
}
