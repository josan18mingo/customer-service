package com.ecommerce.customer.domain.entity;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private UUID id;
    private String name;
    private Email email;
    private boolean active;

    public void deactivate() {
        this.active = false;
    }
}
