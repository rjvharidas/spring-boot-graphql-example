package com.rjv.graphql.example.resource;

import com.rjv.graphql.example.service.CustomerGraphQLService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/customer-service")
public class CustomerResource {

    @Autowired
    private CustomerGraphQLService customerGraphQLService;

    @PostMapping
    public ResponseEntity<ExecutionResult> getCustomer(@RequestBody String query){
        ExecutionResult execute = customerGraphQLService.getGraphQL().execute(query);
        return new ResponseEntity<>(execute, HttpStatus.OK);
    }
}
