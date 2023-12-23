package org.chinacalcweb.webgui.controller;

import java.util.Arrays;
import java.util.List;

import org.chinacalcweb.webgui.model.ChinacalcUser;
import org.chinacalcweb.webgui.model.Enums.Role;
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

@Controller
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

  @PostMapping("/admin")
  public String createUser(@ModelAttribute("user") ChinacalcUser user, Model model,
      RedirectAttributes redirectAttributes) {

    if (userService.isEmailExist(user.getEmail().toLowerCase())) {
      redirectAttributes.addFlashAttribute("error",
          "Пользователь с почтой " + user.getEmail().toLowerCase() + " уже существует.");
      return "redirect:/admin";
    }
    userService.createUser(user);

    redirectAttributes.addFlashAttribute("success",
        "Пользователь создан, временный пароль отправлен на " + user.getEmail());
    return "redirect:/admin";

  }

  @GetMapping("admin/edituser/{id}")
  public String getUserEditForm(@PathVariable(value = "id") Long id, Model model, ChinacalcUser user) {

    model.addAttribute("user", userService.getUserById(id));

    List<Role> roles = Arrays.asList(Role.values());
    model.addAttribute("roles", roles);

    return "edituser";

  }

  //TODO Setup redirect and redirect attribute
  @PostMapping("admin/updateuser/{id}")
  public String updateUser(@PathVariable(value = "id") Long id, @ModelAttribute ChinacalcUser user,
  RedirectAttributes redirectAttributes) {
    
    userService.updateUser(user);
    redirectAttributes.addFlashAttribute("editSuccess", "Пользователь " + user.getEmail() + " успешно сохранен");
    
    return "redirect:/admin/edituser/{id}";
  }
  
  
  //TODO Setup redirect and redirect attribute
  @PostMapping("admin/deleteuser/{id}")
  public String deleteUser(@PathVariable(value = "id") Long id, RedirectAttributes redirectAttributes) {
    
    userService.deleteUserById(id);
    
    return "redirect:/admin";
    
  }
  
  //TODO Setup redirect and redirect attribute
  @PostMapping("admin/updateuserpass/{id}")
  public String updateUserPassword(@PathVariable(value = "id") Long id, @ModelAttribute ChinacalcUser user,
  RedirectAttributes redirectAttributes) {
    
    userService.updateUserPassword(user);
    
    return "redirect:/admin";
  }
  
  //TODO Setup redirect and redirect attribute
  @PostMapping("admin/blockuser/{id}")
  public String blockUser(@PathVariable(value = "id") Long id, @ModelAttribute ChinacalcUser user,
      RedirectAttributes redirectAttributes) {

    userService.blockUserById(id);

    return "redirect:/admin";

  }

}
