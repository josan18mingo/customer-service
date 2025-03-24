package com.ecommerce.customer.infrastructure.controller.inbound.controller;

import com.ecommerce.customer.application.port.CustomerServicePort;
import com.ecommerce.customer.domain.entity.Customer;
import com.ecommerce.customer.infrastructure.controller.inbound.mapper.CustomerDtoFromDomainMapper;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.CustomersApi;
import org.openapitools.model.CreateCustomerDTO;
import org.openapitools.model.CustomerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CustomerController implements CustomersApi {

    private final CustomerServicePort customerServicePort;
    private final CustomerDtoFromDomainMapper customerDtoFromDomainMapper;
    @Override
    public ResponseEntity<Void> createCustomer(CreateCustomerDTO createCustomerDTO) {
        Customer customer = customerServicePort.createCustomer(createCustomerDTO.getName(), createCustomerDTO.getEmail());
        if (Objects.isNull(customer)) {
            return new ResponseEntity<>(HttpStatus.CREATED); //cambiar a error
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CustomerDTO> getCustomerById(UUID id) {
        Optional<Customer> customer = customerServicePort.getCustomerById(id);
        return customer.map(value -> new ResponseEntity<>(customerDtoFromDomainMapper.map(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
