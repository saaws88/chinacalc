package com.saaws88.chinacalc.infrastructure.controller.mvc;

import java.util.Arrays;
import java.util.List;

import com.saaws88.chinacalc.domain.model.user.ChinacalcUser;
import com.saaws88.chinacalc.domain.model.user.enumerated.Role;
import com.saaws88.chinacalc.service.implementation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class AdminController {

  @Autowired
  private UserService service;

  @GetMapping("/admin")
  public String getAdminForm(Model model) {
    model.addAttribute("user", new ChinacalcUser());
    model.addAttribute("userlist", service.findAll());
    return "admin";
  }

  @PostMapping("/admin")
  public String createUser(@ModelAttribute("user") ChinacalcUser user, Model model,
      RedirectAttributes redirectAttributes) {

    if (service.isEmailExist(user.getEmail().toLowerCase())) {
      redirectAttributes.addFlashAttribute("error",
          "Пользователь с почтой " + user.getEmail().toLowerCase() + " уже существует.");
      return "redirect:/admin";
    }
    service.createUser(user);

    redirectAttributes.addFlashAttribute("success",
        "Пользователь создан, временный пароль отправлен на " + user.getEmail());
    return "redirect:/admin";

  }

  @GetMapping("admin/edituser/{id}")
  public String getUserEditForm(@PathVariable(value = "id") Long id, Model model, ChinacalcUser user) {

    model.addAttribute("user", service.getUserById(id));

    List<Role> roles = Arrays.asList(Role.values());
    model.addAttribute("roles", roles);

    return "edituser";

  }

  //TODO Setup redirect and redirect attribute
  @PostMapping("admin/updateuser/{id}")
  public String updateUser(@PathVariable(value = "id") Long id, @ModelAttribute ChinacalcUser user,
  RedirectAttributes redirectAttributes) {
    
    service.updateUser(user);
    redirectAttributes.addFlashAttribute("editSuccess", "Пользователь " + user.getEmail() + " успешно сохранен");
    
    return "redirect:/admin/edituser/{id}";
  }
  
  
  //TODO Setup redirect and redirect attribute
  @PostMapping("admin/deleteuser/{id}")
  public String deleteUser(@PathVariable(value = "id") Long id, RedirectAttributes redirectAttributes) {
    
    service.deleteUserById(id);
    
    return "redirect:/admin";
    
  }
  
  //TODO Setup redirect and redirect attribute
  @PostMapping("admin/updateuserpass/{id}")
  public String updateUserPassword(@PathVariable(value = "id") Long id, @ModelAttribute ChinacalcUser user,
  RedirectAttributes redirectAttributes) {
    
    service.updateUserPassword(user);
    
    return "redirect:/admin";
  }
  
  //TODO Setup redirect and redirect attribute
  @PostMapping("admin/blockuser/{id}")
  public String blockUser(@PathVariable(value = "id") Long id, @ModelAttribute ChinacalcUser user,
      RedirectAttributes redirectAttributes) {

    service.blockUserById(id);

    return "redirect:/admin";

  }

}
