package com.ecommerce.customer.infrastructure.controller.outbound.repository;

import com.ecommerce.customer.infrastructure.controller.outbound.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, UUID> {
}
