package com.rjv.graphql.example.datafetcher;

import com.rjv.graphql.example.model.Customer;
import com.rjv.graphql.example.repository.CustomerRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllCustomerDataFetcher implements DataFetcher<List<Customer>> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> get(DataFetchingEnvironment environment) {
        return customerRepository.findAll();
    }
}
