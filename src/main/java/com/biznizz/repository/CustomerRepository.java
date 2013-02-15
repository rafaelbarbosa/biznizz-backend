package com.biznizz.repository;

import com.biznizz.domains.Customer;
import com.biznizz.persistence.Repository;

public class CustomerRepository extends Repository<Customer, Long> {

    Customer getCustomerBySSN(String ssn){
        return (Customer)em.createQuery("from Customer where ssn = :ssn").setParameter("ssn",ssn).getSingleResult();
    }
}
