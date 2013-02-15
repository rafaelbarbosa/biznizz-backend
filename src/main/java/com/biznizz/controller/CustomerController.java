package com.biznizz.controller;

import com.biznizz.domains.Customer;
import com.biznizz.repository.CustomerRepository;

import javax.inject.Inject;
import java.util.List;

public class CustomerController {

    @Inject
    CustomerRepository customerRepository;


    public List<Customer> get(){
        return customerRepository.getAll();
    }


}
