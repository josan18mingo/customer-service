package com.ecommerce.customer.application.port;

import com.ecommerce.customer.domain.entity.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepositoryPort {
    Customer save(Customer customer);
    Optional<Customer> findById(UUID id);
}
