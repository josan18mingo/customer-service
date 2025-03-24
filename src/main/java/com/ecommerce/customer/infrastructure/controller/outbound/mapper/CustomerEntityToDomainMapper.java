package com.ecommerce.customer.infrastructure.controller.outbound.mapper;

import com.ecommerce.customer.domain.entity.Customer;
import com.ecommerce.customer.domain.entity.Email;
import com.ecommerce.customer.infrastructure.controller.outbound.entity.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerEntityToDomainMapper {
    public Customer map(CustomerEntity customerEntity){
        return Customer.builder()
                .id(customerEntity.getId())
                .name(customerEntity.getName())
                .email(new Email(customerEntity.getEmail()))
                .active(customerEntity.isActive())
                .build();
    }
}
