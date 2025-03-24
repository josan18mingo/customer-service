package com.ecommerce.customer.infrastructure.controller.inbound.mapper;

import com.ecommerce.customer.domain.entity.Customer;
import org.openapitools.model.CustomerDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoFromDomainMapper {

    public CustomerDTO map(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail().value());
        return customerDTO;
    }
}
