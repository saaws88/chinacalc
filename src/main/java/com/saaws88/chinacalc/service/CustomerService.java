package com.saaws88.chinacalc.service;

import java.util.List;

import com.saaws88.chinacalc.domain.model.customer.Customer;

public interface CustomerService {
  
  void createCustomer(Customer customer);

  List<Customer> findAll();

  void deleteCustomerById(Long id);

  Customer getCustomerById(Long id);
  
  void updateCustomer(Customer customer);

  void createOrUpdateCustomer(Customer customer);

}
