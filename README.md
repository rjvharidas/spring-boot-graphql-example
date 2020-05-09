# Spring Boot with GraphQL Example

Sample spring boot project with GraphQL abstraction.

## Customer Service
- `/rest/customer-service` is the REST resource which can fetch Customer information
- DataFetchers are Interfaces for RuntimeWiring of GraphQL with JpaRepository

###Requirements
For building and running the application you need:

- JDK 1.8
- Gradle
- H2
- GraphQL

## Sample GraphQL Scalar Queries
- Accessible service under `http://localhost:8080/rest/customer-service`
- devtool for H2 `http://localhost:8080/h2-console`
- Usage for `allCustomers`
`{
    allCustomers {
        id
        name
        accounts
        startDate
      }
 }`
- Usage for `customer`
`{
   customer(id: "100") {
     id
     name
     accounts
     startDate
   }`
- Combination of both `allCustomers` and `customer`
`{ 
    customer(id: "100") {
         name
    }
    allCustomers {
      id
      name
      accounts
      startDate
    }
  }`