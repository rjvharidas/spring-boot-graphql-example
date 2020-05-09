package com.rjv.graphql.example.datafetcher;

import com.rjv.graphql.example.model.Customer;
import com.rjv.graphql.example.repository.CustomerRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataFetcher implements DataFetcher<Customer> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer get(DataFetchingEnvironment environment) {
        String id = environment.getArgument("id");
        return customerRepository.findById(id).get();
    }
}
