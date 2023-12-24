package org.chinacalcweb.webgui.service;

import java.util.List;

import org.chinacalcweb.webgui.model.Customer;

public interface CustomerService {
  
  public void createCustomer(Customer customer);

  public List<Customer> findAll();

  public void deleteCustomerById(Long id);

  public Customer getCustomerById(Long id);
  
  public void updateCustomer(Customer customer);

  public void createOrUpdateCustomer(Customer customer);

}
