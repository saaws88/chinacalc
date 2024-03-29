package org.chinacalcweb.webgui.controller;

import org.chinacalcweb.webgui.model.Customer;
import org.chinacalcweb.webgui.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;





@Controller
@AllArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

  private final CustomerService customerService;

  @GetMapping("")
  public String getCustomersForm(Model model) {
    
    model.addAttribute("customerslist", customerService.findAll());

    return "customers";

  }

  //TODO Create controller methods
  @GetMapping("/editcustomer")
  public String getCustomerForm(Model model) {
    
    model.addAttribute("customer", new Customer());
    
    return "editcustomer";
  }
  
  @GetMapping("/editcustomer/{id}")
  public String getEditCustomerForm(@PathVariable(value = "id") Long id, @ModelAttribute Customer customer, Model model) {
  
    model.addAttribute("customer", customerService.getCustomerById(id));

    return "editcustomer";
  
  }

  @PostMapping("/updatecustomer/{id}")
  public String createOrUpdateCustomer(@PathVariable(value = "id")Long id, Model model, @ModelAttribute("customer") Customer customer) {
    
    model.addAttribute("customer", customer);
  
    customerService.createOrUpdateCustomer(customer);

    return "redirect:/customers";
    
  }

  @PostMapping("/deletecustomer/{id}")
  public String deleteCustomer(@PathVariable(value = "id")Long id, Model model, @ModelAttribute("customer") Customer customer) {
    
    customerService.deleteCustomerById(id);

    return "redirect:/customers";

  }
  
  
  
}
