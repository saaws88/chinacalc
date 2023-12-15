package org.chinacalcweb.webgui.controller;

import org.chinacalcweb.webgui.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
@AllArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

  private final CustomerService customerService;

  @GetMapping("")
  public String getCustomersForm(Model model) {
    
    model.addAttribute("customerslist", customerService.findAll());

    return("customers");

  }
  
  
}
