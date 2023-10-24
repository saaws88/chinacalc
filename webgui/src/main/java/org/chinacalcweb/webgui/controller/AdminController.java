package org.chinacalcweb.webgui.controller;

import org.chinacalcweb.webgui.model.ChinacalcUser;
import org.chinacalcweb.webgui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class AdminController {
  
  @Autowired
  private UserService userService;

  @GetMapping("/admin")
  public String getAdminForm(Model model) {
    model.addAttribute("user", new ChinacalcUser());
    return "admin";
  }

  @PostMapping("/admin")
  public String createUser(@ModelAttribute ChinacalcUser user, Model model) {
    userService.createUser(user);
    return "admin";
  }
}
