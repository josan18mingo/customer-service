package com.ecommerce.customer.infrastructure.controller.outbound.adapter;

import com.ecommerce.customer.application.port.CustomerRepositoryPort;
import com.ecommerce.customer.domain.entity.Customer;
import com.ecommerce.customer.infrastructure.controller.outbound.entity.CustomerEntity;
import com.ecommerce.customer.infrastructure.controller.outbound.mapper.CustomerEntityFromDomainMapper;
import com.ecommerce.customer.infrastructure.controller.outbound.mapper.CustomerEntityToDomainMapper;
import com.ecommerce.customer.infrastructure.controller.outbound.repository.CustomerJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryAdapter implements CustomerRepositoryPort {

    private final CustomerJpaRepository jpaRepository;
    private final CustomerEntityFromDomainMapper customerEntityFromDomainMapper;
    private final CustomerEntityToDomainMapper customerEntityToDomainMapper;

    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerEntity = customerEntityFromDomainMapper.map(customer);
        CustomerEntity returnedCustomer = jpaRepository.save(customerEntity);
        return customerEntityToDomainMapper.map(returnedCustomer);
    }

    @Override
    public Optional<Customer> findById(UUID id) {
        Optional<CustomerEntity> customerEntity = jpaRepository.findById(id);
        return customerEntity.map(customerEntityToDomainMapper::map);
    }
}
