package com.saaws88.chinacalc.infrastructure.controller.api.v1;

import java.util.List;

import com.saaws88.chinacalc.domain.model.user.ChinacalcUser;
import com.saaws88.chinacalc.domain.model.user.enumerated.Role;
import com.saaws88.chinacalc.service.implementation.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/admin/users")
public class UserApiController {

  private final UserService service;

  @PostMapping("/add")
  public ResponseEntity<ChinacalcUser> createUser(@RequestBody ChinacalcUser user) {
    service.createUser(user);
    return new ResponseEntity<ChinacalcUser>(user, HttpStatus.CREATED);
  }

  @PostMapping("/addadmin")
  public ResponseEntity<ChinacalcUser> createAdmin(@RequestBody ChinacalcUser user) {
    user.getRoles().add(Role.ADMIN);
    service.createUser(user);
    return new ResponseEntity<ChinacalcUser>(user, HttpStatus.CREATED);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<ChinacalcUser> deleteUserById(@PathVariable("id") Long id) {

    service.deleteUserById(id);

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/all")
  public List<ChinacalcUser> listAll() {

    return service.findAll();
  
  }
  

}
