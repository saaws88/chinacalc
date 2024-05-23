package com.saaws88.chinacalc.infrastructure.controller.api.v1;

import java.util.List;


import com.saaws88.chinacalc.domain.model.customer.Customer;
import com.saaws88.chinacalc.infrastructure.dao.CustomerDao;
import com.saaws88.chinacalc.service.CustomerPort;
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
  
  private final CustomerDao dao;

  @PostMapping("/add")
  public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
      
    dao.createCustomer(customer);

    return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
  
  }
  
  @GetMapping("/all")
  public List<Customer> listAll() {
      
    return dao.findAll();
  
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Customer> deleteUserById(@PathVariable("id") Long id) {

    dao.deleteCustomerById(id);

    return new ResponseEntity<>(HttpStatus.OK);
  }

}
