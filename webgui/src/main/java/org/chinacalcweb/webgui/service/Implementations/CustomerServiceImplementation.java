package org.chinacalcweb.webgui.service.Implementations;

import java.util.List;

import org.chinacalcweb.webgui.model.Customer;
import org.chinacalcweb.webgui.model.Enums.CustomerCategory;
import org.chinacalcweb.webgui.repo.CustomerRepository;
import org.chinacalcweb.webgui.service.CustomerService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerServiceImplementation implements CustomerService {

  private CustomerRepository customerRepository;


  @Override
  public void createCustomer(Customer customer) {
    
    if (customer.isPrivatePerson()) {
      customer.setCustomerName(String.format("%s %s %s",
          customer.getContactLastName(),
          customer.getContactFirstName(),
          customer.getContactPatronymic()));
    } else {
      customer.setCustomerName(customer.getCustomerName());
    }

    customer.setCategory(CustomerCategory.INITIAL);

    customerRepository.save(customer);

  }

  @Override
  public List<Customer> findAll() {

    return customerRepository.findAll();

  }

  @Override
  public void deleteCustomerById(Long id) {

    customerRepository.deleteById(id);

  }

  @Override
  public Customer getCustomerById(Long id) {

    return customerRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Клиент не найден"));

  }

  //TODO Get update customer method right
  @Override
  public void updateCustomer(Customer customer) {

    Customer updatedCustomer = getCustomerById(customer.getId());

    if (updatedCustomer.equals(customer)) {
      return;
    }

    updatedCustomer.setPrivatePerson(customer.isPrivatePerson());
    updatedCustomer.setContactLastName(customer.getContactLastName());
    updatedCustomer.setContactFirstName(customer.getContactFirstName());
    updatedCustomer.setContactPatronymic(customer.getContactPatronymic());

    if (updatedCustomer.isPrivatePerson()) {
      updatedCustomer.setCustomerName(String.format("%s %s %s",
          updatedCustomer.getContactLastName(),
          updatedCustomer.getContactFirstName(),
          updatedCustomer.getContactPatronymic()));
    } else {
      updatedCustomer.setCustomerName(customer.getCustomerName());
    }

    updatedCustomer.setCity(customer.getCity());
    updatedCustomer.setEmail(customer.getEmail());
    updatedCustomer.setPhoneNumber(customer.getPhoneNumber());
    updatedCustomer.setIndividualTaxpayerNumber(customer.getIndividualTaxpayerNumber());


    customerRepository.save(updatedCustomer);

  }

  @Override
  public void createOrUpdateCustomer(Customer customer) {
    
    if(customerRepository.findById(customer.getId()).isPresent()) {

      updateCustomer(customer);

    } else {

      createCustomer(customer);    
    
    }

  }

}
