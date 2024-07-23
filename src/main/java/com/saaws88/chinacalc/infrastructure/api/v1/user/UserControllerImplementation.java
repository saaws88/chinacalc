package com.saaws88.chinacalc.infrastructure.api.v1.user;

import com.saaws88.chinacalc.domain.model.user.ChinacalcUser;
import com.saaws88.chinacalc.domain.model.user.enumerated.Role;
import com.saaws88.chinacalc.infrastructure.api.v1.user.dto.UserCreationDto;
import com.saaws88.chinacalc.infrastructure.api.v1.user.dto.UserResponseDto;
import com.saaws88.chinacalc.service.ChinacalcUserService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/admin")
public class UserControllerImplementation implements UserController {

  private final ChinacalcUserService service;
  private final UserConverter converter;

  @PostMapping("/add")
  public ResponseEntity<UserResponseDto> createUser(@RequestBody UserCreationDto dto) {
    
    ChinacalcUser user = converter.toEntity(dto);
    user.setRoles(new HashSet<>());  
    service.createUser(user);
    
    return new ResponseEntity<>(converter.toDto(user), HttpStatus.CREATED);
  
  }

  @PostMapping("/addadmin")
  public ResponseEntity<UserResponseDto> createAdmin(@RequestBody UserCreationDto dto) {
  
    ChinacalcUser user = converter.toEntity(dto);
    
    user.setRoles(new HashSet<>());
    user.getRoles().add(Role.ADMIN);
    service.createUser(user);
    
    return new ResponseEntity<>(converter.toDto(user), HttpStatus.CREATED);
  
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id) {
    
    String username = service.getUserById(id).getUsername();
    service.deleteUserById(id);
    
    return new ResponseEntity<>(String.format("Пользователь %s удален", username), HttpStatus.OK);
  
  }

  @GetMapping("/all")
  public List<UserResponseDto> listAll() {

    return service.findAll()
      .stream()
      .map(converter::toDto)
      .toList();
  
  }

  @PostMapping("/ban/{id}")
  public ResponseEntity<String> blockUserById(@PathVariable("id") Long id) {
    
    String username = service.getUserById(id).getUsername();
    service.blockUserById(id);

    return new ResponseEntity<>(String.format("Пользователь %s заблокирован", username), HttpStatus.OK);
 
  }
  

}
