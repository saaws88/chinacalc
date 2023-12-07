package org.chinacalcweb.webgui.controller;

import org.chinacalcweb.webgui.model.ChinacalcUser;
import org.chinacalcweb.webgui.model.Role;
import org.chinacalcweb.webgui.service.EmailService;
import org.chinacalcweb.webgui.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/admin/users")
public class UserApiController {
  
  private final UserService userService;
  private final EmailService emailService;

  @PostMapping("/add")
  public ResponseEntity<ChinacalcUser> createUser(@RequestBody ChinacalcUser user) {
    userService.createUser(user);
    return new ResponseEntity<ChinacalcUser>(user, HttpStatus.CREATED);
  }
  
  @PostMapping("/addadmin")
  public ResponseEntity<ChinacalcUser> createAdmin(@RequestBody ChinacalcUser user) {
    user.getRoles().add(Role.ADMIN);
    userService.createUser(user);
    return new ResponseEntity<ChinacalcUser>(user, HttpStatus.CREATED);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<ChinacalcUser> deleteUserById(@PathVariable("id") Long id) {
    
    userService.deleteUserById(id);

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("/sendmessage")
  String sendEmail(@RequestParam String to) {

    emailService.sendTemporaryPassword(to, "Amogus");
  
    return "Message sent";
  
  }
   
}
