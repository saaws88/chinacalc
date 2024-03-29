package org.chinacalcweb.webgui.service;

import java.util.List;

import org.chinacalcweb.webgui.model.ChinacalcUser;

public interface UserService {

  public void createUser(ChinacalcUser user);

  public List<ChinacalcUser> findAll();

  public void deleteUserById(Long id);

  public void blockUserById(Long id);

  public ChinacalcUser getUserById(Long id);

  public void updateUser(ChinacalcUser user);

  public void updateUserPassword(ChinacalcUser user);

  public boolean isEmailExist(String email);

}
