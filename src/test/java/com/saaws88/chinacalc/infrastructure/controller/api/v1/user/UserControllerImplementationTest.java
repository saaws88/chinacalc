package com.saaws88.chinacalc.infrastructure.controller.api.v1.user;

import com.saaws88.chinacalc.domain.model.user.ChinacalcUser;
import com.saaws88.chinacalc.service.implementation.ChinacalcUserServiceImplementation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest(UserControllerImplementation.class)
@ExtendWith(MockitoExtension.class)
class UserControllerImplementationTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ChinacalcUserServiceImplementation userService;

  @Test
  void testCreateUser() {
    ChinacalcUser user = new ChinacalcUser();
    user.setUsername("testUser");

    ResponseEntity<ChinacalcUser> response = new UserControllerImplementation(userService).createUser(user);

    Mockito.verify(userService, Mockito.times(1)).createUser(user);
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
  }

  @Test
  void testCreateAdmin() {
    ChinacalcUser user = new ChinacalcUser();
    user.setUsername("adminUser");

    ResponseEntity<ChinacalcUser> response = new UserControllerImplementation(userService).createAdmin(user);

    Mockito.verify(userService, Mockito.times(1)).createUser(user);
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
  }

  @Test
  void testDeleteUserById() {
    Long userId = 1L;
    ChinacalcUser user = new ChinacalcUser();
    user.setId(userId);
    user.setUsername("testUser");

    when(userService.getUserById(userId)).thenReturn(user);

    ResponseEntity<String> response = new UserControllerImplementation(userService).deleteUserById(userId);

    Mockito.verify(userService, Mockito.times(1)).getUserById(userId);
    assertEquals(HttpStatus.OK, response.getStatusCode());
  }

  @Test
  void testListAll() {
    List<ChinacalcUser> userList = Arrays.asList(new ChinacalcUser(), new ChinacalcUser());

    when(userService.findAll()).thenReturn(userList);

    List<ChinacalcUser> result = new UserControllerImplementation(userService).listAll();

    Mockito.verify(userService, Mockito.times(1)).findAll();
    assertEquals(userList.size(), result.size());
  }

  @Test
  void testBlockUserById() {
    Long userId = 1L;

    ChinacalcUser user = new ChinacalcUser();
    user.setId(userId);
    user.setUsername("testUser");

    when(userService.getUserById(userId)).thenReturn(user);
    ResponseEntity<String> response = new UserControllerImplementation(userService).blockUserById(userId);

    Mockito.verify(userService, Mockito.times(1)).getUserById(userId);
    assertEquals(HttpStatus.OK, response.getStatusCode());
  }

}

