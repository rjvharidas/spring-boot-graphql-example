package com.rjv.graphql.example.util;

import com.rjv.graphql.example.model.Customer;
import com.rjv.graphql.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class DataUtil {

    @Autowired
    CustomerRepository customerRepository;

    public void loadDataIntoHSQL() {

        Stream.of(
                new Customer("100", "David", "PA",
                        new String[] {
                                "SA","CC"
                        }, "Dec 2019"),
                new Customer("101", "Steve", "PA",
                        new String[] {
                                "CC"
                        }, "Mar 2020"),
                new Customer("102", "Ann", "TA",
                        new String[] {
                                "SA","CC"
                        }, "Jan 2019"),
                new Customer("103", "Gilliam", "TA",
                        new String[] {
                                "SA"
                        }, "Jun 2018"),
                new Customer("104", "Justine", "PA",
                        new String[] {
                                "SA","CC"
                        }, "Dec 2018"),
                new Customer("105", "Fed", "TA",
                        new String[] {
                                "CC"
                        }, "Dec 2017")
        ).forEach(customer -> {
            customerRepository.save(customer);
        });
    }
}
