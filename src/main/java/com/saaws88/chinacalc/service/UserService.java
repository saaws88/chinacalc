package com.saaws88.chinacalc.service;

import java.util.List;

import com.saaws88.chinacalc.domain.model.user.ChinacalcUser;

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
