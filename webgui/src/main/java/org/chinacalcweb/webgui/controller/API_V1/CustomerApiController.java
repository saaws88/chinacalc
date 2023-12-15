package org.chinacalcweb.webgui.controller.API_V1;

import java.util.List;

import org.chinacalcweb.webgui.model.ChinacalcUser;
import org.chinacalcweb.webgui.model.Customer;
import org.chinacalcweb.webgui.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerApiController {
  
  private final CustomerService customerService;

  @PostMapping("/add")
  public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
      
    customerService.createCustomer(customer);

    return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
  
  }
  
  @GetMapping("/all")
  public List<Customer> listAll() {
      
    return customerService.findAll();
  
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<ChinacalcUser> deleteUserById(@PathVariable("id") Long id) {

    customerService.deleteCustomerById(id);

    return new ResponseEntity<>(HttpStatus.OK);
  }

}
