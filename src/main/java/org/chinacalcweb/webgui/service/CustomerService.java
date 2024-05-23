package org.chinacalcweb.webgui.service;

import java.util.List;

import org.chinacalcweb.webgui.model.customer.Customer;

public interface CustomerService {
  
  void createCustomer(Customer customer);

  List<Customer> findAll();

  void deleteCustomerById(Long id);

  Customer getCustomerById(Long id);
  
  void updateCustomer(Customer customer);

  void createOrUpdateCustomer(Customer customer);

}
