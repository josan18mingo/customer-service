package com.ecommerce.customer.infrastructure.controller.outbound.mapper;

import com.ecommerce.customer.domain.entity.Customer;
import com.ecommerce.customer.infrastructure.controller.outbound.entity.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerEntityFromDomainMapper {
    public CustomerEntity map(Customer customer){

        return CustomerEntity.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail().value())
                .active(customer.isActive())
                .build();
    }
}
