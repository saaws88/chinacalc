package org.chinacalcweb.webgui.service;

import java.util.List;

import org.chinacalcweb.webgui.model.user.ChinacalcUser;

public interface UserService {

  void createUser(ChinacalcUser user);

  List<ChinacalcUser> findAll();

  void deleteUserById(Long id);

  void blockUserById(Long id);

  ChinacalcUser getUserById(Long id);

  void updateUser(ChinacalcUser user);

  void updateUserPassword(ChinacalcUser user);

  boolean isEmailExist(String email);

}
