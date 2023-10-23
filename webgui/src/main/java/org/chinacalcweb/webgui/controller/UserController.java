package org.chinacalcweb.webgui.controller;

import org.chinacalcweb.webgui.model.ChinacalcUser;
import org.chinacalcweb.webgui.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/users")
public class UserController {
  
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/add")
  public ResponseEntity<ChinacalcUser> createUser(@RequestBody ChinacalcUser user) {
    userService.createUser(user);
    return new ResponseEntity<ChinacalcUser>(user, HttpStatus.CREATED);
  }
}
