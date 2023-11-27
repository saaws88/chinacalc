package org.chinacalcweb.webgui.controller;

import java.util.Arrays;
import java.util.List;

import org.chinacalcweb.webgui.model.ChinacalcUser;
import org.chinacalcweb.webgui.model.Role;
import org.chinacalcweb.webgui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    model.addAttribute("userlist", userService.findAll());
    return "admin";
  }

  //TODO Refactor createUser and editUser methods
  @PostMapping("/admin")
  public String createUser(@ModelAttribute("user") ChinacalcUser user, Model model, RedirectAttributes redirectAttributes) {
    
    if (userService.isExist(user.getEmail())){
      redirectAttributes.addFlashAttribute("error", "Пользователь с почтой " + user.getEmail() + " уже существует.");
    }
    userService.createUser(user);

    redirectAttributes.addFlashAttribute("success", "Пользователь создан, временный пароль отправлен на " + user.getEmail());
    return "redirect:/admin";
  
  }

  @GetMapping("admin/edituser/{id}")
  public String getUserEditForm(@PathVariable(value="id") Long id, Model model, ChinacalcUser user) {

    model.addAttribute("user", userService.getUserById(id));

    List<Role> roles = Arrays.asList(Role.values());
    model.addAttribute("roles", roles);

    return "edituser";

  }

  @PostMapping("admin/updateuser/{id}") 
  public String updateUser(@PathVariable(value="id") Long id, @ModelAttribute ChinacalcUser user, RedirectAttributes redirectAttributes) {

    userService.updateUser(user);
    redirectAttributes.addFlashAttribute("editSuccess", "Пользователь " + user.getEmail() + " успешно сохранен");
    
    return "redirect:/admin/edituser/{id}";
  }
}
