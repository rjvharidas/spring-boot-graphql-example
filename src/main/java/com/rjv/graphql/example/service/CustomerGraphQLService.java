package com.rjv.graphql.example.service;

import com.rjv.graphql.example.datafetcher.AllCustomerDataFetcher;
import com.rjv.graphql.example.datafetcher.CustomerDataFetcher;
import com.rjv.graphql.example.util.DataUtil;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Service
public class CustomerGraphQLService {

    @Value("classpath:customer.graphql")
    Resource resource;

    private GraphQL graphQL;

    @Autowired
    private AllCustomerDataFetcher allCustomerDataFetcher;

    @Autowired
    private CustomerDataFetcher customerDataFetcher;

    @Autowired
    private DataUtil dataUtil;

    @PostConstruct
    private void loadSchema() throws IOException {
        //Load few customers into H2 Database
        dataUtil.loadDataIntoHSQL();

        File schemaFile = resource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("allCustomers", allCustomerDataFetcher)
                        .dataFetcher("customer", customerDataFetcher))
                .build();
    }

    public GraphQL getGraphQL() {
        return graphQL;
    }
}
