package com.rjv.graphql.example.repository;

import com.rjv.graphql.example.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
