package org.chinacalcweb.webgui.service;

import org.chinacalcweb.webgui.config.util.PassGen;
import org.chinacalcweb.webgui.model.ChinacalcUser;
import org.chinacalcweb.webgui.model.Role;
import org.chinacalcweb.webgui.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {
  
  private UserRepository userRepository;
  private BCryptPasswordEncoder encoder;

  @Override
  public void createUser(ChinacalcUser user) {
    
    String userEmail = user.getEmail();
    if (userRepository.findByEmail(userEmail).isPresent()) {
      throw new RuntimeException("Пользователь с почтовым адресом " + userEmail + " уже существует");
    }
    user.setEmail(userEmail);
    String password = PassGen.generatePassayPassword();
    user.setPassword(encoder.encode(password));
    user.getRoles().add(Role.USER);

    System.out.println(password);
    userRepository.save(user);
  }
  
}
