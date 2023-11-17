package org.chinacalcweb.webgui.service;

import java.util.List;

import org.chinacalcweb.webgui.model.ChinacalcUser;

public interface UserService {
  
  public void createUser(ChinacalcUser user);

  public List<ChinacalcUser> findAll();
  
}
