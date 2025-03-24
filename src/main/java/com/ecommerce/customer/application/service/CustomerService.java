package com.ecommerce.customer.application.service;

import com.ecommerce.customer.application.port.CustomerRepositoryPort;
import com.ecommerce.customer.application.port.CustomerServicePort;
import com.ecommerce.customer.domain.entity.Customer;
import com.ecommerce.customer.domain.entity.Email;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService implements CustomerServicePort {

    private final CustomerRepositoryPort repository;
    @Override
    public Customer createCustomer(String name, String email) {
        Customer customer = Customer.builder()
                .id(UUID.randomUUID())
                .name(name)
                .email(new Email(email))
                .active(true)
                .build();
        return repository.save(customer);
    }

    @Override
    public Optional<Customer> getCustomerById(UUID id) {
        return repository.findById(id);
    }
}
